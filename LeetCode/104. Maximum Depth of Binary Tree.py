# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:

# Version 1: Divide Conquer
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

# version 2: Traverse
    def maxDepth(self, root):
        self.depth = 0
        self.helper(root, 1)
        return self.depth

    def helper(self, node, curtDepth):
        if node == None:
            return
        if curtDepth > self.depth:
            self.depth = curtDepth
        self.helper(node.left, curtDepth + 1)
        self.helper(node.right, curtDepth + 1)
