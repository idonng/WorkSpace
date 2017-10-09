package com.zbt.organization.controller;

 
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbt.organization.common.CommonUtils;
import com.zbt.organization.pojo.IpCount;
import com.zbt.organization.service.IpCountService;
 

@Controller
@RequestMapping("/page")
public class MonitorController {
	@Resource
	private IpCountService ipCountService;
	@RequestMapping("/monitorIndex.do")
	public void monitorIndex(@RequestParam("ip") String ip,@RequestParam("flag") int flag  ,
			@RequestParam("cityname") String cityname, HttpServletRequest request,
			HttpServletResponse response) {}
	@RequestMapping("/monitorSec.do")
	public void monitorSec(@RequestParam("ip") String ip, 
			@RequestParam("cityname") String cityname, HttpServletRequest request,
			HttpServletResponse response) {}
	
}
