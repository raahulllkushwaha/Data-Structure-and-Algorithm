class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
         PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for(char ch : freq.keySet()){
            maxHeap.add(new int[]{ch, freq.get(ch)});
        }

        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()){
            int[] curr = maxHeap.poll();
            char ch = (char) curr[0];
            int count = curr[1];

            for(int i = 0; i < count; i++){
                result.append(ch);
            }
        }
        return result.toString();
    }
}