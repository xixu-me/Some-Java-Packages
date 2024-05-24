package library;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Book> liBag;

    public Bag() {
        this.liBag = new ArrayList<Book>();
    }

    public void add(Book bk) {
        this.liBag.add(bk);
    }

    public boolean del(String inIsbn) {
        boolean flag = false;
        Book tempBk;
        for (int i = 0; i < this.liBag.size(); i++) {
            tempBk = this.liBag.get(i);
            if (tempBk.getStrIsbn().equals(inIsbn)) {
                this.liBag.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public List<Book> getLiBag() {
        return liBag;
    }

    public void setLiBag(List<Book> liBag) {
        this.liBag = liBag;
    }
}
