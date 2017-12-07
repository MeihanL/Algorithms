/*
 * http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

// Version 0: Non-Recursion
public class BinaryTreePreorderTraversal {
    /*
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();
        if (root == null) 
            return preorder;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);   
            }
        }
        return preorder;
    }
}

//Version 1: Traverse
public class Solution {
    /*
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> preorder = new ArrayList<Integer>(); //或者 List<Integer> preorder = new ArrayList<Integer>(); 
        traverse(root, preorder);
        return preorder;
    }
    // 这里List<Integer> 可对应上面declare的ArrayList<Integer>,而反过来不行
    private void traverse(TreeNode node, ArrayList<Integer> preorder) {  
        if (node == null) 
            return;
        preorder.add(node.val);
        traverse(node.left, preorder);
        traverse(node.right, preorder);
    }
}

//Version 2: Divide & Conquer
public class Solution {
    /*
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // null or leaf
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        // Divide
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);   
        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}

//Version 2: Divide & Conquer---my version
public class Solution {
    /*
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // null or leaf
        int i = 0, j = 0;
        return traverse(root, i, j); 
    }
    private ArrayList<Integer> traverse(TreeNode node, int i, int j) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (node == null) {
            return result;
        }
        // Divide  
        ArrayList<Integer> left = traverse(node.left, i, j);
        ArrayList<Integer> right = traverse(node.right, i, j);
// Conquer
        result.add(node.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}