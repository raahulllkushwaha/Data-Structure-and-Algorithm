class Solution {
    private void func(String s, int start, List<String> current, List<List<String>> answer){
        if(start == s.length()){
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++){
            String sub = s.substring(start, end + 1);

            if (isPalindrome(sub)){
                current.add(sub);
                func(s, end + 1, current, answer);
                current.remove(current.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<String> current = new ArrayList<>();
        List<List<String>> answer = new ArrayList<>();

        func(s, 0, current, answer);

        return answer;
    }
}