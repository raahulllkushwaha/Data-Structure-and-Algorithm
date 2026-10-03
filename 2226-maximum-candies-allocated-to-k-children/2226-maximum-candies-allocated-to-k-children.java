class Solution {
    public int maximumCandies(int[] candies, long k) {
       int low = 1;
       int high = 0;
        for(int candie : candies){
            high = Math.max(high, candie);
        }
        int result = 0;
       while (low <= high){
          long sum = 0;
          int mid = low + (high - low) / 2;
          for(int i = 0; i < candies.length; i++){
            sum += candies[i] / mid;
          }  
            if(sum >= k){
                result = mid;
                low = mid + 1;
            } else{
                
                high = mid - 1;
            }
          
       }
       return result;
    }
}