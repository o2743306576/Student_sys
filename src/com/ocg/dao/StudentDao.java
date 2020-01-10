package com.ocg.dao;

import java.sql.SQLException;
import java.util.List;

import com.ocg.domain.Student;

/*
 * ����������ݿ�ķ���
 * */
public interface StudentDao {

	
	//����ĳ��ѧ����Ϣ
	void insert(Student student) throws SQLException;
	
	//��ѯ����ѧ����Ϣ,���ϵ���ʽ
	void findAll()  throws SQLException ;
	
	//����ѧ�Ų�ѯĳһ��ѧ��
	void findStudentByNumber(int number)  throws SQLException ;
	
	//������������ѧ�ţ��������߼��С�
	void searchStudent(String name , String number)  throws SQLException ;
	
	//ɾ��ĳ��ѧ����Ϣ
	void delete(int number) throws SQLException;
	
	//����ѧ����Ϣ
	void update(Student student) throws SQLException;
}
