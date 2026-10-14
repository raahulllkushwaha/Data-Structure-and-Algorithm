class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder result = new StringBuilder();
        if(sum > 9 * num){
            return "";
        }
            
        for(int i = 0; i < num; i++){
           if(sum >= 9){
            result.append(9);
            sum -= 9;
           }
           else if(sum < 9){
            result.append(sum);
            sum = 0;
           }
        }
        return result.toString();
    }
}