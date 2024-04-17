package shopping;

import java.util.ArrayList;
import java.util.List;

public class ShopCar {
    List<Good> liCar;

    public ShopCar() {
        this.liCar = new ArrayList<Good>();
    }

    public void add(Good gd) {
        this.liCar.add(gd);
    }

    public boolean del(String inName) {
        boolean flag = false;
        Good tempGd;
        for (int i = 0; i < this.liCar.size(); i++) {
            tempGd = this.liCar.get(i);
            if (tempGd.getName().equals(inName)) {
                this.liCar.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public float getTotal() {
        float total = 0;
        for (Good gd : this.liCar) {
            total += gd.getPrice();
        }
        return total;
    }
}
