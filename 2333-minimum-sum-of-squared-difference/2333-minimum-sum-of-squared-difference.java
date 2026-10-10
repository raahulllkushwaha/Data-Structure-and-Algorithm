class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];

        long k = (long) k1 + k2;
        int max = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }

        if (k >= total) return 0;

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                needed += Math.max(0, d - mid);
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int level = low;
        long used = 0;
        long sum = 0;

        for (int d : diff) {
            used += Math.max(0, d - level);
            int value = Math.min(d, level);
            sum += (long) value * value;
        }

        long remaining = k - used;
        sum -= remaining * (2L * level - 1);

        return sum;
    }
}
