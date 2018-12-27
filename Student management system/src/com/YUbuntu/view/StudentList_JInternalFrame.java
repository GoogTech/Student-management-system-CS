package com.YUbuntu.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.YUbuntu.dao.impl.Class_DaoImpl;
import com.YUbuntu.dao.impl.Student_DaoImpl;
import com.YUbuntu.model.Table_Class;
import com.YUbuntu.model.Table_Student;
import com.YUbuntu.util.StringUtil;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description The interface of management student information 
 * @Author #YUbuntu
 * @Date December 8,2018
 * @version 1.0
 */
public class StudentList_JInternalFrame extends JInternalFrame
{
	//Extract objects for easy operation
	private JComboBox Search_ClassName_ComboBox;
	private JComboBox Change_ClassName_ComboBox;
	
	/*
	 * Inorder to easy to set user permissions
	 */
	private JButton ConfirmDelete_Button;
	private JButton Search_Button;
	
	//Button group creation feature: restricts the user to selecting only one of the buttons
	private ButtonGroup buttonGroup; 
	private JRadioButton Change_StudentSex_Male;
	private JRadioButton Change_StudentSex_Female;
	private JTextField Seacher_StudentName_TextField;
	private JTable StudentList_Table;
	private JTextField Change_StudentName_TextField;
	private JTextField Change_StudentPassword_TextField;

	/**
	 * Launch the application.——>(Close program entry)
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentList_JInternalFrame frame = new StudentList_JInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public StudentList_JInternalFrame() 
	{
		
		/* ---------------------------------------------------------------------------
		 * Improve the function of the interface (You can close it, you can icon it) |
		 * ---------------------------------------------------------------------------
		 */
		setClosable(true);
		setIconifiable(true);
		
		setTitle("Student list");
		setBounds(100, 100, 845, 500);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblStudentName = new JLabel("Student name");
		lblStudentName.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		Seacher_StudentName_TextField = new JTextField();
		Seacher_StudentName_TextField.setColumns(10);
		
		JLabel lblClassName = new JLabel("Class name");
		lblClassName.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		Search_ClassName_ComboBox = new JComboBox();
		
