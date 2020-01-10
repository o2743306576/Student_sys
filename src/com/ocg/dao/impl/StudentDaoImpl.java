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
 * ʵ�ʲ�����
 * */
public class StudentDaoImpl implements StudentDao{

	//����ĳ��ѧ����Ϣ
	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		
		runner.update("insert into student_sys values(null , ?,?,?,?,?,?)" ,
				student.getName(),
				student.getNumber(),
				student.getClazz()
				);
		
	}

	//��ѯ����ѧ����Ϣ,���ϵ���ʽ
	@Override
	public void findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		List<Student> list=runner.query("select * from student_sys", new BeanListHandler<Student>(Student.class));
		for (Student student : list) {
			System.out.println("ѧ������:"+student.name+",ѧ��ѧ��:"+student.number+",ѧ���༶:"+student.Clazz);
		}
	}

	//����ѧ�Ų�ѯĳһ��ѧ��
	@Override
	public void findStudentByNumber(int number) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		 Student student=runner.query("select * from student_sys where number = ?", new BeanHandler<Student>(Student.class) ,number);
		 System.out.println("ѧ������:"+student.name+",ѧ��ѧ��:"+student.number+",ѧ���༶:"+student.Clazz);
	}

	//������������ѧ�ţ��������߼��С�
	@Override
	public void searchStudent(String name, String number) throws SQLException {
		
	}

	//ɾ��ĳ��ѧ����Ϣ
	@Override
	public void delete(int number) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("delete from student_sys where number=?" ,number);
	}

	//����ѧ����Ϣ
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
