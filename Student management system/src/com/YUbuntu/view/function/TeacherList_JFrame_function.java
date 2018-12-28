package com.YUbuntu.view.function;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import com.YUbuntu.model.Table_Teacher;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view.function
 * @Description Abstract the system function to the interface.
 * @Author #YUbuntu
 * @Date Dec 28, 2018-6:42:55 PM
 * @version 1.0
 */
public interface TeacherList_JFrame_function
{
	/**
	 * 
	 * @Title Function
	 * @Description Search the specified teacher information.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-6:46:01 PM
	 * @throws ..
	 *
	 */
	void Function_SearchTeacher(ActionEvent e);
	
	/**
	 * 
	 * @Title Function
	 * @Description Modify the specified teacher information.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-6:47:06 PM
	 * @throws ..
	 *
	 */
	void Function_ModifyTeacherInformation(ActionEvent e);
	
	/**
	 * 
	 * @Title Function
	 * @Description Delete the specified teacher.
	 * @param Performed action
	 * @return void
	 * @date Dec 28, 2018-6:48:16 PM
	 * @throws ..
	 *
	 */
	void Function_DeleteTeacher(ActionEvent e);
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Adds the selected student information to the pointing location.
	 * @param Mouse clicked
	 * @return void
	 * @date Dec 28, 2018-6:49:21 PM
	 * @throws ..
	 *
	 */
	void Initialize_SelectTeacherTableRow(MouseEvent e);
	
	/**
	 * 
	 * @Title Function
	 * @Description Initializes the information in the teacher table.
	 * @param no
	 * @return void
	 * @date Dec 28, 2018-6:50:21 PM
	 * @throws ..
	 *
	 */
	void Function_InitializedTeacherTable(Table_Teacher table_Teacher);
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Get the class name.
	 * @param no
	 * @return void
	 * @date Dec 28, 2018-6:51:09 PM
	 * @throws ..
	 *
	 */
	void Initialize_InitializeClassName();
	
	/**
	 * 
	 * @Title Initialize 
	 * @Description Set user permissions.
	 * @param no
	 * @return void
	 * @date Dec 28, 2018-6:53:07 PM
	 * @throws ..
	 *
	 */
	void Initialize_SetUserPermissions();
}
