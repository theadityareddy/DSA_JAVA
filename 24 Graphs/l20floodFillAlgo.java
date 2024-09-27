public class l20floodFillAlgo { // LEETCODE : 733 (Easy)

    // Helper method to perform recursive flood fill using DFS
    public void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol) {
        // Base condition: Check boundaries and ensure we are working on unvisited, valid pixels
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length 
            || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }
        
        // Set the new color and mark the pixel as visited
        image[sr][sc] = color;
        vis[sr][sc] = true;
        
        // Recursively call helper on adjacent cells (left, right, up, down)
        
        // left
        helper(image, sr, sc - 1, color, vis, orgCol);
        // right
        helper(image, sr, sc + 1, color, vis, orgCol);
        // up
        helper(image, sr - 1, sc, color, vis, orgCol);
        // down
        helper(image, sr + 1, sc, color, vis, orgCol);
    }

    // Flood fill method that initializes the process
    public int[][] floodFill(int[][] image, int sr, int sc, int color) { // TC : O(m*n)
        // Create a boolean matrix to track visited pixels
        boolean vis[][] = new boolean[image.length][image[0].length];
        
        // Start the flood fill from the initial pixel (sr, sc) with its original color
        helper(image, sr, sc, color, vis, image[sr][sc]);
        
        // Return the updated image
        return image;
    }

    public static void main(String[] args) {
        
    }
}
