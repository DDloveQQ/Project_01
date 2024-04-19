package Tree;

public class BinaryTree<E> {
    private TreeNode root; //二叉树的根结点
    private int total;//结点总个数

    private class TreeNode {
        //至少有以下几个部分
        TreeNode parent;
        TreeNode left;
        E data;
        TreeNode right;

        public TreeNode(TreeNode parent, TreeNode left, E data, TreeNode right) {
            this.parent = parent;
            this.left = left;
            this.data = data;
            this.right = right;
        }
    }
}
