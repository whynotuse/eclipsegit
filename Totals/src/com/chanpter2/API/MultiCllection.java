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
 * collection接口 单列表集合
 * 子接口：
 * 	list:对collection的扩展   允许多个null元素
 * 		1：有序 可重复
 * 		2：允许多个null元素
 * 		3：具体实现由常用的：arrayList,vector,linkedList
 * 		arrayList 
 * 			1，实现原理：采用动态数组实现，默认构造是一个空数组
 * 			2，第一次添加元素，扩充容量为10，之后的扩充算法：原来数组长度+原来数组长度的一半 1.5倍
 *          3，不适合做删除和插入操作
 *          4，为了防止数组动态的扩充次数过多，建议创建arraylist时给定初始容量
 *          5，线程非安全 建议单线程中使用  jdk1.2开始引入的
 * 		vector
 * 			1,实现原理：采用动态数组，默认构造空数组 容量大小为10
 * 			2，扩充算法：当前容量为0时，扩充为原来的两倍，当增量大小大于0时，扩充大小为原来大小+增量
 * 			3，不适合删除和插入
 * 			4.为了防止数组动态扩充次数过多，建议创建vector时给定初始容量
 * 			5，线程安全，适合多线程中使用，效率较低  jdk1.0开始就有了
 * 		linkedList
 * 			1:实现原理：采用双向链表
 * 在实际开发中如何选择list接口的具体实现呢？
 * 		1：安全问题
 * 		2：是否频繁插入，删除
 * 		3：是否存储后遍历
 * 	 set:
 * 		1：无序的 不保证顺序
 * 		2：不允许重复
 * 		3：常用实现类：hashSet,treeSet,linkedSet
 * 在实际开发中如何选择set接口的具体实现呢？
 * 		1：要排序  treeset
 * 		2: 不要排序，也不保证顺序 hashSet
 * 		3: 不要排序，要保证顺序 linkedHashSet
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月30日 下午1:48:48
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
	 * JDK1.8 新特性 迭代方法 foreach(consumer action);配合lambda表达式  四大接口比较重要
	 * 	Consumer<T>消费接口 用于迭代
	 * 	Function<T,R>函数接口 表示接收一个参数并且产生结果的函数 util包中  R apply(T t)
	 * 	Supplier<T>供应商接口 表示获取一个结果 T get()
	 * 	Predicate<T>断言接口  表示判断和预期结果是否一致  Boollean test()
	 * 
	 * Stream是元素的集合，可以理解为高级iterator
	 * 
	 * @Description:
	 */
	private static void foreach() {
		List<String>list=new ArrayList<>();
		list.add("tom");
		list.add("jack");
		list.add("rose");
		list.add("lily");
		//配合lambda表达式使用迭代
		//Consumer消费迭代 接口 accept 
		list.forEach((String s)->{System.out.println(s);});
		System.out.println("-------------------------");
		list.forEach(System.out::println);//双冒号表示调用方法
		
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
	 * 遍历集合的方式：
	 * 	1：iterator
	 * 	2: ListIterator list接口可以使用这种迭代 双向迭代 但使用少 直接for配合get遍历 还可以参照4
	 * 	3: Enumeration 古老的枚举方式迭代
	 * 	4: foreach
	 * 注意：其中iterator使用率最高 JDK1.5后 新增的foreach也被大量使用
	 * @Description:
	 */
	private static void iterator(Collection<Cat> coll) {
		/*//foreach 1.5
		System.out.println("foreach:");
		for (Cat cat : coll) {
			System.out.println(cat);
		}
		System.out.println("=====================");
		//iterator 1.5之前的统一遍历方式
		System.out.println("iterator:");
		Iterator<Cat> itr = coll.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}*/
		//Enumeration 1.0  常配合vector使用 都是很古老的
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
	 * 		 哈希表和链表列表的实现
	 * 维护着一个运行于所有条目的双重连接列表，此链表定义了迭代顺序，即按照将元素插入的顺序进行迭代
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
			System.out.println(cat);//用链表来记录存入的顺序 保证有序
		}
	}
	/**
	 * TreeSet
	 * 	可排序的，基于treeMap(二叉树数据结构)，对象需要实现自然排序或者指定比较器.
	 * 	对象比较器还可以去除重复元素，如果自定义的数据类，没有实现自然排序接口并且没有指定比较器
	 * 	     ，则无法添加到treeSet集合中
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
	 * 	1: 实现原理：基于哈希表（hashMap）实现
	 * 	2：不允许重复，可以有一个null元素
	 * 	3：不保证顺序恒久不变
	 *  4：添加元素时把元素作为hashMap的Key存储,HashMap的value使用一个固定的object对象
	 *  5：排除重复元素是通过equals来检查对象是否相同的
	 *  6：判断对象是否相同，先判断两个对象的hashCode是否相等（如果两对象的hashCode相同，不一定是同一个对象，
	 *      如果不同，则一定不是同一对象），如果不同，则两对象不是同一个对象,如果相同，还要进行equals判断，
	 *       equals判断，equals相等则是同一个对象，否则不是同一对象
	 *  7：自定义对象要认为属性值都相等时为一个对象，当有这种需求时，那么我们就要重写hashCode和equals方法
	 *  
	 *  小结：
	 *  （1）哈希表的存储结构：数组+链表，数组里的每个元素以链表的形式存储
	 *  （2）如何把对象存储到哈希表中，先计算对象的hashCode值，再对数组的长度求余数，来决定对象要存储在数组的哪个位置
	 *  （3）解决hashSet中的重复值的方式参考第6点	
	 * @Description:
	 */
	private static void hashSet() {
		Set<String>set=new HashSet<>();
		set.add("飞飞");
		set.add("备备");
		set.add("亮亮");
		set.add("关关");
		set.add("曹操");
		set.add("亮亮");//将上边的亮亮替换了
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
//		System.out.println("c1="+c1.hashCode()%16);//哈希表会先取余计算数组中的位置
//		System.out.println("c2="+c2.hashCode()%16);
//		System.out.println("c3="+c3.hashCode()%16);
//		System.out.println("c4="+c4.hashCode()%16);
		System.out.println("c1="+c1.hashCode());//会取绝对值
		System.out.println("c2="+c2.hashCode());
		System.out.println("c3="+c3.hashCode());
		System.out.println("c4="+c4.hashCode());
		//java中判断对象相等的规则 
		//1：判断对象的hashCode是否相等  如果不相等 则认为两对象也不相等,结束
		//如果相等 转入2
		//2：判断两对象的equals运算是否相等 如果不相等 则认为两对象不相等 如果相等 则认为两对象相等
		//注意：equals()是判断两对象是否相等的关键 因为整数会重复 而且会取绝对值
		
	}

	private static void vector() {
			Vector<String> vector=new Vector<>(10);
			vector.add("苍老师");
			vector.add("张老师");
			vector.add("李老师");
			vector.add("网老师");
			vector.add("可老师");
			int size = vector.size();
			for(int i =0;i<size;i++){
				System.out.println(vector.get(i));
			}
	}

	private static void arraylist() {
		//在实际开发中 一个集合中应该存储相同类型的对象 使用泛型可以完成 操作数据方便
		List<String> list=new ArrayList<>(10);
		list.add("苍老师");
		list.add("张老师");
		list.add("李老师");
		list.add("毕老师");
		list.add(new String("dsa"));
		//list.add(10);
		int size = list.size();
		for (int i= 0 ; i< size;i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.contains("苍老师"));
		list.remove("毕老师");
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
