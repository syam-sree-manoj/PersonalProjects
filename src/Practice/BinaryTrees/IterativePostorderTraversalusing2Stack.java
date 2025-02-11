package Practice.BinaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class IterativePostorderTraversalusing2Stack {

    public void postOrder(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> stack1 = new Stack<>();
        Deque<TreeNode> postOrderQueue = new ArrayDeque<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode top = stack1.pop();
            postOrderQueue.addFirst(top);

            if(top.left != null) stack1.push(top.left);
            if(top.right != null) stack1.push(top.right);

        }

        System.out.println(postOrderQueue);

    }
}
