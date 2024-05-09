public class l01bubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int turn = 0; turn <= arr.length - 2; turn++) {

            int swaps = 0; // checks how many swaps happen : if 0 then arr is sorted

            for (int j = 0; j <= arr.length - 2 - turn; j++) {
                // swap
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (swaps != 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 3, 2 };
        bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}