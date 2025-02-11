package Practice.BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativePreorderTraversal {
    // https://www.youtube.com/watch?v=Bfqd8BsPVuw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk
    public void preorder(TreeNode root){
        List<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }

        System.out.println(list);
    }
}
