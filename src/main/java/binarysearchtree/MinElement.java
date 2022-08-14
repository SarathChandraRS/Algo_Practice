package binarysearchtree;

public class MinElement {

    public int minELement (Node root){
        if(root == null){
            return 0;
        }
        int leftMin = minELement(root.left);
        int rightMin = minELement(root.right);
        return Math.min(root.val,Math.min(leftMin,rightMin));
    }
}
