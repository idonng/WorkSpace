package org.zhuc.mybatis.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.zhuc.mybatis.common.CommonUtil;
import org.zhuc.mybatis.domain.GuardSystem;
import org.zhuc.mybatis.domain2.ReaderSystem;


public class Test {
	public static void main(String[] args) {
		String lastModifiedTime =SetSystemProperty.getKeyValue("lastModifiedTime");
		//写入配置文件，即将开始同步
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		java.util.Date date=new java.util.Date();  
		String beforeTime=sdf.format(date);  
		//SetSystemProperty.updateProperties("lastModifiedTime", beforeTime);
		//查询与上次更新之间更新的数据
		ReaderSystemService rs=new ReaderSystemService();
		GuardSystemService gss=new GuardSystemService();
		List<ReaderSystem> lrs=new ArrayList<ReaderSystem>();
		lrs=rs.getAll(lastModifiedTime);
		for(ReaderSystem r:lrs){
			GuardSystem gs=new GuardSystem();
			gs.setDepartId(Integer.valueOf(GuardSystemService.selectDep(r.getCollegename())));
			gs.setEmployeeId(r.getStudentno());
			gs.setEmployeeName(r.getUsername());
			if(r.getCardcode().length()!=8){
				continue ;
			}
			gs.setSerial(CommonUtil.getSerial(r.getCardcode()));
			gs.setEmployeeType("A");
			gs.setEmployeeSex(CommonUtil.getSex(r.getGender()));
			gs.setEmployeePass("1234");
			gs.setInvalidate(CommonUtil.strToDate("2067-12-13 00:00:00"));
			gs.setIsDelete(Byte.valueOf("0"));
			gs.setVisitStatus(Byte.valueOf("1"));
			gs.setPhone(r.getPhone());
				int n=gss.countStuNo(r.getStudentno());
				if(n==0){
					int i= gss.insertGuard(gs);
					if(i>0){
						System.out.println("插入成功："+r.getStudentno());
					}
					else{
						System.out.println("插入失败："+r.getStudentno());
					}
				}
				else{
					int i=gss.updateGuard(gs);
					if(i>0){
						System.out.println("更新成功："+r.getStudentno());
					}
					else{
						System.out.println("更新失败："+r.getStudentno());
					}
				}
		}
		
	}

}
