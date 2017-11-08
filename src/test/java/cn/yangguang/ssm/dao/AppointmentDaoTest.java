package cn.yangguang.ssm.dao;

import cn.yangguang.ssm.BaseTest;
import cn.yangguang.ssm.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by songyangguang on 2017/11/1.
 */
public class AppointmentDaoTest extends BaseTest {

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void insertAppointmentTest() throws Exception {
        long bookId = 1000;
        long studentId = 2017;
        int insert = appointmentDao.insertAppointment(bookId,studentId);
        System.out.println("insert = " + insert);
    }

    @Test
    public void queryByKeyWithBookTest() throws  Exception {
        long bookId = 1000;
        long studentId = 2017;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId,studentId);

        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }
}
