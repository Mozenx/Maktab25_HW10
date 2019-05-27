package ir.maktab.model.dao;

import ir.maktab.core.dao.BaseDaoImpl;
import ir.maktab.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {
    private  final SessionFactory factory;

    public StudentDaoImpl(SessionFactory factory) {
        super(factory);
        this.factory = factory;
    }

    @Override
    protected String getEntityName() {
        return "Student";
    }

    //implement findByName method
    @Override
    public List<Student> findByName(String name) {
        Session session = factory.openSession();

        List<Student> students;

        students = session.createQuery("select s from Student s where s.firstName like :i or" +
                " s.lastName like :i").setParameter("i","%"+name+"%").list();

        session.close();

        return students;
    }

    //implement noLiveInCity method
    @Override
    public List<Student> notLiveInCity(String city) {

        Session session = factory.openSession();

        List<Student> students;

        students = session.createQuery("select s from Student s join s.address where not s.address.city =:i",Student.class)
                .setParameter("i", city).getResultList();

        session.close();

        return students;
    }
}
