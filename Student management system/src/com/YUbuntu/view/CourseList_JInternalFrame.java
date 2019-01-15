package com.YUbuntu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.YUbuntu.dao.impl.Course_DaoImpl;
import com.YUbuntu.dao.impl.Teacher_DaoImpl;
import com.YUbuntu.model.Table_Course;
import com.YUbuntu.model.Table_Teacher;
import com.YUbuntu.view.function.CourseList_JInternalFrame_function;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description The interface of management course information.
 * @Author HuangYuhui
 * @Date Jan 15, 2019-1:05:11 PM
 * @version 2.0
 */
public class CourseList_JInternalFrame extends JInternalFrame implements CourseList_JInternalFrame_function
{
	private JTextField CourseName_TextField;
	private JComboBox TeacherName_JComboBox;
	private JButton Select_JButton;
	private JTable CourseList_JTable;
	private JTextField ModifyCourseName_TextField;
	private JTextField ModifyMaxNumber_TextField;
	private JComboBox ModifyTeacherName_JComboBox;
	private JTextArea ModifyCourseIntroduce_JTextArea;

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
					CourseList_JInternalFrame frame = new CourseList_JInternalFrame();
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
	public CourseList_JInternalFrame()
	{	
		/* 
		 * Improve the function of the interface (You can close it, you can icon it) ~
		 */
		setClosable(true);
		setIconifiable(true);
		
		setTitle("Course information management");
		setBounds(100, 100, 883, 520);
		
		JLabel lblCourseName = new JLabel("Course name");
		lblCourseName.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		CourseName_TextField = new JTextField();
		CourseName_TextField.setColumns(10);
		
		JLabel lblTeacherName = new JLabel("Teacher name");
		lblTeacherName.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		TeacherName_JComboBox = new JComboBox();
		
		Select_JButton = new JButton("Select");
		Select_JButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_SearchCourse(e);
			}
		});
		Select_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Modify the information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCourseName, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CourseName_TextField, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(lblTeacherName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TeacherName_JComboBox, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(Select_JButton))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourseName)
						.addComponent(CourseName_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TeacherName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTeacherName)
						.addComponent(Select_JButton))
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		JLabel lblCourseName_1 = new JLabel("Course name");
		lblCourseName_1.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		ModifyCourseName_TextField = new JTextField();
		ModifyCourseName_TextField.setColumns(10);
		
		JLabel lblTeacherName_1 = new JLabel("Teacher name");
		lblTeacherName_1.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JLabel lblMaxNumber = new JLabel("Max number");
		lblMaxNumber.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		ModifyMaxNumber_TextField = new JTextField();
		ModifyMaxNumber_TextField.setColumns(10);
		
		JLabel lblCourseIntroduce = new JLabel("Course introduce");
		lblCourseIntroduce.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JButton ConfirmModify_JButton = new JButton("Modify");
		ConfirmModify_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JButton ConfirmDelete_JButton = new JButton("Delete");
		ConfirmDelete_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		ModifyTeacherName_JComboBox = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCourseName_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTeacherName_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ModifyTeacherName_JComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ModifyCourseName_TextField, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMaxNumber, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCourseIntroduce, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(ModifyMaxNumber_TextField)
							.addGap(18)
							.addComponent(ConfirmModify_JButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ConfirmDelete_JButton))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourseName_1)
						.addComponent(ModifyCourseName_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaxNumber)
						.addComponent(ModifyMaxNumber_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ConfirmDelete_JButton)
						.addComponent(ConfirmModify_JButton))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTeacherName_1)
							.addComponent(lblCourseIntroduce)
							.addComponent(ModifyTeacherName_JComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		ModifyCourseIntroduce_JTextArea = new JTextArea();
		ModifyCourseIntroduce_JTextArea.setLineWrap(true);
		scrollPane_1.setViewportView(ModifyCourseIntroduce_JTextArea);
		panel.setLayout(gl_panel);
		
		CourseList_JTable = new JTable();
		CourseList_JTable.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				/*
				 * 
				 */
				Initialize_SelectCourseTableRow(e);
			}
		});
		CourseList_JTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Course ID", "Course name", "Teacher ID", "Teacher name", "Max number", "Selected number", "Course introduce"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		CourseList_JTable.getColumnModel().getColumn(0).setPreferredWidth(68);
		CourseList_JTable.getColumnModel().getColumn(1).setPreferredWidth(96);
		CourseList_JTable.getColumnModel().getColumn(2).setPreferredWidth(71);
		CourseList_JTable.getColumnModel().getColumn(3).setPreferredWidth(97);
		CourseList_JTable.getColumnModel().getColumn(4).setPreferredWidth(71);
		CourseList_JTable.getColumnModel().getColumn(5).setPreferredWidth(105);
		CourseList_JTable.getColumnModel().getColumn(6).setPreferredWidth(146);
		scrollPane.setViewportView(CourseList_JTable);
		getContentPane().setLayout(groupLayout);

		
		/*
		 * The initialized course information is added to the user interface table and displayed.
		 */
		Function_InitializedCourseTable(new Table_Course());
		
		/*
		 * Initializes the teacher name and displays it in the specified place.
		 */
		Initialize_InitializeTeacherName();
	}
	
	
	/** 
	 * @Title Function
	 * @Description Search the specified course information.
	 * @param ActionEvene e
	 * @return void
	 * @date Jan 15, 2019-6:40:49 PM
	 *
	 */
	public void Function_SearchCourse(ActionEvent e)
	{
		//Create an object that stores course information.
		Table_Course table_Course = new Table_Course();
						
		//Get the course information and deposit it in the course information object.
		table_Course.setCourse_name(CourseName_TextField.getText().toString());
		table_Course.setTeacher_name(TeacherName_JComboBox.getSelectedItem().toString());
						
		//Refresh the data of table.
		Function_InitializedCourseTable(table_Course);
	}
	
	

	/**
	 * @Title Initialize
	 * @Description Adds the selected course information to the pointing location.
	 * @param MouseEvent e
	 * @return void
	 * @date Jan 15, 2019-6:15:47 PM
	 *
	 */
	public void Initialize_SelectCourseTableRow(MouseEvent e)
	{
		//Get the model object for the table.
		DefaultTableModel defaultTableModel = (DefaultTableModel) CourseList_JTable.getModel();
								
		/*
		 * Initialize the course information.	 																 			 
		 * getValueAt() : Returns an attribute value for the cell at row and column. 															
		 */
		ModifyCourseName_TextField.setText(defaultTableModel.getValueAt(CourseList_JTable.getSelectedRow(), 1).toString());
		ModifyMaxNumber_TextField.setText(defaultTableModel.getValueAt(CourseList_JTable.getSelectedRow(), 4).toString());
		ModifyCourseIntroduce_JTextArea.setText(defaultTableModel.getValueAt(CourseList_JTable.getSelectedRow(), 6).toString());
				
		/*
		 * Initialize the teacher name. So simple ! 
		 */
		String teacherName = (String) defaultTableModel.getValueAt(CourseList_JTable.getSelectedRow(), 3);
		for(int i=0;i<ModifyTeacherName_JComboBox.getItemCount();i++)
		{
			Table_Teacher table_Teacher = (Table_Teacher) ModifyTeacherName_JComboBox.getItemAt(i);
			if(table_Teacher.getTeacher_name().equals(teacherName))
			{
				ModifyTeacherName_JComboBox.setSelectedIndex(i);
			}
		}	
	}
	
	

	/**
	 * @Title Initialize
	 * @Description Initialize the information in course table.
	 * @param The object of Table_Course.
	 * @return void
	 * @date Jan 15, 2019-4:53:29 PM
	 *
	 */
	public void Function_InitializedCourseTable(Table_Course table_Course)
	{
		
		//Gets the model object for the table.
		DefaultTableModel defaultTableModel = (DefaultTableModel) CourseList_JTable.getModel();
		//Clear the list of tables.
		defaultTableModel.setRowCount(0);
		
		//Obtain teacher information.
		Course_DaoImpl course_DaoImpl = new Course_DaoImpl();
	
		List<Table_Course> list = course_DaoImpl.getCourseList(table_Course);
		
		//Write the obtained class information into the course table.
		for (Table_Course table_Course_ : list)
		{
			Vector<Object> vector = new Vector<Object>();
			
			vector.add(table_Course_.getCourse_ID());
			vector.add(table_Course_.getCourse_name());
			vector.add(table_Course_.getTeacher_ID());
			vector.add(table_Course_.getTeacher_name());
			vector.add(table_Course_.getCourse_MaxStudentNumber());
			vector.add(table_Course_.getSelected_StudentNumber());
			vector.add(table_Course_.getCourse_Introduction());
				
			/*
			 * This is an implementation of TableModel thatuses a Vector of Vectors to store thecell value objects.
			 */
			defaultTableModel.addRow(vector);
		}
	}
	
	
	
	/** 
	 * @Title Initialize
	 * @Description Initialize the teacher name.
	 * @param empty
	 * @return void
	 * @date Jan 15, 2019-5:25:06 PM
	 *
	 */
	public void Initialize_InitializeTeacherName()
	{
		Teacher_DaoImpl teacher_DaoImpl = new Teacher_DaoImpl();
		List<Table_Teacher> list = teacher_DaoImpl.getTeacherList(new Table_Teacher());
				
		for (Table_Teacher table_Teacher : list)
		{
			TeacherName_JComboBox.addItem(table_Teacher);
			ModifyTeacherName_JComboBox.addItem(table_Teacher);	
		}
	}	
	
}
