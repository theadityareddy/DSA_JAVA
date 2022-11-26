// 0001000
// 0021200
// 0321230
// 4321234

public class p10pattern {
    public static void main(String[] args) {
        int n = 7;
        for (int i = 1; i <= n; i++){
            for (int j = n-i; j > 0; j--){
                System.out.print("0");
            }

            for (int j = i; j > 1; j--){
                System.err.print(j);
            }
            
            for (int j = 1; j <= i; j++){
                System.out.print(j);
            }

            for (int j = n-i; j > 0; j--){
                System.out.print("0");
            }

            System.out.println();
        }
    }
}