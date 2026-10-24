class Solution {
    private int toDays(String date){
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int totalDays = 0;

        for(int y = 1971; y < year; y++){
            totalDays += isLeapYear(y) ? 366 : 365;
        }
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(isLeapYear(year)){
            days[1] = 29;
        }
        for (int m = 0; m < month - 1; m++) {
        totalDays += days[m];
        }

        totalDays += day;

        return totalDays;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(toDays(date1) - toDays(date2));
    }
}