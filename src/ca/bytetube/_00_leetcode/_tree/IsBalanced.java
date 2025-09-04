package ca.bytetube._00_leetcode._tree;

import ca.bytetube._07_avltree.BinaryTree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * @author dall.
 */
public class IsBalanced {

    //dto data transfer obj
    public static class ReturnData {
        public boolean isB;
        public int height;

        public ReturnData(boolean isB, int height) {
            this.isB = isB;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isB(root).isB;
    }

    public static ReturnData isB(TreeNode root) {
        if (root == null) return new ReturnData(true, 0);
        ReturnData leftData = isB(root.left);
        if (!leftData.isB) return new ReturnData(false, 0);

        ReturnData rightData = isB(root.right);
        if (!rightData.isB) return new ReturnData(false, 0);

        if (Math.abs(leftData.height - rightData.height) > 1) return new ReturnData(false, 0);

        return new ReturnData(true, Math.max(leftData.height, rightData.height) + 1);
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalanced2(root.left) && isBalanced2(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;

    }
}
