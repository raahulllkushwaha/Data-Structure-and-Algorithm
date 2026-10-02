class Solution {
    long find(int[] arr, int n, int speed){
        long h = 0;
        for(int i = 0; i < n; i++){
            h += arr[i]/ speed;
            if(arr[i] % speed != 0){
                h++;
            }
        }
        return h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = 0;
        for(int pile : piles){
            high = Math.max(high, pile);
        }
        int result = high;

        while (low <= high){
            int mid = low + (high - low) / 2;
            long hour = find(piles, n, mid);
            if(hour > h){
                low = mid + 1;
            }
            else{
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }
}