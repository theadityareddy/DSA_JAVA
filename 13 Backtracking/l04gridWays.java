public class l04gridWays {
    static int count = 0;
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int grid[][] = new int[n][m];
        gridWays(grid, 0, 1);
        System.out.println(count);
    }

    private static void gridWays(int[][] grid, int n, int m) {
        // base case 
        if (n==grid.length-1 && m==grid.length-1){
            count ++;
            return;
        }
        // recurssion
        if (m<grid.length){
            gridWays(grid, n, m+1); // right
        }
        if (n<grid.length){
            gridWays(grid, n+1, m); // down
        }
    }
}
// Time Complexity is O(n^(n+m))