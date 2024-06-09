public class l06V1diameterOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int diameter(Node root) { // O(n^2)
        if (root == null) {
            return 0;
        }
        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);

        int leftHt = height(root.left);
        int rightHt = height(root.right);

        int selfDia = leftHt + rightHt + 1;

        return Math.max(selfDia, (Math.max(rightDia, leftDia)));
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         * /
         * 8
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);

        System.out.println("the diameter of a tree is " + diameter(root));
    }
}