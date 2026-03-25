class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        long total = 0;
        
        // Step 1: total sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }
        
        // If odd, impossible
        if (total % 2 != 0) return false;
        
        long target = total / 2;
        
        // Step 2: horizontal cuts
        long prefix = 0;
        for (int i = 0; i < m - 1; i++) { // ensure non-empty bottom
            for (int j = 0; j < n; j++) {
                prefix += grid[i][j];
            }
            if (prefix == target) return true;
        }
        
        // Step 3: vertical cuts
        prefix = 0;
        for (int j = 0; j < n - 1; j++) { // ensure non-empty right
            for (int i = 0; i < m; i++) {
                prefix += grid[i][j];
            }
            if (prefix == target) return true;
        }
        
        return false;
    }
}