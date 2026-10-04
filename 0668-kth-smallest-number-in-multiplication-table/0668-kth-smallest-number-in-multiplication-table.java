class Solution {
    private int func(int mid, int m, int n){
        int count = 0;
        for(int i = 1; i <= m; i++){
            count += Math.min(mid / i, n);
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int low = 0;
        int high = m * n;
        int result = low;   
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(func(mid, m, n) >= k){
                result = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return result;
    }
}