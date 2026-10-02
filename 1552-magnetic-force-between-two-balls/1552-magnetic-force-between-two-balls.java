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
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = position[n - 1] - position[0];
        int result = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(func(position, n, m, mid)){
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