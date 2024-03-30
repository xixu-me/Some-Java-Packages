package equationsolver;

import java.util.Random;

public final class QuadraticEquationSolver {
    private double a;
    private double b;
    private double c;
    private double x[];

    public QuadraticEquationSolver(double a, double b, double c) throws Exception {
        if (a == 0)
            throw new Exception("The coefficient of the quadratic term cannot be zero.");
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0)
            throw new Exception("The quadratic equation has no real roots.");
        this.a = a;
        this.b = b;
        this.c = c;
        this.x = new double[2];
        double sqrtDiscriminant = Math.sqrt(discriminant);
        x[0] = (-b - sqrtDiscriminant) / (2 * a);
        x[1] = (-b + sqrtDiscriminant) / (2 * a);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double[] getX() {
        return x;
    }

    public static void main(String[] args) {
        Random r = new Random();
        double a = r.nextInt(3) == 0 ? 0 : r.nextDouble(200) - 100;
        double b = r.nextDouble(200) - 100;
        double c = r.nextDouble(200) - 100;
        String equation = String.format("%sx^2 %s %sx %s %s = 0;",
                a < 0 ? "-" + -a : a,
                b < 0 ? "-" : "+",
                b < 0 ? -b : b,
                c < 0 ? "-" : "+",
                c < 0 ? -c : c);
        System.out.println(equation);
        try {
            QuadraticEquationSolver solver = new QuadraticEquationSolver(a, b, c);
            System.out.println("x = " + solver.getX()[0] + ", " + solver.getX()[1] + ".");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}