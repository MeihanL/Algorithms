public class FindMinimumInRotatedSortedArray {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return -1;
        else if (nums.length == 1)
            return nums[0];
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end -start) /2;
            if (nums[start] < nums[start + 1] && nums[start + 1] < nums[end])
                return nums[start];
            else if (nums[end] < nums[start] && nums[start] < nums[mid])
                start = mid;
            else if (nums[mid] < nums[end] && nums[end] < nums[start])
                 end = mid;
        }
        if (nums[start] < nums[start + 1])
            return nums[0];
        else
            return nums[start + 1];
    }
}

/* Suppose a sorted array is rotated at some pivot unknown to you beforehand.(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). 
 Find the minimum element.
 Notice: You may assume no duplicate exists in the array.

 Example
 Given [4, 5, 6, 7, 0, 1, 2] return 0
 */
