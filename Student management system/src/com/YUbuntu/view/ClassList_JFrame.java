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
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.YUbuntu.dao.impl.Class_DaoImpl;
import com.YUbuntu.model.Table_Class;
import com.YUbuntu.util.StringUtil;
import com.YUbuntu.view.function.ClassList_JFrame_function;


/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description The interface of management Class information 
 * @Author #YUbuntu
 * @Date December 2,2018
 * @version 1.0
 */
/* -----------------------------------------------
 *  Note: the inherited object is JInternalJrame |
 * -----------------------------------------------
 */
public class ClassList_JFrame extends /*JFrame */ JInternalFrame implements ClassList_JFrame_function
{
	private JPanel contentPane;
	private JTextField ClassName_textField;
	private JTable ClassList_table;
	private JTextField ChangeClassName_textField;
	
	//Extract objects for easy operation
	JTextArea ChangeClassIntroduce_textArea;
	
	/**
	 * Launch the application.¡ª¡ª>(Close program entry)
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClassList_JFrame frame = new ClassList_JFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	

	/**
	 * Create the frame.
	 */
	public ClassList_JFrame() 
	{
		
		/* ---------------------------------------------------------------------------
		 * Improve the function of the interface (You can close it, you can icon it) |
		 * ---------------------------------------------------------------------------
		 */
		setClosable(true);
		setIconifiable(true);
		
		setFont(new Font("Consolas", Font.BOLD, 20));
		setTitle("Class information management interface");
		
		/*----------------------------------------------------------
		 *  Fixed an issue where the interface could not be closed |
		 *----------------------------------------------------------
		 */
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 695, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblClassName = new JLabel("Class name");
		lblClassName.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		ClassName_textField = new JTextField();
		ClassName_textField.setForeground(new Color(0, 255, 0));
		ClassName_textField.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		ClassName_textField.setColumns(10);
		
		JButton Search_Button = new JButton("select");
		Search_Button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Table_Class table_Class = new Table_Class();
				table_Class.set_CLASS_NAME(ClassName_textField.getText().toString());
				
				/*-------------------------------------------------
				 * table_Class : Contains only the class name	  |
				 *-------------------------------------------------
				 */
				Function_InitializeClassTable(table_Class);
			}
		});
		Search_Button.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JLabel lblClassName_1 = new JLabel("Class name");
		lblClassName_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		JLabel lblIntroduce = new JLabel("Introduce");
		lblIntroduce.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		ChangeClassName_textField = new JTextField();
		ChangeClassName_textField.setFont(new Font("Ó×Ô²", Font.BOLD, 15));
		
		ChangeClassIntroduce_textArea = new JTextArea();
		ChangeClassIntroduce_textArea.setLineWrap(true);
		ChangeClassIntroduce_textArea.setFont(new Font("Ó×Ô²", Font.BOLD, 15));
		
		//
		JButton ConfirmChange_Button = new JButton("Change");
		ConfirmChange_Button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_ConfirmChange(e);
			}
		});
		ConfirmChange_Button.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		//
		JButton ConfirmDelete_Button = new JButton("Delete");
		ConfirmDelete_Button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_ConfirmDelete(e);
			}
		});
		ConfirmDelete_Button.setFont(new Font("Consolas", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblClassName)
							.addGap(26)
							.addComponent(ClassName_textField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(Search_Button))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblClassName_1)
								.addComponent(lblIntroduce))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(ChangeClassName_textField, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
								.addComponent(ChangeClassIntroduce_textArea))
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(ConfirmChange_Button)
								.addComponent(ConfirmDelete_Button))
							.addGap(44)))
					.addGap(40))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ClassName_textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblClassName)
						.addComponent(Search_Button))
					.addGap(46)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClassName_1)
						.addComponent(ChangeClassName_textField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(ConfirmChange_Button))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIntroduce)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(ChangeClassIntroduce_textArea, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addComponent(ConfirmDelete_Button)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		
		ClassList_table = new JTable();
		ClassList_table.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				/*--------------------------------------------
				 * Initialize: Class information operations  |
				 *--------------------------------------------
				 */
				Initialize_SelectClassTableRow(e);
				
			}
		});
		
		ClassList_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Introduce"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ClassList_table.getColumnModel().getColumn(0).setPreferredWidth(28);
		ClassList_table.getColumnModel().getColumn(1).setPreferredWidth(127);
		ClassList_table.getColumnModel().getColumn(2).setPreferredWidth(279);
		ClassList_table.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		scrollPane.setViewportView(ClassList_table);
		contentPane.setLayout(gl_contentPane);
		
		/*-------------------------------------------------------------------------------------------------------
		 * THE FUNCTION : The initialized class information is added to the user interface table and displayed. |
		 *-------------------------------------------------------------------------------------------------------
		 */
		Function_InitializeClassTable(new Table_Class());
	}
	 

	/**
	 * 
	 * @Title Function
	 * @Description Deletes the specified class information(Including : class name,class introduction)
	 * @param event
	 * @date December 6,2018
	 * @return void
	 *
	 */
	public void Function_ConfirmDelete(ActionEvent e)
	{
		
		//Determine whether the user has clicked on the class information they want to delete.
		int Row_index = ClassList_table.getSelectedRow();
		if(Row_index==-1)
		{
			JOptionPane.showMessageDialog(this, "Please click on the class information you want to delete !");
			return;	//Solve this problem : Exception in thread "AWT-EventQueue-0" java.lang.ArrayIndexOutOfBoundsException: -1
		}
		
		//Get the model object for the table
		DefaultTableModel defaultTableModel = (DefaultTableModel) ClassList_table.getModel();
		
		//Get the ID of the class information clicked by the user.
		String ClASS_ID = defaultTableModel.getValueAt(ClassList_table.getSelectedRow(), 0).toString();
		
		//Prompt the user to delete class information whether the operation is successful.
		if(JOptionPane.showConfirmDialog(this, "Are you sure to delete it ?")==JOptionPane.YES_OPTION)//Sensitive operation prompt.
		{
			Class_DaoImpl class_Dao = new Class_DaoImpl();
			if(class_Dao.Delete_ClassInformation(ClASS_ID))
			{
				JOptionPane.showMessageDialog(this, "Delete successfully !");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Deletion failed !");
			}
		}
		else
		{
			return;
		}
		
		//Refresh the data in the class information table.
		Function_InitializeClassTable(new Table_Class());
		
		//Clears the data in the specified location.
		Function_ClearData();
	}
	

	/**
	 * 
	 * @Title Function
	 * @Description Modify the class information specified(Including : class name,class introduction)
	 * @param event
	 * @return void
	 * @date December 6,2018
	 *
	 */
	public void Function_ConfirmChange(ActionEvent e) 
	{
		
		//Determine whether the user has clicked on the class information they want to delete.
		int Row_index = ClassList_table.getSelectedRow();
		if(Row_index==-1)
		{
			JOptionPane.showMessageDialog(this, "Please click on the class information you want to update !", "Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		//Get the model object for the table
		DefaultTableModel defaultTableModel = (DefaultTableModel) ClassList_table.getModel();
		//Get the data of the class information clicked by the user.
		String ClassName = defaultTableModel.getValueAt(ClassList_table.getSelectedRow(), 1).toString();
		String ClassIntroduce = defaultTableModel.getValueAt(ClassList_table.getSelectedRow(), 2).toString();
		//Get the data of the class information that the user wants to modify.
		String Update_ClassName = ChangeClassName_textField.getText().toString();
		String Update_ClassIntroduce = ChangeClassIntroduce_textArea.getText().toString();
		
		if(StringUtil.IsEmpty(Update_ClassName)||StringUtil.IsEmpty(Update_ClassIntroduce))
		{
			JOptionPane.showMessageDialog(this, "Please add the class information you need to modify completely !", "Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(ClassName.equals(Update_ClassName)&&ClassIntroduce.equals(Update_ClassIntroduce))
		{
			JOptionPane.showMessageDialog(this, "You did not make any changes to the class information !", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		//Get the ID of the class information clicked by the user.
		//int ClASS_ID = Integer.parseInt(defaultTableModel.getValueAt(ClassList_table.getSelectedRow(), 0).toString());
		String Class_ID = defaultTableModel.getValueAt(ClassList_table.getSelectedRow(), 0).toString();
		
		//Prompt the user to update class information whether the operation is successful.
		if(JOptionPane.showConfirmDialog(this, "Are you sure to update it ?")==JOptionPane.YES_OPTION)//Sensitive operation prompt.
		{
			//Create an object to store class information.
			Table_Class table_Class = new Table_Class();
			table_Class.set_CLASS_ID(Class_ID);
			table_Class.set_CLASS_NAME(Update_ClassName);
			table_Class.set_CLASS_Introduce(Update_ClassIntroduce);
			
			//Prompt the user: whether the class information has been modified successfully.
			Class_DaoImpl class_Dao = new Class_DaoImpl();
			if(class_Dao.Update_ClassInformation(table_Class))
			{
				JOptionPane.showMessageDialog(this, "Update successfully !");
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "Fail to update !");
			}
		}
		else 
		{
			return;
		}
		
		//Refresh the data in the class information table.
		Function_InitializeClassTable(new Table_Class());

		//Clears the data in the specified location.
		Function_ClearData();
	}
	

	/**
	 * 
	 * @Title Initialize
	 * @Description Adds the selected class information to the pointing location.
	 * Including : 'ChangeClassName_textField'+'ChangeClassIntroduce_textArea'
	 * @param 
	 * @return void
	 * @date December 5,2018
	 *
	 */
	public void Initialize_SelectClassTableRow(MouseEvent e)
	{
		//Get the model object for the table
		DefaultTableModel defaultTableModel = (DefaultTableModel) ClassList_table.getModel();
		
		/*---------------------------------------------------------------------------- 																 			 |
		 * getValueAt() : Returns an attribute value for the cell at row and column. |																 
		 *----------------------------------------------------------------------------
		 */																			//row			 //column
		ChangeClassName_textField.setText(defaultTableModel.getValueAt(ClassList_table.getSelectedRow(), 1).toString());
		ChangeClassIntroduce_textArea.setText(defaultTableModel.getValueAt(ClassList_table.getSelectedRow(), 2).toString());
	}


	
	/**
	 * 
	 * @Title Initialize
	 * @Description Initializes the informaiton in the class table
	 * @param The information of class
	 * @return void
	 * @date December 5,2018
	 *
	 */
	public void Function_InitializeClassTable(Table_Class table_Class)
	{
		//Gets the model object for the table
		DefaultTableModel defaultTableModel = (DefaultTableModel) ClassList_table.getModel();
		//Clear the list of tables
		defaultTableModel.setRowCount(0);
		 
		//Obtain class information
		Class_DaoImpl class_Dao = new Class_DaoImpl();
		
		/*---------------------------------------------------------------------------------------------------------------------
		 * getClassList(table_Class) : The 'table_Class' come from 'Function_InitializeClassTable(new Table_Class())'    	  |
		 * 																													  |  
		 * Attention : The 'table_Class' is null now !!!																	  |
		 *---------------------------------------------------------------------------------------------------------------------
		 */
		List<Table_Class> classList = class_Dao.getClassList(table_Class);
		
		//Write the obtained class information into the class table
		for (Table_Class table_Class_ : classList)
		{
			Vector<String> vector = new Vector<String>();//Implement functions similar to dynamic arrays
			vector.add(table_Class_.get_CLASS_ID());
			vector.add(table_Class_.get_CLASS_NAME());
			vector.add(table_Class_.get_CLASS_Introduce());
			
			/*-------------------------------------------------------------------------------------------------------
			 * This is an implementation of TableModel thatuses a Vector of Vectors to store thecell value objects. |
			 *-------------------------------------------------------------------------------------------------------
			 */
			defaultTableModel.addRow(vector);
		}
		
		//Clears the data in the specified location.
		Function_ClearData();
	}
	
	/**
	 * 
	 * @Title Function
	 * @Description Clears the data in the specified location.
	 * @return void
	 * @date December 5,2018
	 *
	 */
	public void Function_ClearData()
	{
		ClassName_textField.setText("");
		ChangeClassName_textField.setText("");
		ChangeClassIntroduce_textArea.setText("");
	}
}
