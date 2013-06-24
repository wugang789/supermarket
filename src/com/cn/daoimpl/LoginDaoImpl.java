package com.cn.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.dao.LoginDao;
public class LoginDaoImpl implements LoginDao {

	/**
	 * 登录判断
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map Login(String name, String password,Connection conn) {
		String SQL="SELECT DISTINCT(power.actionId),power.actionName"+
       "   from myuser,role,rolepower,power,userrole,actionpower"+
        "   where  myuser.name=?"+
         "       and myuser.pssword=?"+
           "     and userrole.id=myuser.id"+
           "     and userrole.roleid=role.roleid"+
           "     and role.roleid=rolepower.roleid"+
            "    and rolepower.actionId=power.actionId";
		Map map=null;
		try {
			 java.sql.PreparedStatement ps=conn.prepareStatement(SQL);
			 ps.setString(1,name);
			 ps.setString(2, password);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()){
				 if(map==null){
					 map=new HashMap();
				 }
				 map.put(rs.getInt("actionId"),rs.getString("actionName"));
			 }
		} catch (Exception e) {
		  e.printStackTrace();
		}
		System.out.println(map);
  		return map;
	}
/**
 * 判断用户是否存在
 */
	@Override
	public int isExistUser(String username, String userPassword,Connection conn) {
		String SQL="select role.roleid from myuser,role,userrole"+
             "  where myuser.name=?"+
             "   and myuser.pssword=?"+
              "  and myuser.id=userrole.id"+
              "  and userrole.roleid=role.roleid";
		ResultSet rs=null;
		int a=0;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			 ps.setString(1,username);
			 ps.setString(2, userPassword);
			 rs=ps.executeQuery();
			while(rs.next()){
			a=rs.getInt(1);
			System.out.println(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return a;
	}
	
	/**
	 * 显示子菜单
	 */
@SuppressWarnings("rawtypes")
@Override
      public List showSubMenu(String userName, String passWord, int myActionId,
		int roleId, Connection conn) {
	List<String> list = null;
	String SQL="SELECT DISTINCT(actionpower.actionColumName)"+
       "     from myuser,role,rolepower,power,userrole,actionpower"+
            "    where  myuser.name=?"+
             "   and myuser.pssword=?"+
            "    and userrole.id=myuser.id"+
             "   and userrole.roleid=role.roleid"+
           "     and role.roleid=rolepower.roleid"+
           "     and rolepower.actionId=power.actionId"+
           "     and actionpower.myActionId=?"+
           "     and actionpower.myRoleId=?";
	System.out.println(SQL);
	ResultSet rs=null;
	try {
		PreparedStatement ps=conn.prepareStatement(SQL);
		 ps.setString(1,userName);
		 ps.setString(2, passWord);
		 ps.setInt(3, myActionId);
		 ps.setInt(4, roleId);
		 rs=ps.executeQuery();
		while(rs.next()){
			if(list==null){
				list=new ArrayList<String>();
			}
		 list.add(rs.getString("actionColumName"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return list;
}
}
