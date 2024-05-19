public class l03searchInSortedAndRotatedArray {

    public static int search(int[] arr, int tar, int si, int ei) {
        // base : invalid condition - target doesn't exist in arr
        if (si > ei) {
            return -1;
        }

        // find mid
        int mid = si + (ei - si) / 2;

        // case FOUND
        if (arr[mid] == tar) {
            return mid;
        }

        // mid on Line-1
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1); // case a : left of mid
            } else {
                return search(arr, tar, mid + 1, ei); // case b : right of mid
            }
        }
        // mid on Line-2
        else {
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei); // case c : right of mid
            } else {
                return search(arr, tar, si, mid - 1); // case d : left of mid
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int tarIdx = search(arr, target, 0, arr.length - 1);
        System.out.println("Found at : " + tarIdx);
    }

}
