<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/libraries/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/libraries/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<link
	href="${pageContext.request.contextPath}/libraries/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/libraries/bootstrap-table-develop/dist/bootstrap-table.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/libraries/bootstrap-table-develop/dist/bootstrap-table.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/libraries/bootstrap-table-develop/dist/locale/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/libraries/bootstrap-table-develop/src/extensions/export/bootstrap-table-export.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/libraries/bootstrap-3.3.7-dist/css/bootstrap.min.css"></link>
<link
	href="${pageContext.request.contextPath}/libraries/bootstrap-table-develop/dist/bootstrap-table.min.css"
	rel="stylesheet" />


<script type="text/javascript"
	src="${pageContext.request.contextPath}/libraries/bootstrap-table-develop/dist/bootstrap-table.min.js"></script>

<link
	href="${pageContext.request.contextPath}/libraries/Content/bootstrap3-editable/css/bootstrap-editable.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/libraries/Content/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/libraries/Content/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/libraries/Content/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/libraries/Content/bootstrap-table/extensions/editable/bootstrap-table-editable.js"></script>

</head>
<body>

	<div class="panel-body" style="padding-bottom: 0px;">
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加出库信息
			</button>
		</div>
		<table id="tb_departments"></table>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">显示信息</h4>
				</div>
				<div class="modal-body">
					<form action="${pageContext.request.contextPath}/depotinfo/adddepotinfo.action"
						method="post">
						<div class="form-group">
							<label for="txt_departmentname">ID</label> <input type="text"
								name="depotinfoId" class="form-control" id="txt_departmentname"
								placeholder="ID">
						</div>
						<div class="form-group">
							<label for="txt_departmentname">仓库名</label>
								<select class="form-control" id="depotName" name="depotName">
								<c:forEach items="${depotList}" var="depotList">
									<option value='${depotList.depotName}'>${depotList.depotName}</option>
								</c:forEach>
								</select>
						</div>
						<div class="form-group">
							<label for="txt_departmentlevel">订单备注</label> 
							<input type="text"
								name="depotInfoExplain" class="form-control" id="txt_departmentname"
								placeholder="ID">
						</div>
						<div class="form-group">
							<label for="txt_departmentlevel">商品名</label> 
							<select class="form-control" id="goodId" name="goodName">
								<c:forEach items="${goodsList}" var="goodsList">
									<option value='${goodsList.goodName}'>${goodsList.goodName}</option>
								</c:forEach>
								</select>
						</div>
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
						</button>
						<button type="submit" id="btn_submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-floppy-disk"></span>保存
						</button>
					</form>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			//1.初始化Table
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();
		});
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table
			oTableInit.Init = function() {
				$('#tb_departments')
						.bootstrapTable(
								{
									url : '${pageContext.request.contextPath}/depotinfo/page.action', //请求后台的URL（*）
									method : 'get', //请求方式（*）
									toolbar : '#toolbar', //工具按钮用哪个容器
									striped : true, //是否显示行间隔色
									cache : true, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
									pagination : true, //是否显示分页（*）
									sortable : true, //是否启用排序
									sortOrder : "asc", //排序方式
									queryParamsType : '', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
									// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
									//queryParams: oTableInit.queryParams,//传递参数（*）
									sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
									pageNumber : 1, //初始化加载第一页，默认第一页
									pageSize : 10, //每页的记录行数（*）
									pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
									search : false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
									strictSearch : true,
									showColumns : true, //是否显示所有的列
									showRefresh : true, //是否显示刷新按钮
									minimumCountColumns : 2, //最少允许的列数
									clickToSelect : true, //是否启用点击选中行
									height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
									uniqueId : "DEPOTINFOID", //每一行的唯一标识，一般为主键列
									showToggle : true, //是否显示详细视图和列表视图的切换按钮
									cardView : false, //是否显示详细视图
									detailView : false, //是否显示父子表
									showExport : true, //是否显示导出
									exportDataType : "basic", //basic', 'all', 'selected'.
									columns : [ {
										checkbox : true
									}, {
										field : 'DEPOTINFOID',
										title : 'ID',
									}, {
										field : 'DEPOTDATE',
										title : '创建日期',
									}, {
										field : 'DEPOTNAME',
										title : '仓库名',
									}, {
										field : 'USERID',
										title : '经手人',
									}, {
										field : 'DEPOTID',
										title : '仓库ID',
									}, {
										field : 'DEPOTINFOEXPLAIN',
										title : '订单备注',
									}, {
										field : 'GOODID',
										title : '订购商品ID',
									}, {
										field : 'GOODNAME',
										title : '订购商品',
									}, {
										field : 'GOODNUMBER',
										title : '订购数量',
									}, {
										field : 'GOODBIDPRICE',
										title : '商品单价',
									}, {
										field : 'GOODEXPLAIN',
										title : '商品备注',
									} ],
									onEditableSave : function(field, row,
											oldValue, $el) {
										var data = {
											depotinfoId : row.DEPOTINFOID,
											depotDate : row.DEPOTDATE,
											depotName : row.DEPOTNAME,
											userId : row.USERID,
											depotId : row.DEPOTID,
											depotInfoExplain : row.DEPOTINFOEXPLAIN,
											goodId : row.GOODID,
											goodName : row.GOODNAME,
											goodNumber : row.GOODNUMBER,
											goodBidPrice : row.GOODBIDPRICE,
											goodExplain : row.GOODEXPLAIN
										}
										$
												.ajax({
													type : "post",
													url : "${pageContext.request.contextPath}/depotinfo/update.action",
													type : "POST",
													data : JSON.stringify(data), //转JSON字符串  
													dataType : 'json',
													contentType : 'application/json;charset=UTF-8',
													success : function(data,
															status) {
														if (status == "success") {
															alert('提交数据成功');
														}
													},
													error : function() {
														alert('编辑失败');
													},
													complete : function() {

													}
												});
									}
								});
			};

			//得到查询的参数
			oTableInit.queryParams = function(params) {
				var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					limit : params.limit, //页面大小
					offset : params.offset, //页码
					departmentname : $("#txt_search_departmentname").val(),
					statu : $("#txt_search_statu").val()
				};
				return temp;
			};
			return oTableInit;
		};
		var ButtonInit = function() {
			var oInit = new Object();
			var postdata = {};

			oInit.Init = function() {
				//初始化页面上面的按钮事件
			};
			return oInit;
		};
		$("#btn_add").click(function() {
			getDeptinfo();
			getUserinfo();
			getGoodsinfo();
			$("#myModalLabel").text("显示信息");
			$('#myModal').modal();
		});
		function getDeptinfo() {
			$
					.ajax({
						url : "${pageContext.request.contextPath}/depotinfo/finddepot.action",
						type : "POST",
						success : function(data) {

						}
					});
		}
		function getUserinfo() {
			$
					.ajax({
						url : "${pageContext.request.contextPath}/depotinfo/finduser.action",
						type : "POST",
						success : function(data) {

						}
					});
		}
		function getGoodsinfo() {
			$
					.ajax({
						url : "${pageContext.request.contextPath}/depotinfo/findgoods.action",
						type : "POST",
						success : function(data) {

						}
					});
		}
		$("#btn_delete").click(function() {
			var rows = $("#tb_departments").bootstrapTable('getSelections');
			if (rows.length == 0) {
				alert("请先选择要删除的记录!");
				return;
			}
			var ids = '';
			for (var i = 0; i < rows.length; i++) {
				ids += rows[i]['DEPOTID'] + ",";
			}
			ids = ids.substring(0, ids.length - 1);
			deleteUser(ids);
		});

		function deleteUser(ids) {
			var msg = "您真的确定要删除吗？(此仓库将不会再运营)";
			if (confirm(msg) == true) {
				$
						.ajax({
							url : "${pageContext.request.contextPath}/depotinfo/del.action",
							type : "POST",
							data : ids,
							success : function(data) {
								alert("删除成功");
								//重新加载记录  
								//重新加载数据  
								//$("#tb_departments").bootstrapTable('refresh', {url: '${pageContext.request.contextPath}/page/depot/newQuery.action'});
								window.location.href = "${pageContext.request.contextPath}/page/order/orderMain.jsp";
							}
						});
			}
		}
	</script>
</body>
</html>