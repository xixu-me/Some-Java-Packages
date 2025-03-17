package finalexam.StandardIO;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++)
            if (isPrime(i))
                primes.add(i);
        System.out.print(primes.size() + "(分别是");
        for (int i = 0; i < primes.size(); i++) {
            System.out.print(primes.get(i));
            if (i != primes.size() - 1)
                System.out.print(",");
        }
        System.out.println(")");
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
