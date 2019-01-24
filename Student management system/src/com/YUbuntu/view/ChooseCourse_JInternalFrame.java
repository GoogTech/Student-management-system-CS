package com.YUbuntu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.YUbuntu.dao.impl.ChooseCourse_DaoImpl;
import com.YUbuntu.dao.impl.Class_DaoImpl;
import com.YUbuntu.dao.impl.Course_DaoImpl;
import com.YUbuntu.dao.impl.Student_DaoImpl;
import com.YUbuntu.dao.impl.Teacher_DaoImpl;
import com.YUbuntu.model.Table_ChoosedCourse;
import com.YUbuntu.model.Table_Class;
import com.YUbuntu.model.Table_Course;
import com.YUbuntu.model.Table_Student;
import com.YUbuntu.model.Table_Teacher;
import com.YUbuntu.view.function.ChooseCourse_JF_function;


/**
 *
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description Course selection interface.
 * @Author HuangYuhui
 * @Date Jan 17, 2019-3:07:35 PM
 * @version 2.0
 */
public class ChooseCourse_JInternalFrame extends JInternalFrame implements ChooseCourse_JF_function
{
	private JComboBox<Table_Class> ClassName_JComboBox;
	private JComboBox<Table_Student> StudentName_JComboBox;
	private JComboBox<Table_Course> CourseName_JComboBox ;
	private JTable CourseInformation_JTable;
	private JComboBox<Table_Class> ModifyClassName_JComboBox;
	private JComboBox<Table_Teacher> ModifyTeacherName_JComboBox;
	private JComboBox<Table_Student> ModifyStudentName_JComboBox;
	private JComboBox<Table_Course> ModifyCourseName_JComboBox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ChooseCourse_JInternalFrame frame = new ChooseCourse_JInternalFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChooseCourse_JInternalFrame()
	{
		/* 
		 * Improve the function of the interface (You can close it, you can icon it) ~
		 */
		setClosable(true);
		setIconifiable(true);
		
		setTitle("Choose course interface");
		setBounds(100, 100, 1020, 558);
		
		JLabel lblStudentName = new JLabel("Student name");
		lblStudentName.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		StudentName_JComboBox = new JComboBox<Table_Student>();
		
		JLabel lblCourseName = new JLabel("Course name");
		lblCourseName.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		CourseName_JComboBox = new JComboBox<Table_Course>();
		
		JButton ConfirmChooseCourse_JButton = new JButton("Confirm choose");
		ConfirmChooseCourse_JButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_ChooseCourse(e);
			}
		});
		ConfirmChooseCourse_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Modify the course selection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel = new JLabel("Class name");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		ClassName_JComboBox = new JComboBox<Table_Class>();
		
		/*
		 * Attention : 
		 * Invoked when an item has been selected or deselected by the user.
		 * The code written for this method performs the operationsthat need to occur when an item is selected (or deselected).
		 */
		ClassName_JComboBox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				Initialize_DisplayStudentName(e);
			}
		});
		

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ClassName_JComboBox, 0, 143, Short.MAX_VALUE)
							.addGap(28)
							.addComponent(lblStudentName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(StudentName_JComboBox, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblCourseName)
							.addGap(29)
							.addComponent(CourseName_JComboBox, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(ConfirmChooseCourse_JButton))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE))
					.addContainerGap(32, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfirmChooseCourse_JButton)
						.addComponent(CourseName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(ClassName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCourseName)
						.addComponent(StudentName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStudentName))
					.addGap(47)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		JLabel lblStudentName_1 = new JLabel("Student name");
		lblStudentName_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		ModifyStudentName_JComboBox = new JComboBox<Table_Student>();
		
		JLabel lblCourseName_1 = new JLabel("Course name");
		lblCourseName_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		ModifyCourseName_JComboBox = new JComboBox<Table_Course>();
		
		JButton ConfirmModifyCourse_JButton = new JButton("Confirm modify");
		ConfirmModifyCourse_JButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_ModifyCourseSelectionInfo(e);
			}
		});
		ConfirmModifyCourse_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JButton ConfirmExitCourse_JButton = new JButton("Exit course");
		ConfirmExitCourse_JButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Function_ExitCourse(e);
			}
		});
		ConfirmExitCourse_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JLabel lblClassName = new JLabel("Teacher name");
		lblClassName.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		ModifyTeacherName_JComboBox = new JComboBox<Table_Teacher>();
		
		JLabel lblClassName_1 = new JLabel("Class name");
		lblClassName_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		ModifyClassName_JComboBox = new JComboBox<Table_Class>();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStudentName_1)
						.addComponent(lblClassName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ModifyTeacherName_JComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ModifyStudentName_JComboBox, 0, 201, Short.MAX_VALUE))
					.addGap(48)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCourseName_1)
						.addComponent(lblClassName_1))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ModifyClassName_JComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ModifyCourseName_JComboBox, 0, 180, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ConfirmExitCourse_JButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ConfirmModifyCourse_JButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(22))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfirmModifyCourse_JButton)
						.addComponent(lblClassName)
						.addComponent(ModifyTeacherName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCourseName_1)
						.addComponent(ModifyCourseName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfirmExitCourse_JButton)
						.addComponent(lblStudentName_1)
						.addComponent(ModifyStudentName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblClassName_1)
						.addComponent(ModifyClassName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		CourseInformation_JTable = new JTable();
		CourseInformation_JTable.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Initialize_ClickCourseTableRow(e);
			}
		});
		CourseInformation_JTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Serial number", "Class name", "Student ID", "Student name", "Teacher ID", "Teacher name", "Course ID", "Course name", "Head count", "Remaining", "Course introduce"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		CourseInformation_JTable.getColumnModel().getColumn(0).setPreferredWidth(109);
		CourseInformation_JTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		CourseInformation_JTable.getColumnModel().getColumn(2).setPreferredWidth(84);
		CourseInformation_JTable.getColumnModel().getColumn(3).setPreferredWidth(101);
		CourseInformation_JTable.getColumnModel().getColumn(4).setPreferredWidth(89);
		CourseInformation_JTable.getColumnModel().getColumn(5).setPreferredWidth(104);
		CourseInformation_JTable.getColumnModel().getColumn(6).setPreferredWidth(82);
		CourseInformation_JTable.getColumnModel().getColumn(7).setPreferredWidth(107);
		CourseInformation_JTable.getColumnModel().getColumn(8).setPreferredWidth(78);
		CourseInformation_JTable.getColumnModel().getColumn(10).setPreferredWidth(158);
		scrollPane.setViewportView(CourseInformation_JTable);
		getContentPane().setLayout(groupLayout);
		
		/*
		 * Initialize the class,teacher,student and course name in the JComboBox.
		 */
		Initialize_InitializeClassName();
		Initialize_InitializeTeacherName();
		Initialize_InitializeStudentName();
		Initialize_InitializeCourseName();
		
		/*
		 * Initizlize the table of course selection.
		 */
		Initialize_ChoosedCourseInfoTable(new Table_ChoosedCourse());
	}
	
	
	/**
	 * @Title Initialize
	 * @Description Get the data which click the specified row in the table.
	 * @param MouseEvent e
	 * @return void
	 * @date Jan 21, 2019-5:47:33 PM
	 *
	 */
	public void Initialize_ClickCourseTableRow(MouseEvent e)
	{
		/*
		 * Get the model object for the table.
		 */
		DefaultTableModel defaultTableModel = (DefaultTableModel) CourseInformation_JTable.getModel();
															
		/*
		 * Initialize the class,student,teacher and course name in the JComboBox.
		 */
		String className = (String) defaultTableModel.getValueAt(CourseInformation_JTable.getSelectedRow(), 1);
		String studentName = (String) defaultTableModel.getValueAt(CourseInformation_JTable.getSelectedRow(), 3);
		String teacherName = (String) defaultTableModel.getValueAt(CourseInformation_JTable.getSelectedRow(), 5);
		String courseName = (String) defaultTableModel.getValueAt(CourseInformation_JTable.getSelectedRow(), 7);
		for (int i = 0; i < ModifyClassName_JComboBox.getItemCount(); i++)
		{
			Table_Class table_Class = (Table_Class) ModifyClassName_JComboBox.getItemAt(i);
			if (table_Class.get_CLASS_NAME().equals(className))
			{
				ModifyClassName_JComboBox.setSelectedItem(i);
				break;
			}
		}
		for (int i = 0; i < ModifyStudentName_JComboBox.getItemCount(); i++)
		{
			Table_Student table_Student = (Table_Student) ModifyStudentName_JComboBox.getItemAt(i);
			if (table_Student.getStudent_name().equals(studentName))
			{
				ModifyStudentName_JComboBox.setSelectedIndex(i);
				break;
			}
		}
		for (int i = 0; i < ModifyTeacherName_JComboBox.getItemCount(); i++)
		{
			Table_Teacher table_Teacher = (Table_Teacher) ModifyTeacherName_JComboBox.getItemAt(i);
			if (table_Teacher.getTeacher_name().equals(teacherName))
			{
				ModifyTeacherName_JComboBox.setSelectedIndex(i);
				break;
			}
		}
		for (int i = 0; i < ModifyCourseName_JComboBox.getItemCount(); i++)
		{
			Table_Course table_Course = (Table_Course) ModifyCourseName_JComboBox.getItemAt(i);
			if (table_Course.getCourse_name().equals(courseName))
			{
				ModifyCourseName_JComboBox.setSelectedIndex(i);
				break;
			}
		}
	}
	
	

	/**
	 * @Title Function
	 * @Description Exit the specified the course.
	 * @param ActionEvent e
	 * @return void
	 * @date Jan 21, 2019-4:02:29 PM
	 *
	 */
	public void Function_ExitCourse(ActionEvent e)
	{
		/*
		 * First step : GetSelectRow : Returns the index of the first selected row, -1 if no row is selected.
		 */
		int Row_index = CourseInformation_JTable.getSelectedRow();
		if(Row_index==-1)
		{
			JOptionPane.showMessageDialog(this, "Please click on the specified course which you want to exit !", "Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}	

		/*
		 * Second step : Prompt the user to exit course information whether the operation is successful.
		 */
		if(JOptionPane.showConfirmDialog(this, "Are you sure to exit this course ?")==JOptionPane.YES_OPTION)//Sensitive operation prompt.
		{
			ChooseCourse_DaoImpl chooseCourse_DaoImpl = new ChooseCourse_DaoImpl();
			if(chooseCourse_DaoImpl.Exit_Course(CourseInformation_JTable.getValueAt(Row_index, 0).toString()))
			{
				/*
				 * The last step : Update the number of student in the specified course.
				 */
				boolean increase = false;
				//Get the course ID by the specified course name.
				String courseName = CourseInformation_JTable.getValueAt(Row_index, 1).toString();
				String courseID = chooseCourse_DaoImpl.getCourseID(courseName);
				if(chooseCourse_DaoImpl.updateCourseStudentNumber(courseID, increase))
				{
					JOptionPane.showMessageDialog(this, "Exit the course successfully !");		
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Fail to exit the course !");
				return;
			}
		}
		else
		{
			return;
		}
		/*
		 * The third step : Refresh the data in the information of course selection.
		 */
		Initialize_ChoosedCourseInfoTable(new Table_ChoosedCourse());
						
		/*
		 * The last step : Clears the data in the specified location.
		 */
		Function_ClearData();
	}
	
	
	
	/**
	 * @Title Initialize
	 * @Description Initialize the data in the specified position.
	 * @param empty
	 * @return void
	 * @date Jan 21, 2019-4:16:37 PM
	 *
	 */
	public void Function_ClearData()
	{
		ClassName_JComboBox.setSelectedIndex(0);
		CourseName_JComboBox.setSelectedIndex(0);
		ModifyTeacherName_JComboBox.setSelectedIndex(0);
		ModifyStudentName_JComboBox.setSelectedIndex(0);
		ModifyCourseName_JComboBox.setSelectedIndex(0);	
	}
	

	/**
	 * @Title Function
	 * @Description Modify the information about course selection.
	 * @param ActionEvent e
	 * @return void
	 * @date Jan 21, 2019-3:59:52 PM
	 *
	 */
	public void Function_ModifyCourseSelectionInfo(ActionEvent e)
	{
		
	}
	
	

	/**
	 * @Title Function
	 * @Description The function of course selection.
	 * @param ActionEvent e
	 * @return void
	 * @date Jan 18, 2019-8:02:12 PM
	 *
	 */
	public void Function_ChooseCourse(ActionEvent e)
	{
		ChooseCourse_DaoImpl chooseCourse_DaoImpl = new ChooseCourse_DaoImpl();
		Table_ChoosedCourse table_ChoosedCourse = new Table_ChoosedCourse();
		
		/*
		 * Get the specified class information by the class name.
		 */
		String className = ClassName_JComboBox.getSelectedItem().toString();
		String classID = chooseCourse_DaoImpl.getClassID(className);

		/*
		 * Get the specified student information by the student name.
		 */
		String studentName = StudentName_JComboBox.getSelectedItem().toString();
		String studentID = chooseCourse_DaoImpl.getStudentID(studentName);

		/*
		 * Get the all of course information by the course name.
		 */
		String courseName = CourseName_JComboBox.getSelectedItem().toString();
		Course_DaoImpl course_DaoImpl = new Course_DaoImpl();
		Table_Course table_Course = course_DaoImpl.getCourseInfo(courseName);
		
		/*
		 * Determine whether the number student is max or the course had been choosed.
		 */
		String courseID = table_Course.getCourse_ID();
		if (chooseCourse_DaoImpl.isCourseNumberMax(courseID))
		{
			if (chooseCourse_DaoImpl.isChoosedCourse(courseID, studentID))
			{
				/*
				 * Store the information about the course selection.
				 */
				table_ChoosedCourse.setClass_ID(classID);
				table_ChoosedCourse.setClass_name(className);
				table_ChoosedCourse.setStudent_ID(studentID);
				table_ChoosedCourse.setStudent_name(studentName);

				table_ChoosedCourse.setTeacher_ID(table_Course.getTeacher_ID());
				table_ChoosedCourse.setTeacher_name(table_Course.getTeacher_name());
				table_ChoosedCourse.setCourse_ID(table_Course.getCourse_ID());
				table_ChoosedCourse.setCourse_name(table_Course.getCourse_name());
				table_ChoosedCourse.setMaxStudentNumber(table_Course.getCourse_MaxStudentNumber());
				table_ChoosedCourse.setChoosedStudentNumber(table_Course.getSelected_StudentNumber());
				table_ChoosedCourse.setCourse_Introduction(table_Course.getCourse_Introduction());

				/*
				 * Determine whether the operation is successful.
				 */
				if (chooseCourse_DaoImpl.AddCourseSelectionInfo(table_ChoosedCourse))
				{
					//Update the number of student in the specified course.
					boolean increase = true;
					if(chooseCourse_DaoImpl.updateCourseStudentNumber(courseID,increase))
					{
						JOptionPane.showMessageDialog(this, "Success to add new course !");
						Initialize_ChoosedCourseInfoTable(new Table_ChoosedCourse());
					}
				} else
				{
					JOptionPane.showMessageDialog(this, "Sorry ! Fail to add new course !", "Error",JOptionPane.WARNING_MESSAGE);
					return;
				}
			} else
			{
				JOptionPane.showMessageDialog(this, "Sorry,The course you have been choosed !", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

		} else
		{
			JOptionPane.showMessageDialog(this, "Sorry,The number of student is Max !", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}

	}
	
	
	/**
	 * @Title Initialize
	 * @Description Initialize the informaton of course selection into the table.
	 * @param Table_ChoosedCourse
	 * @return void
	 * @date Jan 17, 2019-4:53:46 PM
	 *
	 */
	public void Initialize_ChoosedCourseInfoTable(Table_ChoosedCourse table_SelectCourse)
	{
		
		/*
		 * Gets the model object for the table and clear the list of table.
		 */
		DefaultTableModel defaultTableModel = (DefaultTableModel) CourseInformation_JTable.getModel();
		defaultTableModel.setRowCount(0);
		
		/*
		 * Get the information of course selection.
		 */
		ChooseCourse_DaoImpl chooseCourse_DaoImpl = new ChooseCourse_DaoImpl();
		List<Table_ChoosedCourse> list = chooseCourse_DaoImpl.getChoosedCourseList(table_SelectCourse);
		
		/*
		 * Write the obtained course information into the table of course selection.
		 */
		for (Table_ChoosedCourse table_ChoosedCourse : list)
		{
			Vector<Object> vector = new Vector<Object>();
			
			vector.add(table_ChoosedCourse.getChoosedCourse_ID());
			vector.add(table_ChoosedCourse.getClass_name());
			vector.add(table_ChoosedCourse.getStudent_ID());
			vector.add(table_ChoosedCourse.getStudent_name());
			vector.add(table_ChoosedCourse.getTeacher_ID());
			vector.add(table_ChoosedCourse.getTeacher_name());
			vector.add(table_ChoosedCourse.getCourse_ID());
			vector.add(table_ChoosedCourse.getCourse_name());
			vector.add(table_ChoosedCourse.getMaxStudentNumber());
			vector.add(table_ChoosedCourse.getChoosedStudentNumber());
			vector.add(table_ChoosedCourse.getCourse_Introduction());
		
			defaultTableModel.addRow(vector);
		}
	}
	
	
	/**
	 * @Title Initialize the student name by the class name.
	 * @Description Display the student name by the class name.
	 * @param ItemEvent e
	 * @return void
	 * @date Jan 18, 2019-6:40:51 PM
	 *
	 */
	public void Initialize_DisplayStudentName(ItemEvent e)
	{	
		
		/* clear the selection
		 * Attention : 
		 * Invoked when an item has been selected or deselected by the user.
		 * The code written for this method performs the operationsthat need to occur when an item is selected (or deselected).
		 */
		if (e.getStateChange() == ItemEvent.SELECTED)
		{
			//Clear the student item.
			StudentName_JComboBox.setSelectedItem(null);

			//Get the class name.
			String className = ClassName_JComboBox.getSelectedItem().toString();

			//Get the student name by the class name.
			Student_DaoImpl student_DaoImpl = new Student_DaoImpl();
			List<Table_Student> list_studentName = student_DaoImpl.getStudentName(className);

			for (Table_Student table_Student : list_studentName)
			{
				StudentName_JComboBox.addItem(table_Student);
				ModifyStudentName_JComboBox.addItem(table_Student);
			}
		}
	}
	
	
	
	/**
	 * @Title Initialize
	 * @Description Initialize the class name in the JComboBox.
	 * @param empty
	 * @return void
	 * @date Jan 18, 2019-5:15:59 PM
	 *
	 */
	public void Initialize_InitializeClassName()
	{
		Class_DaoImpl class_DaoImpl = new Class_DaoImpl();
		List<Table_Class> list = class_DaoImpl.getClassList(new Table_Class());
		
		for (Table_Class table_Class : list)
		{
			ClassName_JComboBox.addItem(table_Class);
			ModifyClassName_JComboBox.addItem(table_Class);
		}
	}
	
	
	/**
	 * @Title Initialize
	 * @Description Initialize the course name in the JComboBox.
	 * @param empty
	 * @return void
	 * @date Jan 17, 2019-3:50:06 PM
	 *
	 */
	public void Initialize_InitializeCourseName()
	{
		Course_DaoImpl class_Dao = new Course_DaoImpl();
		List<Table_Course> list = class_Dao.getCourseList(new Table_Course());
				
		for (Table_Course table_Course : list)
		{
			/*
			 * Attention : The method of addItem.
			 */
			CourseName_JComboBox.addItem(table_Course);
			ModifyCourseName_JComboBox.addItem(table_Course);
			
		}
	}
	
	
	/**
	 * @Title Initialize
	 * @Description Initialize the student name in the JComboBox.
	 * @param empty
	 * @return void
	 * @date Jan 21, 2019-6:08:45 PM
	 *
	 */
	public void Initialize_InitializeStudentName()
	{
		Student_DaoImpl student_DaoImpl = new Student_DaoImpl();
		List<Table_Student> list = student_DaoImpl.getStudentList(new Table_Student());
				
		for (Table_Student table_Student : list)
		{
			//StudentName_JComboBox.addItem(table_Student);
			ModifyStudentName_JComboBox.addItem(table_Student);
		}
	}
	
	
	/**
	 * @Title Initialize
	 * @Description Initialize the teacher name in the JComboBox.
	 * @param Empty
	 * @return void
	 * @date Jan 21, 2019-6:32:26 PM
	 *
	 */
	public void Initialize_InitializeTeacherName()
	{
		Teacher_DaoImpl teacher_DaoImpl = new Teacher_DaoImpl();
		List<Table_Teacher> list = teacher_DaoImpl.getTeacherList(new Table_Teacher());
				
		for (Table_Teacher table_Teacher : list)
		{
			ModifyTeacherName_JComboBox.addItem(table_Teacher);
		}
	}
}
