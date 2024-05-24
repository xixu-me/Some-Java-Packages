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
                    if (twenty > 1 && five > 0) {
                        twenty -= 2;
                        five--;
                        fifty++;
                        success = true;
                    } else if (ten > 1 && twenty > 0 && five > 0) {
                        ten -= 2;
                        twenty--;
                        five--;
                        fifty++;
                        success = true;
                    } else if (ten > 3 && five > 0) {
                        ten -= 4;
                        five--;
                        fifty++;
                        success = true;
                    } else if (twenty > 0 && ten > 0 && five > 2) {
                        twenty--;
                        ten--;
                        five -= 3;
                        fifty++;
                        success = true;
                    } else if (ten > 2 && five > 2) {
                        ten -= 3;
                        five -= 3;
                        fifty++;
                        success = true;
                    } else if (twenty > 0 && five > 4) {
                        twenty--;
                        five -= 4;
                        fifty++;
                        success = true;
                    } else if (ten > 1 && five > 4) {
                        ten -= 2;
                        five -= 4;
                        fifty++;
                        success = true;
                    } else if (ten > 0 && five > 6) {
                        ten--;
                        five -= 6;
                        fifty++;
                        success = true;
                    } else if (five > 9) {
                        five -= 10;
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

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getTwenty() {
        return twenty;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }

    public int getFifty() {
        return fifty;
    }

    public void setFifty(int fifty) {
        this.fifty = fifty;
    }

    public int getHundred() {
        return hundred;
    }

    public void setHundred(int hundred) {
        this.hundred = hundred;
    }
}
