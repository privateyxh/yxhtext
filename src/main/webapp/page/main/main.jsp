<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Googol</title>
</head>
<style>
* {
	padding: 0;
	margin: 0;
}

body, html {
	overflow: hidden;
	height: 100%;
}

#container {
	width: 100%;
	height: 100%;
}

#container div {
	width: 50%;
	height: 50%;
	float: left;
}

#container div:hover {
	opacity: .8;
	filter: alpha(opacity = 80);
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/libraries/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/libraries/echarts/echarts.js"></script>
<body>
	<div id="container">
		<div id="red"></div>
		<div id="orange"></div>
		<div id="green"></div>
		<div id="blue"></div>
	</div>

</body>
<script type="text/javascript">
    //使用ajax加载数据 
    $.ajax({
        method:'post',
        url:'${pageContext.request.contextPath}/echart/getInfo.action',
        dataType:'json',
        success:function(data){
            initChat1(data);
        }
    }); 
    function initChat1(data){
    var myChart = echarts.init(document.getElementById('red'));
        option = {
                title : {
                    text: '商品比例统计',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: data
                },
                series : [
                    {
                        name: '售卖商品',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:data,
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }       
                    }
                ]
            },
                    myChart.setOption(option);
    };
</script>

<script type="text/javascript">
    //使用ajax加载数据 
    $.ajax({
        method:'post',
        url:'${pageContext.request.contextPath}/echart/getInfo1.action',
        dataType:'json',
        success:function(data){
            initChat2(data);
        }
    }); 
    function initChat2(data){
    var myChart = echarts.init(document.getElementById('orange'));
        option = {
                title : {
                    text: '运营仓库统计',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: data
                },
                series : [
                    {
                        name: '运营仓库',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:data,
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }       
                    }
                ]
            },
                    myChart.setOption(option);
    };
</script>

<script type="text/javascript">
    //使用ajax加载数据 
    $.ajax({
        method:'post',
        url:'${pageContext.request.contextPath}/echart/getInfo2.action',
        dataType:'json',
        success:function(data){
            initChat3(data);
        }
    }); 
    function initChat3(data){
    var myChart = echarts.init(document.getElementById('green'));
        option = {
                title : {
                    text: '合作公司统计',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: data
                },
                series : [
                    {
                        name: '合作公司',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:data,
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }       
                    }
                ]
            },
                    myChart.setOption(option);
    };
</script>

<script type="text/javascript">
    //使用ajax加载数据 
    $.ajax({
        method:'post',
        url:'${pageContext.request.contextPath}/echart/getInfo3.action',
        dataType:'json',
        success:function(data){
            initChat4(data);
        }
    }); 
    function initChat4(data){
    var myChart = echarts.init(document.getElementById('blue'));
        option = {
                title : {
                    text: '员工比例统计',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: data
                },
                series : [
                    {
                        name: '在职员工',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:data,
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }       
                    }
                ]
            },
                    myChart.setOption(option);
    };
</script>

</html>