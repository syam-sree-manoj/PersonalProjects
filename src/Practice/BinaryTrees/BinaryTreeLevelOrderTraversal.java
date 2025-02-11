package Practice.BinaryTrees;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        Deque<TreeNode> dq = new ArrayDeque<>();

        if( root == null) return list;

        dq.addLast(root);

        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> l = new ArrayList<>();
            while(size > 0){
                TreeNode node = dq.pollFirst();
                l.add(node.val);
                if(node.left != null) dq.addLast(node.left);
                if(node.right != null) dq.addLast(node.right);
                size--;
            }
            list.add(l);
        }
        return list;
    }
}
