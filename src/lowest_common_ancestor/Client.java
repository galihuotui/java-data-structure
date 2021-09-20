package lowest_common_ancestor;


public class Client {


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }


    public static void main(String[] args) {

        TreeNode root = initTree();

        //client.lowestCommonAncestor();

        //traverse(root);

        //TreeNode p = new

    }

    public static TreeNode initTree() {

        TreeNode root = new TreeNode(3, null, null);

        TreeNode node1 = new TreeNode(5, null, null);
        TreeNode node2 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(6, null, null);
        TreeNode node4 = new TreeNode(2, null, null);
        TreeNode node5 = new TreeNode(0, null, null);
        TreeNode node6 = new TreeNode(8, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node8 = new TreeNode(4, null, null);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        node4.left = node7;
        node4.right = node8;

        TreeNode treeNode = lowestCommonAncestor(root, node7, node6);
        System.out.println(treeNode);

        return root;
    }

    public static void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        traverse(root.left);
        traverse(root.right);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }

        return left == null ? right : left;

    }
}
