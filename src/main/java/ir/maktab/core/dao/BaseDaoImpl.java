package ir.maktab.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class BaseDaoImpl<E extends Serializable> implements BaseDao<E> {

    private final SessionFactory factory;

    public BaseDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    protected abstract String getEntityName();

    @Override
    public void create(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.save(e);

        session.getTransaction().commit();

        session.close();
    }//end of create method

    @Override
    public E update(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.update(e);

        session.getTransaction().commit();

        session.close();

        return e;
    }//end of update method

    @Override
    public E read(Serializable id) {
        Session session = factory.openSession();

        Object o = session.createQuery("from "+ getEntityName() + " entity where entity.id = " + id)
                .getSingleResult();
        E e = (E)o;

        session.close();

        return e;
    }//end of read method

    @Override
    public void delete(Serializable id) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.createQuery("delete from " + getEntityName()+ " as entity where entity.id = " + id);

        session.getTransaction().commit();

        session.close();

    }//end of delete method

}//end of class
