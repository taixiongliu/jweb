package com.github.taixiongliu.jweb;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 加密公共类
 * 
 * @author admin
 *
 */
public class Md5Util {	 
	 public static String getMd5(String text){
		 String s  = null;

		 MessageDigest md=null;

		 char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		 try {
			 md = MessageDigest.getInstance("MD5");
		 } catch (NoSuchAlgorithmException e) {
			 e.printStackTrace();
			 return null;
		 }
		 md.update(text.getBytes());
		 byte[] datas = md.digest(); //16个字节的长整数
		 char[] str = new char[2*16];
		 int k = 0;
		 for(int i=0;i<16;i++){
			 byte b   = datas[i];
			 str[k++] = hexChars[b>>>4 & 0xf];//高4位
			 str[k++] = hexChars[b & 0xf];//低4位
		 }
		 s = new String(str);
    	return s;
	 }
}
