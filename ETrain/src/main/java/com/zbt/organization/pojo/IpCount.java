package com.zbt.organization.pojo;

import java.util.Date;

public class IpCount {

	private int id;// 自增ID

	private String ipmd5;

	private String ip;

	private String cityname;

	private Date ctime;

	private int flag;
	
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getIpmd5() {
		return ipmd5;
	}

	public void setIpmd5(String ipmd5) {
		this.ipmd5 = ipmd5 == null ? null : ipmd5.trim();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
}