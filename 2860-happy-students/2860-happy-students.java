class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int n = nums.size();
        int count = 0;
        for (int k = 0; k <= n; k++) {
            boolean left = (k == 0 || nums.get(k - 1) < k);
            boolean right = (k == n || nums.get(k) > k);
            if (left && right) {
                count++;
            }
        }
        return count;
    }
}