public class l05largestLexicographicString {
    public static void main(String args[]) {
        String fruits[] = { "Apple", "apple", "mango", "grapes", "pineapple", "Kiwi", "Blueberry", "Litchi" };

        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (fruits[i].compareToIgnoreCase(largest) > 0) {
                largest = fruits[i];
            }
        }

        System.out.println(largest);
    }
}
