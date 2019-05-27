package ir.maktab.model.dao;

import ir.maktab.core.dao.BaseDao;
import ir.maktab.model.Student;

import java.util.List;

public interface StudentDao extends BaseDao<Student> {

    //this method find list of students which firstName or lastName of them consist of the specific name
    List<Student> findByName(String name);

    //this method find list of students which not live in specific city in argument of method
    List<Student> notLiveInCity(String city);

}//end of interface
