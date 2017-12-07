public class Solution1 {
    /*
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            if (nums[0] == target) 
                return 0;
            else
                return -1;
        int left = 0;
        int right= nums.length-1;
        while(left + 1 < right){
            int mid = left + (right-left)/2;
            if(target==nums[mid])
                return mid;
 
            if(nums[left]<=nums[mid]){
                if(nums[left]<=target&& target<nums[mid]){
                    right=mid;
                }else{
                    left=mid;
                }
            }else{
                if(nums[mid]<target&& target<=nums[right]){
                    left=mid;
                }else{
                    right=mid;
                }
            }
        }
        if (nums[left] == target)
            return left;
        else if (nums[left + 1] == target)
            return left + 1;
        else if (nums[right] == target)
            return right;
        else
            return -1;
    }
}

public class Solution2 {
    /*
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0, end= nums.length-1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(target == nums[mid])
                return mid;
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) 
                    end = mid;
                else
                    start = mid;
            } else {
                if (nums[mid] <= target && target <= nums[end])
                    start = mid;
                else
                    end = mid;
            }
        }
        if (nums[start] == target)
            return start;
        else if (nums[end] == target)
            return end;
        else
            return -1;
    }
}

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Challenge: O(logN) time
Example
For [4, 5, 1, 2, 3] and target=1, return 2.
For [4, 5, 1, 2, 3] and target=0, return -1.
*/