package finalexam.StandardIO;

import java.util.Scanner;

public class DateCalculation {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split("[-]");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        int days[] = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (isLeapYear(year))
            days[2] = 28;
        int ans = day;
        for (int i = 1; i < month; i++)
            ans += days[i];
        System.out.println(ans);
    }

    static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
