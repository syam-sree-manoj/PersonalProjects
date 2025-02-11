package Practice.BinaryTrees;

public class BinaryTreeMaximumPathSum {
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;

        int leftPathSum = Math.max(0, dfs(root.left) );
        int rightPathSum = Math.max(0, dfs(root.right) );

        int totalSum = leftPathSum + rightPathSum + root.val;
        int pathMax = root.val + Math.max(leftPathSum, rightPathSum);

        maxSum = Math.max(totalSum, maxSum);

        return pathMax;
    }
}
