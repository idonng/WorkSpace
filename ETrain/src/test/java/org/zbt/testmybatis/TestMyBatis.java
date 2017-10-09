package org.zbt.testmybatis;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zbt.organization.common.CommonUtils;
import com.zbt.organization.pojo.IpCount;
import com.zbt.organization.service.IpCountService;



@RunWith(SpringJUnit4ClassRunner.class)		//琛ㄧず缁ф壙浜哠pringJUnit4ClassRunner绫�
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {
//	private static Logger logger = Logger.getLogger(TestMyBatis.class);
 	@Resource
 	private IpCountService ipCountService;
//
//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}
	 
	@Test
	public void test1() { }
}
