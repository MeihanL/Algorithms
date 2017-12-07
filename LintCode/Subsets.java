/*
 * http://www.lintcode.com/en/problem/subsets/
 * solutions: http://www.cnblogs.com/yuzhangcmu/p/4211815.html 
 * Given a set of distinct integers, return all possible subsets.
 * Notice:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
 */

/*SOLUTION
1. 先对数组进行排序
2. 在set中依次取一个数字出来即可，因为我们保持升序，所以不需要取当前Index之前的数字。
TIME: 227 ms
*/
class Subsets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) {
            return results; }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results; }
        
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }
    
    // 递归三要素
    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    private void helper(ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex,
                        List<List<Integer>> results) {
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        results.add(new ArrayList<Integer>(subset));
        System.out.println(results);
        
        for (int i = startIndex; i < nums.length; i++) {
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper(subset, nums, i + 1, results);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }    
        // 3. 递归的出口
        // return;
    }
}

/*SOLUTION 2: 在Solution 1的基础之上，使用Hashmap来记录中间结果，即是以index开始的所有的组合，希望可以加快运行效率，最后时间：
TIME:253 ms. 实际结果与预期反而不一致。原因可能是每次新组装这些解也需要耗费时间 */

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (S == null) {
            return ret;
        }
        
        Arrays.sort(S);
        return dfs3(S, 0, new HashMap<Integer, List<List<Integer>>>());
        }
     
    public List<List<Integer>> dfs3(int[] S, int index, HashMap<Integer, List<List<Integer>>> map) {
        int len = S.length;
         
        if (map.containsKey(index)) {
            return map.get(index);
        }
         
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> pathTmp = new ArrayList<Integer>();
        ret.add(pathTmp);
         
        for (int i = index; i < len; i++) {
            // System.out.println("layer: " + i); add system.out.println() in the following to understand this solution
            List<List<Integer>> left = dfs3(S, i + 1, map);
            System.out.println("LEFT = "+ left);
            System.out.println("retbefore = "+ ret);
            for (List<Integer> list: left) {
                pathTmp = new ArrayList<Integer>();
                pathTmp.add(S[i]);
                pathTmp.addAll(list);
                ret.add(pathTmp);
            }
            System.out.println("RETAFTER = "+ ret);
        }
        map.put(index, ret);
        System.out.println("Index: " + index);
        System.out.println("MAP: \n" + map);
        return ret;
    }
}

/*SOLUTION 3: 相当牛逼的bit解法。基本的想法是，用bit位来表示这一位的number要不要取，第一位有1，0即取和不取2种可能性。
所以只要把0到N种可能都用bit位表示，再把它转化为数字集合，就可以了。

Ref: http://www.fusu.us/2013/07/the-subsets-problem.html

There are many variations of this problem, I will stay on the general problem of finding all subsets of a set. 
For example if our set is [1, 2, 3] - we would have 8 (2 to the power of 3) subsets: {[], [1], [2], [3], [1, 2], [1, 3], [1, 2, 3], [2, 3]}. 
So basically our algorithm can't be faster than O(2^n) since we need to go through all possible combinations.

There's a few ways of doing this. I'll mention two ways here - the recursive way, that we've been taught in high schools; and using a bit string.

Using a bit string involves some bit manipulation but the final code can be found easy to understand.
The idea  is that all the numbers from 0 to 2^n are represented by unique bit strings of n bit width that can be translated into a subset. 
So for example in the above mentioned array we would have 8 numbers from 0 to 7 inclusive that would have a bit representation 
that is translated using the bit index as the index of the array.

each subset equals to an binary integer between 0 .. 2^n - 1
Nr  Bits Combination
0   000  {}
1   001  {1}
2   010  {2}
3   011  {1, 2}
4   100  {3}
5   101  {1, 3}
6   110  {2, 3}
7   111  {1, 2, 3}
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    
       List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);       
        // 1 << n is 2^n
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                // check whether the jth digit in i's binary representation is 1
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }    
        
    /* the above one is much easier to understand, below is another method to implement this solution, but slower(see below /*性能测试) 
       public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {    
            return ret;
            }
        int len = nums.length;
        Arrays.sort(nums);
    // forget to add (long).
        long numOfSet = (long)Math.pow(2, len);
       
        for (int i = 0; i < numOfSet; i++) {
           // bug 3: should use tmp - i.
            long tmp = i;
            System.out.println("tmpbefore: "+tmp);
           
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (tmp != 0) {
               // bug 2: use error NumberOfTrailingZeros. 
                int indexOfLast1 = Long.numberOfTrailingZeros(tmp);
                System.out.println("indexOfLast1: "+indexOfLast1);
                list.add(nums[indexOfLast1]);
                System.out.println("list: "+list);
               // clear the bit.
                tmp ^= (1 << indexOfLast1);
                System.out.println("tmp: "+tmp);
            }
            ret.add(list);
            System.out.println("ret: "+ret+"\n");
        }
        return ret;
    }
    */  
}
    
/*性能测试：
1. when SIZE = 19:
Subset with memory record: 14350.0 millisec.
Subset recursion: 2525.0 millisec.
Subset Iterator: 5207.0 millisec.
表明带memeory的性能反而不行。而iterator的性能也不并不如。

2. size再继续加大时，iterator的会出现Heap 溢出的问题，且速度非常非常慢。原因不是太懂。
GITHUB: https://github.com/yuzhangcmu/LeetCode_algorithm/blob/master/dfs/Subsets.java
*/