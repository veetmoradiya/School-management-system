import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyPayment extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textname;
	private JTextField textyear;
	private JTextField textmonth;
	private JTextField textSalary;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyPayment frame = new ModifyPayment();
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
	public ModifyPayment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModifyPayment = new JLabel("Modify Payment");
		lblModifyPayment.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblModifyPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyPayment.setBounds(0, 0, 636, 40);
		contentPane.add(lblModifyPayment);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 65, 60, 25);
		contentPane.add(lblName);
		
		textName = new JTextField();
		textName.setBounds(80, 65, 120, 25);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(210, 65, 45, 25);
		contentPane.add(lblYear);
		
		textYear = new JTextField();
		textYear.setColumns(10);
		textYear.setBounds(261, 65, 100, 25);
		contentPane.add(textYear);
		
		JLabel lblMonth = new JLabel("Month :");
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMonth.setBounds(371, 65, 60, 25);
		contentPane.add(lblMonth);
		
		textMonth = new JTextField();
		textMonth.setColumns(10);
		textMonth.setBounds(441, 65, 100, 25);
		contentPane.add(textMonth);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(551, 65, 85, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblname = new JLabel("Name :");
		lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblname.setBounds(10, 115, 60, 25);
		contentPane.add(lblname);
		
		textname = new JTextField();
		textname.setColumns(10);
		textname.setBounds(80, 115, 120, 25);
		contentPane.add(textname);
		
		JLabel lblyear = new JLabel("Year :");
		lblyear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblyear.setBounds(210, 115, 45, 25);
		contentPane.add(lblyear);
		
		textyear = new JTextField();
		textyear.setColumns(10);
		textyear.setBounds(261, 115, 100, 25);
		contentPane.add(textyear);
		
		JLabel lblmonth = new JLabel("Month :");
		lblmonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmonth.setBounds(371, 115, 60, 25);
		contentPane.add(lblmonth);
		
		textmonth = new JTextField();
		textmonth.setColumns(10);
		textmonth.setBounds(441, 115, 100, 25);
		contentPane.add(textmonth);
		
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalary.setBounds(210, 155, 60, 25);
		contentPane.add(lblSalary);
		
		textSalary = new JTextField();
		textSalary.setColumns(10);
		textSalary.setBounds(293, 155, 150, 25);
		contentPane.add(textSalary);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(185, 197, 85, 25);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(300, 197, 85, 25);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 235, 631, 393);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Month", "Year", "Salary"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("Close");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(415, 197, 85, 25);
		contentPane.add(button);
	}

}
