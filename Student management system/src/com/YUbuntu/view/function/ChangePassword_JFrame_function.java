package com.YUbuntu.view.function;

import java.awt.event.ActionEvent;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view.function
 * @Description Abstract the system function into the interface. 
 * @Author #YUbuntu
 * @Date Dec 28, 2018-4:26:17 PM
 * @version 1.0
 */
public interface ChangePassword_JFrame_function
{
	/**
	 * 
	 * @Title Function
	 * @Description Displays the user information of the current login.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-4:48:34 PM
	 * @throws ..
	 *
	 */
	void Function_DisplayUserInformation();
	
	/**
	 * 
	 * @Title Function
	 * @Description Modify the user password.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-4:50:01 PM
	 * @throws ..
	 *
	 */
	void Confirm_ChangePassword(ActionEvent e);
	
	/**
	 * 
	 * @Title Function
	 * @Description Reset the information entered by the user.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-4:52:19 PM
	 * @throws ..
	 *
	 */
	void Reset_Information(ActionEvent e);
}
