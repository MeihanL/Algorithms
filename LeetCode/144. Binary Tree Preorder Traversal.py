# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# Recursion
class Solution:
    """
    @param root: The root of binary tree.
    @return: Preorder in ArrayList which contains node values.
    """

    def preorderTraversal(self, root):
        self.results = []
        self.traverse(root)
        return self.results

    def traverse(self, root):
        if root is None:
            return
        self.results.append(root.val)
        self.traverse(root.left)
        self.traverse(root.right)

# Non-recursion 1
class Solution:
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        preorder = []
        stack = [root]
        while stack:
            node = stack.pop()
            preorder.append(node.val)
            if node.right != None:
                stack.append(node.right)
            if node.left != None:
                stack.append(node.left)

        return preorder

# Non-recursion 2
    def preorderTraversal(self, root):

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

                stack.append(node.left);
                operationStack.append(self.PROCESS)

                stack.append(node)
                operationStack.append(self.ADDTORESULT)
        return result