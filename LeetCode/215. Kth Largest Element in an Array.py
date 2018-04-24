class Solution:

# Version 1
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if nums is None or len(nums) < k:
            return
        self.quicksort(nums, 0, len(nums) - 1)
        return nums[-k]

    def quicksort(self, nums, start, end):
        if start >= end:
            return
        l = start
        r = end
        pivot = nums[(start + end) // 2]
        while l <= r:
            while l <= r and nums[l] < pivot:
                l += 1
            while l <= r and nums[r] > pivot:
                r -= 1
            if l <= r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1
        self.quicksort(nums, start, r)
        self.quicksort(nums, l, end)


# Version 2
    def findKthLargest(self, nums, k):
        self.quickSelect(nums, 0, len(nums) - 1, k)
        return nums[k - 1]

    def quickSelect(self, nums, left, right, k):
        pivot = nums[left]
        i = left
        j = right
        while i <= j:
            while i <= j and nums[i] > pivot:
                i += 1
            while i <= j and nums[j] < pivot:
                j -= 1
            if i <= j:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
                j -= 1
        if left + k - 1 <= j:
            return self.quickSelect(nums, left, j, k)
        if left + k - 1 >= i:
            return self.quickSelect(nums, i, right, k - (i - left))