package com.cn.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface LoginDao {
	
	/**
	 * �û���¼Ȩ��
	 */
@SuppressWarnings("rawtypes")
public Map Login(String name,String password,Connection conn);

/**
 * �ж��û��Ƿ����
 */
public int isExistUser(String username, String userPassword,Connection conn);

/**
 *  ��ʾ�Ӳ˵�
 */
public List showSubMenu(String userName,String passWord,int myActionId,int roleId,Connection conn);
}
