public class l02ascending1toN {
    public static void main(String[] args) {
        int n=10;
        asc(n);
    }

    public static void asc(int n) {
        if (n==1){
            System.out.print(n + " ");
            return;
        }
        asc(n-1);
        System.out.print(n + " ");
    }
}
