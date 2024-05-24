package finalexam.StandardIO;

import java.util.Scanner;

public class DateFormatOutput {
    public static void main(String[] args) {
        char[] num = { '〇', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String arr[] = s.split("[-]");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int date = Integer.parseInt(arr[2]);
        System.out.println(year + "年" + month + "月" + date + "日");
        String yearStr = "";
        String monthStr = "";
        String dateStr = "";
        for (int i = 0; i < arr[0].length(); i++) {
            yearStr += num[arr[0].charAt(i) - '0'];
        }
        yearStr += "年";
        if (month < 10) {
            monthStr = num[month] + "月";
        } else {
            monthStr = "十" + num[month % 10] + "月";
        }
        if (date < 10) {
            dateStr = num[date] + "日";
        } else if (date < 20) {
            dateStr = "十" + num[date % 10] + "日";
        } else {
            dateStr = num[date / 10] + "十" + num[date % 10] + "日";
        }
        System.out.println(yearStr + monthStr + dateStr);
    }
}
