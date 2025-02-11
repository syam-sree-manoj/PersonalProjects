package Practice.BinaryTrees;

import java.util.*;

public class IterativePostorderTraversalusing1Stack {
    // https://www.youtube.com/watch?v=NzIGLLwZBS8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk

    public void postOrder(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> postList = new ArrayList<>();

        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode topRight = stack.peek().right;
                if(topRight == null){
                    TreeNode top = stack.pop();
                    postList.add(top);
                    while(!stack.isEmpty() && top == stack.peek().right ){
                        top = stack.pop();
                        postList.add(top);
                    }
                }else{
                    curr = topRight;
                }
            }
        }
        System.out.println(postList);
    }
}
