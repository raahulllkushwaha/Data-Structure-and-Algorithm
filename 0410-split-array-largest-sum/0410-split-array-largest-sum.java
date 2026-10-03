class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }
        int result = 0;
        while (low <= high){
            int mid = low + (high - low) / 2;

            int subarrayNeeded = 1;
            int currentSum = 0;
            for(int num : nums){
                if(currentSum + num <= mid){
                    currentSum += num;
                }
                else{
                    subarrayNeeded++;
                    currentSum = num;
                }
            }
            if(subarrayNeeded <= k){
                result = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return result; 
    }
}