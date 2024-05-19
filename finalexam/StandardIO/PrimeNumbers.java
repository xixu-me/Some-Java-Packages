import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers {
    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int ans = 0;
        List<Integer> li = new ArrayList<Integer>();
        for (int j = 2; j < i; j++) {
            if (isPrime(j)) {
                ans++;
                li.add(j);
            }
        }
        System.out.print(ans + "(分别是");
        for (int j = 0; j < li.size(); j++) {
            System.out.print(li.get(j));
            if (j != li.size() - 1)
                System.out.print(",");
        }
        System.out.println(")");
    }
}
