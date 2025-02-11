package Practice.BinaryTrees;

public class FlattenBinaryTreetoLinkedList {
    // https://www.youtube.com/watch?v=sWf7k1x9XR4
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if( root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.left = null;
        root.right = prev;
        prev = root;
    }
}
