package com.YUbuntu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.YUbuntu.dao.impl.Class_DaoImpl;
import com.YUbuntu.dao.impl.Teacher_DaoImpl;
import com.YUbuntu.model.Table_Class;
import com.YUbuntu.model.Table_Teacher;
import com.YUbuntu.util.StringUtil;
import com.YUbuntu.view.function.TeacherList_JFrame_function;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description The interface of management student information 
 * @Author #YUbuntu
 * @Date Dec 16, 2018-11:08:41 AM
 * @version 1.0
 */
public class TeacherList_JInternalFrame extends JInternalFrame implements TeacherList_JFrame_function
{
	private JTable TeacherList_Table;
	private JTextField Search_TeacherName_TextField;
	private JTextField Modify_TeacherID_TextField;
	private JTextField Modify_TeacherName_TextField;
	private JTextField Modify_TeacherPassword_TextField;
	private JTextField Modify_TeacherAge_TextField;
	private JTextField Modify_TeacherTelephone_TextField;
	
	//Extract objects for easy operation
	private JComboBox Search_ClassName_ComboBox;
	private JComboBox Modify_ClassName_ComboBox;
	private JButton ConfirmDelete_JButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(Object[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					TeacherList_JInternalFrame frame = new TeacherList_JInternalFrame();
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
	public TeacherList_JInternalFrame()
	{
		/* ---------------------------------------------------------------------------
		 * Improve the function of the interface (You can close it, you can icon it) |
		 * ---------------------------------------------------------------------------
		 */
		setClosable(true);
		setIconifiable(true);
		
		setTitle("Teacher information management");
		setBounds(100, 100, 933, 532);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblTeacherName = new JLabel("Teacher name");
		lblTeacherName.setIcon(new ImageIcon(TeacherList_JInternalFrame.class.getResource("/icon/Teacher name.png")));
		lblTeacherName.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		Search_TeacherName_TextField = new JTextField();
		Search_TeacherName_TextField.setColumns(10);
		
		JButton Search_TeacherName_JButton = new JButton("Seek");
		Search_TeacherName_JButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_SearchTeacher(e);
			}
		});
		Search_TeacherName_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		Search_TeacherName_JButton.setIcon(new ImageIcon(TeacherList_JInternalFrame.class.getResource("/icon/Search.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Modify the information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		Search_ClassName_ComboBox = new JComboBox();
		
		JLabel lblClassName = new JLabel("Class name");
		lblClassName.setIcon(new ImageIcon(TeacherList_JInternalFrame.class.getResource("/icon/Class name.png")));
		lblClassName.setFont(new Font("Consolas", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblTeacherName)
					.addGap(18)
					.addComponent(Search_TeacherName_TextField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblClassName)
					.addGap(18)
					.addComponent(Search_ClassName_ComboBox, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(Search_TeacherName_JButton)
					.addContainerGap(166, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 872, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(22))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Search_TeacherName_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTeacherName)
						.addComponent(lblClassName)
						.addComponent(Search_ClassName_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Search_TeacherName_JButton))
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		JLabel lblId = new JLabel("ID");
		lblId.setIcon(new ImageIcon(TeacherList_JInternalFrame.class.getResource("/icon/Id card.png")));
		lblId.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		Modify_TeacherID_TextField = new JTextField();
		Modify_TeacherID_TextField.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setIcon(new ImageIcon(TeacherList_JInternalFrame.class.getResource("/icon/Teacher name.png")));
		lblName.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		Modify_TeacherName_TextField = new JTextField();
		Modify_TeacherName_TextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setIcon(new ImageIcon(TeacherList_JInternalFrame.class.getResource("/icon/Teacher password.png")));
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		Modify_TeacherPassword_TextField = new JTextField();
		Modify_TeacherPassword_TextField.setColumns(10);
		
		JLabel lblSex = new JLabel("telephone");
		lblSex.setIcon(new ImageIcon(TeacherList_JInternalFrame.class.getResource("/icon/Teacher telephone.png")));
		lblSex.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		JLabel lblAge = new JLabel("age");
		lblAge.setIcon(new ImageIcon(TeacherList_JInternalFrame.class.getResource("/icon/Age.png")));
		lblAge.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		Modify_TeacherAge_TextField = new JTextField();
		Modify_TeacherAge_TextField.setColumns(10);
		
		Modify_TeacherTelephone_TextField = new JTextField();
		Modify_TeacherTelephone_TextField.setColumns(10);
		
		JButton ConfirmModify_JButton = new JButton("Modify");
		ConfirmModify_JButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_ModifyTeacherInformation(e);
			}
		});
		ConfirmModify_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		ConfirmModify_JButton.setIcon(new ImageIcon(TeacherList_JInternalFrame.class.getResource("/icon/Confirm.png")));
		
