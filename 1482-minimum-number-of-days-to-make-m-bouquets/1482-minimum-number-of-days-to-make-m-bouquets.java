class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if((long) m * k > bloomDay.length){
            return -1;
        }
        int n = bloomDay.length;
        int low = 1;
        int high = 0;
        for(int bloom : bloomDay){
            high = Math.max(high, bloom);
        }
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int bouquets = 0;
            int flowers = 0;
            for(int day : bloomDay){
                if(day <= mid){
                    flowers++;  
                    if(flowers == k){
                        bouquets++;
                        flowers = 0;
                    }
                } else{
                    flowers = 0;
                }
            }
            if(bouquets >= m){
                result =  mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
}