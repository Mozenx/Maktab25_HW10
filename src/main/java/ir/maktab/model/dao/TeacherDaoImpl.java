package ir.maktab.model.dao;

import ir.maktab.core.dao.BaseDaoImpl;
import ir.maktab.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements  TeacherDao{

    private final SessionFactory factory;

    public TeacherDaoImpl(SessionFactory factory) {
        super(factory);
        this.factory = factory;
    }

    @Override
    protected String getEntityName() {
        return "Teacher";
    }

    @Override
    public void removeByTeacherCode(long teacherCode) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.createQuery("delete from Teacher as t where t.teacherCode = " + teacherCode).executeUpdate();
        System.out.println("inside remove");

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public List<Teacher> showYoungestAndOldest() {
        Session session = factory.openSession();

        List<Teacher> teachers = new ArrayList<>();

        teachers.add((Teacher) session.createQuery("from Teacher t where t.birthday=" +
                "(select max(b.birthday) from Teacher b)").getSingleResult());
        teachers.add((Teacher) session.createQuery("from Teacher t where t.birthday = " +
                "(select min(b.birthday) from Teacher b)").getSingleResult());

        session.close();

        return teachers;
    }

    @Override
    public List<Teacher> showMaxAndMinSalary() {
        Session session = factory.openSession();

        List<Teacher> teachers = new ArrayList<>();

        teachers.add((Teacher) session.createQuery("from Teacher  t where t.salary = " +
                "(select max(b.salary) from Teacher b)").getSingleResult());
        teachers.add((Teacher) session.createQuery("from Teacher t where t.salary = " +
                "(select min(b.salary) from Teacher b)").getSingleResult());

        session.close();

        return teachers;
    }

    @Override
    public List<Teacher> liveInCity(String city) {
        return null;
    }
}
