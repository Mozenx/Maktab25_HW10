package ir.maktab.core.dao;

import java.io.Serializable;

public interface BaseDao<E extends Serializable> {

    //this method add object to the table
    void create(E e);

    //this method update table
    E update(E e);

    //this method get data from table
    E read(Serializable id);

    //this method delete data from table
    void delete(Serializable id);
}//end of interface
