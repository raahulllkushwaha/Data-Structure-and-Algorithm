class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int currentDecrement = 0;
        int[] diff = new int[n + 1];

        for (int i = 0; i < n; i++) {
            currentDecrement -= diff[i];
            int needed = nums[i] - currentDecrement;

            if (needed < 0) {
                return false;
            }

            if (needed > 0) {
                if (i + k > n) {
                    return false;
                }
                currentDecrement += needed;
                diff[i + k] += needed;
            }
        }

        return true;
    }
}
