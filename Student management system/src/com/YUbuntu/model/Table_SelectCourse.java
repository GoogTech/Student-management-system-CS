package com.YUbuntu.model;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.model
 * @Description Course selection information sheet.
 * @Author HuangYuhui
 * @Date Jan 17, 2019-2:33:44 PM
 * @version 2.0
 */
public class Table_SelectCourse
{
	private int SelectCourse_ID;
	private String Student_ID;
	private String Student_Name;
	private String Teacher_ID;
	private String Teacher_Name;
	private String Course_ID;
	private String Course_Name;
	private String Course_Introduction;
	
	public int getSelectCourse_ID()
	{
		return SelectCourse_ID;
	}
	public void setSelectCourse_ID(int selectCourse_ID)
	{
		SelectCourse_ID = selectCourse_ID;
	}
	public String getStudent_ID()
	{
		return Student_ID;
	}
	public void setStudent_ID(String student_ID)
	{
		Student_ID = student_ID;
	}
	public String getStudent_Name()
	{
		return Student_Name;
	}
	public void setStudent_Name(String student_Name)
	{
		Student_Name = student_Name;
	}
	public String getTeacher_ID()
	{
		return Teacher_ID;
	}
	public void setTeacher_ID(String teacher_ID)
	{
		Teacher_ID = teacher_ID;
	}
	public String getTeacher_Name()
	{
		return Teacher_Name;
	}
	public void setTeacher_Name(String teacher_Name)
	{
		Teacher_Name = teacher_Name;
	}
	public String getCourse_ID()
	{
		return Course_ID;
	}
	public void setCourse_ID(String course_ID)
	{
		Course_ID = course_ID;
	}
	public String getCourse_Name()
	{
		return Course_Name;
	}
	public void setCourse_Name(String course_Name)
	{
		Course_Name = course_Name;
	}
	public String getCourse_Introduction()
	{
		return Course_Introduction;
	}
	public void setCourse_Introduction(String course_Introduction)
	{
		Course_Introduction = course_Introduction;
	}

}
