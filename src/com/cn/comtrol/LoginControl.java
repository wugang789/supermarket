package com.cn.comtrol;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.cn.service.Login;
import com.cn.serviceimpl.LoginImpl;

/**
 * Servlet implementation class LoginControl
 */
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private Login login;  
     String userName=null;
     String password=null;
     int roleid=0;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String variableName=request.getParameter("name");
		System.out.println(variableName);
		if(variableName.equals("Power")){
			Power(request, response);
		}else if(variableName.equals("Login")){
			Login(request, response);
		}else if(variableName.equals("")||variableName==null){
			showSubMenu(request, response);
		}else if(variableName.equals("showSubMenu")){
			showSubMenu(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 权限栏
	 */
	protected void Power(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out=null;
		 if(login==null){
			 login=new LoginImpl();
		 }
		@SuppressWarnings("rawtypes")
		Map map=login.login(userName,password);
		request.getSession().setAttribute("map",map);
		if(out==null){
			out=response.getWriter();
		}
		System.out.println(",,,,,>>");
		 String jss = "{\"a\":\"登录成功\"}";
		 out.write(jss);
	}
	
  /**
   * 用户登录和验证码判断
   */
  protected void Login(HttpServletRequest request,HttpServletResponse response){
	  response.setContentType("text/html;charset=UTF-8");
	  userName=request.getParameter("username");
	  System.out.println(userName);
	  password=request.getParameter("password");
	  PrintWriter out=null;
	  try {
		  out=response.getWriter();
	} catch (IOException e) {
		e.printStackTrace();
	}
	  String code=(String) request.getSession().getAttribute("codeNumbers");
	  String inputCode=request.getParameter("mynumber");
	  if(code.equals(inputCode)){
		  if(login==null){
				 login=new LoginImpl();
			 }
		roleid=login.isExistUser(userName,password );
		request.getSession().setAttribute("roleid", roleid);
		System.out.println(roleid);
		if(roleid!=0){
				try {
				request.getSession().setAttribute("myUserName", userName);
				request.getSession().setAttribute("myPassWord", password);
					Power(request ,response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		 }else{
			//错误提示
			 System.out.println(">>>>>>>>>..");
			 String jds = "{\"f\":\"用户名或密码错误\"}"; 
			 out.write(jds);
		}
	  }else{
		  String js = "{\"b\":\"输入验证码错误\"}";
		  out.write(js);
	  }
	  
  }
	
  /**
   * 异步显示子菜单
   */
  protected void showSubMenu(HttpServletRequest request,HttpServletResponse response){
	  JSONArray json;
	  if(login==null){
			 login=new LoginImpl();
		 }
	  String name=(String) request.getSession().getAttribute("myUserName");
	 List list= login.showSubMenu(name,
			 (String)request.getSession().getAttribute("myPassWord"), 
			  Integer.valueOf((String)request.getParameter("myActionId")),
			  (Integer)request.getSession().getAttribute("roleid"));
	  json = new JSONArray().fromObject(list);
	  System.out.println(json.toString());
	  response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
  }
}
