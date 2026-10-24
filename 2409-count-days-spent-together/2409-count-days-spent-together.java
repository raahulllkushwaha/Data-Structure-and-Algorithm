class Solution {
    private int toDayOfYear(String date){
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int months = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        for(int i = 0; i < months - 1; i++){
            day += days[i];
        }
        return day;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int start = Math.max(toDayOfYear(arriveAlice), toDayOfYear(arriveBob));
        int end = Math.min(toDayOfYear(leaveAlice), toDayOfYear(leaveBob));
        return Math.max(0, end - start + 1);
    }
}