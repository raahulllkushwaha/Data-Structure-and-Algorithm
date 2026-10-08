class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int opened = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                if(opened > 0){
                    res.append(c);
                }
                opened++;
            } else{
                if(opened > 1){
                    res.append(c);
                }
                opened--;
            }
        }
        return res.toString();
    }
}