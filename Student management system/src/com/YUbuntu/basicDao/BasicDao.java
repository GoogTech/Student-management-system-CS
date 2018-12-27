package com.YUbuntu.basicDao;

import java.sql.Connection;

import com.YUbuntu.util.JDBCUtil;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description Create a database connection object that is used by the entire project to interact with the database.
 * @Author #YUbuntu
 * @Date November 30,2018
 * @version 1.0
 */
public class BasicDao
{
	public Connection connection = new JDBCUtil().getConnection();

	/*
	 * Every object that operates on the database is used :
	 * JDBCUtil.freeResource(null, preparedStatement, connection);
	 */

	// Frees database connection resources
//	 public void Close_BasicDao()
//	 {
//		 if(connection!=null)
//		 {
//			 try {
//				 	connection.close();
//			 	 } catch (SQLException e) {
//			 		 System.err.println("ERROR : Failed to close database connection !\n");
//			 		 e.printStackTrace();
//			 	 }
//			 connection = null;
//		 }
//	 }
}
