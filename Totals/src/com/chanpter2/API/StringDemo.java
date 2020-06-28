package com.chanpter2.API;

/**
 * 
 * @version:
 * @Description:
 * @author :衡晶
 * @date:2019年9月19日 下午5:00:12
 */
public class StringDemo {

	public static void main(String[] args) {

		String str1 = "哈哈";// 推荐使用的方式 会在字符串常量池中存储"哈哈" 返回地址赋值str1 一个对象

		str1 = new String("haha");// 一个或两对象 new 一个在堆 "haha"在常量池
		
		//4种情况分析：直接赋值字符串连接时，考虑编译期和运行期
		//如果在编译期可以确定，那么就使用已有的对象，否则会创建新的对象
		String a = "a";
		String a1 = a + 1;//在堆中创建对象
		String a2 = "a1";
		System.out.println(a1 == a2);//false
		
		final String b="b";
		String b1=b+1;//相当于 "b"+1  编译优化为"b1"
		String b2="b1";
		System.out.println(b1==b2);//true
		
		String c=getC();
		String c1=c+1;
		String c2="c1";
		System.out.println(c1==c2);//false
		
		final String d=getD();//编译期不能确定方法的值
		String d1=d+1;//虽然是final 但是不能确定值 所以不做优化 还是会创建对象
		String d2="d1";
		System.out.println(d1==d2);//false

	}

	private static String getD() {
		return "d";
	}

	private static String getC() {
		return "c";
	}
}
