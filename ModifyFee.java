import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyFee extends JFrame {

	private JPanel contentPane;
	private JTextField textAdmissionNo;
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textName;
	private JTextField textClass;
	private JTextField textSection;
	private JTextField textAdmissionno;
	private JTextField textyear;
	private JTextField textmonth;
	private JTextField textAmount;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyFee frame = new ModifyFee();
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
	public ModifyFee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 759);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelModifyFee = new JLabel("Modify Fee");
		labelModifyFee.setHorizontalAlignment(SwingConstants.CENTER);
		labelModifyFee.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelModifyFee.setBounds(0, 0, 936, 50);
		contentPane.add(labelModifyFee);
		
		JLabel lblAdmissionNo = new JLabel("AdmissionNo :");
		lblAdmissionNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdmissionNo.setBounds(10, 60, 120, 25);
		contentPane.add(lblAdmissionNo);
		
		textAdmissionNo = new JTextField();
		textAdmissionNo.setBounds(135, 60, 150, 30);
		contentPane.add(textAdmissionNo);
		textAdmissionNo.setColumns(10);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(295, 60, 60, 25);
		contentPane.add(lblYear);
		
		textYear = new JTextField();
		textYear.setColumns(10);
		textYear.setBounds(365, 60, 150, 30);
		contentPane.add(textYear);
		
		JLabel lblMonth = new JLabel("Month :");
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMonth.setBounds(540, 60, 60, 25);
		contentPane.add(lblMonth);
		
		textMonth = new JTextField();
		textMonth.setColumns(10);
		textMonth.setBounds(610, 60, 150, 30);
		contentPane.add(textMonth);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(789, 60, 100, 30);
		contentPane.add(btnSearch);
		
		JLabel label = new JLabel("Name :");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 134, 60, 30);
		contentPane.add(label);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(80, 134, 200, 30);
		contentPane.add(textName);
		
		JLabel lblClass = new JLabel("Class :");
		lblClass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClass.setBounds(305, 134, 60, 30);
		contentPane.add(lblClass);
		
		textClass = new JTextField();
		textClass.setColumns(10);
		textClass.setBounds(365, 134, 200, 30);
		contentPane.add(textClass);
		
		JLabel lblSection = new JLabel("Section :");
		lblSection.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSection.setBounds(589, 134, 90, 30);
		contentPane.add(lblSection);
		
		textSection = new JTextField();
		textSection.setColumns(10);
		textSection.setBounds(689, 134, 200, 30);
		contentPane.add(textSection);
		
		JLabel lblAdmissionno = new JLabel("AdmissionNo :");
		lblAdmissionno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdmissionno.setBounds(10, 203, 120, 25);
		contentPane.add(lblAdmissionno);
		
		textAdmissionno = new JTextField();
		textAdmissionno.setColumns(10);
		textAdmissionno.setBounds(135, 203, 200, 30);
		contentPane.add(textAdmissionno);
		
		JLabel lblyear = new JLabel("Year :");
		lblyear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblyear.setBounds(365, 203, 60, 25);
		contentPane.add(lblyear);
		
		textyear = new JTextField();
		textyear.setColumns(10);
		textyear.setBounds(435, 203, 200, 30);
		contentPane.add(textyear);
		
		JLabel lblmonth = new JLabel("Month :");
		lblmonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmonth.setBounds(645, 203, 60, 25);
		contentPane.add(lblmonth);
		
		textmonth = new JTextField();
		textmonth.setColumns(10);
		textmonth.setBounds(715, 203, 200, 30);
		contentPane.add(textmonth);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmount.setBounds(295, 265, 120, 25);
		contentPane.add(lblAmount);
		
		textAmount = new JTextField();
		textAmount.setColumns(10);
		textAmount.setBounds(435, 265, 200, 30);
		contentPane.add(textAmount);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(295, 325, 100, 30);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(435, 325, 100, 30);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 365, 916, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Admission No", "Month", "Year", "Amount"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(579, 325, 100, 30);
		contentPane.add(btnClose);
	}

}
