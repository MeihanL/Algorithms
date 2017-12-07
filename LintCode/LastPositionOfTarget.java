public class LastPositionOfTarget  {
    /*
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while ((start + 1) < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) 
                end = mid;
            else
                start = mid;
        }
        if (n > 1 && nums[end] == target)  // n > 1 is a necessary condition considering the case of n ==1
            return end;
        else if (nums[start] == target)
            return start;
        else
            return -1;
    }
}


/*
 * Find the last position of a target number in a sorted array. Return -1 if target does not exist.
 * Example
 * Given [1, 2, 2, 4, 5, 5].
 * For target = 2, return 2.
 * For target = 5, return 5.
 * For target = 6, return -1.
 */
