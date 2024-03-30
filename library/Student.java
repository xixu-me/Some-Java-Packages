package library;

public class Student {
    private int iId;
    private String strName;
    private Bag bg;

    public Student(int inId, String inName) {
        this.iId = inId;
        this.strName = inName;
        this.bg = new Bag();
    }

    public void addBook(Book bk) {
        this.bg.add(bk);
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public Bag getBg() {
        return bg;
    }

    public void setBg(Bag bg) {
        this.bg = bg;
    }
}