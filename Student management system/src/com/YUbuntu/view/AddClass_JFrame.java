package com.YUbuntu.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.YUbuntu.dao.impl.Class_DaoImpl;
import com.YUbuntu.model.Table_Class;
import com.YUbuntu.util.StringUtil;
import com.YUbuntu.view.function.AddClass_JFrame_function;

import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * 
 * @Project Student management system
 * @Package com.YUbuntu.view
 * @Description The interface of adding class information 
 * @Author #YUbuntu
 * @Date December 2,2018
 * @version 1.0
 */
public class AddClass_JFrame extends /*JFrame*/ JInternalFrame implements AddClass_JFrame_function
{

	private JPanel contentPane;
	
	//Extract objects for easy operation
	private JTextField ClassName_textField;
	private JTextArea ClassIntroduce_textArea;
	private JTextField ClassID_textField;

	/**
	 * Launch the application.¡ª¡ª>(Close program entry)
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddClass_JFrame frame = new AddClass_JFrame();
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
	public AddClass_JFrame() 
	{
		/* ---------------------------------------------------------------------------
		 * Improve the function of the interface (You can close it, you can icon it) |
		 * ---------------------------------------------------------------------------
		 */
		setClosable(true);
		setIconifiable(true);
		
		setFont(new Font("Consolas", Font.BOLD, 20));
		setTitle("Add class information interface");
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 533, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblClassName = new JLabel("Class name");
		lblClassName.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		ClassName_textField = new JTextField();
		ClassName_textField.setColumns(10);
		
		JLabel lblIntroduce = new JLabel("Introduce");
		lblIntroduce.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		ClassIntroduce_textArea = new JTextArea();
		
		JButton Submit_Button = new JButton("Submit");
		Submit_Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_AddClass(e);
			}
		});
		Submit_Button.setIcon(null);
		Submit_Button.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		JButton Reset_Button = new JButton("Reset");
		Reset_Button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_ResetInformation(e);
			}
		});
		Reset_Button.setIcon(null);
		Reset_Button.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JLabel lblClassId = new JLabel("Class ID");
		lblClassId.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		ClassID_textField = new JTextField();
		ClassID_textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClassName)
						.addComponent(lblClassId)
						.addComponent(lblIntroduce))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ClassName_textField)
						.addComponent(ClassIntroduce_textArea, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
						.addComponent(ClassID_textField))
					.addContainerGap(93, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(128)
					.addComponent(Submit_Button)
					.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
					.addComponent(Reset_Button)
					.addGap(116))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ClassID_textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblClassId))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClassName)
						.addComponent(ClassName_textField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIntroduce)
						.addComponent(ClassIntroduce_textArea, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Submit_Button)
						.addComponent(Reset_Button))
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * 
	 * @Title Function
	 * @Description Add class information to MySQL database
	 * @param event
	 * @date December 6,2018
	 * @return void
	 *
	 */
	public void Function_AddClass(ActionEvent e) 
	{
		String classID = ClassID_textField.getText();
		String className = ClassName_textField.getText();
		String classIntroduce = ClassIntroduce_textArea.getText();
		
		//Helpful hints
		if(StringUtil.IsEmpty(classID))
		{
			JOptionPane.showConfirmDialog(this, "Please enter the class ID !", "Warning", JOptionPane.WARNING_MESSAGE);
			return;	
		}
		if(StringUtil.IsEmpty(className))
		{
			JOptionPane.showConfirmDialog(this, "Please enter the class name !", "Warning", JOptionPane.WARNING_MESSAGE);
			return;	
		}
		if(StringUtil.IsEmpty(classIntroduce))
		{
			JOptionPane.showConfirmDialog(this, "Please enter the class introduce !","Warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		//Determine whether the class information has been added successfully
		Table_Class table_Class = new Table_Class();
		Class_DaoImpl class_Dao = new Class_DaoImpl();
		
		table_Class.set_CLASS_ID(classID);
		table_Class.set_CLASS_NAME(className);
		table_Class.set_CLASS_Introduce(classIntroduce);
		
		//The method of 'addClass' is boolean ~
		if(class_Dao.addClass(table_Class))
			JOptionPane.showMessageDialog(this, "Successfully added class information !");
		else
			JOptionPane.showMessageDialog(this, "Failed to add class information !");
		Function_ResetInformation(e);
	}
	

	/**
	 * 
	 * @Title Funciton
	 * @Description Reset the data entered by the user
	 * @param events
	 * @date December 6,2018
	 * @return void
	 *
	 */
	public void Function_ResetInformation(ActionEvent e)
	{
		ClassID_textField.setText("");
		ClassName_textField.setText("");
		ClassIntroduce_textArea.setText("");	
	}
}
