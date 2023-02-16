import java.util.*;

public class l09topViewOfTree {
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

    static class Info{
        Node node; // The tree Node
        int hd; // Horizontal Distance

        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        // We'll be doing level order traversal
        Queue<Info> q = new LinkedList<>();
        HashMap <Integer, Node> map = new HashMap<>(); // Integer -> hd (key) ... Node -> node (value)

        // adding 1st element (Level order traversal)
        q.add(new Info(root, 0)); // Root has horizontal dist of 0
        q.add(null);

        int min = 0;
        int max = 0;

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if (q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)){ // if we are adding horizontal dist for 1st time
                    map.put(curr.hd, curr.node);
                }
    
                if (curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
    
                if (curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i=min; i<=max; i++){
            System.out.print(map.get(i).data + " ");
        } System.out.println();
    }

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7  
                expected output : 4 2 1 3 7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topView(root);
    }
}