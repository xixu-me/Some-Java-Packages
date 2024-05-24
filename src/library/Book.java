package library;

public class Book {
    private String strIsbn;
    private String strTitle;
    private int iCount;

    public Book(String inIsbn, String inTitle, int inCount) {
        this.strIsbn = inIsbn;
        this.strTitle = inTitle;
        this.iCount = inCount;
    }

    public String getStrIsbn() {
        return strIsbn;
    }

    public void setStrIsbn(String strIsbn) {
        this.strIsbn = strIsbn;
    }

    public String getStrTitle() {
        return strTitle;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public int getiCount() {
        return iCount;
    }

    public void setiCount(int iCount) {
        this.iCount = iCount;
    }
}
