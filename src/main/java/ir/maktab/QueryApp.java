package ir.maktab;

import ir.maktab.model.dao.TeacherDao;
import ir.maktab.model.dao.TeacherDaoImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        TeacherDao dao = new TeacherDaoImpl(factory);

        System.out.println(dao.liveInCity("tehran"));

        System.out.println(dao.beingNumberWith("0912"));

        System.out.println(dao.beingNumberWithLiveInCity("0912", "tehran"));

        factory.close();
    }
}
