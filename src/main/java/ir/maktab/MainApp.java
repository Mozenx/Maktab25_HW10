package ir.maktab;

import ir.maktab.model.Address;
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

        Address address = new Address("tehran","tehran","0912123456","azadi","12321");
        Address address1 = new Address("mashad","korasan razavi","0912654321","azadi","123221");
        Address address2 = new Address("tehran","tehran","0912123556","gomrok","1232121");
        Address address3 = new Address("shiraz","fars","0912123459","azadi","1232561");
        Address address4 = new Address("tehran","tehran","0912123856","azadi","1232321");
        Address address5 = new Address("tehran","tehran","0912223456","azadi","12321578");

        Teacher teacher = new Teacher("Ali","Hasani",123745L,
                2000, LocalDate.of(1380,01,31),address);
        Teacher teacher1 = new Teacher("Milad","Jabari",123456L,
                4000,LocalDate.of(1340,03,23),address1);
        Teacher teacher2 = new Teacher("Reza","Madani",122334L,
                344,LocalDate.of(1356,11,14),address2);

        Student student = new Student("Jafar","Soltani",address4);
        Student student1 = new Student("Soltan", "Jafari",address3);
        Student student2 = new Student("Amir", "Razavi",address5);


        TeacherDao dao = new TeacherDaoImpl(factory);
        StudentDao dao1 = new StudentDaoImpl(factory);
//
        dao1.create(student);
        dao1.create(student1);
        dao1.create(student2);

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
