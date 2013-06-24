package com.cn.serviceimpl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import com.cn.dao.LoginDao;
import com.cn.daoimpl.LoginDaoImpl;
import com.cn.service.Login;
import com.cn.util.DbUtil;

public class LoginImpl implements Login {
 private LoginDao login;
 private Connection conn;
 /**
  * Ȩ���ж�
  */
	@SuppressWarnings("rawtypes")
	@Override
	public Map login(String name, String password) {
		if(login==null){
			login=new LoginDaoImpl();
		}
		if(conn==null){
			conn=DbUtil.getconn();
		}
		Map map=login.Login(name, password, conn);
		return map;
	}
	
	/**
	 * ��¼�ж��Ƿ����
	 */
	@Override
	public int isExistUser(String username, String userPassword) {
		if(login==null){
			login=new LoginDaoImpl();
		}
		if(conn==null){
			conn=DbUtil.getconn();
		}
		return login.isExistUser(username, userPassword, conn);
	}

	/**
	 * ��ʾ�Ӳ˵�
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List showSubMenu(String userName, String passWord, int myActionId,
			int roleId) {
		if(login==null){
			login=new LoginDaoImpl();
		}
		if(conn==null){
			conn=DbUtil.getconn();
		}
		return login.showSubMenu(userName, passWord, myActionId, roleId, conn);
	}


}
