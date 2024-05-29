package finalexam.StandardIO;

import java.util.Scanner;

public class StringInitialization {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        for (int i = 1; i < c.length; i++) 
            if (c[i - 1] != ',' && c[i - 1] != ' ')
                c[i] = Character.toLowerCase(c[i]);
            else
                c[i] = Character.toUpperCase(c[i]);
        System.out.println(new String(c));
    }
}
