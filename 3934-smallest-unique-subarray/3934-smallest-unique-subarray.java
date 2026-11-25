class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int[] sa = buildSuffixArray(nums);
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }
        int[] lcp = new int[n];
        int h = 0;
        for (int i = 0; i < n; i++) {
            int r = rank[i];
            if (r == 0) continue;
            int j = sa[r - 1];
            while (i + h < n && j + h < n &&
                   nums[i + h] == nums[j + h]) {
                h++;
            }
            lcp[r] = h;
            if (h > 0) h--;
        }
        int ans = n;
        for (int i = 0; i < n; i++) {
            int maxLcp = 0;
            if (i > 0) {
                maxLcp = Math.max(maxLcp, lcp[i]);
            }
            if (i < n - 1) {
                maxLcp = Math.max(maxLcp, lcp[i + 1]);
            }
            int required = maxLcp + 1;
            if (sa[i] + required <= n) {
                ans = Math.min(ans, required);
            }
        }
        return ans;
    }
    private int[] buildSuffixArray(int[] nums) {
    int n = nums.length;
    Integer[] sa = new Integer[n];
    int[] rank = new int[n];
    int[] newRank = new int[n];
    for (int i = 0; i < n; i++) {
        sa[i] = i;
        rank[i] = nums[i];
    }
    for (int len = 1; len < n; len *= 2) {
        final int k = len;
        final int[] currentRank = rank;
        Arrays.sort(sa, (a, b) -> {
            if (currentRank[a] != currentRank[b]) {
                return Integer.compare(currentRank[a], currentRank[b]);
            }
            int ra = a + k < n ? currentRank[a + k] : -1;
            int rb = b + k < n ? currentRank[b + k] : -1;
            return Integer.compare(ra, rb);
        });
        newRank[sa[0]] = 0;
        for (int i = 1; i < n; i++) {
            int a = sa[i - 1];
            int b = sa[i];
            boolean different =
                rank[a] != rank[b] ||
                (a + k < n ? rank[a + k] : -1) !=
                (b + k < n ? rank[b + k] : -1);
            newRank[b] = newRank[a] + (different ? 1 : 0);
        }
        int[] temp = rank;
        rank = newRank;
        newRank = temp;
        if (rank[sa[n - 1]] == n - 1) {
            break;
        }
    }
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
        result[i] = sa[i];
    }
    return result;
}
}