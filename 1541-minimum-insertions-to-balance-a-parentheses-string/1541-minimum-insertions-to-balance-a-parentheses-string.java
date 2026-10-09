class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertion = 0;
        for(int i = 0; i < s.length(); i++){
           if(s.charAt(i) == '('){
              stack.push('(');
           }  else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else{
                            insertion++;
                        }
                        i++;
                    }
                    else{
                        if(!stack.isEmpty()){
                            stack.pop();
                            insertion++;
                        }
                        else{
                            insertion += 2;
                        }
                    }
                }
                
             }
            
        
         insertion += stack.size() * 2;
        return insertion;
    }
}