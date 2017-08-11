<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
	<meta charset="utf-8">
    <link href="css/main.css" rel="stylesheet">
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
</head>
<body>
<!-- 新闻管理 -->
            <div class="AccountManagement_c" id="NewsManagement_c">
                <h3>新闻管理 
                    <div class="amcl fr">
                        <select class="fl NewsManagement_search">
                            <c:forEach	items="${depart}" var="dep">
                           		 <option>${dep.department_name}</option>
			            	</c:forEach>
                        </select>
                        <input type="text" placeholder="用户名" class="fl" name="">
                        <div class="search fl"><img src="images/search.png"></div>
                    </div> 
                </h3>
                <div class="list" id="release_news">
                    <ul class="list_h">
                        <li class="b80"><label>发布新闻</label></li>
                    </ul>
                    <div class="list_b_c" id="release_news_in">
                        <div class="release_news">
                              <form action="NewsServlet" method="post">
                            <div class="news_title">
                                <label class="text_center">标题</label>                             
			                            <input type="text"  name="biaoti">			                                  
			                            </div>
			                            <div class="column_name">
			                                <label class="text_center">栏目</label>
			                                <select class="column_name_release" onchange="ocg()">
			                                    <c:forEach	items="${depart}" var="dep">
					                           		 <option>${dep.department_name}</option>
								            	</c:forEach>
			                                </select>
			                            </div>
			                            <input type="hidden"  name="lanmu" id="hid">
                          		  <textarea id="texts" class="release_news_content release_news_content" rows="50" cols="60" style="height:1000px;" placeholder="编辑正文" name="textarea"></textarea>     
                            	  <input type="submit" value="发布" class="release_news_ok_btn">
                       		  </form>
                           
                        </div>


                    </div>
                </div>
            </div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
 	CKEDITOR.replace('texts');
 	function ocg(){
 		var zs=$(".column_name_release").val();
 		$("#hid").val(zs);
 	}
 	
 	
 	
 	
 	/*		
	function send()
		{
			var xmlhttp;
				xmlhttp=new XMLHttpRequest();
			
			xmlhttp.onreadystatechange=function()
			{
				if (xmlhttp.readyState==4 && xmlhttp.status==200)
				{
					document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
				}
			}
			xmlhttp.open("post","NewsServlet?name=zhangsan",true);
			var text = CKEDITOR.instances.texts.getData(); 
			var info="{name:zhang,age:18,test:"+text+"}";
			alert(info);
			xmlhttp.send(info);
		}
	
 */
	</script>


</body>
</html>