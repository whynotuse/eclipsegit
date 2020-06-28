package com.chanpter2.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * collection�ӿ� ���б���
 * �ӽӿڣ�
 * 	list:��collection����չ   ������nullԪ��
 * 		1������ ���ظ�
 * 		2��������nullԪ��
 * 		3������ʵ���ɳ��õģ�arrayList,vector,linkedList
 * 		arrayList 
 * 			1��ʵ��ԭ�����ö�̬����ʵ�֣�Ĭ�Ϲ�����һ��������
 * 			2����һ�����Ԫ�أ���������Ϊ10��֮��������㷨��ԭ�����鳤��+ԭ�����鳤�ȵ�һ�� 1.5��
 *          3�����ʺ���ɾ���Ͳ������
 *          4��Ϊ�˷�ֹ���鶯̬������������࣬���鴴��arraylistʱ������ʼ����
 *          5���̷߳ǰ�ȫ ���鵥�߳���ʹ��  jdk1.2��ʼ�����
 * 		vector
 * 			1,ʵ��ԭ�����ö�̬���飬Ĭ�Ϲ�������� ������СΪ10
 * 			2�������㷨����ǰ����Ϊ0ʱ������Ϊԭ������������������С����0ʱ�������СΪԭ����С+����
 * 			3�����ʺ�ɾ���Ͳ���
 * 			4.Ϊ�˷�ֹ���鶯̬����������࣬���鴴��vectorʱ������ʼ����
 * 			5���̰߳�ȫ���ʺ϶��߳���ʹ�ã�Ч�ʽϵ�  jdk1.0��ʼ������
 * 		linkedList
 * 			1:ʵ��ԭ������˫������
 * ��ʵ�ʿ��������ѡ��list�ӿڵľ���ʵ���أ�
 * 		1����ȫ����
 * 		2���Ƿ�Ƶ�����룬ɾ��
 * 		3���Ƿ�洢�����
 * 	 set:
 * 		1������� ����֤˳��
 * 		2���������ظ�
 * 		3������ʵ���ࣺhashSet,treeSet,linkedSet
 * ��ʵ�ʿ��������ѡ��set�ӿڵľ���ʵ���أ�
 * 		1��Ҫ����  treeset
 * 		2: ��Ҫ����Ҳ����֤˳�� hashSet
 * 		3: ��Ҫ����Ҫ��֤˳�� linkedHashSet
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��30�� ����1:48:48
 */
