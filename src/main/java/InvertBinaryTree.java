public class InvertBinaryTree {
    public Node invert(Node root) {
        if (root != null) {
            Node left = invert(root.left);
            Node right = invert(root.right);

            root.left = right;
            root.right = left;

        }
        return root;
    }
}
