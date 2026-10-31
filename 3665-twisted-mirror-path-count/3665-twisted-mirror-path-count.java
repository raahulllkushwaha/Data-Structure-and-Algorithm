class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;
        long[][] dp = new long[m][n];
        long[][] right = new long[m][n];
        long[][] down = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    if (i + 1 < m) {
                        if (grid[i+ 1][j] == 1) {
                            down[i + 1][j] =
                                (down[i + 1][j]+ right[i][j]) % MOD;
                        } else {
                            dp[i + 1][j] =
                                (dp[i + 1][j] + right[i][j]) % MOD;
                        }
                    }

                    if (j + 1 < n) {
                        if (grid[i][j + 1] == 1) {
                            right[i][j + 1] =
                                (right[i][j + 1] + down[i][j]) % MOD;
                        } else {
                            dp[i][j + 1] =
                                (dp[i][j + 1] + down[i][j]) % MOD;
                        }
                    }

                } else {

                    if (j + 1 < n) {
                        if (grid[i][j + 1] == 1) {
                            right[i][j + 1] =
                                (right[i][j + 1] + dp[i][j]) % MOD;
                        } else {
                            dp[i][j + 1] =
                                (dp[i][j + 1] + dp[i][j]) % MOD;
                        }
                    }

                    if (i + 1 < m) {
                        if (grid[i + 1][j] == 1) {
                            down[i + 1][j] =
                                (down[i + 1][j] + dp[i][j]) % MOD;
                        } else {
                            dp[i + 1][j] =
                                (dp[i + 1][j] + dp[i][j]) % MOD;
                        }
                    }
                }
            }
        }
return (int) dp[m - 1][n - 1];
    }
}