public class MultiCllection {
	public static void main(String[] args) {
//		arraylist();
//		vector();
//		hashSet();
//		treeSet();
//		linkedHashSet();
//		List<Cat>list=new ArrayList<>();
//		list.add(new Cat("miao1", 1, 15));
//		list.add(new Cat("miao2", 2, 11));
//		list.add(new Cat("miao3", 3, 15));
//		list.add(new Cat("miao4", 4, 1));
//		
//		Vector<Cat>vec=new Vector<>();
//		vec.add(new Cat("miao1", 1, 15));
//		vec.add(new Cat("miao2", 2, 11));
//		vec.add(new Cat("miao3", 3, 15));
//		vec.add(new Cat("miao4", 4, 1));
//		
//		iterator(vec);
		foreach();
	}
	/**
	 * JDK1.8 ������ �������� foreach(consumer action);���lambda���ʽ  �Ĵ�ӿڱȽ���Ҫ
	 * 	Consumer<T>���ѽӿ� ���ڵ���
	 * 	Function<T,R>�����ӿ� ��ʾ����һ���������Ҳ�������ĺ��� util����  R apply(T t)
	 * 	Supplier<T>��Ӧ�̽ӿ� ��ʾ��ȡһ����� T get()
	 * 	Predicate<T>���Խӿ�  ��ʾ�жϺ�Ԥ�ڽ���Ƿ�һ��  Boollean test()
	 * 
	 * Stream��Ԫ�صļ��ϣ��������Ϊ�߼�iterator
	 * 
	 * @Description:
	 */
	private static void foreach() {
		List<String>list=new ArrayList<>();
		list.add("tom");
		list.add("jack");
		list.add("rose");
		list.add("lily");
		//���lambda���ʽʹ�õ���
		//Consumer���ѵ��� �ӿ� accept 
		list.forEach((String s)->{System.out.println(s);});
		System.out.println("-------------------------");
		list.forEach(System.out::println);//˫ð�ű�ʾ���÷���
		
		//Function<T,R>
		String s = strToUpperCase("qc_vince",(str)->{return str.toUpperCase();});
		System.out.println(s);
		//Supplier<T>
		List<Integer>iList=getNums(10,()->(int)(Math.random()*100));
		iList.forEach(System.out::println);
	}
	private static String strToUpperCase(String str,Function<String,String>f) {
		return f.apply(str);
	}
	private static List<Integer> getNums(int num,Supplier<Integer>s){
		List<Integer>list=new ArrayList<>();
		for(int i=0;i<num;i++){
			list.add(s.get());
		}
		return list;
	}
	/**
	 * �������ϵķ�ʽ��
	 * 	1��iterator
	 * 	2: ListIterator list�ӿڿ���ʹ�����ֵ��� ˫����� ��ʹ���� ֱ��for���get���� �����Բ���4
	 * 	3: Enumeration ���ϵ�ö�ٷ�ʽ����
	 * 	4: foreach
	 * ע�⣺����iteratorʹ������� JDK1.5�� ������foreachҲ������ʹ��
	 * @Description:
	 */
	private static void iterator(Collection<Cat> coll) {
		/*//foreach 1.5
		System.out.println("foreach:");
		for (Cat cat : coll) {
			System.out.println(cat);
		}
		System.out.println("=====================");
		//iterator 1.5֮ǰ��ͳһ������ʽ
		System.out.println("iterator:");
		Iterator<Cat> itr = coll.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}*/
		//Enumeration 1.0  �����vectorʹ�� ���Ǻܹ��ϵ�
		System.out.println("Enumeration:");
		if(coll instanceof Vector){
			Vector<Cat>vs=(Vector<Cat>)coll;
			Enumeration<Cat> es = vs.elements();
			while(es.hasMoreElements()){
				Cat cat = es.nextElement();
				System.out.println(cat);
			}
		}
		
	}
	/**
	 * linkedHashSet
	 * 		 ��ϣ��������б��ʵ��
	 * ά����һ��������������Ŀ��˫�������б����������˵���˳�򣬼����ս�Ԫ�ز����˳����е���
	 * @Description:
	 */
	private static void linkedHashSet() {
		LinkedHashSet<Cat>set=new LinkedHashSet<>();
		Cat c1=new Cat("tom", 1, 5);
		Cat c2=new Cat("huahua", 2, 4);
		Cat c3=new Cat("zhang", 3, 3);
		Cat c4=new Cat("tom", 4, 5);
		set.add(c1);
		set.add(c2);
		set.add(c3);
		set.add(c4);
		for (Cat cat : set) {
			System.out.println(cat);//����������¼�����˳�� ��֤����
		}
	}
	/**
	 * TreeSet
	 * 	������ģ�����treeMap(���������ݽṹ)��������Ҫʵ����Ȼ�������ָ���Ƚ���.
	 * 	����Ƚ���������ȥ���ظ�Ԫ�أ�����Զ���������࣬û��ʵ����Ȼ����ӿڲ���û��ָ���Ƚ���
	 * 	     �����޷���ӵ�treeSet������
	 * @Description:
	 */
	private static void treeSet() {
		TreeSet<Cat> tree=new TreeSet<>(new Comparator<Cat>() {
			@Override
			public int compare(Cat o1, Cat o2) {
				return o1.getId()-o2.getId();
			}
		});
		Cat c1=new Cat("tom", 1, 5);
		Cat c2=new Cat("huahua", 2, 4);
		Cat c3=new Cat("zhang", 3, 3);
		Cat c4=new Cat("tom", 1, 5);
		tree.add(c1);
		tree.add(c2);
		tree.add(c3);
		tree.add(c4);
		System.out.println(tree.size());
		for (Cat cat : tree) {
			System.out.println(cat);
		}
	}
	/**
	 * HashSet
	 * 	1: ʵ��ԭ�����ڹ�ϣ��hashMap��ʵ��
	 * 	2���������ظ���������һ��nullԪ��
	 * 	3������֤˳���ò���
	 *  4�����Ԫ��ʱ��Ԫ����ΪhashMap��Key�洢,HashMap��valueʹ��һ���̶���object����
	 *  5���ų��ظ�Ԫ����ͨ��equals���������Ƿ���ͬ��
	 *  6���ж϶����Ƿ���ͬ�����ж����������hashCode�Ƿ���ȣ�����������hashCode��ͬ����һ����ͬһ������
	 *      �����ͬ����һ������ͬһ���󣩣������ͬ������������ͬһ������,�����ͬ����Ҫ����equals�жϣ�
	 *       equals�жϣ�equals�������ͬһ�����󣬷�����ͬһ����
	 *  7���Զ������Ҫ��Ϊ����ֵ�����ʱΪһ�����󣬵�����������ʱ����ô���Ǿ�Ҫ��дhashCode��equals����
	 *  
	 *  С�᣺
	 *  ��1����ϣ��Ĵ洢�ṹ������+�����������ÿ��Ԫ�����������ʽ�洢
	 *  ��2����ΰѶ���洢����ϣ���У��ȼ�������hashCodeֵ���ٶ�����ĳ���������������������Ҫ�洢��������ĸ�λ��
	 *  ��3�����hashSet�е��ظ�ֵ�ķ�ʽ�ο���6��	
	 * @Description:
	 */
	private static void hashSet() {
		Set<String>set=new HashSet<>();
		set.add("�ɷ�");
		set.add("����");
		set.add("����");
		set.add("�ع�");
		set.add("�ܲ�");
		set.add("����");//���ϱߵ������滻��
		System.out.println(set.size());
		String[] names = set.toArray(new String[]{});
		for (String string : names) {
			System.out.println(string);
		}
		
		Set<Cat>cats=new HashSet<>();
		Cat c1=new Cat("tom", 1, 5);
		Cat c2=new Cat("huahua", 1, 5);
		Cat c3=new Cat("zhang", 1, 5);
		Cat c4=new Cat("tom", 1, 5);
		
		cats.add(c1);
		cats.add(c2);
		cats.add(c3);
		cats.add(c4);
		
		System.out.println(cats.size());
		
		for(Cat c:cats){
			System.out.println(c);
		}
//		System.out.println("c1="+c1.hashCode()%16);//��ϣ�����ȡ����������е�λ��
//		System.out.println("c2="+c2.hashCode()%16);
//		System.out.println("c3="+c3.hashCode()%16);
//		System.out.println("c4="+c4.hashCode()%16);
		System.out.println("c1="+c1.hashCode());//��ȡ����ֵ
		System.out.println("c2="+c2.hashCode());
		System.out.println("c3="+c3.hashCode());
		System.out.println("c4="+c4.hashCode());
		//java���ж϶�����ȵĹ��� 
		//1���ж϶����hashCode�Ƿ����  �������� ����Ϊ������Ҳ�����,����
		//������ ת��2
		//2���ж��������equals�����Ƿ���� �������� ����Ϊ��������� ������ ����Ϊ���������
		//ע�⣺equals()���ж��������Ƿ���ȵĹؼ� ��Ϊ�������ظ� ���һ�ȡ����ֵ
		
	}

	private static void vector() {
			Vector<String> vector=new Vector<>(10);
			vector.add("����ʦ");
			vector.add("����ʦ");
			vector.add("����ʦ");
			vector.add("����ʦ");
			vector.add("����ʦ");
			int size = vector.size();
			for(int i =0;i<size;i++){
				System.out.println(vector.get(i));
			}
	}

	private static void arraylist() {
		//��ʵ�ʿ����� һ��������Ӧ�ô洢��ͬ���͵Ķ��� ʹ�÷��Ϳ������ �������ݷ���
		List<String> list=new ArrayList<>(10);
		list.add("����ʦ");
		list.add("����ʦ");
		list.add("����ʦ");
		list.add("����ʦ");
		list.add(new String("dsa"));
		//list.add(10);
		int size = list.size();
		for (int i= 0 ; i< size;i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.contains("����ʦ"));
		list.remove("����ʦ");
		System.out.println(list.size());
		System.out.println(Arrays.toString(list.toArray()));
	}
	
}
class Cat {
	private String name;
	private Integer id;
	private int age;
	public Cat(String name, Integer id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", id=" + id + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;//  11111
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (age != other.age)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
