class Solution {
    public int differenceOfSums(int n, int m) {
        int sumN = 0;
        int sumM = 0;
        for(int i = 1; i <= n; i++){
            if(i % m == 0){
                sumM += i;
            } else{
                sumN += i;
            }
           
        }
        return sumN - sumM;
    }
}