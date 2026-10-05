class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.merge(w, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a,b ) -> {
            if(!a.getValue().equals(b.getValue())){
                return a.getValue() - b.getValue();
            }
            return b.getKey().compareTo(a.getKey());  
        });

        for(Map.Entry<String, Integer> e : freq.entrySet()){
            minHeap.add(e);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        String[] result = new String[k];
        for(int i = k - 1; i >= 0; i--){
            result[i] = minHeap.poll().getKey();
        }
        return Arrays.asList(result);
    }
}