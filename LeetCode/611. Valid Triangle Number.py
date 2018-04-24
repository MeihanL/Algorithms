class Solution:

# Version 1
    def triangleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) < 3:
            return 0
        nums = sorted(nums, reverse = True)
        length = len(nums)
        count = 0
        for i in range(0, length - 2):
            left = i + 1
            right = i + 2
            while right < length and nums[left] + nums[right] > nums[i]:
                right += 1
            right -= 1
            while left < right:
                count += right - left
                left += 1
                while left < right and nums[left] + nums[right] <= nums[i]:
                    right -= 1
        return count

# Version 2
    def triangleCount(self, S):
        # write your code here
        S = sorted(S)
        count = 0
        for i in range(2, len(S)):
            l = 0
            r = i-1
            while l < r:
                sum = S[l] + S[r]
                if sum > S[i]:
                    count += r-l
                    r -= 1
                else:
                    l += 1
        return count