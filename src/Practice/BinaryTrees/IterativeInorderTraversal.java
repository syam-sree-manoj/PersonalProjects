package Practice.BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativeInorderTraversal {
    // https://www.youtube.com/watch?v=lxTGsVXjwvM&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk
    public void inorder(TreeNode root){
        List<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while(true){
            if(currNode != null){
                stack.push(currNode);
                currNode = currNode.left;
            }else{
                if(stack.isEmpty()) break;
                TreeNode top = stack.pop();
                list.add(top);
                currNode = currNode.right;
            }
        }

        System.out.println(list);
    }
}
