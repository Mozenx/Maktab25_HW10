package ir.maktab.model.dao;

import ir.maktab.core.dao.BaseDao;
import ir.maktab.model.Student;

import java.util.List;

public interface StudentDao extends BaseDao<Student> {

    List<Student> findByName(String name);

    List<Student> notLiveInCity(String city);

}
