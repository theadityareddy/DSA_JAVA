public class l06mirrorBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val){ // O(h)
        if (root == null){
            return new Node (val);
        }
        if (root.data > val){
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void preorder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node mirror(Node root){ // O(n)
        if (root == null){
            return null;
        }
        // get both subtrees in 2 variables
        Node leftSubtree = mirror(root.left);
        Node rightSubtree = mirror(root.right);
        // swap two subtrees
        root.left = rightSubtree;
        root.right = leftSubtree;

        return root;
    }

    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 6, 10, 11};
        Node root = null;
        
        for (int i=0; i<arr.length; i++){
            root = insert(root, arr[i]);
        }

        preorder(mirror(root));
        System.out.println();
    }
}