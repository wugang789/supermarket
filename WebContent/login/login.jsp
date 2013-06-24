<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>管理登陆</title>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 11pt;
	font-weight: bold;
}
-->
</style>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/login.js" charset="GBK"></script>
</head>

<body style="background-image:url(../images/admin_login_bg.gif); margin:0 auto; width:500px;">

<div  style="background-image:url(../images/admin_login.png); width:500px; height:200px; margin-top:130px;margin-left: 420px;">
  <form id="form1" name="form1" method="post" action="">
    <table width="500" border="0" cellpadding="0" cellspacing="0" align="center">
      <tr>
        <td width="250">&nbsp;</td>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td height="40"><div align="right" class="STYLE1">用户名：</div></td>
        <td height="40" colspan="2"><input type="text" name="name" style="height:25px; width:200px; font-size:15pt; font-weight:bold;" id="myname"/>
        <span id="mynametext"></span>
        </td>
      </tr>
      <tr>
        <td height="40"><div align="right" class="STYLE1">密&nbsp; 码：</div></td>
        <td height="40" colspan="2"><input type="password" name="password" style="height:25px; width:200px; font-size:15pt; font-weight:bold;" id="mypassword" /></td>
      </tr>
      <tr>
        <td height="40"><div align="right" class="STYLE1">验证码：</div></td>
        <td width="100" height="40"><input type="text" name="textfield3" style="height:25px; width:85px; font-size:15pt; font-weight:bold;" id="mynumber" /></td>
        <td width="150"><img id="code" src="/supermarket/GetAuthCode" title="点击刷新验证码" onclick="changeValidateCode()" style="cursor : pointer;"/></td>
      </tr>
      <tr>
        <td height="40">&nbsp;</td>
        <td height="40" colspan="2"><input  value="" style="width:130px; height:30px; background-image:url(../images/admin_login_button.png); border:0; background-color: transparent ;cursor:pointer; "
          id="mysubmit" /></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>