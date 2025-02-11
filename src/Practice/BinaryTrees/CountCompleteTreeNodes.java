package Practice.BinaryTrees;

public class CountCompleteTreeNodes {
    // https://www.youtube.com/watch?v=u-yWemKGWO0
    // https://leetcode.com/problems/count-complete-tree-nodes/
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if( leftHeight == rightHeight) return (1 << leftHeight) -1;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeftHeight(TreeNode root){
        TreeNode curr = root;
        int height = 0;
        while(curr != null){
            height++;
            curr = curr.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode root){
        TreeNode curr = root;
        int height = 0;
        while(curr != null){
            height++;
            curr = curr.right;
        }
        return height;
    }
}
