
package org.zhuc.mybatis.domain2;

public class Test {
	public static void main(String[] args) {
		String s="1-26-";
		String ss=s.substring(0,s.lastIndexOf("-"));
		String sss=ss.substring(ss.lastIndexOf("-")+1,ss.length());
		System.out.println("1-"+(Integer.valueOf(sss)+1)+"-");
	}
}
