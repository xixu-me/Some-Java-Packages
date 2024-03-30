package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> liLib;

    public Library() {
        this.liLib = new ArrayList<Book>();
    }

    public void add(Book bk) {
        Book tempBk;
        for (int i = 0; i < this.liLib.size(); i++) {
            tempBk = this.liLib.get(i);
            if (tempBk.getStrIsbn().equals(bk.getStrIsbn())) {
                tempBk.setiCount(tempBk.getiCount() + bk.getiCount());
                return;
            }
        }
        this.liLib.add(bk);
    }

    public boolean del(Book bk) {
        Book tempBk;
        for (int i = 0; i < this.liLib.size(); i++) {
            tempBk = this.liLib.get(i);
            if (tempBk.getStrIsbn().equals(bk.getStrIsbn())) {
                if (tempBk.getiCount() > bk.getiCount()) {
                    tempBk.setiCount(tempBk.getiCount() - bk.getiCount());
                    return true;
                } else if (tempBk.getiCount() == bk.getiCount()) {
                    this.liLib.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
}
