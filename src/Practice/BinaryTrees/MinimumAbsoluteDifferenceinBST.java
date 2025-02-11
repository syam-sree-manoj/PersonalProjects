package Practice.BinaryTrees;

public class MinimumAbsoluteDifferenceinBST {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode curr){
        if(curr.left != null) inorder(curr.left);
        if(prev == null){
            prev = curr;
        }else{
            int diff = Math.abs(prev.val-curr.val);
            minDiff = Math.min(minDiff, diff);
            prev = curr;
        }
        if(curr.right != null) inorder(curr.right);
    }
}
