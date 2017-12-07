public class MaximumNumberInMountainSequenc {
    /*
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
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
            if (nums[mid] <= nums[mid + 1])
                start = mid;
            else if (nums[mid] > nums[mid + 1])
                end = mid;
        }
        if (nums[start] > nums[end])
            return nums[start];
        else
            return nums[end];
    }
}


/* 
 * Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
 * Example
 * Given nums = [1, 2, 4, 8, 6, 3] return 8
 * Given nums = [10, 9, 8, 7], return 10
 */
