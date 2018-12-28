package com.YUbuntu.view.function;

import java.awt.event.ActionEvent;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view.function
 * @Description Abstracts system functions into interfaces.
 * @Author #YUbuntu
 * @Date Dec 28, 2018-3:20:06 PM
 * @version 1.0
 */
public interface Login_JFrame_function
{
	/**
	 * 
	 * @Title Login
	 * @Description Check user information from the database.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-3:20:35 PM
	 * @throws 1.0
	 *
	 */
	void LoginEvent(ActionEvent e);
	
	/**
	 * 
	 * @Title Reset
	 * @Description Reset the informaiton entered by the user.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-3:25:49 PM
	 * @throws 1.0
	 *
	 */
	void Function_ResetInformation(ActionEvent e);	
}
