class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;

        Deque<int[]> deque = new ArrayDeque<>();
        long cost = 0;
        long ans = 0;

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            int count = 1;
            while (!deque.isEmpty() && deque.peekLast()[0] < num) {
                int[] last = deque.pollLast();

                int nextNum = last[0];
                int nextCount = last[1];

                count += nextCount;

                cost += (long) (num - nextNum) * nextCount;
            }

            deque.offerLast(new int[]{num, count});
            while (cost > k) {
                int[] first = deque.pollFirst();

                int rightmostNum = first[0];
                int rightmostCount = first[1];

                cost -= (long) (rightmostNum - nums[j]);
                j--;

                if (rightmostCount > 1) {
                    deque.offerFirst(
                        new int[]{rightmostNum, rightmostCount - 1}
                    );
                }
            }
            ans += j - i + 1;
        }

        return ans;
    }
}
