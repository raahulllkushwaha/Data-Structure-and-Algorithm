class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) { 
            Arrays.sort(nums);
            used = new boolean[nums.length];

            backtrack(nums);
            return result;
    }

    void backtrack(int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            used[i] = true;

            backtrack(nums);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}

    
