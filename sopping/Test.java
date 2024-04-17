package shopping;

public class Test {
    public static void main(String[] args) {
        Customer cs = new Customer("zhang", 2000);
        Cashier cash = new Cashier("li", 1000);
        cs.addGood(new Good("apple", 23.5f, 3));
        cs.addGood(new Good("book", 67.5f, 2));
        cs.addGood(new Good("Desk", 200f, 3));
        cash.cash(cs);
        cash.print(cs);
    }
}
