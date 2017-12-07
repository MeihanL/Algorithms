// My solution
public class SubsetsII {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return results; }
//        if (nums.length == 0) {
//            results.add(new ArrayList<Integer>());
//            return results; }
        results.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }
    
    private void helper(ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex,
                        List<List<Integer>> results) {
        for (int i = startIndex; i < nums.length; i++) {
         // use continus so do not need while loop and i < nums.length as shown below
           while (i < nums.length && i > startIndex && nums[i] == nums[i - 1]) {
               ++i;
           }
            if (i >= startIndex && i < nums.length) {
                subset.add(nums[i]);
                //System.out.println(subset);
                results.add(new ArrayList<Integer>(subset));
                helper(subset, nums, i + 1, results);
                subset.remove(subset.size() - 1);
            }   
        }    
    }
}

// other solution
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return results; }
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }
    
    private void helper(ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex,
                        List<List<Integer>> results) {
        // deep copy subset and add to resultss
        results.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            if ( i != 0 && i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(subset, nums, i + 1, results);
            // »ØËİ
            subset.remove(subset.size() - 1);
        }    
    }
}