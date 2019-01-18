package com.YUbuntu.dao;

import java.util.List;

import com.YUbuntu.model.Table_ChoosedCourse;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.dao
 * @Description The function of course selection.
 * @Author HuangYuhui
 * @Date Jan 18, 201-93:49:58 PM
 * @version 2.0
 */
public interface ChooseCourse_Dao
{
	
	/**
	 *
	 * @Title Select 
	 * @Description Get the information about course selection.
	 * @param Table_ChoosedCourse
	 * @return List<Table_SelectCourse>
	 * @date Jan 18, 20194:01:17 PM
	 *
	 */
	List<Table_ChoosedCourse> getChoosedCourseList(Table_ChoosedCourse table_SelectCourse);
}
