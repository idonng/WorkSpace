package org.zhuc.mybatis.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zhuc.mybatis.domain2.ReaderSystem;


public class ReaderSystemService {
	private static Connection getConn() {
	    String driver = SetSystemProperty.getKeyValue("dataSource_reader.driver");
	    String url = SetSystemProperty.getKeyValue("dataSource_reader.url");
	    String username =SetSystemProperty.getKeyValue("dataSource_reader.username");
	    String password = SetSystemProperty.getKeyValue("dataSource_reader.password");
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
 
	public    List<ReaderSystem> getAll(String lastModifiedTime) {
	    Connection conn = getConn();
	    String sql = "select * from sel_readers where lastModifiedTime >='"+lastModifiedTime+"'";
	    PreparedStatement pstmt;
	    List<ReaderSystem> lds=new ArrayList<ReaderSystem>();
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	         	ReaderSystem f=new ReaderSystem();
	         	f.setStudentno(rs.getObject(2).toString());
	         	f.setUsername(rs.getObject(3).toString());
	         	f.setCollegename(rs.getObject(10).toString());
	         	f.setCardcode(rs.getObject(23).toString());
	         	f.setPhone(rs.getObject(15).toString());
	         	lds.add(f);
	        }
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return lds;
	}
	public static void main(String[] args) {
		ReaderSystemService rs=new ReaderSystemService();
		rs.getAll("1970-01-01 00:00:00");
	}
}
