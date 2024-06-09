public class l03printInRange {
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

    public static void printInRange(Node root, int k1, int k2){
        if (root == null){
            return;
        }
        // Case 1 - Our range lies in left subtree, root & right subtree
        if (root.data >= k1 && root.data <=k2){
            printInRange(root.left, k1, k2);
            System.out.println(root.data + " ");
            printInRange(root.right, k1, k2);
        } 
        // Case 2 - Our range lies in left subtree
        else if (root.data < k1){
            printInRange(root.left, k1, k2);
        }
        // Case 2 - Our range lies in left subtree
        else{
            printInRange(root.right, k1, k2);
        }
    }
    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        
        for (int i=0; i<arr.length; i++){
            root = insert(root, arr[i]);
        }

        printInRange(root, 5, 12);
    }
}