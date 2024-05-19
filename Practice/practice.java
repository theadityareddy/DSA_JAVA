public class Practice {
    public static void printDec(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static int calcFact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * calcFact(n - 1);
    }

    public static int calcSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + calcSum(n - 1);
    }

    public static int calcFib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return calcFib(n - 1) + calcFib(n - 2);
    }

    public static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int findKey(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return findKey(arr, key, i + 1);
    }

    public static int findLastKey(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = findLastKey(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int calcPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * calcPower(x, n - 1);
    }

    public static int calcOptimizedPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPower = calcOptimizedPower(x, n / 2);
        if (n % 2 == 0) {
            return halfPower * halfPower;
        }
        return x * halfPower * halfPower;
    }

    public static void main(String[] args) {
        System.out.println(calcOptimizedPower(2, 10));
    }
}