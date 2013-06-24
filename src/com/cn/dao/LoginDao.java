package com.cn.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface LoginDao {
	
	/**
	 * 用户登录权限
	 */
@SuppressWarnings("rawtypes")
public Map Login(String name,String password,Connection conn);

/**
 * 判断用户是否存在
 */
public int isExistUser(String username, String userPassword,Connection conn);

/**
 *  显示子菜单
 */
public List showSubMenu(String userName,String passWord,int myActionId,int roleId,Connection conn);
}
