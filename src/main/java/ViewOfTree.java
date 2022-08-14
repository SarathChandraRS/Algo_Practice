public class ViewOfTree {
    private static int max_level =0;
    public void leftViewTree(Node root, int level){
        if (root == null)
            return ;

        if (max_level < level){
            System.out.println(root.val + " ");
            max_level = level;
        }
        leftViewTree(root.left, level+1);
        leftViewTree(root.right, level+1);
    }
}
