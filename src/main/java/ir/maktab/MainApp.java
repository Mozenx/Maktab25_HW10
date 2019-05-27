package ir.maktab;

import ir.maktab.model.dao.StudentDao;
import ir.maktab.model.dao.StudentDaoImpl;
import ir.maktab.model.dao.TeacherDao;
import ir.maktab.model.dao.TeacherDaoImpl;
import ir.maktab.model.Teacher;
import ir.maktab.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Teacher teacher = new Teacher("Ali","Hasani",12345L,
                2000, LocalDate.of(1380,01,31));
        Teacher teacher1 = new Teacher("Milad","Jabari",123456L,
                4000,LocalDate.of(1340,03,23));
        Teacher teacher2 = new Teacher("Reza","Madani",1234L,
                344,LocalDate.of(1356,11,14));

        Student student = new Student("Jafar","Soltani");
        Student student1 = new Student("Soltan", "Jafari");


        TeacherDao dao = new TeacherDaoImpl(factory);
        StudentDao dao1 = new StudentDaoImpl(factory);
//
        dao1.create(student);
        dao1.create(student1);

        dao.create(teacher);
        dao.create(teacher1);
        dao.create(teacher2);
        dao.removeByTeacherCode(12345);

//        System.out.println(dao.showMaxAndMinSalary());
//        System.out.println(dao.showYoungestAndOldest());

//        System.out.println(dao1.findByName("Jafari"));

        factory.close();

    }
}
