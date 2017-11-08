package cn.yangguang.ssm.entity;

import java.util.Date;

/**
 * Created by songyangguang on 2017/10/31.
 */
public class Appointment {
    private long book_id;//图书ID
    private long student_id;//学生学号
    private Date appoint_time;//订阅图书的日期

    //多对一的复合属性
    private Book book;//图书实体

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public Date getAppoint_time() {
        return appoint_time;
    }

    public void setAppoint_time(Date appoint_time) {
        this.appoint_time = appoint_time;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "book_id=" + book_id +
                ", student_id=" + student_id +
                ", appoint_time=" + appoint_time +
                ", book=" + book +
                '}';
    }
}
