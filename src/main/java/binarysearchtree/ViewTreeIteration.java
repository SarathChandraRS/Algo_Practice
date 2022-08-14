package binarysearchtree;

import java.util.PriorityQueue;
import java.util.Stack;

class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
        left=right=null;
    }
}

public class ViewTreeIteration {
    Node root;
    public static void main(String[] args)
    {
        ViewTreeIteration tree = new ViewTreeIteration();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        System.out.println(
                "Preorder traversal of binary tree is ");
        tree.preorder(tree.root);
    }

    public void preorder(Node node){
        Stack<Node> result = new Stack();
        result.add(node);
        while(result.size() > 0){
            Node tempNode = result.pop();
            System.out.println(tempNode.val);
            if(tempNode.right != null){
                result.add(tempNode.right);
            }
            if(tempNode.left != null){
                result.add(tempNode.left);
            }
        }
    }
    public void inorder(Node node){
        Stack<Node> result = new Stack();
        result.add(node);
        while(result.size() > 0){
            Node tempNode = result.pop();
            System.out.println(tempNode.val);
            if(tempNode.right != null){
                result.add(tempNode.right);
            }
            if(tempNode.left != null){
                result.add(tempNode.left);
            }

        }
    }

}
