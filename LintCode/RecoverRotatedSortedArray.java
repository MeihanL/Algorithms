import java.util.*;
public class RecoverRotatedSortedArray {
    /* Given a rotated sorted array, recover it to sorted array in-place. What is rotated array?
    * For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
    * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
    * @param nums: An integer array
    * @return: nothing
    */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return;
        }
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                reverse(nums, 0, i);
                reverse(nums, i + 1, n - 1);
                reverse(nums, 0, n - 1);
                // return;
            }
        }
    }
    private void reverse(List<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
    public static void main(String[] args) {   
        RecoverRotatedSortedArray perc = new RecoverRotatedSortedArray();
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(1);
        nums.add(-1);
        nums.add(1);
        perc.recoverRotatedSortedArray(nums);
        System.out.println(nums); 
    }
}

