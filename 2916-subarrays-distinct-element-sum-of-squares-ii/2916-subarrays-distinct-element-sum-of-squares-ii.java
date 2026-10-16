class Solution {
    private static final long MOD = 1_000_000_007L;

    private static class SegmentTree {
        long[] sum;
        long[] sumSq;
        int[] lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new int[4 * n];
        }

        private void apply(int node, int left, int right, int delta) {
            long len = right - left + 1L;

            sumSq[node] = (
                sumSq[node]
                + 2L * delta * sum[node]
                + (long) delta * delta * len
            ) % MOD;

            sum[node] = (
                sum[node] + (long) delta * len
            ) % MOD;

            lazy[node] += delta;
        }

        private void push(int node, int left, int right) {
            if (lazy[node] == 0 || left == right) {
                return;
            }

            int mid = left + (right - left) / 2;
            int delta = lazy[node];

            apply(node * 2, left, mid, delta);
            apply(node * 2 + 1, mid + 1, right, delta);

            lazy[node] = 0;
        }

        void add(int ql, int qr) {
            if (ql > qr) {
                return;
            }
            update(1, 0, n - 1, ql, qr);
        }

        private void update(
            int node, int left, int right,
            int ql, int qr
        ) {
            if (ql <= left && right <= qr) {
                apply(node, left, right, 1);
                return;
            }

            push(node, left, right);

            int mid = left + (right - left) / 2;

            if (ql <= mid) {
                update(node * 2, left, mid, ql, qr);
            }

            if (qr > mid) {
                update(node * 2 + 1, mid + 1, right, ql, qr);
            }

            sum[node] = (
                sum[node * 2] + sum[node * 2 + 1]
            ) % MOD;

            sumSq[node] = (
                sumSq[node * 2] + sumSq[node * 2 + 1]
            ) % MOD;
        }

        long getSumOfSquares() {
            return sumSq[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        int[] last = new int[100001];

        java.util.Arrays.fill(last, -1);

        SegmentTree tree = new SegmentTree(n);
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];

            tree.add(prev + 1, i);

            ans = (ans + tree.getSumOfSquares()) % MOD;

            last[nums[i]] = i;
        }

        return (int) ans;
    }
}
