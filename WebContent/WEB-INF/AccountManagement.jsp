<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<link href="css/main.css" rel="stylesheet">
</head>
<body>
			<div class="AccountManagement_c " id="AccountManagement_c">
                <h3>账户管理 
                    <div class="amcl fr">
                        <input type="text" placeholder="用户名" class="fl" name="">
                        <div class="search fl"><img src="images/search.png"></div>
                    </div> 
                </h3>
                <div class="AM_ct text_center">
                    <div class="AM_ct_in">
                        <div class="add_btn df_btn fl" id="add_Account_btn">添加</div>
                        <div class="edit_btn df_btn fl" id="edit_Account_btn">编辑</div>
                        <div class="delete_btn df_btn fl" id="delete_Account_btn">删除</div>
                        <div class="fr df_btn ac_btn" id="ac_Account_btn">账号授权</div>
                    </div>
                </div>

                <div class="list">
                    <ul class="list_h">
                        <li class="b15"><label><span  style="margin-left:20px;">用户名</span></label></li>
                        <li class="b35"><label>密码</label></li>
                        <li class="b50"><label>授权形式</label></li>
                    </ul>
                    <div class="list_b_c">
                        <ul class="list_null">
                            <li class="text_center">未添加管理员账户！</li>
                        </ul>
					<c:forEach items="${userList}" var="ul">
                        <ul class="list_b">
                            <li class="b15"><label><input type="radio" name="danxuan"><span>${ul.username}</span></label></li>
                            <li class="b35"><label>${ul.password}</label></li>
                            <li class="b50"><label>${ul.jobName}</label></li>
                        </ul>
					</c:forEach>




                    </div>

                    <div class="pull_page">
                        <div class="fl pull_page_up" id="up" style="cursor: pointer;">上一页</div>
                        	 <%-- <ul>
	                           <c:forEach items="${pageList}" var="pl">			                       
			                            <li>${pl.pg}</li>			                       
								</c:forEach>
							 </ul> --%>
							 
							 <ul class="love">
							 	<li></li>
							 	<li></li>
							 	<li></li>
							 	<li></li>
							 	<li></li>
							 </ul>
                        <div class="fl pull_page_down" id="dn" style="cursor: pointer;">下一页</div>
                    </div>

                    
                </div>
            </div>


            <!-- 弹窗 -->
    <!-- 添加账户 -->
    <div class="add_Account dn" id="add_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    添加账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="" id="insertName">     
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label> <input type="password" placeholder="输入密码" name="" id="insertPass">     
            </div>
            <div class="add_Account_ok_btn text_center" id="add_Account_ok_btn" onclick="insert()">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 账户编辑 -->
    <div class="add_Account dn" id="user_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    编辑账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="column_now ">正在编辑 “<span>jiaowuchu</span>”账户</div>
            <div class="user_name user_i">
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="" id="updateName">     
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label> <input type="password" placeholder="输入密码" name="" id="updatePass">     
            </div>
            <div class="add_Account_ok_btn text_center" id="user_column_ok_btn" onclick="update()">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 删除账户 -->
    <div class="add_Account dn" id="delete_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    删除账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="delete_text">确定删除“ <span id="dename"></span> ”账户吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_Account_ok_btn" onclick="delete1()">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 账户授权 -->
    <div class="add_Account dn" id="ac_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    账户栏目授权
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <ul  id="mylove">
            	<c:forEach	items="${depart}" var="dep">
               		 <li><label><input type="checkbox" name="">&nbsp;<span>${dep.department_name}</span></label></li>
            	</c:forEach>

            </ul>
            <div class="add_Account_ok_btn text_center" id="ac_Account_ok_btn">保<i>呀</i>存</div>
        </div>
    </div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/main.js"></script> 
