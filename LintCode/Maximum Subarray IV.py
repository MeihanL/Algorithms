class Solution:
    """
    @param nums: an array of integer
    @param k: an integer
    @return: the largest sum
    """

    def maxSubarray4(self, nums, k):
        # write your code here
        if nums == None or len(nums) == 0 or k <= 0:
            return
        if len(nums) < k:
            return 0

        result = 0
        for i in range(k):
            result += nums[i]

        sum = [0 for _ in range(len(nums) + 1)]

        min_prefix = 0
        for i in range(1, len(nums) + 1):
            sum[i] = sum[i - 1] + nums[i - 1]
            if i >= k and sum[i] - min_prefix > result:
                result = max(result, sum[i] - min_prefix)

            if i >= k:
                min_prefix = min(min_prefix, sum[i - k + 1])
                print('i:  ' + str(i) + '   min_prefix:  ' + str(min_prefix))

        return result