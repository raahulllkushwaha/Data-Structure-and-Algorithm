class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(s, 0, n - 1);
    }
    public int solve(String s, int left, int right) {
        if (left > right) return 0;
        if (left == right) return 1;
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        if (s.charAt(left) == s.charAt(right)) {
            return dp[left][right] =
                2 + solve(s, left + 1, right - 1);
        }
        return dp[left][right] = Math.max(
            solve(s, left + 1, right),
            solve(s, left, right - 1)
        );
    }
}
