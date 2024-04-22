package ticket;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        TicketSeller ts = new TicketSeller(1, 1, 1, 1, 1);
        String name;
        int payment;
        boolean continueBuy = true;
        Scanner sc = new Scanner(System.in);
        while (continueBuy) {
            System.out.println("Ticket Seller: Five Yuan - " + ts.getFive() + ", Ten Yuan - " + ts.getTen()
                    + ", Twenty Yuan - " + ts.getTwenty() + ", Fifty Yuan - " + ts.getFifty() + ", Hundred Yuan - "
                    + ts.getHundred());
            System.out.print("Please enter your name: ");
            name = sc.nextLine();
            System.out.print("Please enter your payment: ");
            payment = sc.nextInt();
            Thread consumer = new Thread(ts, name + "-" + payment);
            consumer.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Do you want to continue buying tickets? Y: Yes, N: No");
            continueBuy = "Y".equalsIgnoreCase(sc.next());
            sc.nextLine();
        }
        sc.close();
    }
}
