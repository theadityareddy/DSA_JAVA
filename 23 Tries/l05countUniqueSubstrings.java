public class l05countUniqueSubstrings {
    static  class Node{
        Node[] children = new Node[26];
        boolean eow;

        public Node(){
            for(int i =0; i<26; i++){
                children[i] = null;            
            }
            eow = false;
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        int level =0;
        int len = word.length();
        int idx;

        Node curr = root;

        for(level =0; level<len; level++){
            idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int count =0;
        for(int i =0; i<26; i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }

        return count + 1;
    }

    public static void main(String args[]){
        String str = "ababa"; // ans =10;

        //suffix -> trie
        for(int i =0; i<str.length(); i++){
           String curr =  str.substring(i);
           insert(curr);
        }

        System.out.println(countNodes(root));
        
    }
}