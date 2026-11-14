class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int x = worker.length;
        int totalProfit = 0;
       
        for(int i = 0; i < x; i++){
            int maxProfit = 0;
            for(int j = 0; j < n; j++){
                if(difficulty[j] <= worker[i]){
                    maxProfit = Math.max(maxProfit, profit[j]);
                }
            }
            totalProfit += maxProfit;
        }
        return totalProfit;
    }
}