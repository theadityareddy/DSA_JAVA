public class l08BSTtoBalancedBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if (root == null){
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node array2BST(ArrayList<Integer> inorder, int start, int end){
        if (start > end){
            return null;
        }
        int mid = (start + end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = array2BST(inorder, start, mid-1);
        root.right = array2BST(inorder, mid+1, end);
        return root;
    }

    public static Node balancedBST(Node root){
        // inorder seq 
        ArrayList <Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder -> BST
        root = array2BST(inorder, 0, inorder.size()-1);
        return root;
    }

    public static void main(String args[]) {
        /*
                     8
                   /   \
                  6     10
                 /       \
                5         11 
               /           \
              3             12
            given BST
         */
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        /*
                     8
                   /   \
                  5     11
                 / \    / \
                3   6  10 12
            expected BST
         */

         root = balancedBST(root);
         preorder(root);
    }
}
