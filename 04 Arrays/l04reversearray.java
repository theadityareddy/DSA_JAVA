import java.util.Scanner;

public class l04reversearray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a[]={2,4,5,8,12,23,31,38};
        System.out.println("enter no to find in an array");
        int rev[] = reverse(a);
        for(int i=0;i<rev.length;i++){
            System.out.print(rev[i]+" ");
        }
        in.close();
    }

    public static int[] reverse(int a[]) {
        int temp = 0, min =0, max=a.length-1;
        while(min<=max){
            temp = a[min];
            a[min]=a[max];
            a[max]=temp;
            min++;
            max--;
        }
        return a;
    }
}

// TimeComplexity = O(n/2) = O(n)
// SpaceComplexity = O(2) = O(1) : we save a lot of space by this method, else we'd have to store revered array in new array.