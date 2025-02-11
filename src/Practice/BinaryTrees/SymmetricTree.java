package Practice.BinaryTrees;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return solve(root.left, root.right);
    }

    public boolean solve(TreeNode t1, TreeNode t2){

        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        if(t1.val != t2.val) return false;

        boolean leftSymmetric = solve(t1.left, t2.right);
        boolean rightSymmetric = solve(t1.right, t2.left);

        return leftSymmetric && rightSymmetric;
    }

}
