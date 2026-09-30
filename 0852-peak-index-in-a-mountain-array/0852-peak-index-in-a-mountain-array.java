class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int result = 0;
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] < arr[i + 1]){
               continue;
            }
            else if(arr[i] > arr[i+1]){
                result = i;
                break;
            }
            
        }
        return result;
    }
}