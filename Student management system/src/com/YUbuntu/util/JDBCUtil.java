package com.YUbuntu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Tools for connecting MySQL databaseL ¡ª¡ª 18/11/30
 * @author #YUbuntu
 * @version 1.0
 *
 */
/*
 * Extends JFrame : In order to use the dialog box to prompt the user !
 */
public class JDBCUtil extends JFrame
{
	private static String URL = "jdbc:mysql://**********/**********?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static String USER = "**********";
	private static String PASSWORD = "**********";
	private static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	//public JDBCUtil() {}
	
	//########## Ensure that the registered driver code is only executed once ##########
	static 
	{
		try {
				Class.forName(DRIVER_NAME);
			} catch (Exception e) {
				System.err.println("ERROR : Fail to Initialize the driver of MySQL ~\n");
				throw new ExceptionInInitializerError(e);
			}
	}
	
	// ########## Return a database connection object ##########
	public Connection getConnection()
	{
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(this, "Not connect to Database server !", "Connection error",
					JOptionPane.WARNING_MESSAGE);
			/*---------------------------------------------------------
			 * Terminates the currently running Java Virtual Machine. |
			 *---------------------------------------------------------
			 */
			System.exit(0);
		}
		return connection;
	}
	
	
	/* --------------------------------------
	 *  Frees database connection resources |
	 * --------------------------------------
	 */
	public static void freeResource(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection)
	{
		if(resultSet!=null)
		{
			try {
				resultSet.close();
			    } catch (Exception e) {
				System.err.println("ERROR : Fail to close the resultSet of MySQL ~\n");
			    }
			resultSet = null;
		}
		if(preparedStatement!=null)
		{
			try {		
				preparedStatement.close();
			    } catch (Exception e2) {
				System.err.println("ERROR : Fail to close the statement of MySQL ~\n");
			    }
			preparedStatement = null;			
		}
		if(connection!=null)
		{
			try{
				connection.close();	
			   } catch (SQLException e3) {
				System.err.println("ERROR : Fail to close the connection of MySQL ~\n");
			   }
			connection = null;
		}
	}		
}
