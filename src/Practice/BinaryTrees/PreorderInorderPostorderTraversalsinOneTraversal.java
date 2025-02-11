package Practice.BinaryTrees;

import java.util.*;

public class PreorderInorderPostorderTraversalsinOneTraversal {
    // https://www.youtube.com/watch?v=ySp2epYvgTE&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk

    public void allTraversals(TreeNode root){
        List<TreeNode> preorder = new ArrayList<>();
        List<TreeNode> inorder = new ArrayList<>();
        List<TreeNode> postorder = new ArrayList<>();

        Stack<Item> stack = new Stack<>();
        stack.push(new Item(root, 1));

        while(!stack.isEmpty()){
            Item top = stack.pop();
            if(top.traversalNo == 1){
                // increment traversalNo to 2
                // push left side of tree
                preorder.add(top.node);
                top.traversalNo++;
                stack.push(top);
                if(top.node.left != null) stack.push(new Item(top.node.left, 1));
            }else if(top.traversalNo == 2){
                // increment traversalNo to 3
                // push right side of tree
                inorder.add(top.node);
                top.traversalNo++;
                stack.push(top);
                if(top.node.right != null) stack.push(new Item(top.node.right, 1));
            }else{
                postorder.add(top.node);
            }
        }
    }

    class Item{
        TreeNode node;
        int traversalNo;

        Item(TreeNode node, int traversalNo){
            this.node = node;
            this.traversalNo = traversalNo;
        }
    }
}
