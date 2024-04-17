package shopping;

public class Cashier {
    private String strName;
    private float fMoney;

    public Cashier(String strName, float fMoney) {
        this.strName = strName;
        this.fMoney = fMoney;

    }

    public void cash(Customer cm) {
        float total = cm.getShopCar().getTotal();
        cm.pay(total);
        this.fMoney += total;
    }

    public void print(Customer cm) {
        System.out.println("Cashier: " + this.fMoney);
        System.out.println("Customer: " + cm.getMoney());
        Good gd;
        for (int i = 0; i < cm.sc.liCar.size(); i++) {
            gd = cm.sc.liCar.get(i);
            System.out.println("name: " + gd.getName() + " price: " + gd.getPrice());
        }
    }

    public String getName() {
        return this.strName;
    }

    public float getMoney() {
        return this.fMoney;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public void setMoney(float fMoney) {
        this.fMoney = fMoney;
    }
}
