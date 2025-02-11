package Practice.BinaryTrees;

import java.util.*;

public class BinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root = null;

        Map<Integer,Integer> inorderMap = new HashMap<>();

        for(int i=0; i<n; i++){
            inorderMap.put(inorder[i], i);
        }

        return constructTree(preorder, inorder, inorderMap, 0, n-1, 0, n-1);
    }

    private TreeNode constructTree(int[] preorder, int[] inorder, Map<Integer,Integer>  inorderMap, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd){
        if(preorderStart > preorderEnd || inorderStart > inorderEnd) return null;

        int node = preorder[preorderStart];
        TreeNode root = new TreeNode(node);

        int inorderNodeIndex = inorderMap.get(node);

        int leftNodes = inorderNodeIndex - inorderStart;

        int preorderLeftStart = preorderStart + 1;
        int preorderLeftEnd = preorderLeftStart + leftNodes;

        int inorderLeftStart = inorderStart;
        int inorderLeftEnd = inorderNodeIndex - 1;

        int preorderRightStart = preorderStart + leftNodes + 1;
        int preorderRightEnd = preorderEnd;

        int inorderRightStart = inorderNodeIndex + 1;
        int inorderRightEnd = inorderEnd;

        TreeNode left = constructTree(preorder, inorder, inorderMap, preorderLeftStart, preorderLeftEnd, inorderLeftStart, inorderLeftEnd);

        TreeNode right = constructTree(preorder, inorder, inorderMap, preorderRightStart, preorderRightEnd, inorderRightStart, inorderRightEnd);

        root.left = left;
        root.right = right;

        return root;
    }
}
