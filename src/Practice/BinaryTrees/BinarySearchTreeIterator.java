package Practice.BinaryTrees;

import java.util.Stack;

public class BinarySearchTreeIterator {
    // https://www.youtube.com/watch?v=D2jMcmxU4bs
    // https://leetcode.com/problems/binary-search-tree-iterator/

    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }

    public int next() {
        TreeNode top = stack.pop();
        pushAll(top.right);
        return top.val;
    }

    public void pushAll(TreeNode node){
        TreeNode curr = node;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
