package com.test;

public class Horse {

	private String name;
	private int age;
	
	
	
	public Horse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		if(age>=0){
			this.age = age;
		}else{
			System.out.println("年龄不合法，默认为0");
		}
	}
	@Override
	public String toString() {
		print();
		return "Horse [name=" + name + ", age=" + age + "]";
	}
	public void print(){
		System.out.println("详细描述：我"+age+"岁了");
	}
	
}
