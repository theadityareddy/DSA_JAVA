public class l02deleteNode {
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

    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search (Node root, int key){ // O(h)
        if (root == null){
            return false;
        }

        if (root.data == key){
            return true;
        }
        if (root.data > key){
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val){
        if (root.data > val){
            root.left = delete(root.left, val);
        } else if (root.data < val){
            root.right = delete(root.right, val);
        } else {
            // you find the node that you want to delete

            // case 1 - no child
            if (root.left == null && root.right == null){
                return null;
            }

            // case 2 - one child 
            if (root.left == null){
                return root.right;
            } 
            else if (root.right == null){
                return root.left;
            }
            else{

            // case 3 - both child 
                Node is = findInOrderSucessor(root.right, val);
                root.data = is.data;
                root.right = delete(root.right, is.data);
            }
        }
        return root;
    }

    public static Node findInOrderSucessor(Node root, int val){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        
        for (int i=0; i<arr.length; i++){
            root = insert(root, arr[i]);
        }

        inorder(root);
        System.out.println();

        delete(root, 10);
        System.out.println();

        inorder(root);
        System.out.println();
    }
}