package com.chanpter2.API;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 数字处理工具类
 * 	BigInteger:可以让超出integer范围的数字进行运算、
 * 构造方法 public BigIntger(String val){}
 * 常用法法 加减乘除
 * BigDecimal:由于运算的时候，float和double很容易丢失精度，
 * 			为了能精确的表示，计算浮点数，java提供了BigDecimal，不可变的，任意精度的有符号十进制数
 * 	构造方法 public BigDecimal(String val){}
 *常用方法 加减乘除 
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月24日 下午6:48:41
 */
public class BigDecimaltest {
	public static void main(String[] args) {
		//bigInt();
		bigDec();
	}

	private static void bigDec() {
			String val1="4565.415645678612315645165";
			String val2="562.45648678264655465456";
			BigDecimal b1=new BigDecimal(val1);
			BigDecimal b2=new BigDecimal(val2);
			System.out.println(b1.add(b2));
			System.out.println(b1.subtract(b2));
			System.out.println(b1.multiply(b2));
		try {
			System.out.println(b1.divide(b2));//除不尽的问题 算数异常
		} catch (ArithmeticException e) {
			System.out.println("除不尽了");
		}
	}

	private static void bigInt() {
			//大整数的运算
		String val1= "77288556415631534948";
		String val2= "6546545616518914564";
		BigInteger bi1=new BigInteger(val1);
		BigInteger bi2=new BigInteger(val2);
		
		System.out.println(bi1.add(bi2));//加法
		System.out.println(bi1.subtract(bi2));//减法
		System.out.println(bi1.multiply(bi2));//乘法
		System.out.println(bi1.divide(bi2));//除法
		System.out.println(bi1.remainder(bi2));//取模
		
		System.out.println(Arrays.toString(bi1.divideAndRemainder(bi2))); //除法和取余
		
	}
}
