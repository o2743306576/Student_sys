package com.ocg.dao;

import java.sql.SQLException;
import java.util.List;

import com.ocg.domain.Student;

/*
 * 定义操作数据库的方法
 * */
public interface StudentDao {

	
	//插入某个学生信息
	void insert(Student student) throws SQLException;
	
	//查询所有学生信息,集合的形式
	void findAll()  throws SQLException ;
	
	//根据学号查询某一个学生
	void findStudentByNumber(int number)  throws SQLException ;
	
	//根据姓名或者学号，或者两者兼有。
	void searchStudent(String name , String number)  throws SQLException ;
	
	//删除某个学生信息
	void delete(int number) throws SQLException;
	
	//更新学生信息
	void update(Student student) throws SQLException;
}
