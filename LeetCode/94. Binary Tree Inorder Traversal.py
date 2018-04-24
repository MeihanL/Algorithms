# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Recursion
class Solution:
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        return self.inorderTraversal(root.left) + [root.val] + \
        self.inorderTraversal(root.right)

# Non-recursion 1
    def inorderTraversal(self, root):
        # write your code here
        if root is None:
            return []
        stack = [root]
        inorder = []
        node = root
        while stack:
            while node.left:
                stack.append(node.left)
                node = node.left
            node = stack.pop()
            inorder.append(node.val)
            if node.left == None and node.right == None and stack:
                node = stack.pop()
                inorder.append(node.val)
            while node.right == None and stack:
                node = stack.pop()
                inorder.append(node.val)
            if node.right is not None:
                stack.append(node.right)
                node = node.right
        return inorder

# Non-recursion 2
    def inorderTraversal(self, root):

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
                stack.append(node.right)
                operationStack.append(self.PROCESS)

                stack.append(node)
                operationStack.append(self.ADDTORESULT)

                stack.append(node.left);
                operationStack.append(self.PROCESS)
        return result