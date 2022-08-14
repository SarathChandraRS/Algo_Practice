package binarysearchtree;

public class IdenticalTrees {

    public boolean identicalTrees(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if (node1 != null && node2 != null)
            return (node1.val == node2.val && identicalTrees(node1.left, node2.left) && identicalTrees(node1.right, node2.right));

        return false;
    }

}
