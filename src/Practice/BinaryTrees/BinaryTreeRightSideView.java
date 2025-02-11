package Practice.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView {
    // https://leetcode.com/problems/binary-tree-right-side-view/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> dq = new ArrayDeque<>();

        if( root == null) return list;

        dq.addLast(root);

        while(!dq.isEmpty()){
            int size = dq.size();
            while(size > 0){
                TreeNode node = dq.pollFirst();
                if(size == 1) list.add(node.val);
                if(node.left != null) dq.addLast(node.left);
                if(node.right != null) dq.addLast(node.right);
                size--;
            }
        }
        return list;
    }
}
