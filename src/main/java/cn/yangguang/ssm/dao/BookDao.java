package cn.yangguang.ssm.dao;

import cn.yangguang.ssm.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by songyangguang on 2017/10/31.
 */
public interface BookDao {

    /**
     * 根据书本的ID号查询单本图书
     * @param bookId
     * @return
     */
    Book queryBookById(long bookId);

    /**
     * 根据要求查询所有图书
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     */
    List<Book> queryAllBook(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 减少馆藏数量
     *
     * @param bookId
     * @return 如果影响行数等于>1，表示更新的记录行数
     */
    int reduceBookNum(long bookId);
}
