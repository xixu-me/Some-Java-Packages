package finalexam.StandardIO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] arr = s.split("[-]");
        int year = Integer.parseInt(arr[0]), month = Integer.parseInt(arr[1]), day = Integer.parseInt(arr[2]);
        System.out.println(year + "年" + month + "月" + day + "日");
    }
}
