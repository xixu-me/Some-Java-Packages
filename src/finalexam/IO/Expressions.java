package finalexam.StandardIO;

import java.util.Scanner;

public class Expressions {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split("[\\(\\),]");
        double ans = 0;
        switch (arr[0]) {
            case "add":
                ans = Double.parseDouble(arr[1]) + Double.parseDouble(arr[2]);
                break;
            case "sub":
                ans = Double.parseDouble(arr[1]) - Double.parseDouble(arr[2]);
                break;
            case "max":
                ans = Math.max(Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
                break;
            case "min":
                ans = Math.min(Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
                break;
            case "doubleMe":
                ans = Double.parseDouble(arr[1]) * 2;
                break;
        }
        System.out.println(s + "=" + Double.toString(ans));
    }
}
