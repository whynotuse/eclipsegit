package com.chanpter2.API;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * MD5 ��ϢժҪ�㷨  ������
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2020��6��29�� ����3:12:06
 */
public class MD5Test {
	public static void main(String[] args) {
			String password="admin123456";//����
			String savePassword ="pmq7VoTEWWLYh1ZPCDRujQ==";//����
			try {
				MessageDigest md=MessageDigest.getInstance("md5");
				//ͨ�^md5Ӌ��ժҪ
				byte[] digest = md.digest(password.getBytes("utf-8"));
				System.out.println(Arrays.toString(digest));
				String mdStr=new String(digest);
//				System.out.println(mdStr);
				//���a a-z A-Z 0-9 / *  BASE64���a�㷨  ʹ�����ֻ��Ϊ�˽�md5ת����İ��Ľ�һ���ӹ� �����˵��Ķ�ϰ��
				//jdk1.8�汾
				String encodeToString = Base64.getEncoder().encodeToString(digest);
				System.out.println(encodeToString);//pmq7VoTEWWLYh1ZPCDRujQ==
				byte[] decode = Base64.getDecoder().decode(encodeToString);
				System.out.println(Arrays.toString(decode));
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
