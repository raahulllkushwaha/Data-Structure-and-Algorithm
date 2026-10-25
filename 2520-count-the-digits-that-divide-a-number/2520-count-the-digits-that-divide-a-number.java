class Solution {
    public int countDigits(int num) {
        int val = 0;
        int original = num;
        while(num > 0){
            int digit = num % 10;
            num /= 10;

            if(original % digit == 0){
                val++;
            }
        }
        
        return val;
    }
}