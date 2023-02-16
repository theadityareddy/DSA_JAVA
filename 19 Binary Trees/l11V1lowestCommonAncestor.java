import java.util.*;

public class l11V1lowestCommonAncestor {
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

    public static boolean getPath(Node root, int n, ArrayList<Node> path){ // O(n)
        if (root == null){
            return false;
        }

        path.add(root);

        if (root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        // if either node has the value "n", then return true
        if(foundLeft || foundRight){
            return true;
        }

        // if both return false then, return false and remove node form path as it doesnt contain 
        path.remove(root);
        return false;
    }

    public static Node lca (Node root, int n1, int n2){ // O(n^2)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // get path from root to n1 and n2
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // lowest common ancestor - lca
        int i;
        for (i=0; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        // the last anscestor is i-1 ... as at i

        return path1.get(i-1);
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