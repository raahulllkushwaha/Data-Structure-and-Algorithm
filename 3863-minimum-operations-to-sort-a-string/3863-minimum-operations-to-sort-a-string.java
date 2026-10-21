class Solution {
    public int minOperations(String s) {
        boolean alreadySorted = true;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) > s.charAt(i+1)){
                alreadySorted = false;
                break;
            }
        }
        if(alreadySorted){
            return 0;
        } 
        int n = s.length();

        if (n == 2) {
            return -1;
        }
        char min = s.charAt(0);
        char max = s.charAt(0);
        int minCount = 0;
        int maxCount = 0;

        for(int i = 0; i < s.length(); i++){
            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == min) {
                minCount++;
            }
            if (s.charAt(i) == max) {
                maxCount++;
            }
        }

        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        if (s.charAt(0) == max && s.charAt(n - 1) == min
                && maxCount == 1 && minCount == 1) {
            return 3;
        }

        return 2;
    }
}