package com.ocg.domain;

public class Student {
	public String name;				//姓名
	public int number;				//学号
	public int Clazz;				//班级
	
	//get和set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getClazz() {
		return Clazz;
	}
	public void setClass(int Clazz) {
		this.Clazz = Clazz;
	}
	//toString
	@Override
	public String toString() {
		return "Student [name=" + name + ", number=" + number + ", Clazz=" + Clazz + "]";
	}
	
	
	
	

}
