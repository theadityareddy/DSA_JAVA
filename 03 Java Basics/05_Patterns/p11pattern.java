// 10101111
// 01010111
// 10101111
// 01010111
// 10101111
// 11111111
// 11111111

public class p11pattern {
    public static void main(String[] args) {
        for (int i = 0; i<7; i++){
            for (int j = 0; j<8; j++){
                if ((i+j) % 2 == 0 || j>4 || i>4){
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
}
