class Solution {
    private boolean func(int[] stalls, int n, int k, int mid){
        int cow = 1;
        int pos = stalls[0];
        for(int i = 1; i < n; i++){
            int dist = stalls[i] - pos;
            if(dist >= mid){
                cow++;
                pos = stalls[i];
            }
          
        }
        return cow >= k;
    }
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int low = 0;
        int high = price[n - 1] - price[0];
        int result = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(func(price, n, k, mid)){
                result = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return result;
    }
}