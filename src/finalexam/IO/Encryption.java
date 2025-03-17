package finalexam.StandardIO;

import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String k = sc.nextLine();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++)
            c[i] += k.charAt(i % k.length()) - '0';
        System.out.println(new String(c));
    }
}
