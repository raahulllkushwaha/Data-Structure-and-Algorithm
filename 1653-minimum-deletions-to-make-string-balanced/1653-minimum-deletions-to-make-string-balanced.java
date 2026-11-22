class Solution {
    public int minimumDeletions(String s) {
        int deleteCount = 0;
        Stack<Character> stk = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == 'b'){
                stk.push(ch);
            }
            else {
                // ch == a
                if(!stk.isEmpty()){
                    deleteCount++;
                    stk.pop();
                }
            }
        }
        return deleteCount;
    }
}