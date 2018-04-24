"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""


class Solution:
    """
    @param root: a TreeNode, the root of the binary tree
    @return: nothing
    """
# Recursion
    def flatten(self, root):
        # write your code here
        if root is None:
            return
        self.flatten(root.left)
        self.flatten(root.right)
        if root.left == None:
            return
        node = root.left
        while node.right:
            node = node.right
        node.right = root.right
        root.right = root.left
        root.left = None

# Traversal
    def flatten(self, root):
        if root is None:
            return None

        self.prev = root
        self.flatten(root.left)
        temp = root.right
        root.right = root.left
        root.left = None
        self.prev.right = temp
        self.flatten(temp)

        return root
# Divide & Conquer
    def flatten(self, root):
        self.prev = None
        if root is None:
            return None
        self.helper(root)

    def helper(self, node):
        if node is None:
            return None

        self.helper(node.right)
        self.helper(node.left)
        node.right = self.prev
        node.left = None
        self.prev = node

# Non-recursion 1
# preorder tree, use stack1 to store nodes
    def flatten(self, root):
        # write your code here
        if root is None:
            return
        stack = [root]
        stack1 = [root]
        stack1.pop()
        while stack:
            node = stack.pop()
            stack1.append(node)
            if node.right != None:
                stack.append(node.right)
            if node.left != None:
                stack.append(node.left)
        node = None
        while stack1:
            prenode = stack1.pop()
            prenode.right = node
            prenode.left = None
            node = prenode
# Non-recursion 1-1
    def flatten(self, root):
        if root is None:
            return

        stack = [root]
        while stack:
            node = stack.pop()
            if node.right != None:
                stack.append(node.right)
            if node.left != None:
                stack.append(node.left)
            node.left = None
            if not stack:
                node.right = None
            else:
                node.right = stack.pop()
                stack.append(node.right)



