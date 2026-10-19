class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
               result.add(i);
            }
            else if(nums[i] < target){
                low++;
            }
            else{
                high--;
            }
        }
        return result;
    }
}