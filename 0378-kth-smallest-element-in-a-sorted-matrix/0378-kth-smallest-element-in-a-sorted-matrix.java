class Solution {
    private int func(int[][] matrix, int mid, int n){
        int count = 0;
        int row = n - 1;
        int col = 0;
        while (row >= 0 && col < n){
            if(matrix[row][col] <= mid){
                count += (row + 1);
                col++;
            } else{
                row--;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0]; // samllest element
        int high = matrix[n-1][n-1];  // largest element
        int result = low;   
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(func(matrix, mid, n) >= k){
                result = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return result;
    }
}