package Practice.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class MaxStackLeetcode {
    // https://leetcode.ca/2017-11-15-716-Max-Stack/
    // look at coding solution not explanation

    TreeMap<Integer, List<Node>> treeMap = new TreeMap<>();
    DoubleLinkedList stack = new DoubleLinkedList();


    void push(int val){
        Node node = stack.push(val);
        treeMap.compute(val, (key,value) -> {
            if(value == null) value = new ArrayList<>();
            value.add(node);
            return value;
        });
    }

    int pop(){
        Node node = stack.pop();
        List<Node> nodes = treeMap.get(node.val);
        nodes.remove(nodes.size()-1);

        if(nodes.isEmpty()) treeMap.remove(node.val);
        return node.val;
    }

    int peek(){
        return stack.peek();
    }

    int peekMax(){
        return treeMap.lastKey();
    }

    int popMax(){
        int max = treeMap.lastKey();

        List<Node> nodes = treeMap.get(max);
        Node node = nodes.remove(nodes.size()-1);

        if(nodes.isEmpty()) treeMap.remove(max);

        stack.remove(node);

        return max;
    }


    class Node{
        int val;
        Node prevNode;
        Node nextNode;

        public Node(){}

        public Node(int val){
            this.val = val;
        }
    }

    class DoubleLinkedList{
        Node head = new Node();
        Node tail = new Node();

        DoubleLinkedList(){
            tail.prevNode = head;
            head.nextNode = tail;
        }

        Node push(int val){
            Node node = new Node(val);
            Node prev = tail.prevNode;

            prev.nextNode = node;
            node.prevNode = prev;
            node.nextNode = tail;
            tail.prevNode = node;

            return node;
        }

        Node remove(Node node){
            Node prev = node.prevNode;
            Node next = node.nextNode;

            prev.nextNode = next;
            next.prevNode = prev;

            return node;
        }

        Node pop(){
            return remove(tail.prevNode);
        }

        int peek(){
            return tail.prevNode.val;
        }
    }
}

