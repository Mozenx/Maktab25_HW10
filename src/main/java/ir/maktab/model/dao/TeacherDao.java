package ir.maktab.model.dao;

import ir.maktab.model.Teacher;
import ir.maktab.core.dao.BaseDao;

import java.util.List;

public interface TeacherDao extends BaseDao<Teacher> {

    //this method remove teacher from table of teacher by teacherCode
    void removeByTeacherCode(long teacherCode);

    //this method show youngest and oldest of teachers
    List<Teacher> showYoungestAndOldest();

    //this method show max and min salary of teachers
    List<Teacher> showMaxAndMinSalary();

    //this method find list of teachers which live in specific city
    List<Teacher> liveInCity(String city);

    //this method find list of teachers which phone number of them begin with specific number
    List<Teacher> beginNumberWith(String number);

    //this method find list of teachers which live in specific city and phone number of them begin with specific number
    List<Teacher> beginNumberWithLiveInCity(String number, String city);
}//end of interface
