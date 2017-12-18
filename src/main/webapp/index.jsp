<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>Googol</title>
	<link href="${pageContext.request.contextPath}/libraries/layui_login/css/default.css" rel="stylesheet" type="text/css" />
<!--必要样式-->
	<link href="${pageContext.request.contextPath}/libraries/layui_login/css/styles.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/libraries/layui_login/css/demo.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/libraries/layui_login/css/loaders.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/libraries/layui_login/layui/css/layui.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/libraries/layui_login/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/libraries/layui_login/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src='${pageContext.request.contextPath}/libraries/layui_login/js/stopExecutionOnTimeout.js?t=1'></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/libraries/layui_login/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/libraries/layui_login/js/Particleground.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/libraries/layui_login/js/Treatment.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/libraries/layui_login/js/jquery.mockjax.js"></script>
</head>
<body>
	<div class='login'>
	  <div class='login_title'>
	    <span>登录</span>
	  </div>
	  <form action="${pageContext.request.contextPath}/user/login.action" method="post">
	  <div class='login_fields'>
	    <div class='login_fields__user'>
	      <div class='icon'>
	        <img alt="" src='${pageContext.request.contextPath}/libraries/layui_login/img/user_icon_copy.png'/>
	      </div>
	      <input name="userName" id="uname" placeholder='用户名' maxlength="16" type='text' autocomplete="off" value="admin"/>
	        <div class='validation'>
	          <img alt="" src='${pageContext.request.contextPath}/libraries/layui_login/img/tick.png'/>
	        </div>
	    </div>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='${pageContext.request.contextPath}/libraries/layui_login/img/lock_icon_copy.png'/>
	      </div>
	      <input name="userPassword" id="upwd" placeholder='密码' maxlength="16" type='text' autocomplete="off" />
	      <div class='validation'>
	        <img alt="" src='${pageContext.request.contextPath}/libraries/layui_login/img/tick.png' />
	      </div>
	    </div>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='${pageContext.request.contextPath}/libraries/layui_login/img/key.png' />
	      </div>
	      <input name="code" id="codes" placeholder='验证码' maxlength="4" type='text' name="ValidateNum" autocomplete="off"/>
	      <div class='validation' style="opacity: 1; right: -5px;top: -3px;">
          <canvas class="J_codeimg" id="myCanvas" onclick="Code();">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
	      </div>
	    </div>
	    <div class='login_fields__submit'>
	      <input type='submit' value='登录'/>
	    </div>
	      </div>
	    </form>
	
	  <div class='success'>
	  </div>
	  <div class='disclaimer'>
	    <p></p>
	  </div>
	</div>
	<div class='authent'>
	  <div class="loader" style="height: 44px;width: 44px;margin-left: 28px;">
        <div class="loader-inner ball-clip-rotate-multiple">
            <div></div>
            <div></div>
            <div></div>
        </div>
        </div>
	  <p>☺登陆中☺</p>
	</div>
	<div class="OverWindows"></div>

	<script type="text/javascript">
		var canGetCookie = 0;//是否支持存储Cookie 0 不支持 1 支持
		var ajaxmockjax = 1;//是否启用虚拟Ajax的请求响 0 不启用  1 启用
		//默认账号密码
		var truelogin = "admin";
		var truepwd = "";
		var CodeVal = 0;
	    Code();
	    function Code() {
			if(canGetCookie == 1){
				createCode("AdminCode");
				var AdminCode = getCookieValue("AdminCode");
				showCheck(AdminCode);
			}else{
				showCheck(createCode(""));
			}
	    }
	    function showCheck(a) {
			CodeVal = a;
	        var c = document.getElementById("myCanvas");
	        var ctx = c.getContext("2d");
	        ctx.clearRect(0, 0, 1000, 1000);
	        ctx.font = "80px 'Hiragino Sans GB'";
	        ctx.fillStyle = "#E8DFE8";
	        ctx.fillText(a, 0, 100);
	    }
	    $(document).keypress(function (e) {
	        // 回车键事件  
	        if (e.which == 13) {
	            $('input[type="button"]').click();
	        }
	    });
	    //粒子背景特效
	    $('body').particleground({
	        dotColor: '#E8DFE8',
	        lineColor: '#9900ff'
	    });
	    $('input[name="password"]').focus(function () {
	        $(this).attr('type', 'password');
	    });
	    $('input[type="text"]').focus(function () {
	        $(this).prev().animate({ 'opacity': '1' }, 200);
	    });
	    $('input[type="text"],input[type="password"]').blur(function () {
	        $(this).prev().animate({ 'opacity': '.5' }, 200);
	    });
	    $('input[name="username"],input[name="password"]').keyup(function () {
	        var Len = $(this).val().length;
	        if (!$(this).val() == '' && Len >= 5) {
	            $(this).next().animate({
	                'opacity': '1',
	                'right': '30'
	            }, 200);
	        } else {
	            $(this).next().animate({
	                'opacity': '0',
	                'right': '20'
	            }, 200);
	        }
	    });
	    var open = 0;
	    layui.use('layer', function () {
			var msgalert = 'Googol后台已准备就绪( ´◔ ‸◔`)';
    		var index = layer.alert(msgalert, { icon: 6, time: 4000, offset: 't', closeBtn: 0, title: '友情提示', btn: [], anim: 2, shade: 0 });  
			layer.style(index, {
				color: '#777'
			}); 
	        //非空验证
	        $('input[type="submit"]').click(function () {
	        	var uname = $("#uname").val();
	            var upwd = $("#upwd").val();
	            var codes = $("#codes").val();
	            if (uname == '') {
	                ErroAlert('请输入您的账号');
	                return false;
	            } else if (upwd == '') {
	                ErroAlert('请输入密码');
	                return false;
	            } else if (codes == '' || codes.length != 4) {
	                ErroAlert('输入验证码');
	                return false;
	            }  else if (codes != CodeVal.toLowerCase()) {
	                ErroAlert('验证码错误，请重新输入');
	                codes=null;
	                return false;
	            } else {
	                //认证中..
	                //fullscreen();
	                $('.login').addClass('test'); //倾斜特效
	                setTimeout(function () {
	                    $('.login').addClass('testtwo'); //平移特效
	                }, 300);
	                setTimeout(function () {
	                    $('.authent').show().animate({ right: -320 }, {
	                        easing: 'easeOutQuint',
	                        duration: 600,
	                        queue: false
	                    });
	                    $('.authent').animate({ opacity: 1 }, {
	                        duration: 200,
	                        queue: false
	                    }).addClass('visible');
	                }, 500);
	            }
	        })
	    })
	    var fullscreen = function () {
	        elem = document.body;
	        if (elem.webkitRequestFullScreen) {
	            elem.webkitRequestFullScreen();
	        } else if (elem.mozRequestFullScreen) {
	            elem.mozRequestFullScreen();
	        } else if (elem.requestFullScreen) {
	            elem.requestFullscreen();
	        } else {
	            //浏览器不支持全屏API或已被禁用  
	        }
	    }  
		if(ajaxmockjax == 1){
			$.mockjax({  
				url: 'Ajax/Login',  
				status: 200,  
				responseTime: 50,          
				responseText: {"Status":"ok","Text":"登录成功<br /><br />欢迎回来"}  
			}); 
			$.mockjax({  
				url: 'Ajax/LoginFalse',  
				status: 200,  
				responseTime: 50,          
				responseText: {"Status":"Erro","Erro":"账号名或密码或验证码有误"}
			});   
		}
		//Ajax提交
		function AjaxPost(Url,JsonData,LodingFun,ReturnFun) {
		    $.ajax({
		        type: "post",
		        url: Url,
		        data: JsonData,
		        dataType: 'json',
		        async: 'false',
		        beforeSend: LodingFun,
		        error: function () { AjaxErro({ "Status": "Erro", "Erro": "500" }); },
		        success: ReturnFun
		    });
		}
		//弹出
		function ErroAlert(e) {
		    var index = layer.alert(e, { icon: 5, time: 2000, offset: 't', closeBtn: 0, title: '错误信息', btn: [], anim: 2, shade: 0 });
		    layer.style(index, {
		        color: '#777'
		    }); 
		}
		//Ajax 错误返回处理
		function AjaxErro(e) {
		    if (e.Status == "Erro") {
		        switch (e.Erro) {
		            case "500":
		                top.location.href = '/Erro/Erro500';
		                break;
		            case "100001":
		                ErroAlert("错误 : 错误代码 '10001'");
		                break;
		            default:
		                ErroAlert(e.Erro);
		        }
		    } else {
		        layer.msg("未知错误！");
		    }
		}
		//生成验证码
		var code = "";
		function createCode(e) {
		    code = "";
		    var codeLength = 4;
		    var selectChar = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
		    for (var i = 0; i < codeLength; i++) {
		        var charIndex = Math.floor(Math.random() * 60);
		        code += selectChar[charIndex];
		    }
		    if (code.length != codeLength) {
		        createCode(e);
		    }
			if(canGetCookie == 1){
		    	setCookie(e, code, 60 * 60 * 60, '/');
			}else{
				return code;
			}
		}
		//hours为空字符串时,cookie的生存期至浏览器会话结束。  
		//hours为数字0时,建立的是一个失效的cookie,  
		//这个cookie会覆盖已经建立过的同名、同path的cookie（如果这个cookie存在）。     
		function setCookie(name, value, hours, path) {
		    var name = escape(name);
		    var value = escape(value);
		    var expires = new Date();
		    expires.setTime(expires.getTime() + hours * 3600000);
		    path = path == "" ? "" : ";path=" + path;
		    _expires = (typeof hours) == "string" ? "" : ";expires=" + expires.toUTCString();
		    document.cookie = name + "=" + value + _expires + path;
		}
		//cookie名获取值  
		function getCookieValue(name) {
		    var name = escape(name);
		    //读cookie属性，这将返回文档的所有cookie     
		    var allcookies = document.cookie;
		    //查找名为name的cookie的开始位置     
		    name += "=";
		    var pos = allcookies.indexOf(name);
		    //如果找到了具有该名字的cookie，那么提取并使用它的值     
		    if (pos != -1) {    //如果pos值为-1则说明搜索"version="失败     
		        var start = pos + name.length;   //cookie值开始的位置     
		        var end = allcookies.indexOf(";", start); //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置     
		        if (end == -1) end = allcookies.length; //如果end值为-1说明cookie列表里只有一个cookie     
		        var value = allcookies.substring(start, end);  //提取cookie的值     
		        return unescape(value);       //对它解码           
		    }
		    else return "-1";    //搜索失败，返回-1  
		}    
    </script>
</body>
</html>
