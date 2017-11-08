package cn.yangguang.ssm.entity;

/**
 * Created by songyangguang on 2017/10/31.
 */
public class Book {
    private long book_id;
    private String name;
    private int number;

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
