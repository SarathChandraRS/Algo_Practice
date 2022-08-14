package binarysearchtree;

public class MaxPathLeafRootSum {

    public int maxSum(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        int maxPath = Math.max(maxSum(root.left),maxSum(root.right));
        return root.val + maxPath;
    }
}
