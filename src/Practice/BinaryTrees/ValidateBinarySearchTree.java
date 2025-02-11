package Practice.BinaryTrees;

public class ValidateBinarySearchTree {
    TreeNode prev = null;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isValid;
    }
    public void inorder(TreeNode root){
        if( root.left != null) inorder(root.left);
        if(prev == null){
            prev = root;
        }else{
            if(prev.val >= root.val){
                isValid = false;
                return;
            }
            prev = root;
        }
        if( root.right != null) inorder(root.right);
    }
}
