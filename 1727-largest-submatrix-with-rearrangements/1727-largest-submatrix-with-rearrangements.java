import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] heights = new int[m][n];

        // Step 1: Build heights
        for (int j = 0; j < n; j++) {
            heights[0][j] = matrix[0][j];
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] == 1) {
                    heights[i][j] = heights[i-1][j] + 1;
                } else {
                    heights[i][j] = 0;
                }
            }
        }

        int maxArea = 0;

        // Step 2: For each row, sort heights and compute max area
        for (int i = 0; i < m; i++) {
            int[] row = heights[i].clone();
            Arrays.sort(row); // ascending
            for (int j = 0; j < n; j++) {
                int h = row[n - 1 - j]; // descending order
                maxArea = Math.max(maxArea, h * (j + 1));
            }
        }

        return maxArea;
    }
}