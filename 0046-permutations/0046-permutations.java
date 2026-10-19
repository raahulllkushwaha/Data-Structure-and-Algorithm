class Solution {
    private void func(int[] nums, List<Integer> currentPer, List<List<Integer>> answer, boolean[] used){
        if(currentPer.size() == nums.length){
            answer.add(new ArrayList<>(currentPer));
            return;
        }     
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                currentPer.add(nums[i]);

                func(nums, currentPer, answer, used);
                currentPer.remove(currentPer.size() - 1);
                used[i] = false;
            }
        }
}
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> currentPer = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        func(nums, currentPer, answer, used);
        return answer;
    }
}