package Recursion;

public class AddvalueToBST {
    class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
            left=right=null;
        }
    }
    public Node add(Node node,int val){
        if(node == null){
            Node insertNode = new Node(val);
            return insertNode;
        }
        if(node.val < val){
            node.right = add(node.right,val);
        }else{
            node.left = add(node.left,val);
        }
        return node;
    }
}
