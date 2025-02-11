package Practice.BinaryTrees;

import java.util.*;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer,Integer> inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return constructTree(inorder, postorder, 0,n-1,0,n-1,inorderMap );
    }

    public TreeNode constructTree(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd, Map<Integer,Integer> inorderMap){

        if(postorderEnd < postorderStart || inorderStart > inorderEnd) return null;

        int node = postorder[postorderEnd];
        int inorderNodeIndex = inorderMap.get(node);
        int rightNodes = inorderEnd - inorderNodeIndex;

        int inorderLeftStart = inorderStart;
        int inorderLeftEnd = inorderNodeIndex - 1;

        int inorderRightStart = inorderNodeIndex +1;
        int inorderRightEnd = inorderEnd;

        int postOrderRightStart = postorderEnd - rightNodes;
        int postOrderRightEnd = postorderEnd - 1;

        int postOrderLeftStart = postorderStart;
        int postOrderLeftEnd = postOrderRightStart - 1;

        TreeNode root = new TreeNode(node);

        TreeNode left = constructTree(inorder, postorder, inorderLeftStart, inorderLeftEnd, postOrderLeftStart, postOrderLeftEnd, inorderMap);
        TreeNode right = constructTree(inorder, postorder, inorderRightStart, inorderRightEnd, postOrderRightStart, postOrderRightEnd, inorderMap);

        root.left = left;
        root.right = right;

        return root;
    }

}
