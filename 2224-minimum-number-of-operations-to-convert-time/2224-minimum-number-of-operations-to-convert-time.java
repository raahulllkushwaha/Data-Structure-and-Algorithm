class Solution {
    public int convertTime(String current, String correct) {
        int start = Integer.parseInt(current.substring(0, 2)) * 60
                  + Integer.parseInt(current.substring(3, 5));

            int end = Integer.parseInt(correct.substring(0, 2)) * 60
            + Integer.parseInt(correct.substring(3, 5));

            int diff = end - start;
            int[] operations = {60, 15, 5, 1};
            int count = 0;

            for (int op : operations) {
                count += diff / op;
                diff %= op;
            }

            return count;
        
    }
}