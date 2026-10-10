class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                pq.offer(new int[]{i, freq[i]});
            }
        }
        StringBuilder result = new StringBuilder();
        int prev = -1;
        int prevFreq = 0;

        while(!pq.isEmpty()){
            int[] p = pq.poll();
            result.append((char) (p[0] + 'a'));
            p[1]--;

            if(prev != -1 && prevFreq > 0){
                pq.offer(new int[]{prev, prevFreq});
            }

            prev = p[0];
            prevFreq = p[1];
        }
        return result.length() == s.length() ? result.toString() : "";
    }
}