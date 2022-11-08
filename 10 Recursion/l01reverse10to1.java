public class l01reverse10to1 {
    public static void main(String[] args) {
        int n=10;
        rev(n);
    }

    public static void rev(int n) {
        if (n==1){
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        rev(n-1);
    }
} 