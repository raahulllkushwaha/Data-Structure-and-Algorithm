class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int weight : weights){
            low = Math.max(low, weight);
            high += weight;
        }
        int result = 0;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int currentWeight = 0;
            int daysNeeded = 1;

            for(int weight: weights){
                if(currentWeight + weight <= mid){
                    currentWeight += weight;
                }
                else{
                    daysNeeded++;
                    currentWeight = weight;
                }
            }
            if(daysNeeded <= days){
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