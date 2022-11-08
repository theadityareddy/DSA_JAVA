public class l4 {
    public static void main(String[] args) {
        char ch=65; //char c='A' __ this also increments by ch++
        for (int i=1; i<=4; i++)
        {
            for (int j=1; j<=i; j++)
            { 
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }
}
