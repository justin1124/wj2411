<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<jsp:include page="../common/common.jsp"></jsp:include>
	<title>双色球</title>
</head>
<body>
	<jsp:include page="../top.jsp"></jsp:include>
	<div id="page">
			<!-- start content -->
			<div id="content">
				<div class="post">
					<h2 class="title">双色球计算器(红球)</h2>
					<p class="meta"><span style="color:red">不想加入计算的域请留空!</span></p>
					<div class="entry">
						<form id="ssqCountForm" method="post">
							<ul id="biaoge">
								<li class="left">期号:</li>
							    <li class="right"><input type="text" class="easyui-numberbox" name="issue" id="issue"/></li>
							    <li class="left">遗漏和区间:</li>
							    <li class="right">
							    	<input type="text" class="easyui-numberbox" name="minOmitSum" style="width:90px;"/> -
							    	<input type="text" class="easyui-numberbox" name="maxOmitSum" style="width:90px;"/>
							    </li>
							    <li class="left">尾和区间:</li>
							    <li class="right">
							    	<input type="text" class="easyui-numberbox" name="minSumTail" style="width:90px;"/> -
							    	<input type="text" class="easyui-numberbox" name="maxSumTail" style="width:90px;"/>
							    </li>
							    <li class="left">和值区间:</li>
							    <li class="right">
							    	<input type="text" class="easyui-numberbox" name="min" style="width:90px;"/> -
							    	<input type="text" class="easyui-numberbox" name="max" style="width:90px;"/>
							    </li>
							    <li class="left">奇偶比:</li>
							    <li class="right">
							    	<select name="oddNum">
										<option value="">全部</option>
										<option value="6">6:0</option>
										<option value="5">5:1</option>
										<option value="4">4:2</option>
										<option value="3">3:3</option>
										<option value="2">2:4</option>
										<option value="1">1:5</option>
										<option value="0">0:6</option>
									</select>
							    </li>
							    <li class="left">是否横连:</li>
							    <li class="right">
							    	<select name="horizontalLink">
										<option value="">全部</option>
										<option value="1">是</option>
										<option value="0">否</option>
									</select>
							    </li>
							    <li class="left">是否竖连:</li>
							    <li class="right">
							    	<select name="verticalLink">
										<option value="">全部</option>
										<option value="1">是</option>
										<option value="0">否</option>
									</select>
							    </li>
							    <li class="left">区间比:</li>
							    <li class="right">
							    	<select name="partition">
										<option value="">全部</option>
										<option value="6:0:0">6:0:0</option>
										<option value="5:1:0">5:1:0</option>
										<option value="5:0:1">5:0:1</option>
										<option value="4:2:0">4:2:0</option>
										<option value="4:0:2">4:0:2</option>
										<option value="4:1:1">4:1:1</option>
										<option value="3:3:0">3:3:0</option>
										<option value="3:0:3">3:0:3</option>
										<option value="3:2:1">3:2:1</option>
										<option value="3:1:2">3:1:2</option>
										<option value="2:4:0">2:4:0</option>
										<option value="2:0:4">2:0:4</option>
										<option value="2:3:1">2:3:1</option>
										<option value="2:1:3">2:1:3</option>
										<option value="2:2:2">2:2:2</option>
										<option value="1:5:0">1:5:0</option>
										<option value="1:0:5">1:0:5</option>
										<option value="1:4:1">1:4:1</option>
										<option value="1:1:4">1:1:4</option>
										<option value="1:3:2">1:3:2</option>
										<option value="1:2:3">1:2:3</option>
										<option value="0:6:0">0:6:0</option>
										<option value="0:0:6">0:0:6</option>
										<option value="0:5:1">0:5:1</option>
										<option value="0:1:5">0:1:5</option>
										<option value="0:4:2">0:4:2</option>
										<option value="0:2:4">0:2:4</option>
										<option value="0:3:3">0:3:3</option>
									</select>
							    </li>
							    <li class="left">质合比:</li>
							    <li class="right">
							    	<select name="primeNum">
										<option value="">全部</option>
										<option value="6">6:0</option>
										<option value="5">5:1</option>
										<option value="4">4:2</option>
										<option value="3">3:3</option>
										<option value="2">2:4</option>
										<option value="1">1:5</option>
										<option value="0">0:6</option>
									</select>
							    </li>
							    <li><a id="submit" href="javascript:void(0);" onclick="$('#ssqCountForm').submit();$(this).linkbutton('disable');" class="easyui-linkbutton" icon="icon-ok">确定</a></li>
							</ul>
						</form>
						<div class="result">
							<div id="result" class="easyui-panel" title="计算结果" collapsible="true" style="width:160px;height:300px;padding:10px 20px;background:#fafafa;">
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end content -->
			<!-- start sidebar -->
			<jsp:include page="../left.jsp"></jsp:include>
			<!-- end sidebar -->
		</div>
		<!-- end page -->
		<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
