class Solution {
    public int minimumDeletions(String s) {
        int ans = 0;
        int bCount = 0;
        for(char c : s.toCharArray()) {
            if(c == 'b') {
                bCount++;
            } else {
                ans = Math.min(1 + ans, bCount);
            }
        }
        return ans;
    }
}