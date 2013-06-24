package com.cn.service;

import java.util.List;
import java.util.Map;

public interface Login {
/**
 * 用户登录权限
 */
	@SuppressWarnings("rawtypes")
	public Map login(String name,String password);
	
	/**
	 * 登录判断是否存在
	 */
	public int isExistUser(String username,String userPassword);
	
	/**
	 *  显示子菜单
	 */
	public List showSubMenu(String userName,String passWord,int myActionId,int roleId);
}
