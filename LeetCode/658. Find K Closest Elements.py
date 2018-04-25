class Solution:
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        length = len(arr)
        if arr is None or length == 0:
            return []
        if k == 0 or length < k:
            return []

        output = []
        for i in range(k):
            output.append(arr.pop(self.findTarget(arr, x)))
        # target_index = self.findTarget(A, target)
        # output.append(A[target_index])
        # k -= 1
        # l = target_index - 1
        # r = target_index + 1
        # while l > -1 and r < length and k > 0:
        #     if abs(A[l] - target) <= abs(A[r] - target):
        #         output.append(A[l])
        #         l -= 1
        #     else:
        #         output.append(A[r])
        #         r += 1
        #     k -= 1
        # while l == -1 and r < length and k > 0:
        #     output.append(A[r])
        #     r += 1
        #     k -= 1
        # while r == length and l > -1 and k > 0:
        #     output.append(A[l])
        #     l -= 1
        #     k -= 1
        return sorted(output)

    def findTarget(self, arr, x):
        start = 0
        end = len(arr) - 1
        while start + 1 < end:
            mid = (start + end) // 2
            if arr[mid] == x:
                return mid
            elif arr[mid] < x:
                start = mid
            else:
                end = mid
        if abs(arr[start] - x) <= abs(arr[end] - x):
            return start
        else:
            return end