package cn.yangguang.ssm.dao;

import cn.yangguang.ssm.BaseTest;
import cn.yangguang.ssm.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by songyangguang on 2017/10/31.
 */
public class BookDaoTest extends BaseTest{
    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryBookById() throws Exception {
        long bookId = 1000;
        Book book = bookDao.queryBookById(bookId);
        System.out.println(book);
    }

    @Test
    public void testQueryAll() throws Exception{
        List<Book> books = bookDao.queryAllBook(0,4);
        for (Book book:books) {
            System.out.println(book);
        }
    }

    @Test
    public void testReduceNumber() {
        long bookId = 1000;
        int update = bookDao.reduceBookNum(bookId);
        System.out.println(update);
    }
}
