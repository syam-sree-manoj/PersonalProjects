package Practice.BinaryTrees;

import java.util.*;

public class BoundaryTraversalinBinaryTree {
    // https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk

    void addLeftBoundary(TreeNode root, ArrayList<Integer> res){
        TreeNode curr = root.left;
        while(curr != null){
            if(!isLeaf(curr)) res.add(curr.val);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    void addRightBoundary(TreeNode root, ArrayList<Integer> res){
        TreeNode curr = root.right;
        LinkedList<Integer> list = new LinkedList<>();

        while(curr != null){
            if(!isLeaf(curr)) list.addFirst(curr.val);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        res.addAll(list);
    }

    void addLeaves(TreeNode root, ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.val);
            return;
        }
        if(root.left != null) addLeaves(root.left, res);
        if(root.right != null) addLeaves(root.right, res);

    }

    public List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        ArrayList<Integer> res = new ArrayList<>();

        if(!isLeaf(root)) res.add(root.val);
        addLeftBoundary(root,res);
        addLeaves(root,res);
        addRightBoundary(root,res);
        return res;
    }
}
