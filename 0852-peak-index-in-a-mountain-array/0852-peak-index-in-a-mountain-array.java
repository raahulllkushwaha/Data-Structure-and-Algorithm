class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int result = 0;
        int low = 0;
        int high = arr.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(arr[mid] < arr[mid + 1]){
               low++;
            }
            else if(arr[mid] > arr[mid + 1]){
                result = mid;
                high--;
            }
            
        }
        return result;
    }
}