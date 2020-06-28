package com.test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.plaf.synth.SynthStyle;

public class StringTest {
	public static void main(String[] args) throws IOException {
		
		System.out.println(Math.PI);
		System.out.println(Math.abs(-10));
		System.out.println(Math.random()*100);
		System.out.println(Math.round(Math.random()*100));
		System.out.println(Math.max(10, 2));
		System.out.println(Math.sqrt(3));
		System.out.println(Math.floor(11.6));
		System.out.println(Math.ceil(11.2));
		
		Random r=new Random();
		int nextInt = r.nextInt(10);
		System.out.println(nextInt);
		
		Date date=new Date();
		System.out.println(date);
		
		Calendar c1=Calendar.getInstance();
		Calendar c2=new GregorianCalendar();
		c1.get(Calendar.YEAR);
		c1.get(Calendar.MONTH);
		c1.get(Calendar.DAY_OF_MONTH);
		c1.get(Calendar.HOUR_OF_DAY);
		c1.get(Calendar.MINUTE);
		System.out.println(c1.get(Calendar.SECOND));
		System.out.println(c1.get(Calendar.MILLISECOND));
		
		DateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String a = format.format(new Date());
		System.out.println(a);
		
		Person[] ps={new Person(11, "张三"),new Person(12, "李四"),new Person(5, "王五")};
		System.out.println(Arrays.toString(ps));
		Arrays.sort(ps);
		System.out.println(Arrays.toString(ps));
		Student[] ss={new Student(11, "张三"),new Student(6, "王五"),new Student(99, "李四")};
		Arrays.sort(ss, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.getAge()-o1.getAge();
			}
		});
		System.out.println(Arrays.toString(ss));
		
		int[] ia={1,2,3,1,2,1,2,1,1,1,2,1,3,2,1,2};
		int[] ib=new int[ia.length];
		System.arraycopy(ia, 0, ib, 0, ia.length);
		System.out.println(Arrays.toString(ib));
		System.out.println(ia==ib);
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.home"));
//		Runtime.getRuntime().exec("notepad");
		SimpleDateFormat format1=new SimpleDateFormat("yyyyMMddHHmmsssss");
		String str = format1.format(new Date());
		StringBuilder sb=new StringBuilder();
		sb.append(str);
		
		String hexString = Long.toHexString(Long.parseLong(sb.toString()));
		
		System.out.println(hexString+".jpg");
		
	}
}

class Student{
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
}
class Person implements Comparable<Person>{
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Person o) {
		return this.age-o.age;
	}
	
}
