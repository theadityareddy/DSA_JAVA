import java.util.*;

public class l04root2leafPaths {
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

    public static void root2leafpaths(Node root, ArrayList <Integer> list){
        if (root == null){
            return;
        }

        list.add(root.data);

        if (root.left == null && root.right == null){
            printPath(list);
        }

        root2leafpaths(root.left, list);
        root2leafpaths(root.right, list);
        list.remove(list.size() - 1);
    }

    public static void printPath(ArrayList <Integer> list){
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + "->");
        }
        System.out.println("Null");
    }
    
    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 6, 10, 11, 14};
        Node root = null;
        
        for (int i=0; i<arr.length; i++){
            root = insert(root, arr[i]);
        }

        root2leafpaths(root, new ArrayList<>());
    }
}