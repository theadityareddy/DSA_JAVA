public class l14transformToSumTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }

        // get the prev value of the node b4 re-writing data of the node
        int prevLeftVal = transform(root.left);
        int prevRightVal = transform(root.right);

        // story the root data... and later on return it
        int data = root.data;

        // get the new data for child nodes after re-writing data of the node
        int leftNodeVal = (root.left == null) ? 0 : root.left.data;
        int rightNodeVal = (root.right == null) ? 0 : root.right.data;

        // rewrite the current node's data
        root.data = prevLeftVal + leftNodeVal + prevRightVal + rightNodeVal;

        return data;
    }

    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         * 
         * expected output :
         * 27
         * / \
         * 9 13
         * / \ / \
         * 0 0 0 0
         * 
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transform(root);
        preorderTraversal(root);
        System.out.println();
    }
}