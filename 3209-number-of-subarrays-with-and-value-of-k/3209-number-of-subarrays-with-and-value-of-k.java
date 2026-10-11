class Solution {
    public long countSubarrays(int[] nums, int k) {
        Map<Integer, Long> prev = new HashMap<>();
        long ans = 0;

        for (int num : nums) {
            Map<Integer, Long> curr = new HashMap<>();

            curr.put(num, curr.getOrDefault(num, 0L) + 1);

            for (Map.Entry<Integer, Long> entry : prev.entrySet()) {
                int value = entry.getKey() & num;
                curr.put(value,
                    curr.getOrDefault(value, 0L) + entry.getValue());
            }

            ans += curr.getOrDefault(k, 0L);
            prev = curr;
        }

        return ans;
    }
}
