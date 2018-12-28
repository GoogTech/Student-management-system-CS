package com.YUbuntu.view.function;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import com.YUbuntu.model.Table_Class;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view.function
 * @Description Abstract the system function to the interface.
 * @Author #YUbuntu
 * @Date Dec 28, 2018-6:33:09 PM
 * @version 1.0
 */
public interface ClassList_JFrame_function
{
	/**
	 * 
	 * @Title Function
	 * @Description Delete the specified class.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-6:35:53 PM
	 * @throws ..
	 *
	 */
	void Function_ConfirmDelete(ActionEvent e);
	
	/**
	 * 
	 * @Title Function
	 * @Description Modify the specified class information.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-6:37:14 PM
	 * @throws ..
	 *
	 */
	void Function_ConfirmChange(ActionEvent e);
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Adds the selected class information to the pointing location.
	 * @param Mouse clicked
	 * @return void
	 * @date Dec 28, 2018-6:38:47 PM
	 * @throws ..
	 *
	 */
	void Initialize_SelectClassTableRow(MouseEvent e);
	
	/**
	 * 
	 * @Title Function
	 * @Description Initializes the informaiton in the class table.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-6:39:53 PM
	 * @throws ..
	 *
	 */
	void Function_InitializeClassTable(Table_Class table_Class);
	
	/**
	 * 
	 * @Title Function
	 * @Description Reset the information.
	 * @param no
	 * @return void
	 * @date Dec 28, 2018-6:40:43 PM
	 * @throws ..
	 *
	 */
	void Function_ClearData();
	
}
