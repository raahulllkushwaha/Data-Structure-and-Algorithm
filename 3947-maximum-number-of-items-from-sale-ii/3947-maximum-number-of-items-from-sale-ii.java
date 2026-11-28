class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int[] item : items){
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }
        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }
        int[] gain = new int[maxFactor + 1];
        for(int i = 1; i <= maxFactor; i++){
            int count = 0;
            for(int j = i; j <= maxFactor; j+=i){
                count += freq[j];
            }
            gain[i] = count - 1;
        }
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));
        long ans = 0;
        long remaining = budget;

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            if (2L * minPrice < price) {
                break;
            }
            int available = gain[factor];
            long take = Math.min(
                (long) available,
                remaining / price
            );
            ans += 2 * take;
            remaining -= take * price;
        }
        ans += remaining / minPrice;
        return (int) ans;
    }
}