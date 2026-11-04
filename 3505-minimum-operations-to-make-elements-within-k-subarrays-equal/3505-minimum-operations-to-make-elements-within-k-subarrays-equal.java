class Solution {
    static class SlidingMedian {
        TreeMap<Long, Integer> low = new TreeMap<>();
        TreeMap<Long, Integer> high = new TreeMap<>();

        long lowSum = 0, highSum = 0;
        int lowSize = 0, highSize = 0;

        void add(long num) {
            if (low.isEmpty() || num <= low.lastKey()) {
                addLow(num);
            } else {
                addHigh(num);
            }
            balance();
        }

        void remove(long num) {
            if (low.containsKey(num)) {
                removeLow(num);
            } else {
                removeHigh(num);
            }
            balance();
        }

        void addLow(long num) {
            low.merge(num, 1, Integer::sum);
            lowSum += num;
            lowSize++;
        }

        void addHigh(long num) {
            high.merge(num, 1, Integer::sum);
            highSum += num;
            highSize++;
        }

        void removeLow(long num) {
            removeValue(low, num);
            lowSum -= num;
            lowSize--;
        }

        void removeHigh(long num) {
            removeValue(high, num);
            highSum -= num;
            highSize--;
        }

        void removeValue(TreeMap<Long, Integer> map, long num) {
            int count = map.get(num);
            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }

        void balance() {
            while (lowSize > highSize + 1) {
                long val = low.lastKey();
                removeLow(val);
                addHigh(val);
            }

            while (lowSize < highSize) {
                long val = high.firstKey();
                removeHigh(val);
                addLow(val);
            }
        }

        long median() {
            return low.lastKey();
        }

        long cost() {
            long med = median();

            return med * lowSize - lowSum
                    + highSum - med * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // Step 1: Calculate cost of every window of size x
        long[] cost = new long[n - x + 1];

        SlidingMedian sm = new SlidingMedian();

        for (int i = 0; i < n; i++) {
            sm.add(nums[i]);

            if (i >= x) {
                sm.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = sm.cost();
            }
        }

        // Step 2: DP
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        Arrays.fill(prev, 0);

        for (int j = 1; j <= k; j++) {
            long[] curr = new long[n + 1];
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                // Do not choose a subarray ending at i
                curr[i] = curr[i - 1];

                // Choose a subarray of length x ending at i
                if (i >= x && prev[i - x] != INF) {
                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            prev = curr;
        }

        return prev[n];
    }
}
