package ca.bytetube._00_leetcode._tree;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * @author dall.
 */
public class InvertTree {
    public TreeNode invertTree0(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree0(root.left);
        invertTree0(root.right);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;


        invertTree1(root.left);
        invertTree1(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        invertTree(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);


        return root;
    }
}
