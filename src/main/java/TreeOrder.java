import java.util.LinkedList;
import java.util.Queue;

public class TreeOrder {

    Node root;
   public static void main(String[] args)
    {
        TreeOrder tree = new TreeOrder();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

//        System.out.println(
//                "Preorder traversal of binary tree is ");
//        tree.printPreorder(tree.root);
//
//        System.out.println(
//                "\nInorder traversal of binary tree is ");
//        tree.printInorder(tree.root);
//
//        System.out.println(
//                "\nPostorder traversal of binary tree is ");
//        tree.printLeaves(tree.root);
//
        tree.inorderSuccessor(tree.root,new Node(5));

    }

    public void printPreorder(Node root){
       if (root == null){
           return;
       }
       System.out.println(root.val);
       printPreorder(root.left);
        printPreorder(root.right);
    }

    public void printInorder(Node root){
        if (root == null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    public void printPostorder(Node root){
        if (root == null){
            return;
        }
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.println(root.val);

    }

    public void printLeaves(Node root){
       if(root == null){
           return;
       }
       if(root.right == null && root.left == null){
           System.out.println(root.val);
       }
       printLeaves(root.left);
        printLeaves(root.right);
    }

    public void breadthFirstSearch(Node root){
        if (root== null) {
            return;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
    static boolean foundInorder = false;
    static boolean foundSuccessor = false;

    public void inorderSuccessor(Node root, Node inorder){

        if(root == null){
            return;
        }

        inorderSuccessor(root.left,inorder);
        if(foundInorder && !foundSuccessor){
            System.out.println(root.val);
            foundSuccessor = true;
            return;
        }
        if(root.val == inorder.val){
            foundInorder = true;
        }
        inorderSuccessor(root.right,inorder);
    }
}


class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
        left=right=null;
    }
}