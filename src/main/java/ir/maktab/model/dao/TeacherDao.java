package ir.maktab.model.dao;

import ir.maktab.model.Teacher;
import ir.maktab.core.dao.BaseDao;
import ir.maktab.model.Teacher;

import java.util.List;

public interface TeacherDao extends BaseDao<Teacher> {

    void removeByTeacherCode(long teacherCode);

    List<Teacher> showYoungestAndOldest();

    List<Teacher> showMaxAndMinSalary();
}
