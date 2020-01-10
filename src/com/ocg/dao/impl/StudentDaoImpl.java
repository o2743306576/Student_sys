package com.ocg.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.ocg.dao.StudentDao;
import com.ocg.domain.Student;
import com.ocg.util.JDBCUtil;

/*
 * 实际操作类
 * */
public class StudentDaoImpl implements StudentDao{

	//插入某个学生信息
	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		
		runner.update("insert into student_sys values(null , ?,?,?,?,?,?)" ,
				student.getName(),
				student.getNumber(),
				student.getClazz()
				);
		
	}

	//查询所有学生信息,集合的形式
	@Override
	public void findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		List<Student> list=runner.query("select * from student_sys", new BeanListHandler<Student>(Student.class));
		for (Student student : list) {
			System.out.println("学生姓名:"+student.name+",学生学号:"+student.number+",学生班级:"+student.Clazz);
		}
	}

	//根据学号查询某一个学生
	@Override
	public void findStudentByNumber(int number) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		 Student student=runner.query("select * from student_sys where number = ?", new BeanHandler<Student>(Student.class) ,number);
		 System.out.println("学生姓名:"+student.name+",学生学号:"+student.number+",学生班级:"+student.Clazz);
	}

	//根据姓名或者学号，或者两者兼有。
	@Override
	public void searchStudent(String name, String number) throws SQLException {
		
	}

	//删除某个学生信息
	@Override
	public void delete(int number) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("delete from student_sys where number=?" ,number);
	}

	//更新学生信息
	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("update student_sys set name=? , number=? , clazz=?", 
				student.getName(),
				student.getNumber(),
				student.getClazz())
				;
	}

	

}
