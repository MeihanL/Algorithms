class Solution:
    
    def longestPalindrome(self, s):
        # write your code here
        if s is None or len(s) < 2:
            return s
        string = s[0]
        length = len(s)
        i = 0
        while i < length - 1:
            l = i
            r = l + 1
            while r < length and s[r] == s[i]:
                r += 1
            # i start at the number that is not equal to the one ahead of it
            if r > l + 1:
                i = r
            else:
                i += 1

            l -= 1
            while l >= 0 and r < length and s[l] == s[r]:
                l -= 1
                r += 1
            if len(s[l + 1:r]) > len(string):
                string = s[l + 1:r]
        return string