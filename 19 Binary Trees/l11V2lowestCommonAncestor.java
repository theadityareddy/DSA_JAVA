public class l11V2lowestCommonAncestor {
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

        System.out.println(lca(root, 4, 5).data);
    }
}