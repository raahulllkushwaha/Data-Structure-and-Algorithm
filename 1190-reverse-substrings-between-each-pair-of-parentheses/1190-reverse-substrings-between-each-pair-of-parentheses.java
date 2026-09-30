class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch != ')'){
                stk.push(ch);
            }
            else {
                StringBuilder temp = new StringBuilder();
                
                while(stk.peek() != '('){
                    temp.append(stk.pop()); 
                }
                stk.pop();
                for(int j = 0; j < temp.length(); j++){
                    stk.push(temp.charAt(j));
                }
            }
            
        }
        StringBuilder result = new StringBuilder();
        while(!stk.isEmpty()){
            result.insert(0, stk.pop());
        }
        return result.toString();
    }
}