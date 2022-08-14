package binarysearchtree;

class Res{
    int val;
}
public class MaxPathSum {
    int maxValue;
    public int maxPathSum(Node root){
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
       return pathSum(root,res);
    }


        public int pathSum(Node root,Res res){

            if(root == null){
                return 0;
            }

            int left = pathSum(root.left,res);
            int right = pathSum(root.right,res);

            res.val = Math.max(root.val,res.val);
            res.val = Math.max(root.val + left,res.val);
            res.val = Math.max(root.val + right,res.val);
            res.val = Math.max(root.val + left + right ,res.val);

            return Math.max((Math.max(left,right)+root.val),root.val);
        }

}



