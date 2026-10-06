class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int x = 0;
        for(char c : s.toCharArray()){
            if(c == '['){
                open++;
            } else{
                if(open > 0){
                    open--;
                } else{
                    x++;
                }
            }
        }
        return (x+1) / 2;
    }
}