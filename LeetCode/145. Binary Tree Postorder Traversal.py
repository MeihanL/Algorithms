# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Recursion
class Solution:
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        return self.postorderTraversal(root.left) + \
        self.postorderTraversal(root.right) + [root.val]

# Non-recursion 1
    def postorderTraversal(self, root):
        # write your code here
        if root is None:
            return []
        stack = [root]
        postorder = []
        while stack:
            node = stack.pop()
            postorder.append(node.val)
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        postorder = postorder[::-1]
        return postorder

# Non-recursion 2
    def postorderTraversal(self, root):

        self.PROCESS = 'PROCESS'
        self.ADDTORESULT = 'ADDTORESULT'
        result = []
        if (root == None):
            return result

        stack = [root]
        operationStack = [self.PROCESS]
        while stack:
            node = stack.pop()
            operation = operationStack.pop()
            if node == None:
                continue
            if operation == self.ADDTORESULT:
                result.append(node.val)
            else:
                stack.append(node)
                operationStack.append(self.ADDTORESULT)

                stack.append(node.right)
                operationStack.append(self.PROCESS)

                stack.append(node.left);
                operationStack.append(self.PROCESS)
        return result