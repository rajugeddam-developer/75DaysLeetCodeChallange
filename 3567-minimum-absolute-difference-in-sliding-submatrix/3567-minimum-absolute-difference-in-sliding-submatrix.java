import java.util.*;

public class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                List<Integer> values = new ArrayList<>();

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        values.add(grid[x][y]);
                    }
                }

                Collections.sort(values);

                int minDiff = Integer.MAX_VALUE;

                for (int idx = 1; idx < values.size(); idx++) {
                    int a = values.get(idx);
                    int b = values.get(idx - 1);

                    if (a != b) {
                        minDiff = Math.min(minDiff, a - b);
                    }
                }

                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }

        return ans;
    }
}