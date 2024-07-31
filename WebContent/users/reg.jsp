<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
  </head>
  <script language="JavaScript">
		function check11()
			{
				
				if (document.form1.account.value == "" ) 
				{
					alert("用户账号不能为空!");
					document.form1.account.focus();
					return false;
				}
				if (document.form1.password.value == ""  )  
				{
					alert("密码不能为空!");
					document.form1.password.focus();
					return false;
				}
				var pwdreg=/[^\d]/
				if (!pwdreg.test(document.form1.password.value ) )  
				{
					alert("密码必须包含特殊字符!");
					document.form1.password.focus();
					return false;
				}
				if (document.form1.qpassword.value == ""  )  
				{
					alert("确认密码不能为空!");
					document.form1.qpassword.focus();
					return false;
				}
				if (document.form1.qpassword.value != document.form1.password.value  )  
				{
					alert("两次密码不一致!");
					document.form1.qpassword.focus();
					return false;
				}
				if (document.form1.zname.value == ""  )  
				{
					alert("昵称不能为空!");
					document.form1.zname.focus();
					return false;
				}
				if (document.form1.phone.value != ""  ){
				if (!/\d{11}/.test(document.form1.phone.value )  )
				{
					alert("请输入正确的手机号码!");
					document.form1.phone.focus();
					return false;
				}}
				if (document.form1.email.value == ""  )  
				{
					alert("电子邮箱不能为空!");
					document.form1.email.focus();
					return false;
				}
				var emailreg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
				if (!emailreg.test(document.form1.email.value )  )  
					{
						alert("请输入正确的电子邮箱!");
						document.form1.email.focus();
						return false;
					}
			}
</script>
  <body>
  <form action="<%=request.getContextPath() %>/servlets/RegServlet" name="form1" method="post" onSubmit="return check11()">
  <div align="center"><br>
  <table bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" border="1">
				<tr>
					<td colspan="3" align="center" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="#666666">请填写用户信息(带<font color="red">*</font>为必填项)</font>
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="#996633">账&nbsp;&nbsp; &nbsp;户：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<input class="input7" type="text" name="account"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="red">&nbsp;* </font>您用来登录的用户名
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="#996633">密&nbsp;&nbsp; &nbsp;码：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<input class="input7" type="password" name="password"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="red">&nbsp;* </font>必须包含特殊字符
					</td>
				</tr>				
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="#996633">确认密码：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<input class="input7" type="password" name="qpassword"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="red">&nbsp;* </font>请将输入的密码再次输入
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="#996633">呢称：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<input class="input7" type="text" name="zname"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="red">&nbsp;* </font>填写您想展示给别人的称呼
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="#996633">性&nbsp; &nbsp;&nbsp;别：</font>
					</td>
					<td align="center" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<input type="radio" name="sex" checked value="男">
						男&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex" value="女">
						女
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="red">&nbsp;* </font>请填写您的真实信息
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="#996633">年&nbsp;&nbsp; &nbsp;龄：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<input class="input7" type="text" name="age"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						请输入整数年龄
					</td>
				</tr>				
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="#996633">电话号码：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<input class="input7" type="text" name="phone"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						请填写您的真实信息(格式为02411111111或13911111111) </td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="#996633">电子邮箱：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<input class="input7" type="text" name="email"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						请填写您有效的邮件地址，以便于我们为您提供有效的服务。
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<input type="submit" value="注册">
						<input type="button" value="返回主页" onclick="location='./systems/index.jsp'"/>
					</td>
				</tr>
				<tr>
				<%
				if(request.getAttribute("ok") != null){
				%>
					<th colspan="3" height="40" style="border: 2px groove #D5CD71" bgcolor="#FCCE8F">
						<font size="3" color="red"> 恭喜您注册成功！！！！</font><br>
						网页将在5秒钟后自动跳转到登录页面页，如没自动跳转请按<a href="users/login.jsp">这里</a>
					</th>
				<%}%>
				</tr>
			</table>
  </div>
  </form>
  </body>
</html>