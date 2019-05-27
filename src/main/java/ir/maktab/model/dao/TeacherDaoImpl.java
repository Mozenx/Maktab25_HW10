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

        Session session = factory.openSession();

        List<Teacher> teachers;

        teachers = session.createQuery("select t from Teacher t join t.address where t.address.city=:i",Teacher.class)
                .setParameter("i",city).getResultList();

        List<Teacher> teachers1 = (List<Teacher>) teachers;

        session.close();

        return teachers;
    }

    @Override
    public List<Teacher> beingNumberWith(String number) {

        Session session = factory.openSession();

        List<Teacher> teachers;

        teachers = session.createQuery("select t from Teacher t join t.address where t.address.number like :i",Teacher.class)
                .setParameter("i",number+"%").list();

        session.close();

        return teachers;
    }

    @Override
    public List<Teacher> beingNumberWithLiveInCity(String number, String city) {

        Session session = factory.openSession();

        List<Teacher> teachers;

        teachers = session.createQuery("select t from Teacher t join t.address where t.address.number like :i and t.address.city= :j",Teacher.class)
                .setParameter("i", number+"%").setParameter("j",city).getResultList();

        session.close();

        return teachers;
    }
}
