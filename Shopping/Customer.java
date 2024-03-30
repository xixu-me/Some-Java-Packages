package shopping;

public class Customer {
    private String strName;
    private float fMoney;
    ShopCar sc;

    public Customer(String strName, float fMoney) {
        this.strName = strName;
        this.fMoney = fMoney;
        this.sc = new ShopCar();
    }

    public void pay(float sun) {
        this.fMoney -= sun;
    }

    public void addGood(Good gd) {
        this.sc.add(gd);
    }

    public String getName() {
        return this.strName;
    }

    public float getMoney() {
        return this.fMoney;
    }

    public ShopCar getShopCar() {
        return this.sc;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public void setMoney(float fMoney) {
        this.fMoney = fMoney;
    }

    public void setShopCar(ShopCar sc) {
        this.sc = sc;
    }
}
