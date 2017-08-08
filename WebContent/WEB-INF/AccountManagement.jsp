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
                        <li class="b20"><label><input type="checkbox" name=""><span>用户名</span></label></li>
                        <li class="b20"><label>密码</label></li>
                        <li class="b60"><label>授权形式</label></li>
                    </ul>
                    <div class="list_b_c">
                        <ul class="list_null">
                            <li class="text_center">未添加管理员账户！</li>
                        </ul>
					<c:forEach items="${userList}" var="ul">
                        <ul class="list_b">
                            <li class="b20"><label><input type="checkbox" name=""><span>${ul.username}</span></label></li>
                            <li class="b20"><label>${ul.password}</label></li>
                            <li class="b60"><label>${ul.jobName}</label></li>
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
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="">     
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label> <input type="password" placeholder="输入密码" name="">     
            </div>
            <div class="add_Account_ok_btn text_center" id="add_Account_ok_btn">确<i>皮</i>定</div>
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
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="">     
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label> <input type="password" placeholder="输入密码" name="">     
            </div>
            <div class="add_Account_ok_btn text_center" id="user_column_ok_btn">确<i>皮</i>定</div>
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
            <div class="delete_text">确定删除“ <span>jiaopwuchu</span> ”账户吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_Account_ok_btn">确<i>皮</i>定</div>
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
            <ul>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
            </ul>
            <div class="add_Account_ok_btn text_center" id="ac_Account_ok_btn">保<i>呀</i>存</div>
        </div>
    </div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/main.js"></script> 
<script type="text/javascript">
		
		
 		$(function(){
 			var pagemax=<%=request.getSession().getAttribute("pagemax") %>;
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
		if(number!=0){
			 window.location.href="Servlet1?hes="+number; 
		}
	})
</script>  
</body>

</html>