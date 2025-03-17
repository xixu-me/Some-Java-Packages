package finalexam.StandardIO;

import java.util.Scanner;

public class SecurePasswordSpecification {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(isSafePassword(s) ? "success" : "fail");
    }

    static boolean isSafePassword(String password) {
        if (password.length() < 6 || password.length() > 12)
            return false;
        boolean haveLower = false, hasUpper = false, haveDigit = false, hasWhitespace = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c))
                haveLower = true;
            else if (Character.isUpperCase(c))
                hasUpper = true;
            else if (Character.isDigit(c))
                haveDigit = true;
            else if (Character.isWhitespace(c))
                hasWhitespace = true;
        }
        return haveLower && hasUpper && haveDigit && !hasWhitespace;
    }
}
