import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Createclass extends JFrame {
	
	String username = "root";
	String password = "";
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	
	int std;
	String div = null;

	private JPanel contentPane;
	private JTextField textClassName;
	private JTextField textSection;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Createclass frame = new Createclass();
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
	public Createclass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 209, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateClass = new JLabel("Create Class");
		lblCreateClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateClass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCreateClass.setBounds(10, 10, 466, 50);
		contentPane.add(lblCreateClass);
		
		JLabel lblClassName = new JLabel("Class Name");
		lblClassName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClassName.setBounds(79, 118, 110, 25);
		contentPane.add(lblClassName);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSection.setBounds(79, 158, 110, 25);
		contentPane.add(lblSection);
		
		textClassName = new JTextField();
		textClassName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textClassName.setBounds(282, 118, 150, 30);
		contentPane.add(textClassName);
		textClassName.setColumns(10);
		
		textSection = new JTextField();
		textSection.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSection.setColumns(10);
		textSection.setBounds(282, 158, 150, 30);
		contentPane.add(textSection);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/mydatabase";
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, username, password);	
					
					stat = conn.createStatement();
					
					std = Integer.parseInt(textClassName.getText());
					div = textSection.getText();
					
					if(std>12) {
						JOptionPane.showMessageDialog(null, "Enter Valid Class.");
					}else {
					
						String sql = "INSERT INTO `class`(`std`, `division`) VALUES ('"+std+"','"+div+"')";
						stat.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Class Added Successfully");
					}
					}catch(Exception e1) {
						System.out.println(e1.getMessage());
					}	
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCreate.setBounds(130, 230, 100, 25);
		contentPane.add(btnCreate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/mydatabase";
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, username, password);	
					
					stat = conn.createStatement();
					
					std = Integer.parseInt(textClassName.getText());
					div = textSection.getText();
					
					if(std>12) {
						JOptionPane.showMessageDialog(null, "Enter Valid Class.");
					}else {
					
						String sql = "DELETE FROM `class` WHERE `std`='"+std+"' AND `division`='"+div+"'";
						stat.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Class Deleted Successfully");
					}
					}catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(282, 230, 100, 25);
		contentPane.add(btnDelete);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(282, 265, 100, 25);
		contentPane.add(btnClose);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(130, 265, 100, 25);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 300, 466, 353);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Class", "Section"
			}
		));
		scrollPane.setViewportView(table);
	}

}
