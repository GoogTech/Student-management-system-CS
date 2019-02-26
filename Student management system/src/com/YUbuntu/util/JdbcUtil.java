package com.YUbuntu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.util
 * @Description Tools for connecting MySQL database.
 * @Author #YUbuntu
 * @Date Dec 28, 2018-3:49:03 PM
 * @version 2.1
 */

/*
 * Extends JFrame : In order to use the dialog box to prompt the user !
 */
public class JdbcUtil extends JFrame
{
	
	private static final long serialVersionUID = 7998300586272280215L;
	
	private static String URL = DatabaseConfig.mailConfigInfo.getUrl();
	private static String USER = DatabaseConfig.mailConfigInfo.getUserName();
	private static String PASSWORD = DatabaseConfig.mailConfigInfo.getUserPassword();
	private static String DRIVER_NAME = DatabaseConfig.mailConfigInfo.getDriverName();

	/*
	 * Ensure that the registered driver code is only executed once.
	 */
	static
	{
		try
		{
			Class.forName(DRIVER_NAME);
		} catch (Exception e)
		{
			System.err.println("ERROR : Fail to Initialize the driver of MySQL ~\n");
			throw new ExceptionInInitializerError(e);
		}
	}

	/*
	 * Return a database connection object
	 */
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
			// Terminates the currently running Java Virtual Machine.
			System.exit(0);
		}
		return connection;
	}

	/**
	 * @Title release
	 * @Description Frees database connection resources.
	 * @return void
	 * @date Feb 26, 2019-6:22:51 PM
	 *
	 */
	public static void freeResource(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection)
	{
		if (resultSet != null)
		{
			try
			{
				resultSet.close();
			} catch (Exception e)
			{
				System.err.println("ERROR : Fail to close the resultSet of MySQL ~\n");
			}
			resultSet = null;
		}
		if (preparedStatement != null)
		{
			try
			{
				preparedStatement.close();
			} catch (Exception e2)
			{
				System.err.println("ERROR : Fail to close the statement of MySQL ~\n");
			}
			preparedStatement = null;
		}
		if (connection != null)
		{
			try
			{
				connection.close();
			} catch (SQLException e3)
			{
				System.err.println("ERROR : Fail to close the connection of MySQL ~\n");
			}
			connection = null;
		}
	}
}
