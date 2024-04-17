package shopping;

public class Good {
    private String strName;
    private float fPrice;
    private int iCount;

    public Good(String strName, float fPrice, int iCount) {
        this.strName = strName;
        this.fPrice = fPrice;
        this.iCount = iCount;
    }

    public String getName() {
        return strName;
    }

    public float getPrice() {
        return fPrice;
    }

    public int getCount() {
        return iCount;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public void setPrice(float fPrice) {
        this.fPrice = fPrice;
    }

    public void setCount(int iCount) {
        this.iCount = iCount;
    }
}
