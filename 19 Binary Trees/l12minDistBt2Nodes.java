public class l12minDistBt2Nodes {
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

    public static Node lca (Node root, int n1, int n2){ // O(n)
        // base case
        // if root == null or root.data == n1 or root.data == n2 ... return root
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLCA = lca(root.left, n1, n2);
        Node rightLCA = lca(root.right, n1, n2);

        // backtracking concept

        // if rightLCA == null... return LeftLCA
        if(rightLCA == null){
            return leftLCA;
        }

        // if leftLCA == null... return rightLCA
        if(leftLCA == null){
            return rightLCA;
        }

        // if both LCA are not null... return root
        return root;
    }

    public static int findDist(Node root, int n){
        // base case
        if (root == null){
            return -1;
        }

        // found element ... from now on add 1 everytime you backtrack
        if (root.data == n){
            return 0;
        }

        // find left and right dist
        int leftDist = findDist(root.left, n);
        int rightDist = findDist(root.right, n);

        // this concept is similar to LCA
        if (leftDist == -1 && rightDist == -1){
            return -1;
        } else if (leftDist == -1){
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2){
        // find lca
        Node lca = lca(root, n1, n2);

        int dist1 = findDist(lca, n1);
        int dist2 = findDist(lca, n2);

        return dist1 + dist2;
    }

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7  
                expected output : 4 5 6 7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("the dist bt 2 nodes is " + minDist(root, 4, 6));
    }
}
