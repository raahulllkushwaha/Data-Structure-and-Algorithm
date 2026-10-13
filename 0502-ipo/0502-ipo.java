class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];

        for(int i = 0; i < n; i++){
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int idx = 0;

        for(int i = 0; i < k; i++){
            while(idx < n && projects[idx][0] <= w){
                maxProfitHeap.add(projects[idx][1]);
                idx++;
            }

            if(maxProfitHeap.isEmpty()){
                break;
            }
            w += maxProfitHeap.poll();
        }
        return w;
    }
}