package calculator;

public class Factory {
    public static Compute getCompute(char op) {
        switch (op) {
            case '+':
                return new Add();
            case '-':
                return new Subtract();
            case '*':
                return new Multiply();
            case '/':
                return new Divide();
            default:
                return null;
        }
    }
}