<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}/page"></c:set>
<!DOCTYPE html>
<html lang="en">
<% 
 int flag = 0;
 if(session.isNew()) 
 {
  flag=1; 
 }%> 
<head>
<title>步长制药</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>
<script src="${ctx}/js/jquery.min.js"></script>
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>  
<script type="text/javascript">
var ip= returnCitySN["cip"];
var cityname=returnCitySN["cname"];
var flag= "<%=flag%>";
monitorIndex();
	function monitorIndex() { 
	var urlPath="${ctx}/monitorIndex.do"
	$.ajax({
			type : "POST",
			url : urlPath,
			data : {
				'ip' : ip,
				'cityname' : cityname,
				'flag': flag
			},
			dataType : "json",
			success : function() { 
			} 
		});
	}
	function monitorSec() { 
	var urlPath="${ctx}/monitorSec.do"
		$.ajax({
			type : "POST",
			url : urlPath,
			data : {
				'ip' : ip,
				'cityname' : cityname 
			},
			dataType : "json",
			success : function() { 
				self.location='http://www.tdaifu.cn:8090/taodoctor/statichtml/ximalaya/Login.html'; 
			}
		});
	}
</script>

		<script type="text/javascript">
			//pages reconstruction
			var phoneWidth = parseInt(window.screen.width);
			var phoneScale = phoneWidth / 750;
			var ua = navigator.userAgent;
			if(/Android (\d+\.\d+)/.test(ua)) {
				var version = parseFloat(RegExp.$1);
				if(version > 2.3) {
					document.write('<meta name="viewport" content="width=750, minimum-scale = ' + phoneScale + ', maximum-scale = ' + phoneScale + ', target-densitydpi=device-dpi">');
				} else {
					document.write('<meta name="viewport" content="width=750, target-densitydpi=device-dpi">');
				}
			} else {
				document.write('<meta name="viewport" content="width=750, user-scalable=no, target-densitydpi=device-dpi">');
			}
		</script>
</head>
<body>
<div class="container">
			<div class="header">
				<img src="${ctx}/images/bg_top_01.png" class="bg_top"/>
				<img src="${ctx}/images/logo_03.png" class="logo"/>
				<a href="javascript:monitorSec();">
					<img src="${ctx}/images/redpacket_07.png"/>
					<img src="${ctx}/images/gold.png" width="200px" class="gold"/>
					<p>点击参与活动</p>
				</a>
			</div>
			<div class="wordstyle">
				<h3>活动规则</h3>
				<div class="text">
					<p>1．  凡在步长指定的网上药店购买步长电商渠道产品的用户，上传购买记录（包括购物清单）的截图可免费领取10元红包。</p>
					<p>2．  注册成为涛大夫APP用户可领取相应红包，在APP可健康咨询使用。</p>
					<p>3．  每名用户（以手机号码区分）只可参与一次活动。</p>
				</div>
			</div>
			<hr />
			<div class="advertise">
				<div class="text">
					<img src="${ctx}/images/advertise.png"/>
				</div>
			</div>
			<hr />
			<div class="wordstyle">
				<h3>企业简介</h3>
				<div class="text indent">
					<p>“听党的话，走中国特色社会主义道路，尊重各级政府领导，遵纪守法经营”是步长制药区别于其他医药企业的鲜明特色。步长制药是国内著名的大型中药企业，坚持走自主研发道路，独家知识产权专利产品达90余个。产品范围覆盖心脑血管疾病药物，妇科、男科、儿科、呼吸、消化类产品。坚持“诚信为本，稳健经营”，注重产品质量，提出“疗效才是硬道理！”，为企业赢得了广泛赞誉。</p>
				</div>
			</div>
			<hr />
			<div class="wordstyle starbg">
				<h3>科技创新  永恒动力</h3>
				<div class="text indent">
					<p>步长高度重视科技开发和自主创新。</p>
					<p>截止2016年12月31日，步长已拥有自主知识产权的国家新药90多个，获得国家专利252件，其中发明专利206件，外观设计专利34件，实用新型专利12件。步长已成为中国拥有知识产权和独家产品最多的中药企业。</p>
					<p>步长自主研制的治疗心脑血管病的大品种中药注射液获得中国中药首个专利金奖，成为自药品实施专利保护以来首个获得中国专利金奖的中药产品。</p>
				</div>
			</div>
			<hr />
			<div class="wordstyle">
				<h3>脑心同治心脑血管病患者的福音</h3>
				<div class="text indent">
					<p>赵涛董事长的父亲赵步长曾经支边18载，用医药知识服务于哈族同胞，并创办阿勒泰地区卫生学校。在治疗中风病人的同时，与夫人伍海勤、长子赵涛经过多年中西医结合临床实践，创造性的提出“脑心同治”和“供血不足乃万病之源”两大医学理论，得到了多位中国科学院和中国工程院院士的高度评价和国内外医学界的广泛认可。脑心同治理论突破了传统的脑心分治思维，是心脑血管病治疗的重大创新，被中华中医药学会授予科技进步一等奖。在脑心同治理论指导下研制出了一系列具有显著临床疗效的心脑血管优秀产品，上市数十年造福千万患者。</p>
				</div>
			</div>
			<hr />
			<div class="wordstyle mapbg">
				<h3>步长情缘同心共铸</h3>
				<img src="${ctx}/images/chineseheart.png" class="heart"/>
				<div class="text indent">
					<p>“同心·共铸中国心”是由中央统战部、国务院侨办、国家卫计委指导，中国藏文化保护与发展协会、中国红十字基金会、北京市红十字基金会主办，步长制药全程赞助的大型公益项目。自2008年发起至今，“同心·共铸中国心”的专家医疗团队和志愿者们不间断的为老少边穷地区以及藏区广大人民群众开展医疗救助活动。其中，受到救助的群众累计达到百万人次，为近千余名先天性心脏病患儿提供免费手术，使千名白内障患者可以重见光明。</p>
				</div>
			</div>
			<hr />
			<div class="erweima">
				<img src="${ctx}/images/erweima.png"/>
				<p>扫描关注步长制药更多信息</p>
				<img src="${ctx}/images/bg_bottom.png" class="bg_bottom"/>
			</div>
		</div>
</body>
</html>
