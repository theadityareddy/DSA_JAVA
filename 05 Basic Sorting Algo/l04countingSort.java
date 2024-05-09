public class l04countingSort {

    public static void countingSort(int[] arr) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // find freq of numbers
        int[] count = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // sorting
        int currArr = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[currArr] = i;
                count[i]--;
                currArr++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 1, 3, 2, 4, 3, 7 };
        countingSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
