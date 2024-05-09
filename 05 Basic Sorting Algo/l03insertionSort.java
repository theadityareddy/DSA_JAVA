public class l03insertionSort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int curr = arr[i];
            int prev = i - 1;

            // to get which position to place curr in
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // place curr in correct place i.e. prev+1 (coz prev is reduced by one in our
            // last loop of while)
            arr[prev + 1] = curr;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 3, 2 };
        insertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
