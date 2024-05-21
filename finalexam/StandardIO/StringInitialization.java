package finalexam.StandardIO;

import java.util.Scanner;

public class StringInitialization {
    public static void main(String[] var0) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuffer sb = new StringBuffer(s);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        for (int i = 1; i < s.length(); ++i)
            if (s.charAt(i - 1) != ',' && s.charAt(i - 1) != ' ')
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
            else
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        System.out.println(sb);
    }
}
