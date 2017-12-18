<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加公司资料
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
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
					<form action="${pageContext.request.contextPath}/company/add.action"
						method="post">
						<div class="form-group">
							<label for="txt_departmentname">ID</label> <input type="text"
								name="companyId" class="form-control" id="txt_departmentname"
								placeholder="ID">
						</div>
						<div class="form-group">
							<label for="txt_departmentname">公司名</label> <input type="text"
								name="companyName" class="form-control" id="txt_departmentname"
								placeholder="公司名">
						</div>
						<div class="form-group">
							<label for="txt_parentdepartment">负责人</label> <input type="text"
								name="companyUser" class="form-control"
								id="txt_parentdepartment" placeholder="负责人">
						</div>
						<div class="form-group">
							<label for="txt_departmentlevel">负责人电话</label> <input type="text"
								name="companyPhone" class="form-control" id="txt_departmentlevel"
								placeholder="负责人电话">
						</div>
						<div class="form-group">
							<label for="txt_departmentlevel">公司地址</label> <input type="text"
								name="companyAddress" class="form-control"
								id="txt_departmentlevel" placeholder="公司地址">
						</div>
						<div class="form-group">
							<label for="txt_departmentlevel">状态</label><br /> 
							<select name="companyState">
								<option value="0">合作中</option>
								<option value="1">合作终止(将会停止合作)</option>
							</select>
						</div>
						<div class="form-group">
							<label for="txt_departmentlevel">备注</label> <input type="text"
								name="companyExplain" class="form-control"
								id="txt_departmentlevel" placeholder="备注">
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
    $(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: '${pageContext.request.contextPath}/company/page.action',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: true,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParamsType : '', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			//queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "COMPANYID",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            showExport: true,                     //是否显示导出
            exportDataType: "basic",              //basic', 'all', 'selected'.
            columns: [{
                checkbox: true
            }, {
            	field : 'COMPANYID',
				title : 'ID',
                editable: {
                    type: 'text',
                    title: 'ID',
                    validate: function (v) {
                        if (!v) return '编号不能为空';
                    }
                }
               
            }, {
            	field : 'COMPANYNAME',
				title : '公司名',
                editable: {
                    type: 'text',
                    title: '公司名',
                    validate: function (v) {
                        if (!v) return '公司名不能为空';

                    }
                }
            }, {
            	field : 'COMPANYUSER',
				title : '负责人',
                editable: {
                    type: 'text',
                    title: '负责人',
                    validate: function (v) {
                        if (!v) return '负责人不能为空';

                    }
                }
            }, {
            	field : 'COMPANYPHONE',
				title : '负责人电话',
                editable: {
                    type: 'text',
                    title: '负责人电话',
                    validate: function (v) {
                        if (!v) return '负责人电话不能为空';

                    }
                }
            },{
            	field : 'COMPANYADDRESS',
				title : '公司地址',
                editable: {
                    type: 'text',
                    title: '公司地址',
                    validate: function (v) {
                        if (!v) return '公司地址不能为空';

                    }
                }
            },{
            	field : 'COMPANYSTATE',
				title : '状态',
                //editable: {
                    //type: 'text',
                    //title: '状态',
                    //validate: function (v) {
                        //if (!v) return '状态不能为空("运营中或停运")';
                    //}
                //}
            },{
            	field : 'COMPANYEXPLAIN',
				title : '备注',
                editable: {
                    type: 'text',
                    title: '备注',
                    validate: function (v) {
                        if (!v) return '备注不能为空';

                    }
                }
            }], onEditableSave: function (field, row, oldValue, $el) {
            	var data = {  
            			companyId:row.COMPANYID,
            			companyName:row.COMPANYNAME,
            			companyUser:row.COMPANYUSER,
            			companyPhone:row.COMPANYPHONE,
            			companyAddress:row.COMPANYADDRESS,
            			companyState:row.COMPANYSTATE,
            			companyExplain:row.COMPANYEXPLAIN
                }  
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/company/update.action",
                    type : "POST",  
                    data : JSON.stringify(data), //转JSON字符串  
                    dataType: 'json',  
                    contentType:'application/json;charset=UTF-8', 
                    success: function (data, status) {
                        if (status == "success") {
                            alert('提交数据成功');
                        }
                    },
                    error: function () {
                        alert('编辑失败');
                    },
                    complete: function () {

                    }
                });
            }
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            departmentname: $("#txt_search_departmentname").val(),
            statu: $("#txt_search_statu").val()
        };
        return temp;
    };
    return oTableInit;
};
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };
    return oInit;
};
$("#btn_add").click(function () {
    $("#myModalLabel").text("显示信息");
    $('#myModal').modal();
});
$("#btn_delete").click(function () {
	 var rows = $("#tb_departments").bootstrapTable('getSelections'); 
	    if (rows.length== 0) {  
	        alert("请先选择要删除的记录!");  
	        return;  
	    }  
	    var ids = '';  
	    for (var i = 0; i < rows.length; i++) {  
	        ids += rows[i]['COMPANYID'] + ",";  
	    }  
	    ids = ids.substring(0, ids.length - 1);  
	    deleteUser(ids);  
	});

	function deleteUser(ids) {  
	    var msg = "您真的确定要删除吗？(此仓库将不会再运营)";  
	    if (confirm(msg) == true) {  
	        $.ajax({  
	            url: "${pageContext.request.contextPath}/company/del.action",  
	            type : "POST",  
                data : ids,
	            success: function (data) {  
	                alert("删除成功");  
	                //重新加载记录  
	                //重新加载数据  
	                //$("#tb_departments").bootstrapTable('refresh', {url: '${pageContext.request.contextPath}/page/depot/newQuery.action'});
	                window.location.href="${pageContext.request.contextPath}/page/company/companyMain.jsp";
	            }  
	        });
	    }  
	}   

</script>
</body>
</html>