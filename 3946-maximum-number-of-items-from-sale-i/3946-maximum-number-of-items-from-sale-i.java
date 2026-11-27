class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] free = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && items[j][0] % items[i][0] == 0){
                    free[i]++;
                }
            }
        }

        int k = -1;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (items[i][1] < minPrice ||
                (items[i][1] == minPrice && free[i] > free[k])) {
                minPrice = items[i][1];
                k = i;
            }
        }

        if (minPrice > budget) {
            return 0;
        }
        int[] dpWithK = new int[budget + 1];
        int[] dpWithoutK = new int[budget + 1];
        Arrays.fill(dpWithK, -1);
        Arrays.fill(dpWithoutK, -1);

        dpWithK[minPrice] = 1 + free[k];
        dpWithoutK[0] = 0;

         for (int i = 0; i < n; i++) {
            if (i == k) continue;

            int price = items[i][1];
            int value = 1 + free[i];

            for (int c = budget; c >= price; c--) {

                if (dpWithK[c - price] != -1) {
                    dpWithK[c] = Math.max(
                        dpWithK[c],
                        dpWithK[c - price] + value
                    );
                }

                if (dpWithoutK[c - price] != -1) {
                    dpWithoutK[c] = Math.max(
                        dpWithoutK[c],
                        dpWithoutK[c - price] + value
                    );
                }
            }
        }

        int ans = 0;

        // Calculate the maximum answer
        for (int c = 0; c <= budget; c++) {
            int extra = (budget - c) / minPrice;

            if (dpWithK[c] != -1) {
                ans = Math.max(ans, dpWithK[c] + extra);
            }

            if (dpWithoutK[c] != -1) {
                int bonus = extra > 0 ? free[k] : 0;

                ans = Math.max(
                    ans,
                    dpWithoutK[c] + extra + bonus
                );
            }
        }

        return ans;
    }
}