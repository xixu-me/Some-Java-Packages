package calculator;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print(">>> ");
                int a = sc.nextInt();
                char op = sc.next().charAt(0);
                int b = sc.nextInt();
                System.out.println(Factory.getCompute(op).computer(a, b));
            }
        }
    }
}