package ticket;

public class TicketSeller implements Runnable {
    private int five, ten, twenty, fifty, hundred;

    public TicketSeller(int five, int ten, int twenty, int fifty, int hundred) {
        this.five = five;
        this.ten = ten;
        this.twenty = twenty;
        this.fifty = fifty;
        this.hundred = hundred;
    }

    @Override
    public synchronized void run() {
        String threadName = Thread.currentThread().getName();
        String[] threadNameArr = threadName.split("-");
        String userName = threadNameArr[0];
        int payment = Integer.valueOf(threadNameArr[1]);
        boolean success = false;
        while (!success) {
            switch (payment) {
                case 5:
                    five++;
                    success = true;
                    break;
                case 10:
                    if (five > 0) {
                        five--;
                        ten++;
                        success = true;
                    }
                    break;
                case 20:
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                        twenty++;
                        success = true;
                    } else if (five >= 3) {
                        five -= 3;
                        twenty++;
                        success = true;
                    }
                    break;
                case 50:
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                        fifty++;
                        success = true;
                    } else if (five >= 3) {
                        five -= 3;
                        fifty++;
                        success = true;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid payment amount!");
            }
            if (!success) {
                System.out.println(userName + ": Unable to get change, ticket purchase failed, waiting!");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(userName + ": Ticket purchase successful!");
                notifyAll();
            }
        }
    }
}
