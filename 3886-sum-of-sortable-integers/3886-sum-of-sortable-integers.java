class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int k = 1; k <=n; k++){
            if(n % k != 0) continue;
            if(check(nums, k)){
                sum += k;
            }
        }
        return sum;
    }
    private boolean check(int[] nums, int len){
        int n = nums.length;
        int min = 0;

        for(int i = 0; i < n; i+=len){
            if(nums[i] < min) return false;

            int max = nums[i];
            boolean point = false;

            for(int j = i+1; j < i+len; j++){
                if(nums[j] < min) return false;

                if(nums[j-1] > nums[j]){
                    if(point) return false;
                    point = true;
                }
                max = Math.max(max, nums[j]);
            }
            if(point){
                if(nums[i] < nums[i+len-1]) return false;
            }
            min = max;
        }
        return true;
    }
}