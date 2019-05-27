package ir.maktab;

import ir.maktab.model.Student;
import ir.maktab.model.Teacher;
import ir.maktab.model.dao.StudentDao;
import ir.maktab.model.dao.StudentDaoImpl;
import ir.maktab.model.dao.TeacherDao;
import ir.maktab.model.dao.TeacherDaoImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryApp {

    public static void main(String[] args) {

        //declare SessionFactory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        //declare TeacherDao and StudentDao
        TeacherDao dao = new TeacherDaoImpl(factory);
        StudentDao dao1 = new StudentDaoImpl(factory);


        //declare lists for keep result of query
        List<Teacher> liveIn = dao.liveInCity("tehran");
        List<Teacher> beginNumber = dao.beginNumberWith("0912");
        List<Teacher> beginNumberLiveIn = dao.beginNumberWithLiveInCity("0912", "tehran");
        List<Student> notLiveIn = dao1.notLiveInCity("tehran");

        //print result of query
        System.out.println(liveIn);
        System.out.println(beginNumber);
        System.out.println(beginNumberLiveIn);
        System.out.println(notLiveIn);

        //close SessionFactory
        factory.close();
    }//end of main method
}//end of class
