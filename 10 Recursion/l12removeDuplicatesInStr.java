public class l12removeDuplicatesInStr {
    public static void main(String[] args) {
        String str = "adityareddy"; // ans = adityre    
        removeDuplicates(str, 0, new StringBuilder (""), new boolean [26]);
    }

    private static void removeDuplicates(String str, int i, StringBuilder newStr, boolean[] map) {
        //base
        if (i==str.length()){
            System.out.println(newStr);
            return;
        }

        //main code
        char c = str.charAt(i);
        if (map[c - 'a'] == true){
            removeDuplicates(str, i+1, newStr, map);
        } else {
            map [c - 'a'] = true;
            removeDuplicates(str, i+1, newStr.append(c), map);
        }
    }
}
