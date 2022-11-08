import java.util.Scanner;

public class l03binarysearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a[]={2,4,5,8,12,23,31,38};
        System.out.println("enter no to find in an array");
        int key = in.nextInt();
        System.out.println("the no is at " + binary(a,key));
        in.close();
    }

    public static int binary(int a[], int key) {
        int min=0, max = (a.length-1), mid=0;
        while(min<=max){
            mid = ( min + max ) / 2;
            //mid
            if (a[mid]==key){
                return mid;
            }
            //left
            if (a[mid]>key){
                max = mid -1;
            }
            //right
            if (a[mid]<key){
                min = mid + 1;
            }
        }
        return -1;
    }
}
