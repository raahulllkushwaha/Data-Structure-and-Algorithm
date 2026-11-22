class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        int g = gcd(n, k);
        long ans = 0;
        for (int i = 0; i < g; i++) {
            List<Integer> group = new ArrayList<>();
            int j = i;
            while (true) {
                group.add(arr[j]);
                j = (j + k) % n;
                if (j == i) {
                    break;
                }
            }
            Collections.sort(group);
            int median = group.get(group.size() / 2);
            for (int num : group) {
                ans += Math.abs((long) num - median);
            }
        }
        return ans;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}