package com.cn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbUtil {
	public static Connection getconn() {
		// 数据库驱动
		String drivername = "com.mysql.jdbc.Driver";
		// 数据库用户名
		String username = "root";
		// 密码
		String password = "";
		// 数据库名
		// String dbName="mycity";
		// 定义数据库连接对象connection
		Connection conn = null;
		// 定义url设置数据库连接时编码
		String url = "jdbc:mysql://localhost:3306/suptermarket?useUnicode=true&characterEncoding=utf-8";
		try {
			// 加载驱动
			Class.forName(drivername);
			System.out.println("开始连接.......");
			conn = DriverManager.getConnection(url, username, password);// 获取连接
			System.out.println("连接成功。。。。");

		} catch (Exception e) {
			System.out.println("连接不成功！");
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		try {
			Statement st = DbUtil.getconn().createStatement();
			System.out.println("测试结束");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
