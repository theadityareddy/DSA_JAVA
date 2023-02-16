public class l13KthAncestorOfNode {
    static class Node{
        int data;
        Node right;
        Node left;

        public Node (int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static int kthancestor(Node root,int n, int k){
        if (root == null){
            return -1;
        }
        if (root.data == n){
            return 0;
        }

        // concept similar to min dist bt 2 nodes
        int leftDist = kthancestor(root.left, n, k);
        int rightDist = kthancestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1){
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if ((max+1) == k){
            System.out.print(" " + root.data);
        }System.out.println();
        return max+1;
    }

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7  
                expected output : 1
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print("the kth ancestor is ");
        kthancestor(root, 5, 2);
    }
}