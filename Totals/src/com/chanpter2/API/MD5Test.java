package com.chanpter2.API;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * MD5 信息摘要算法  不可逆
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2020年6月29日 下午3:12:06
 */
public class MD5Test {
	public static void main(String[] args) {
			String password="admin123456";//明文
			String savePassword ="pmq7VoTEWWLYh1ZPCDRujQ==";//暗文
			try {
				MessageDigest md=MessageDigest.getInstance("md5");
				//通過md5計算摘要
				byte[] digest = md.digest(password.getBytes("utf-8"));
				System.out.println(Arrays.toString(digest));
				String mdStr=new String(digest);
//				System.out.println(mdStr);
				//編碼 a-z A-Z 0-9 / *  BASE64編碼算法  使用这个只是为了将md5转换后的暗文进一步加工 符合人的阅读习惯
				//jdk1.8版本
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
