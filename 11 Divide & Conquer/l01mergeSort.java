public class l01mergeSort {
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }

    private static void printArr(int arr[]){
        for (int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void mergeSort(int[] arr, int si, int ei) {
        //mid
        int mid = si + (ei - si)/2; // (si+ei)/2

        // base case
        if (si>=ei){
            return;
        }

        // main code
        mergeSort(arr, si, mid); // for left
        mergeSort(arr, mid+1, ei); // for right

        //merge
        merge(arr, si, mid, ei);
    }

    private static void merge(int[] arr, int si, int mid, int ei) {
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        //traverses the two array and makes a new sorted array
        while (i<=mid && j<=ei){
            if (arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp [k++] = arr [j++];
            }
        }

        //for remaining elements in right 
        while (i<=mid){
            temp[k++] = arr[i++];
        }

        //for remaining elements in left
        while (j<=ei){
            temp[k++] = arr[j++];
        }

        //copy temp to original arr
        for (k=0, i=si; k<temp.length; k++,i++){
            arr[i] = temp[k];
        }
    }
}