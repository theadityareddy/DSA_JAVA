import java.util.Scanner;

public class l01linearsearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a[]={2,4,5,8,12,23,31,38};
        int key = 12;
        System.out.println("the position of " + key + " is " + (linearsearch(a,key)+1));
        in.close();
    }

    public static int linearsearch(int[] a, int key) {
        for (int i=0; i<a.length;i++){
            if (a[i]==key) {
                return i;
            }
        }
        return -1;
    }
}

// Time Complexity is O(n)