<script type="text/javascript">
		//添加按钮点击事件
		function insert(){
			 var insertName=document.getElementById("insertName").value;
			 var insertPass=document.getElementById("insertPass").value;
			 if(insertName!=null&&insertPass!=null){
				 window.location.href="Servlet1?insertName="+insertName+"&&insertPass="+insertPass; 
			 }
		}
		
		//账号授权事件
		$('#ac_Account_btn').click(function(){
	        ips=$(".list_b_c").find("input");
			ips.each(function(){
				if($(this).attr("checked")){
					userId=$(this).next().html();//获取当前被选中的多选框的值
					
				}
			})
		})
		
		$('#ac_Account_ok_btn').click(function(){
			ips=$("#mylove").find("input");
			ips.each(function(){
				if($(this).attr("checked")){
					departId=$(this).next().html();//获取当前被选中的多选框的值

					window.location.href="Servlet1?userId="+userId+"&&departId="+departId; 
				}
			})
		})
		
		
		//删除按钮点击事件
		$('#delete_Account_btn').click(function(){
			 //删除账户	        
	        ips=$(".list_b_c").find("input");
			ips.each(function(){
				if($(this).attr("checked")){
					var delete1=$(this).next().html();					
				        $('#dename').html(delete1);
				        $("#delete_Account").fadeIn(100);

				}
			})
		})
		
		
		 
		function delete1(){
			ips.each(function(){
				if($(this).attr("checked")){
					var delete1=$(this).next().html();					
					window.location.href="Servlet1?deleteName="+delete1; 
				}
			})
		}
		
	
		//编辑按钮点击事件
		function update(){	
			 var updateName1=document.getElementById("updateName").value;
			 var updatePass1=document.getElementById("updatePass").value;
			 if(insertName!=null&&insertPass!=null){
				 var ips=$(".list_b_c").find("input");
					ips.each(function(){
						if($(this).attr("checked")){
							var updateName=$(this).next().html();
							var updatePass=$(this).parents("li").next().find("label").html();
							 window.location.href="Servlet1?updateName="+updateName+"&&updatePass="+updatePass+"&&updatePass1="+updatePass1+"&&updateName1="+updateName1; 
						}
					})
				
			 }
		}
		//分页的JS代码
 		$(function(){
 			
 			var zs=$('.list_b_c').find('ul');
 			var js=0;
 			zs.each(function(){
 				js++;
 				if(js>=2){
 					$('.list_b_c').find('ul').eq(0).css("display","none");
 				}
 			})
 			
 			
 			
 			 pagemax=<%=request.getSession().getAttribute("pagemax") %>;
 			var fs=<%=request.getSession().getAttribute("nowPage") %>;
 			if(pagemax==1){
 				$(".love").find("li").eq(0).html(1);
 				$(".love").find("li:gt(0)").css("display","none");
 			}else if(pagemax==2){
 				$(".love").find("li").eq(0).html(1);
 				$(".love").find("li").eq(1).html(2);
 				$(".love").find("li:gt(1)").css("display","none");
 			}else if(pagemax==3){
 				$(".love").find("li").eq(0).html(1);
 				$(".love").find("li").eq(1).html(2);
 				$(".love").find("li").eq(2).html(3);
 				$(".love").find("li:gt(2)").css("display","none");
 			}else if(pagemax==4){
 				$(".love").find("li").eq(0).html(1);
 				$(".love").find("li").eq(1).html(2);
 				$(".love").find("li").eq(2).html(3);
 				$(".love").find("li").eq(3).html(4);
 				$(".love").find("li:gt(3)").css("display","none");
 			}else if(pagemax>=5){
 				if(fs>=pagemax-2){
 	 				$(".love").find("li").eq(0).html(pagemax-4);
 	 	 			$(".love").find("li").eq(1).html(pagemax-3);
 	 				$(".love").find("li").eq(2).html(pagemax-2);
 	 	 			$(".love").find("li").eq(3).html(pagemax-1);
 	 	 			$(".love").find("li").eq(4).html(pagemax);
 	 			}else if(fs>=3){
 	 				$(".love").find("li").eq(2).html(fs);
 	 	 			$(".love").find("li").eq(0).html(fs-2);
 	 	 			$(".love").find("li").eq(1).html(fs-1);
 	 	 			$(".love").find("li").eq(3).html(fs+1);
 	 	 			$(".love").find("li").eq(4).html(fs+2);
 	 	 			$(".love").append("<li>...</li>");
 	 	 			$(".love").append("<li>"+pagemax+"</li>");
 	 			}else{
 	 	 			$(".love").find("li").eq(0).html(1);
 	 	 			$(".love").find("li").eq(1).html(2);
 	 				$(".love").find("li").eq(2).html(3);
 	 	 			$(".love").find("li").eq(3).html(4);
 	 	 			$(".love").find("li").eq(4).html(5);
 	 				
 	 			}
 	 			
 			}
 					
 			
			var number= $(".pull_page ul").find("li");
			var fs=<%=request.getSession().getAttribute("nowPage") %>;	
			/* alert("fs="+fs); */
			number.each(function(){				
				if($(this).html()==fs){
					/* alert("进来了"); */
					$(this).addClass("on");
				} else{
					$(this).removeClass("on");
				}
			})
			/* alert("number="+number);
			alert("fs="+fs); */
			
		
			
		})
		
	// pull page   翻页
	$(".pull_page ul li").click(function(){
		
		var index =$(this).index();
		
		$(this).addClass("on").siblings().removeClass("on");
		
	     var number=$(".on").html();
	    /*  alert(number); */
		 window.location.href="Servlet1?hes="+number; 

	})
	
	$("#up").click(function(){
		var number=$(".on").html()-1;
		if(number!=0){
			 window.location.href="Servlet1?hes="+number; 
		}
	})
	
	$("#dn").click(function(){
		var number=$(".on").html()-1+2;
		if(number>=pagemax){
			 window.location.href="Servlet1?hes="+pagemax; 
		}
	})


</script>  
</body>

</html>