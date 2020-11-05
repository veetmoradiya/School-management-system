import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Modifyteacher extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textSalary;
	private JTextField textMobile;
	private JTextField textAddress;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modifyteacher frame = new Modifyteacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Modifyteacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModifyTeacher = new JLabel("Modify Teacher");
		lblModifyTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyTeacher.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblModifyTeacher.setBounds(0, 0, 436, 60);
		contentPane.add(lblModifyTeacher);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(50, 70, 100, 30);
		contentPane.add(lblName);
		
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalary.setBounds(50, 110, 100, 30);
		contentPane.add(lblSalary);
		
		JLabel lblMobile = new JLabel("Mobile :");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobile.setBounds(50, 150, 100, 30);
		contentPane.add(lblMobile);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(50, 190, 100, 30);
		contentPane.add(lblAddress);
		
		textName = new JTextField();
		textName.setBounds(160, 70, 200, 30);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textSalary = new JTextField();
		textSalary.setColumns(10);
		textSalary.setBounds(160, 110, 200, 30);
		contentPane.add(textSalary);
		
		textMobile = new JTextField();
		textMobile.setColumns(10);
		textMobile.setBounds(160, 150, 200, 30);
		contentPane.add(textMobile);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(160, 190, 200, 30);
		contentPane.add(textAddress);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(50, 240, 100, 30);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(160, 240, 100, 30);
		contentPane.add(btnDelete);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(270, 240, 100, 30);
		contentPane.add(btnClose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 293, 416, 360);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Salary", "Address", "Mobile"
			}
		));
		scrollPane.setViewportView(table);
	}
}