		ConfirmDelete_JButton = new JButton("Delete");
		ConfirmDelete_JButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Function_DeleteTeacher(e);
			}
		});
		ConfirmDelete_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		ConfirmDelete_JButton.setIcon(new ImageIcon(TeacherList_JInternalFrame.class.getResource("/icon/Delete.png")));
		
		JLabel lblClassName_1 = new JLabel("Class name");
		lblClassName_1.setIcon(new ImageIcon(TeacherList_JInternalFrame.class.getResource("/icon/Class name.png")));
		lblClassName_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		Modify_ClassName_ComboBox = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(Modify_TeacherName_TextField)
						.addComponent(Modify_TeacherID_TextField, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(lblSex))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(Modify_TeacherTelephone_TextField)
						.addComponent(Modify_TeacherPassword_TextField, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblAge)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Modify_TeacherAge_TextField, 0, 0, Short.MAX_VALUE))
						.addComponent(lblClassName_1))
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(ConfirmModify_JButton)
							.addGap(18)
							.addComponent(ConfirmDelete_JButton))
						.addComponent(Modify_ClassName_ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(Modify_TeacherID_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Modify_TeacherPassword_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword)
						.addComponent(ConfirmModify_JButton)
						.addComponent(lblAge)
						.addComponent(Modify_TeacherAge_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ConfirmDelete_JButton))
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(Modify_TeacherName_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSex)
						.addComponent(Modify_TeacherTelephone_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblClassName_1)
						.addComponent(Modify_ClassName_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		TeacherList_Table = new JTable();
		TeacherList_Table.addMouseListener(new MouseAdapter() 
		{
			/*
			 * (non-Javadoc)
			 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				/*----------------------------------------------
				 * Initialize: Teacher information operations  |
				 *----------------------------------------------
				 */
				Initialize_SelectTeacherTableRow(e);
			}
		});
		TeacherList_Table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Password", "Sex", "Age", "Title", "Class ID", "Class name", "Telephone"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		TeacherList_Table.getColumnModel().getColumn(0).setPreferredWidth(43);
		TeacherList_Table.getColumnModel().getColumn(1).setPreferredWidth(79);
		TeacherList_Table.getColumnModel().getColumn(2).setPreferredWidth(106);
		TeacherList_Table.getColumnModel().getColumn(3).setPreferredWidth(49);
		TeacherList_Table.getColumnModel().getColumn(4).setPreferredWidth(45);
		TeacherList_Table.getColumnModel().getColumn(5).setPreferredWidth(88);
		TeacherList_Table.getColumnModel().getColumn(6).setPreferredWidth(63);
		TeacherList_Table.getColumnModel().getColumn(7).setPreferredWidth(82);
		TeacherList_Table.getColumnModel().getColumn(8).setPreferredWidth(131);
		scrollPane.setViewportView(TeacherList_Table);
		getContentPane().setLayout(groupLayout);
		
		/* --------------------------------------------------------------------------------
		 * Initializes the class name and displays it in the 'Search_ClassName_ComboBox'  |
		 * --------------------------------------------------------------------------------
		 */
		Initialize_InitializeClassName();
		
		/*------------------------------------------------------------------------------------------
		 * The initialized student information is added to the user interface table and displayed. |
		 *------------------------------------------------------------------------------------------
		 */
		Function_InitializedTeacherTable(new Table_Teacher());
		
		/*-------------------------------------
		 * Initialize : Set user permissions. |
		 *-------------------------------------
		 */
		Initialize_SetUserPermissions();

	}
	
	
	/**
	 * @Title Function
	 * @Description Search the specified teacher information.
	 * @param ActionEvent e
	 * @return void
	 * @date Dec 17, 2018-7:21:06 PM
	 * @throws no
	 *
	 */
	public void Function_SearchTeacher(ActionEvent e)
	{
		//Create an object that stores teacher information.
		Table_Teacher table_Teacher = new Table_Teacher();
				
		//Get the teacher's name and deposit it in the teacher information object.
		table_Teacher.setTeacher_name(Search_TeacherName_TextField.getText().toString());
				
		//Get the class'name and deposit it in the teacher information object.
		Table_Class table_Class = (Table_Class) Search_ClassName_ComboBox.getSelectedItem();
		table_Teacher.setTeacher_ClassName(table_Class.get_CLASS_NAME());
				
		//Refresh the table data
		Function_InitializedTeacherTable(table_Teacher);
	}


	/**
	 * @Title Function
	 * @Description Modify the specified teacher information
	 * @param 
	 * @return void
	 * @date Dec 17, 2018-5:56:49 PM
	 * @throws no
	 *
	 */
	public void Function_ModifyTeacherInformation(ActionEvent e)
	{
		//Determine whether the user has clicked on the teacher information they want to delete.
		int Row_index = TeacherList_Table.getSelectedRow();
		if(Row_index==-1)
		{
			JOptionPane.showMessageDialog(this, "Please click on the class information you want to update !", "Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		//Get the model object for the table
		DefaultTableModel defaultTableModel = (DefaultTableModel) TeacherList_Table.getModel();
		//Get the data of the teacher information clicked by the user.
		String teacherID = defaultTableModel.getValueAt(TeacherList_Table.getSelectedRow(), 0).toString();
		String teacherName = defaultTableModel.getValueAt(TeacherList_Table.getSelectedRow(), 1).toString();
		String teacherPassword = defaultTableModel.getValueAt(TeacherList_Table.getSelectedRow(), 2).toString();
		String teacherAge = defaultTableModel.getValueAt(TeacherList_Table.getSelectedRow(), 4).toString();
		String teacherTelephone = defaultTableModel.getValueAt(TeacherList_Table.getSelectedRow(), 8).toString();
		//Get the data of the teacher information that the user wants to modify.
		String Update_TeacherID = Modify_TeacherID_TextField.getText().toString();
		String Update_TeacherName = Modify_TeacherName_TextField.getText().toString();
		String Update_TeacherPassword = Modify_TeacherPassword_TextField.getText().toString();
		int Update_TeacherAge = Integer.parseInt(Modify_TeacherAge_TextField.getText().toString());
		String Update_TeacherTelephone = Modify_TeacherTelephone_TextField.getText().toString();
		
		//Friendly tips !
		if(StringUtil.IsEmpty(Update_TeacherID)||StringUtil.IsEmpty(Update_TeacherName)||StringUtil.IsEmpty(Update_TeacherPassword)
				||StringUtil.IsEmpty(Modify_TeacherAge_TextField.getText().toString())||StringUtil.IsEmpty(Update_TeacherTelephone))
		{
			JOptionPane.showMessageDialog(this, "Please add the teacher information you need to modify completely !", "Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(!teacherID.equals(Update_TeacherID))
		{
			JOptionPane.showMessageDialog(this,"Sorry ! Modify the teacher ID function temporarily can not be used !");
			Modify_TeacherID_TextField.setText(teacherID);
			return;
		}
		if(teacherName.equals(Update_TeacherName)
				&&teacherPassword.equals(Update_TeacherPassword)&&teacherAge.equals(Update_TeacherAge)&&teacherTelephone.equals(Update_TeacherTelephone))
		{
			JOptionPane.showMessageDialog(this, "You did not make any changes to the teacher information !", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}		
				
		//Prompt the user to update teacher information whether the operation is successful.
		if(JOptionPane.showConfirmDialog(this, "Are you sure to update it ?")==JOptionPane.YES_OPTION)//Sensitive operation prompt.
		{
			//Create an object to store teacher information.
			Table_Teacher table_Teacher = new Table_Teacher();
			table_Teacher.setTeacher_id(teacherID);
			table_Teacher.setTeacher_name(Update_TeacherName);
			table_Teacher.setTeacher_password(Update_TeacherPassword);
			table_Teacher.setTeacher_age(Update_TeacherAge);
			table_Teacher.setTeacher_telephone(Update_TeacherTelephone);
			
			/*
			 * Store teacher information.
			 */
			Table_Class table_Class = (Table_Class) Modify_ClassName_ComboBox.getSelectedItem();
			table_Teacher.setTeacher_ClassID(table_Class.get_CLASS_ID());
			table_Teacher.setTeacher_ClassName(table_Class.get_CLASS_NAME());
			
			//Prompt the user: whether the teacher information has been modified successfully.
			Teacher_DaoImpl teacher_Dao = new Teacher_DaoImpl();
			if(teacher_Dao.Update_TeacherInformation(table_Teacher))
			{
				JOptionPane.showMessageDialog(this, "Update the teacher information successfully !");
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "Fail to update the teacher information !");
				return;
			}
		}
		else 
		{
			return;
		}
				
		//Refresh the data in the teacher information table.
		Function_InitializedTeacherTable(new Table_Teacher());
		//Clears the data in the specified location.
		Function_ClearData();
	}

	
	/**
	 * 
	 * @Title Initialize
	 * @Description Clears the data in the specified location.
	 * @param 
	 * @return void
	 * @date Dec 17, 20187:06:34 PM
	 * @throws
	 *
	 */
	private void Function_ClearData()
	{
		//Search_TeacherName_TextField.setText("");
		//Search_ClassName_ComboBox.setSelectedIndex(0);
		
		Modify_TeacherID_TextField.setText("");
		Modify_TeacherName_TextField.setText("");
		Modify_TeacherPassword_TextField.setText("");
		Modify_TeacherAge_TextField.setText("");
		Modify_TeacherTelephone_TextField.setText("");
		Modify_ClassName_ComboBox.setSelectedIndex(0);	
	}


	/**
	 * 
	 * @Title Function
	 * @Description Delete the specified teacher information.
	 * @param ActionEvent e
	 * @return void
	 * @date Dec 17, 2018-5:41:22 PM
	 * @throws no
	 *
	 */
	public void Function_DeleteTeacher(ActionEvent e)
	{
		//First step : GetSelectRow : Returns the index of the first selected row, -1 if no row is selected.
		int Row_index = TeacherList_Table.getSelectedRow();
		if(Row_index==-1)
		{
			JOptionPane.showMessageDialog(this, "Please click on the teacher information you want to delete !", "Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}	

		//Second step : Prompt the user to delete teacher information whether the operation is successful.
		/*
		 * getValueAt : Returns the cell value at row and column. (0 == Teacher' ID)
		 */
		if(JOptionPane.showConfirmDialog(this, "Are you sure to delete it ?")==JOptionPane.YES_OPTION)//Sensitive operation prompt.
		{
			Teacher_DaoImpl teacher_Dao = new Teacher_DaoImpl();
			if(teacher_Dao.Delete_TeacherInformation(TeacherList_Table.getValueAt(Row_index, 0).toString()))
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
		//The third step : Refresh the data in the teacher information table.
		Function_InitializedTeacherTable(new Table_Teacher());
		
		//Clears the data in the specified location.
		Function_ClearData();
	}

	

	/**
	 * 
	 * @Title Initialize
	 * @Description Adds the selected teacher information to the pointing location.
	 * @param MouseEvent e
	 * @return void
	 * @date Dec 16, 2018-11:03:43 PM
	 * @throws ..
	 *
	 */
	public void Initialize_SelectTeacherTableRow(MouseEvent e)
	{
		//Get the model object for the table
		DefaultTableModel defaultTableModel = (DefaultTableModel) TeacherList_Table.getModel();
						
		/*---------------------------------------------------------------------------- 																 			 |
		 * getValueAt() : Returns an attribute value for the cell at row and column. |																 |
		 *----------------------------------------------------------------------------
		 */
		//Initialize the student name and class name									//row			//column(index)
		Modify_TeacherID_TextField.setText(defaultTableModel.getValueAt(TeacherList_Table.getSelectedRow(), 0).toString());
		Modify_TeacherName_TextField.setText(defaultTableModel.getValueAt(TeacherList_Table.getSelectedRow(), 1).toString());
		Modify_TeacherPassword_TextField.setText(defaultTableModel.getValueAt(TeacherList_Table.getSelectedRow(), 2).toString());
		Modify_TeacherAge_TextField.setText(defaultTableModel.getValueAt(TeacherList_Table.getSelectedRow(), 4).toString());
		Modify_TeacherTelephone_TextField.setText(defaultTableModel.getValueAt(TeacherList_Table.getSelectedRow(), 8).toString());
		
		/*
		 * Initialize the class name. So simple !  (っ•̀ω•́)っ✎⁾⁾  ~
		 */
		String ClassName = (String) defaultTableModel.getValueAt(TeacherList_Table.getSelectedRow(), 7);
		for(int i=0;i<Modify_ClassName_ComboBox.getItemCount();i++)
		{
			Table_Class table_Class = (Table_Class) Modify_ClassName_ComboBox.getItemAt(i);
			if(table_Class.get_CLASS_NAME().equals(ClassName))
			{
				Modify_ClassName_ComboBox.setSelectedIndex(i);
			}
		}	
	}

	
	/**
	 * 
	 * @Title Initialize(CUSTOM)
	 * @Description Initializes the information in the teacher table
	 * @param The teacher information
	 * @return void
	 * @date Dec 16, 2018-11:06:55 PM
	 * @throws
	 *
	 */
	public void Function_InitializedTeacherTable(Table_Teacher table_Teacher)
	{
		/*
		 * Set user permissions
		 */
		if("Teacher".equals(Main_JFrame.userType.getName()))
		{
			Table_Teacher table_Teacher_  = (Table_Teacher) Main_JFrame.userObject;
			/*
			 * In order to display only the personal information of the teacher who has logged in.
			 */
			table_Teacher.setTeacher_name(table_Teacher_.getTeacher_name());
		}
		
		//Gets the model object for the table	
		DefaultTableModel defaultTableModel = (DefaultTableModel) TeacherList_Table.getModel();
		//Clear the list of tables
		defaultTableModel.setRowCount(0);
			  
		//Obtain teacher information
		Teacher_DaoImpl teacher_Dao = new Teacher_DaoImpl();
		
		/*-------------------------------------------------------------------------------------------------------------------------
		 * getTeacherList(table_Teacher) : The 'table_Teacher' come from 'Function_InitializedTeacherTable(new Table_Teacher))'   |
		 * 																													      |  
		 * Attention : The 'table_Teacher' is null now !!!																		  |
		 *-------------------------------------------------------------------------------------------------------------------------
		 */
		List<Table_Teacher> Teacher_List = teacher_Dao.getTeacherList(table_Teacher);
		
		//Write the obtained class information into the class table
		for (Table_Teacher table_Teacher_ : Teacher_List)
		{
			Vector<Object> vector = new Vector<Object>();//Implement functions similar to dynamic arrays
			vector.add(table_Teacher_.getTeacher_id());
			vector.add(table_Teacher_.getTeacher_name());
			vector.add(table_Teacher_.getTeacher_password());
			vector.add(table_Teacher_.getTeacher_sex());
			vector.add(table_Teacher_.getTeacher_age());
			vector.add(table_Teacher_.getTeacher_title());
			vector.add(table_Teacher_.getTeacher_ClassID());
			vector.add(table_Teacher_.getTeacher_ClassName());
			vector.add(table_Teacher_.getTeacher_telephone());
				
			/*-------------------------------------------------------------------------------------------------------
			 * This is an implementation of TableModel thatuses a Vector of Vectors to store thecell value objects. |
			 *-------------------------------------------------------------------------------------------------------
			 */
			defaultTableModel.addRow(vector);
		}
	}
	
	/**
	 * 
	 * @Title Function
	 * @Description Get class name.
	 * @param no
	 * @return void
	 * @date Dec 16, 2018-10:46:09 PM
	 * @throws no
	 *
	 */
	public void Initialize_InitializeClassName()
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
			Modify_ClassName_ComboBox.addItem(table);
			
		}
	}
	
	/**
	 * 
	 * @Title Initialize
	 * @Description TODO
	 * @param no
	 * @return void
	 * @date Dec 19, 2018-11:33:35 PM
	 * @throws ..
	 *
	 */
	public void Initialize_SetUserPermissions()
	{
		/*
		 * Set user permissions
		 */
		if("Teacher".equals(Main_JFrame.userType.getName()))
		{
			Table_Teacher table_Teacher  = (Table_Teacher) Main_JFrame.userObject;
			Search_TeacherName_TextField.setText(table_Teacher.getTeacher_name());
			
			/*
			 * Disable functionality.
			 */		
			//Initialize Class name
			for(int i=0;i<Search_ClassName_ComboBox.getItemCount();i++)
			{ 		
				Table_Class table_Class = (Table_Class) Search_ClassName_ComboBox.getItemAt(i);//GetItemAt : return the item at that list position; or null if out of range
				if(table_Teacher.getTeacher_ClassID().equals(table_Class.get_CLASS_ID()))//Attention : Not Compare with adress value !
				{
					Search_ClassName_ComboBox.setSelectedIndex(i);
					break;
				}
			}
			Search_TeacherName_TextField.setEnabled(false);
			Search_ClassName_ComboBox.setEnabled(false);
			Modify_ClassName_ComboBox.setEnabled(false);
			ConfirmDelete_JButton.setEnabled(false);
		}
	}
}

