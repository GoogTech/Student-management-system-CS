package com.YUbuntu.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import com.YUbuntu.dao.impl.Course_DaoImpl;
import com.YUbuntu.model.Table_Course;
import com.YUbuntu.model.Table_Teacher;
import com.YUbuntu.util.StringUtil;
import com.YUbuntu.view.function.AddCourse_JFrame_function;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description The interface of adding new course information.
 * @Author #YUbuntu
 * @Date Dec 29, 2018-2:36:13 PM
 * @version 2.0
 */
public class AddCourse_JFrame extends JInternalFrame implements AddCourse_JFrame_function
{
	private JComboBox<Table_Teacher> TeacherNameList_ComboBox;
	private JTextArea CourseIntroduce_TextArea;
	
	private JTextField CourseID_TextField;
	private JTextField CourseName_TextField;
	private JTextField StudentMaxNumber_TextField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AddCourse_JFrame frame = new AddCourse_JFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}*/
	

	/**
	 * Create the frame.
	 */
	public AddCourse_JFrame()
	{
		/*
		 * Improve the function of the interface (You can close it, you can icon it)
		 */
		setClosable(true);
		setIconifiable(true);
		
		setBounds(100, 100, 412, 472);	
		JLabel lblCourseId = new JLabel("Course ID");
		lblCourseId.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		CourseID_TextField = new JTextField();
		CourseID_TextField.setColumns(10);
		
		JLabel lblCourseName = new JLabel("Course name");
		lblCourseName.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		CourseName_TextField = new JTextField();
		CourseName_TextField.setColumns(10);
		
		JLabel lblTeacher = new JLabel("Teacher name");
		lblTeacher.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		TeacherNameList_ComboBox = new JComboBox();
		
		JLabel lblStudentCount = new JLabel("The number of students");
		lblStudentCount.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		StudentMaxNumber_TextField = new JTextField();
		StudentMaxNumber_TextField.setColumns(10);
		
		JLabel lblCourseInterview = new JLabel("Course introduction");
		lblCourseInterview.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		CourseIntroduce_TextArea = new JTextArea();
		CourseIntroduce_TextArea.setBackground(UIManager.getColor("ToolTip.background"));
		CourseIntroduce_TextArea.setLineWrap(true);
		
		JButton ConfirmAddCourse_JButton = new JButton("Confirm");
		ConfirmAddCourse_JButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_ConfirmAddCourse(e);
			}
		});
		ConfirmAddCourse_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JButton ResetInformation_JButton = new JButton("Reset");
		ResetInformation_JButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_ResetInformation(e);
			}
		});
		ResetInformation_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(135)
					.addComponent(StudentMaxNumber_TextField, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
					.addGap(187))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(114)
					.addComponent(lblCourseInterview)
					.addContainerGap(149, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(102)
					.addComponent(lblStudentCount)
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(CourseIntroduce_TextArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(ConfirmAddCourse_JButton)
							.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
							.addComponent(ResetInformation_JButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCourseName)
								.addComponent(lblCourseId)
								.addComponent(lblTeacher))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(TeacherNameList_ComboBox, 0, 129, Short.MAX_VALUE)
								.addComponent(CourseID_TextField, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
								.addComponent(CourseName_TextField, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))))
					.addGap(106))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourseId)
						.addComponent(CourseID_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourseName)
						.addComponent(CourseName_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTeacher)
						.addComponent(TeacherNameList_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(lblStudentCount)
					.addGap(18)
					.addComponent(StudentMaxNumber_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblCourseInterview)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CourseIntroduce_TextArea, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfirmAddCourse_JButton)
						.addComponent(ResetInformation_JButton))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		/*
		 * Initializes the teacher name and displays it in the 'TeacherNameList_ComboBox'
		 */
		Initialize_InitializeTeacherName();

	}

	/**
	 * 
	 * @Title Function
	 * @Description Add a new course into  database.
	 * @param Performed action.
	 * @return void
	 * @date Dec 29, 2018-4:05:21 PM
	 * @throws no
	 *
	 */
	public void Function_ConfirmAddCourse(ActionEvent e)
	{
		String courseID = CourseID_TextField.getText();
		String courseName = CourseName_TextField.getText();
		int studentMaxNumber = 0;
		String courseIntroduce = CourseIntroduce_TextArea.getText();
		
		//Give the tip when error data inputed by the user.
		try
		{
			studentMaxNumber = Integer.parseInt(StudentMaxNumber_TextField.getText());		
			if(studentMaxNumber<0||studentMaxNumber>150)
			{
				JOptionPane.showMessageDialog(this, "The range is : 0 < student <= 150", "warning",JOptionPane.WARNING_MESSAGE );
			}
		} catch (NumberFormatException e_)
		{
			JOptionPane.showMessageDialog(this, "Please enter the number !","warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if(StringUtil.IsEmpty(courseID))
		{
			JOptionPane.showMessageDialog(this, "Please enter the course ID !","warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(StringUtil.IsEmpty(courseName))
		{
			JOptionPane.showMessageDialog(this, "Please enter the course name !","warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(StringUtil.IsEmpty(courseIntroduce))
		{
			JOptionPane.showMessageDialog(this, "Please enter the introduction of student !","warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		/*
		 * Stores the teacher information. Including : teacher ID and name.
		 * For details, please refer to : List<Table_Teacher> com.YUbuntu.dao.impl.Course_DaoImpl.getTeacherName()
		 */
		Table_Teacher table_Teacher = (Table_Teacher) TeacherNameList_ComboBox.getSelectedItem();		
		Table_Course table_Course = new Table_Course();
		
		/*------------------------------------------------------------------------------
		 * Get the teacher ID and name based on the teacher name selected by the user. |
		 *------------------------------------------------------------------------------
		 */
		table_Course.setTeacher_ID(table_Teacher.getTeacher_id());
		table_Course.setTeacher_name(table_Teacher.getTeacher_name());
		
		table_Course.setCourse_ID(courseID);
		table_Course.setCourse_name(courseName);
		table_Course.setCourse_MaxStudentNumber(studentMaxNumber);
		table_Course.setCourse_Introduction(courseIntroduce);
		
		//Stores the student information.
		Course_DaoImpl course_DaoImpl = new Course_DaoImpl();
		if(course_DaoImpl.addCourse(table_Course))
		{
			JOptionPane.showMessageDialog(this,"Success to add course !","warning",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Fail to add course !","warning",JOptionPane.WARNING_MESSAGE);
		}
		Function_ResetInformation(e);
	}
	

	
	/**
	 * 
	 * @Title Function
	 * @Description Reset the information entered by the user.
	 * @param Performed action
	 * @return void
	 * @date Dec 29, 2018-3:59:58 PM
	 * @throws ..
	 *
	 */
	public void Function_ResetInformation(ActionEvent e)
	{
		CourseID_TextField.setText("");
		CourseName_TextField.setText("");
		TeacherNameList_ComboBox.setSelectedIndex(0);
		StudentMaxNumber_TextField.setText("");
		CourseIntroduce_TextArea.setText("");
	}
	
	/**
	 * 
	 * @Title Initialze
	 * @Description Get teacher name.
	 * @param no
	 * @return void
	 * @date Dec 29, 2018-8:14:24 PM
	 * @throws no
	 *
	 */
	public void Initialize_InitializeTeacherName()
	{
		Course_DaoImpl course_DaoImpl = new Course_DaoImpl();
		List<Table_Teacher> list = course_DaoImpl.getTeacherName();
		
		for (Table_Teacher table_Teacher : list)
		{
			TeacherNameList_ComboBox.addItem(table_Teacher);
		}
	}	
}
