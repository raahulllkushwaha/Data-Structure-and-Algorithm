class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        Map<String, Integer> wordMap = new HashMap<>();
        for(String w : words){
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }

        for(int i = 0; i < wordLen; i++){
            Map<String, Integer> seen = new HashMap<>();
            int left = i, right = i, count = 0;

            while(right + wordLen <= s.length()){
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    count++;

                    while (seen.get(sub) > wordMap.get(sub)) {
                        String leftSub = s.substring(left, left + wordLen);
                        seen.put(leftSub, seen.get(leftSub) - 1);
                        count--;
                        left += wordLen;
                    }
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else{
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}