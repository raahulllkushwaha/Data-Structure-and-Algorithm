class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = citations.length - 1;
        int result = 0;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(citations[mid] >= n - mid){
                result = n - mid;
                high = mid - 1; 
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
}