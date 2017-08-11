<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>新闻发布管理平台</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="css/main.css" rel="stylesheet">
</head>
<body>

    <div class="header">
        <div class="header_in">
            <img src="images/tit.png">
            <div class="quit text_center" onclick="goby()">安全退出</div>
        </div>
        
    </div>

    <div class="content ">
        <div class="user">
            <div class="user_status fl text_center">当前用户： <span>管理员001</span></div>
            <div class="user_location fl">当前： 首页-<span>账户管理</span>  </div>
        </div>
        <div class="nav_side text_center fl">
            <div class="nav AccountManagement active" id="z1">账户管理</div>
            <div class="nav ColumnManagement">栏目管理</div>
            <div class="nav NewsManagement">新闻管理</div>
        </div>


        <div class="main_fx">
            
            <div class="AccountManagement_c_iframe">
                <iframe src="Servlet1"></iframe>
            </div>
        </div>
    </div>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript">
	window.onload = function(){
		if(<%=request.getSession().getAttribute("level") %>==1){
			document.getElementById("z1").style.display="none";
			$("iframe").attr("src","Servlet2");
		}
	}
	
	function goby(){
		 window.location.href="IndexServlet"; 
	}
</script>
</body>
</html>