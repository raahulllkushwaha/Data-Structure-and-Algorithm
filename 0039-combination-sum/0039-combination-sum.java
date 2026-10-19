class Solution {
    private void func(int[] arr, int n, int idx, List<Integer> diary, int sum, List<List<Integer>> result, int target){
        if(idx == n){
           return;
        }
        if(sum == target){
            result.add(new ArrayList<>(diary));
            return;
        }
        func(arr, n, idx+1, diary, sum, result, target); //dont take
        if(arr[idx] + sum <= target){ //take it
            diary.add(arr[idx]);
            sum += arr[idx];

            func(arr, n, idx, diary, sum, result, target);
            diary.remove(diary.size() - 1);
            sum -= arr[idx];
        }
        return;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        func(candidates, n, 0, diary, 0, result, target);
        return result;
    }
}
