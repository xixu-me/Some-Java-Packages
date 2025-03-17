package finalexam.StandardIO;

import java.util.Scanner;

class Goods {
    private String name;
    private double price;

    Goods(String inName, Double inPrice) {
        name = inName;
        price = inPrice;
    }

    public String toString() {
        return name + "," + price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class StatisticsOfProducts {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Goods[] goods = new Goods[5];
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            String name = sc.next();
            double price = sc.nextDouble();
            goods[i] = new Goods(name, price);
            sum += price;
        }
        for (int i = 0; i < 5; i++)
            System.out.println(goods[i].toString());
        System.out.println("应付:" + sum);
    }
}
