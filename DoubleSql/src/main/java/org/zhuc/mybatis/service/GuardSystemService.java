package org.zhuc.mybatis.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhuc.mybatis.common.CommonUtil;
import org.zhuc.mybatis.domain.GuardSystem;
import org.zhuc.mybatis.domain2.ReaderSystem;

  
public class GuardSystemService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static Connection getConn() {
	    String driver = SetSystemProperty.getKeyValue("dataSource_guard.driver");
	    String url = SetSystemProperty.getKeyValue("dataSource_guard.url");
	    String username =SetSystemProperty.getKeyValue("dataSource_guard.username");
	    String password = SetSystemProperty.getKeyValue("dataSource_guard.password");
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
	public   int updateGuard(GuardSystem guard) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update pb_emply set "
	    		+ "depart_id= " +guard.getDepartId()
	    		+ " ,employee_name='" + guard.getEmployeeName()
	    		+ "' ,serial='" + guard.getSerial()
	    		+ "' ,phone='" + guard.getPhone() 
	    		+ "' where employee_id='" + guard.getEmployeeId() + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	public   int insertGuard(GuardSystem guard) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into pb_emply (depart_id,employee_id,employee_name,serial,employee_type,employee_sex,employee_pass,invalidate,is_delete,visit_status,phone)"
	    		+ " values(?,?,?,?,?,?,?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setInt(1,guard.getDepartId());
	        pstmt.setString(2, guard.getEmployeeId());
	        pstmt.setString(3, guard.getEmployeeName());
	        pstmt.setString(4, guard.getSerial());
	        pstmt.setString(5, guard.getEmployeeType());
	        pstmt.setByte(6, guard.getEmployeeSex());
	        pstmt.setString(7, guard.getEmployeePass());
	        pstmt.setDate(8, new Date(guard.getInvalidate().getTime()));
	        pstmt.setByte(9, guard.getIsDelete());
	        pstmt.setByte(10, guard.getVisitStatus());
	        pstmt.setString(11, guard.getPhone());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	//添加部门信息
	private static  int insertDep(String depName) {
		if("".equals(selMaxDepCode())){
			return 0;
		}
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into pb_depart (name,parent_id,status,is_parent,path) values(?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, depName);
	        pstmt.setInt(2, 0);
	        pstmt.setByte(3, (byte) 0); 
	        pstmt.setString(4, selMaxDepCode()); 
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	//生成最大的部门path
	private static  String selMaxDepCode(){
	    Connection conn = getConn();
	    String sql = "SELECT * FROM pb_depart where depart_id=(SELECT max(depart_id) from pb_depart)" ;
	    PreparedStatement pstmt;
	    String result="";
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        rs.last();
	        if(rs.getRow()>0){
	        	 String prePath= rs.getObject(6).toString();
	        	 result=CommonUtil.getNewPath(prePath);
	        }
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	
	}
	//生成最大的部门path
	private static  String selMaxDepId(){
		    Connection conn = getConn();
		    String sql = "SELECT max(depart_id) from  pb_depart " ;
		    PreparedStatement pstmt;
		    String result="1";
		    try {
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		        rs.last();
		        if(rs.getRow()>0){
		        	result=  rs.getObject(1).toString(); 
		        }
		        pstmt.close();
		        conn.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return result;
		
		}
	public static    String selectDep(String depName) {
	    Connection conn = getConn();
	    String sql = "select * from pb_depart where  name ='"+depName+"'";
	    PreparedStatement pstmt;
	    String result="1";
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        rs.last();
	        if(rs.getRow()>0){
	        	result = rs.getObject(1).toString();
	        }
	        else{
	        	int i=insertDep(depName.trim());
	        	if(i==0){
	        		result= "1";
	        	}
	        	else{
	        		result= selMaxDepId();
	        	}
	        }
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public   Integer countStuNo(String stuNo) {
	    Connection conn = getConn();
	    String sql = "select * from pb_emply where employee_id ='"+stuNo+"'";
	    PreparedStatement pstmt;
	    int n=0;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        rs.last(); //结果集指针知道最后一行数据  
	        n=rs.getRow();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return n;
	}
	
}
