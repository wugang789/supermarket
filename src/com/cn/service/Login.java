package com.cn.service;

import java.util.List;
import java.util.Map;

public interface Login {
/**
 * �û���¼Ȩ��
 */
	@SuppressWarnings("rawtypes")
	public Map login(String name,String password);
	
	/**
	 * ��¼�ж��Ƿ����
	 */
	public int isExistUser(String username,String userPassword);
	
	/**
	 *  ��ʾ�Ӳ˵�
	 */
	public List showSubMenu(String userName,String passWord,int myActionId,int roleId);
}
