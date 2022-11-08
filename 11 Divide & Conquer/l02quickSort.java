public class l02quickSort {
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 4, 2};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }

    private static void printArr(int arr[]){
        for (int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void quickSort(int[] arr, int si, int ei) {
        //base case
        if(si>=ei){
            return;
        }

        //my Pivot is last element

        int pidx = partition(arr, si, ei); //accepts the partition index

        quickSort(arr, si, pidx-1); // for left
        quickSort(arr, pidx+1, ei); //for right
    }

    private static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si-1; //makes space for elements smaller than pivot

        for (int j=si; j<ei; j++){
            if (arr[j] < pivot){ // here pivot is a value not index... hence, no arr[pivot]
                i++;
                //swap
                int temp = arr[j];
                arr [j] = arr[i];
                arr[i] = temp;
            }
        }
        //to swap pivot to rt place
        i++;
        //swap
        int temp = arr[ei];
        arr [ei] = arr[i];
        arr[i] = temp;

        return i; // returns the partition index
    }
}