		Search_Button = new JButton("Select");
		Search_Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_SearchStudent(e);
			}
		});
		Search_Button.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JLabel lblStudentName_1 = new JLabel("Student name");
		lblStudentName_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		Change_StudentName_TextField = new JTextField();
		Change_StudentName_TextField.setColumns(10);
		
		JLabel lblClassName_1 = new JLabel("Class name");
		lblClassName_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		Change_StudentPassword_TextField = new JTextField();
		Change_StudentPassword_TextField.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		Change_StudentSex_Male = new JRadioButton("Male");
		Change_StudentSex_Male.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		Change_StudentSex_Female = new JRadioButton("Female");
		Change_StudentSex_Female.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		//Button group creation feature: restricts the user to selecting only one of the buttons
		buttonGroup = new ButtonGroup();
		buttonGroup.add(Change_StudentSex_Male);
		buttonGroup.add(Change_StudentSex_Female);
		
		JButton ConfirmSubmit_Button = new JButton("Modify");
		ConfirmSubmit_Button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_ConfirmModify(e);
			}
		});
		ConfirmSubmit_Button.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		ConfirmDelete_Button = new JButton("Delete");
		ConfirmDelete_Button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Function_DeleteStudent(e);
			}
		});
		ConfirmDelete_Button.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		Change_ClassName_ComboBox = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStudentName_1)
								.addComponent(lblClassName_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Change_ClassName_ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(Change_StudentName_TextField, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword)
								.addComponent(lblSex))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(Change_StudentSex_Male)
									.addGap(18)
									.addComponent(Change_StudentSex_Female))
								.addComponent(Change_StudentPassword_TextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
							.addGap(52)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ConfirmDelete_Button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(ConfirmSubmit_Button, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
							.addGap(6))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblStudentName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Seacher_StudentName_TextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblClassName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Search_ClassName_ComboBox, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(Search_Button)))
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Seacher_StudentName_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStudentName)
						.addComponent(lblClassName)
						.addComponent(Search_ClassName_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Search_Button))
					.addGap(38)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentName_1)
						.addComponent(Change_StudentName_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword)
						.addComponent(Change_StudentPassword_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ConfirmSubmit_Button))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClassName_1)
						.addComponent(Change_ClassName_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSex)
						.addComponent(Change_StudentSex_Male)
						.addComponent(Change_StudentSex_Female)
						.addComponent(ConfirmDelete_Button))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		StudentList_Table = new JTable();
		StudentList_Table.addMouseListener(new MouseAdapter() 
		{
			/*
			 * (non-Javadoc)
			 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent e)
			{
				/*----------------------------------------------
				 * Initialize: Student information operations  |
				 *----------------------------------------------
				 */
				Initialize_SelectStudentTableRow(e);
			}
		});
		
		StudentList_Table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "name", "sex", "password", "Class ID", "Class name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		StudentList_Table.getColumnModel().getColumn(0).setPreferredWidth(48);
		StudentList_Table.getColumnModel().getColumn(1).setPreferredWidth(61);
		StudentList_Table.getColumnModel().getColumn(2).setPreferredWidth(32);
		StudentList_Table.getColumnModel().getColumn(3).setPreferredWidth(140);
		StudentList_Table.getColumnModel().getColumn(4).setPreferredWidth(98);
		StudentList_Table.getColumnModel().getColumn(5).setPreferredWidth(160);
		StudentList_Table.setFont(new Font("幼圆", Font.PLAIN, 15));
		scrollPane.setViewportView(StudentList_Table);
		getContentPane().setLayout(groupLayout);

		/* ----------------------------------------------------------------------------------------------------------------
		 * Initializes the class name and displays it in the 'Search_ClassName_ComboBox' and 'Change_ClassName_ComboBox'  |
		 * ----------------------------------------------------------------------------------------------------------------
		 */
		Initialize_InitializeClassName();	
		
		/*------------------------------------------------------------------------------------------
		 * The initialized student information is added to the user interface table and displayed. |
		 *------------------------------------------------------------------------------------------
		 */
		Function_InitializedStudentTable(new Table_Student());
		
		/*-------------------------------------
		 * Initialize : Set user permissions. |
		 *-------------------------------------
		 */
		Initialize_SetUserPermissions();
	}
		
	
	/**
	 * 
	 * @Title Function 
	 * @Description Modify the student information specified(Including : student name+sex+password+class name)
	 * @param ActionEvent e
	 * @return void
	 * @date December 11,2018-7:55:47
	 *
	 */
	protected void Function_ConfirmModify(ActionEvent e)
	{
		//Determine whether the user has clicked on the class information they want to delete.
		int Row_index = StudentList_Table.getSelectedRow();
		if(Row_index==-1)
		{
			JOptionPane.showMessageDialog(this, "Please click on the class information you want to update !", "Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		//Get the model object for the table
		DefaultTableModel defaultTableModel = (DefaultTableModel) StudentList_Table.getModel();
		//Get the data of the student information clicked by the user.
		String StudentID = defaultTableModel.getValueAt(StudentList_Table.getSelectedRow(), 0).toString();
		String StudentName = defaultTableModel.getValueAt(StudentList_Table.getSelectedRow(), 1).toString();
		String StudentPassword = defaultTableModel.getValueAt(StudentList_Table.getSelectedRow(), 2).toString();
		//Get the data of the student information that the user wants to modify.
		String Update_StudentName = Change_StudentName_TextField.getText().toString();
		String Update_StudentPassword = Change_StudentPassword_TextField.getText().toString();
				
		if(StringUtil.IsEmpty(Update_StudentName)||StringUtil.IsEmpty(Update_StudentPassword))
		{
			JOptionPane.showMessageDialog(this, "Please add the student information you need to modify completely !", "Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(StudentName.equals(Update_StudentName)&&StudentPassword.equals(Update_StudentPassword))
		{
			JOptionPane.showMessageDialog(this, "You did not make any changes to the student information !", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}		
		
		//Prompt the user to update student information whether the operation is successful.
		if(JOptionPane.showConfirmDialog(this, "Are you sure to update it ?")==JOptionPane.YES_OPTION)//Sensitive operation prompt.
		{
			//Create an object to store student information.
			Table_Student table_Student = new Table_Student();
			table_Student.setStudent_id(StudentID);
			table_Student.setStudent_name(Update_StudentName);
			table_Student.setStudent_password(Update_StudentPassword);
			//Store students' gender information.
			if(Change_StudentSex_Male.isSelected())
				table_Student.setStudent_sex(Change_StudentSex_Male.getText().toString());
			else			
				table_Student.setStudent_sex(Change_StudentSex_Female.getText().toString());
			//Store class name information
			Table_Class table_Class = (Table_Class) Change_ClassName_ComboBox.getSelectedItem();
			table_Student.setStudent_ClassId(table_Class.get_CLASS_ID());
			table_Student.setStudent_ClassName(table_Class.get_CLASS_NAME());
			
					
			//Prompt the user: whether the class information has been modified successfully.
			Student_DaoImpl class_Dao = new Student_DaoImpl();
			if(class_Dao.Update_StudentInformation(table_Student))
			{
				JOptionPane.showMessageDialog(this, "Update the student information successfully !");
			} 
			else 
			{
				JOptionPane.showMessageDialog(this, "Fail to update the student information !");
				return;
			}
		}
		else 
		{
			return;
		}
		
		//Refresh the data in the student information table.
		Function_InitializedStudentTable(new Table_Student());

		//Clears the data in the specified location.
		Function_ClearData();
	}
	

	
	/**
	 * 
	 * @Title Initialize
	 * @Description Clears the data in the specified location.
	 * @param no
	 * @return void
	 * @date December 11,2018-9:18:48
	 *
	 */
	private void Function_ClearData()
	{
		Seacher_StudentName_TextField.setText("");
		Search_ClassName_ComboBox.setSelectedIndex(0);
		Change_StudentName_TextField.setText("");
		Change_StudentPassword_TextField.setText("");
		Change_ClassName_ComboBox.setSelectedIndex(0);
		buttonGroup.clearSelection();
	}


	/**
	 * 
	 * @Title Initialize
	 * @Description Adds the selected student information to the pointing location.
	 * Including : 'Change_StudentName_TextField'+'Change_ClassName_ComboBox'+' Change_StudentPassword_TextField' 
	 * @param MouseEvent e
	 * @return void
	 * @date December 11,2018-12:54:29
	 *
	 */
	protected void Initialize_SelectStudentTableRow(MouseEvent e)
	{
		//Get the model object for the table
		DefaultTableModel defaultTableModel = (DefaultTableModel) StudentList_Table.getModel();
				
		/*---------------------------------------------------------------------------- 																 			 |
		 * getValueAt() : Returns an attribute value for the cell at row and column. |																 |
		*----------------------------------------------------------------------------
		*/
		//Initialize the student name and class name									//row			//column(index)
		Change_StudentName_TextField.setText(defaultTableModel.getValueAt(StudentList_Table.getSelectedRow(), 1).toString());
		Change_StudentPassword_TextField.setText(defaultTableModel.getValueAt(StudentList_Table.getSelectedRow(), 3).toString());
		
		/*
		 * Initialize the class name. So simple !  (っ•̀ω•́)っ✎⁾⁾  ~
		 */
		String ClassName = (String) defaultTableModel.getValueAt(StudentList_Table.getSelectedRow(), 5);
		for(int i=0;i<Change_ClassName_ComboBox.getItemCount();i++)
		{
			Table_Class table_Class = (Table_Class) Change_ClassName_ComboBox.getItemAt(i);
			if(table_Class.get_CLASS_NAME().equals(ClassName))
			{
				Change_ClassName_ComboBox.setSelectedIndex(i);
			}
		}	
		//Initialize the Student sex
		String StudentSex = defaultTableModel.getValueAt(StudentList_Table.getSelectedRow(), 2).toString();
		buttonGroup.clearSelection();
		if(StudentSex.equals(Change_StudentSex_Male.getText()))
		{
			Change_StudentSex_Male.setSelected(true);
		}
		if(StudentSex.equals(Change_StudentSex_Female.getText()))
		{
			Change_StudentSex_Female.setSelected(true);
		}
	}



	/**
	 * 
	 * @Title Function
	 * @Description Delete the specified student
	 * @param ActionEvent e
	 * @return void
	 * @date December 11,2018-11:31:03
	 *
	 */
	protected void Function_DeleteStudent(ActionEvent e)
	{
		//First step : GetSelectRow : Returns the index of the first selected row, -1 if no row is selected.
		int Row_index = StudentList_Table.getSelectedRow();
		if(Row_index==-1)
		{
			JOptionPane.showMessageDialog(this, "Please click on the student information you want to delete !","Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}	

		//Second step : Prompt the user to delete class information whether the operation is successful.
		/*
		 * getValueAt : Returns the cell value at row and column. (0 == Student ID)
		 */
		if(JOptionPane.showConfirmDialog(this, "Are you sure to delete it ?")==JOptionPane.YES_OPTION)//Sensitive operation prompt.
		{
			Student_DaoImpl student_Dao = new Student_DaoImpl();
			if(student_Dao.Delete_StudentInformation(StudentList_Table.getValueAt(Row_index, 0).toString()))
			{
				JOptionPane.showMessageDialog(this, "Delete successfully !");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Deletion failed !");
				return;
			}
		}
		else
		{
			return;
		}

		//The third step : Refresh the data in the class information table.
		Function_InitializedStudentTable(new Table_Student());
	}	
	
	
	/**
	 * 
	 * @Title Function
	 * @Description Implement the function of the query button : find the specified student information.
	 * @param event
	 * @return void
	 * @date Decemebr 11,2018-9:22:55
	 *
	 */
	protected void Function_SearchStudent(ActionEvent e)
	{
		//Create an object that stores student information.
		Table_Student table_Student = new Table_Student();
		
		//Get the student's name and deposit it in the student information object.
		table_Student.setStudent_name(Seacher_StudentName_TextField.getText().toString());
		
		//Get the class'name and deposit it in the student information object.
		Table_Class table_Class = (Table_Class) Search_ClassName_ComboBox.getSelectedItem();
		table_Student.setStudent_ClassName(table_Class.get_CLASS_NAME());
		
		//Refresh the table data
		Function_InitializedStudentTable(table_Student);
	}

	
	/**
	 * @Title Interface
	 * @Description Initializes the information in the student table
	 * @param The information of student
	 * @date December 8,2018
	 * @throws
	 */
	private void Function_InitializedStudentTable(Table_Student table_Student)
	{
		/*
		 * Set user permissions
		 */
		if("Student".equals(Main_JFrame.userType.getName()))
		{
			Table_Student table_Student_  = (Table_Student) Main_JFrame.userObject;
			/*
			 * In order to display only the personal information of the student who has logged in.
			 */
			table_Student.setStudent_name(table_Student_.getStudent_name());
		}
		
		//Gets the model object for the table	
		DefaultTableModel defaultTableModel = (DefaultTableModel) StudentList_Table.getModel();
		//Clear the list of tables
		defaultTableModel.setRowCount(0);
			  
		//Obtain class information
		Student_DaoImpl student_Dao = new Student_DaoImpl();
		
		/*-------------------------------------------------------------------------------
		 * If user permissions are not set in the above, 'table_Student' is empty !!!	|
		 *-------------------------------------------------------------------------------
		 */
		List<Table_Student> studentList = student_Dao.getStudentList(table_Student);
		
		//Write the obtained class information into the class table
		for (Table_Student table_Student_ : studentList)
		{
			Vector<String> vector = new Vector<String>();//Implement functions similar to dynamic arrays
			vector.add(table_Student_.getStudent_id());
			vector.add(table_Student_.getStudent_name());
			vector.add(table_Student_.getStudent_sex());
			vector.add(table_Student_.getStudent_password());
			vector.add(table_Student_.getStudent_ClassId());
			vector.add(table_Student_.getStudent_ClassName());
				
			/*
			 * This is an implementation of TableModel thatuses a Vector of Vectors to store thecell value objects. 
			 */
			defaultTableModel.addRow(vector);
		}
	}
	
	
	/**
	 * @Title Initialize
	 * @Description Get class name from MySQL database.
	 * @param no
	 * @return void
	 * @date December 8,2018
	 *
	 */
	private void Initialize_InitializeClassName()
	{
		Class_DaoImpl class_Dao = new Class_DaoImpl();
		List<Table_Class> list = class_Dao.getClassList(new Table_Class());
				
		for (Table_Class table : list)
		{
			/*  addItem();
			 * --------------------------------------------------------------------------------------------------------------------
			 *	Warning:Focus and keyboard navigation problems may arise if you add duplicate String objects. 					  |
			 *  A workaround is to add new objects instead of String objects and make sure that the toString() method is defined. |
			 * --------------------------------------------------------------------------------------------------------------------
			 */
			Search_ClassName_ComboBox.addItem(table);
			Change_ClassName_ComboBox.addItem(table);
		}
	}
	
	/**
	 * 
	 * @Title Initialize
	 * @Description Initializes user rights to manage student information tables.
	 * @param no
	 * @return void
	 * @date Dec 19, 2018-5:43:32 PM
	 * @throws
	 *
	 */
	private void Initialize_SetUserPermissions()
	{
		/*
		 * Set user permissions
		 */
		if("Student".equals(Main_JFrame.userType.getName()))
		{
			Table_Student table_Student  = (Table_Student) Main_JFrame.userObject;
			Seacher_StudentName_TextField.setText(table_Student.getStudent_name());
			
			/*
			 * Disable functionality. ————————————> There has a BUG .. 
			 */		
			//Initialize Class name
			for(int i=0;i<Search_ClassName_ComboBox.getItemCount();i++)
			{ 		
				Table_Class table_Class = (Table_Class) Search_ClassName_ComboBox.getItemAt(i);//GetItemAt : return the item at that list position; or null if out of range
				if(table_Student.getStudent_ClassId().equals(table_Class.get_CLASS_ID()))//Attention : Not Compare with adress value !
				{
					Search_ClassName_ComboBox.setSelectedIndex(i);
					//Change_ClassName_ComboBox.setSelectedIndex(i);
					break;
				}
			}
			Search_ClassName_ComboBox.setEnabled(false);
			Change_ClassName_ComboBox.setEnabled(false);
			Seacher_StudentName_TextField.setEnabled(false);
			Search_Button.setEnabled(false);
			ConfirmDelete_Button.setEnabled(false);		
		}
	}
}
