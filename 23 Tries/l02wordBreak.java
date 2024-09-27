public class l02wordBreak {
    
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        Node(){
            for(int i =0; i<26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){

        Node curr = root;
        for(int i =0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String key){

        Node curr = root;

        for(int i =0; i<key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public static boolean wordbreak(String key){
        //base case
        if(key.length() == 0) {
            return true;
        }   

        for(int i =1; i<=key.length(); i++){ //as in substring(0, 1) -> 1 is not included 
            if(search(key.substring(0, i)) && wordbreak(key.substring(i)) ){
                return true;
            }
        }
        //here we are checking the current string and then recursively strings ahead of them
        //so for current string to be present, wordbreak shoud be true for the remaining part

        return false;
    }

    
    
    public static void main(String args[]){

        String arr[] = {"i", "like", "samsung" , "mobile" , "ice","sam"};
        for(int i =0; i<arr.length; i++){
            insert(arr[i]);
        }

        String key = "ilikesamsung";

    

        System.out.println(wordbreak(key));
    }
}