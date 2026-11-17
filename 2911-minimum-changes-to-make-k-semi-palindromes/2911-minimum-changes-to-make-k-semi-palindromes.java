class Solution {
    public int minimumChanges(String s, int k) {

        int n = s.length();
        int INF = 1000000;
        int[][] cost = new int[n][n];
        for (int len = 2; len <= n; len++){
            for (int i = 0; i + len <= n; i++){
                int j = i + len - 1;
                cost[i][j] = INF;
                for (int d = 1; d < len; d++){
                    if (len % d != 0) {
                        continue;
                    }
                    int changes = 0;
                    int groups = len / d;
                    for (int r = 0; r < d; r++) {
                        for (int t = 0; t < groups / 2; t++) {
                            int left = i + r + t * d;
                            int right = i + r + (groups - 1 -t) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }
        int[][] dp = new int[k + 1][n + 1];

        for (int p = 0; p <= k; p++) {
            for (int j = 0; j <= n; j++) {
                dp[p][j] = INF;
            }
        }

        dp[0][0] = 0;
        for (int p = 1; p <= k; p++){
            for (int j = 2 * p; j <= n; j++){
                for (int t = 2 * (p - 1); t <= j - 2; t++){
                    if (dp[p - 1][t] == INF){
                        continue;
                    }
                    dp[p][j] = Math.min( dp[p][j], dp[p - 1][t] + cost[t][j - 1]);
                }
            }
        }
        return dp[k][n];
    }
}
