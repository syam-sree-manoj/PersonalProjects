package Practice.BinaryTrees;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor {
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

    Set<TreeNode> set = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        set.add(p);
        set.add(q);

        return dfs(root);
    }

    public TreeNode dfs(TreeNode root){

        if(root == null) return null;

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);

        if( left != null && right != null) return root;

        if( left != null){
            if(set.contains(root)){
                return root;
            }else{
                return left;
            }
        }

        if( right != null){
            if(set.contains(root)){
                return root;
            }else{
                return right;
            }
        }

        return set.contains(root) ? root : null;
    }
}
