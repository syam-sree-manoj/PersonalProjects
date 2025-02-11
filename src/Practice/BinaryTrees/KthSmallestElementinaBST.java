package Practice.BinaryTrees;

public class KthSmallestElementinaBST {
    int currSmallest = 0;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }

    public void inorder(TreeNode root, int k){
        if(root.left != null) inorder(root.left, k);
        currSmallest++;
        if( currSmallest == k){
            ans = root.val;
            return;
        }
        if(root.right != null) inorder(root.right, k);
    }
}
