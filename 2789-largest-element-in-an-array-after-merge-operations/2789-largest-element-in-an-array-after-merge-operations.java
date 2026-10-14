class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long currentSum = nums[n - 1]; 
        long maxSum = currentSum;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= currentSum) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
