package library;

public class Administrator {
    private int iId;
    private String strName;
    private Library lib;

    public Administrator(int inId, String inName) {
        this.iId = inId;
        this.strName = inName;
        this.lib = new Library();
    }

    public boolean register(Student st) {
        for (Book bk : st.getBg().getLiBag())
            if (!this.lib.del(bk)) {
                System.out.println("Book not found in library: " + bk.getStrIsbn());
                return false;
            }
        this.print(st);
        return true;
    }

    private void print(Student st) {
        System.out.println("Administrator ID: " + this.iId);
        System.out.println("Administrator Name: " + this.strName);
        System.out.println("Student ID: " + st.getiId());
        System.out.println("Student Name: " + st.getStrName());
        for (Book bk : st.getBg().getLiBag())
            System.out.println(
                    "Book ISBN: " + bk.getStrIsbn() + " Title: " + bk.getStrTitle() + " Count: " + bk.getiCount());
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

    public Library getLib() {
        return lib;
    }

    public void setLib(Library lib) {
        this.lib = lib;
    }
}
