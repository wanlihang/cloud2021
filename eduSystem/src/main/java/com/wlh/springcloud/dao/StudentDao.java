package com.wlh.springcloud.dao;

import com.wlh.springcloud.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student selectByStudentId(Integer studentId);

    List<Student> selectByClaId(Integer claId);

    List<Student> getAllStudent();
}
