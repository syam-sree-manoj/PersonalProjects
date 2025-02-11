package Practice.BinaryTrees;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        Deque<TreeNode> dq = new ArrayDeque<>();

        if( root == null) return list;

        dq.addLast(root);
        boolean leftToRight = true;
        while(!dq.isEmpty()){
            int size = dq.size();
            LinkedList<Integer> l = new LinkedList<>();
            while(size > 0){
                TreeNode node = dq.pollFirst();
                if(leftToRight){
                    l.addLast(node.val);
                }else{
                    l.addFirst(node.val);
                }
                if(node.left != null) dq.addLast(node.left);
                if(node.right != null) dq.addLast(node.right);
                size--;
            }
            list.add(l);
            leftToRight = !leftToRight;
        }
        return list;
    }
}
