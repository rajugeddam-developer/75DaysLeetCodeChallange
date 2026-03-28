class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: Validate diagonal
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
        }

        char[] res = new char[n];
        Arrays.fill(res, '#');

        char ch = 'a';

        // Step 2: Assign characters greedily
        for (int i = 0; i < n; i++) {
            if (res[i] == '#') {
                if (ch > 'z') return ""; // more than 26 groups

                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        res[j] = ch;
                    }
                }
                ch++;
            }
        }

        // Step 3: Validate LCP matrix
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int expected;

                if (res[i] == res[j]) {
                    if (i + 1 < n && j + 1 < n)
                        expected = 1 + lcp[i + 1][j + 1];
                    else
                        expected = 1;
                } else {
                    expected = 0;
                }

                if (lcp[i][j] != expected) return "";
            }
        }

        return new String(res);
    }
}