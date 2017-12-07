/**
 * http://www.lintcode.com/en/problem/binary-tree-inorder-traversal/
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

// non-recursive method
public class BinaryTreeInorderTraversal {
    /*
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }
}