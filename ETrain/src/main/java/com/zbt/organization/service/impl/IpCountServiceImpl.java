package com.zbt.organization.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zbt.organization.dao.IpCountMapper;
import com.zbt.organization.pojo.IpCount;
import com.zbt.organization.service.IpCountService;
 
@Service("ipCountService")
public class IpCountServiceImpl  implements IpCountService{
	@Resource
	private IpCountMapper ipCountMapper;

	@Override
	public int insert(IpCount ic) {
		// TODO Auto-generated method stub
		return this.ipCountMapper.insert(ic);
	} }
