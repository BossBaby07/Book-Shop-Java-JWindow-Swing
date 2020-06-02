package bookShop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Customer {

	private JFrame frame;
	private JTextField txtCustomerName;
	private JTextField txtPhoneNumber;
	private JTextField txtBookName;
	private JTextField txtWriterName;
	
	String t1 = null , t2 = null, t3 = null, t4 = null;
	
	JTextPane customerInfo;
	JTextPane booksInfo;
	JTextPane successMessage;
	JTextPane allBooksInfo;
	
	JButton bookAdd;
	JButton bookReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY, 8));
		panel.setBounds(10, 107, 613, 197);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel customerName = new JLabel("Customer Name :");
		customerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		customerName.setBounds(23, 21, 177, 30);
		panel.add(customerName);
		
		JLabel phoneNumber = new JLabel("Phone Number :");
		phoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phoneNumber.setBounds(23, 62, 177, 30);
		panel.add(phoneNumber);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(264, 21, 325, 30);
		panel.add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(264, 62, 325, 30);
		panel.add(txtPhoneNumber);
		
		//========================= Customer Add Button =============================
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtCustomerName.getText().isEmpty()) {
					successMessage.setText("Do not blank any input field!");
					t1 = "";
				}else {
					t1 = txtCustomerName.getText();
				}
				
				String name = t1;
				
				if(txtPhoneNumber.getText().isEmpty()) {
					successMessage.setText("Do not blank any input field!");
					t2 = "";
				}else {
					t2 = txtPhoneNumber.getText();
				}
				String phone = t2;
				
				if(name.isEmpty() || phone.isEmpty()) {
					
					customerInfo.setText("");
					
					bookAdd.setEnabled(false);
					bookReset.setEnabled(false);
					
				}else {
					
					customerInfo.setText("Customer Name: " + name + 
				              "\nPhone Number: " + phone);
					
					bookAdd.setEnabled(true);
					bookReset.setEnabled(true);
					
				}
				
				
				if(!customerInfo.getText().isEmpty()) {
					successMessage.setText("Customer Info Taken Succesfully." +  "\nNow, the system is eligible for taking book info!");
				}
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		button.setBackground(new Color(144, 238, 144));
		button.setBounds(64, 134, 122, 30);
		panel.add(button);
		
		//============================ Customer Cancel Button ========================
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCustomerName.setText(null);
				txtPhoneNumber.setText(null);
				customerInfo.setText(null);
				successMessage.setText(null);
				
				successMessage.setText("Customer Info Clear Successfully!");
				
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCancel.setBackground(new Color(255, 69, 0));
		btnCancel.setBounds(433, 134, 122, 30);
		panel.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(124, 252, 0));
		panel_1.setBorder(new LineBorder(Color.GRAY, 8));
		panel_1.setBounds(10, 11, 1164, 85);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 128, 0), 4));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\SADI\\eclipse-workspace\\BookShopCustomerInfo\\image\\bookshop.png"));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel(" Book Shop Books Selling Information System ");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 128, 0), 8));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\SADI\\eclipse-workspace\\BookShopCustomerInfo\\image\\bookshop.png"));
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 128, 0), 4));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 255, 240));
		panel_2.setBorder(new LineBorder(Color.GRAY, 8));
		panel_2.setBounds(10, 647, 1164, 103);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		//============================= Exit Application ===============================================
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter("E:/Book Shop Java App/book.txt");
					fileWriter.write("");
					fileWriter.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex+"\nPlease Create a Folder in the E: Drive. "+" Name : Book Shop Java App"+"\nThanks!");
				}
				
				System.exit(0);
			}
		});
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		exit.setBackground(new Color(255, 0, 0));
		exit.setBounds(848, 28, 227, 47);
		panel_2.add(exit);
		
		//==================================== Cancel Order Button ==================================
		
		JButton resetAll = new JButton("Reset All / Next Order");
		resetAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCustomerName.setText(null);
				txtPhoneNumber.setText(null);
				txtBookName.setText(null);
				txtWriterName.setText(null);
				
				customerInfo.setText(null);
				booksInfo.setText(null);
				allBooksInfo.setText(null);
				
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter("E:/Book Shop Java App/book.txt");
					fileWriter.write("");
					fileWriter.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex+"\nPlease Create a Folder in the E: Drive. "+" Name : Book Shop Java App"+"\nThanks!");
				}
				
				successMessage.setText("Order Canceled!");
				
			}
		});
		resetAll.setForeground(Color.BLACK);
		resetAll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resetAll.setBackground(new Color(255, 255, 0));
		resetAll.setBounds(474, 28, 227, 47);
		panel_2.add(resetAll);
		
		//================================= Complete Order Button =========================================
		
		JButton completeOrder = new JButton("Complete Order");
		completeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(customerInfo.getText().isEmpty() || allBooksInfo.getText().isEmpty()) {
					
				}else {
					
					FileWriter fileWriter; // for write into file
					File file = new File("E:/Book Shop Java App/customerDatabase.txt"); //for read from the file line by line
					String fileContent = "";
					//Read file try catch block
					try {
						
						Scanner scan = new Scanner(file);
						
						while(scan.hasNextLine()) {
							fileContent = fileContent.concat(scan.nextLine() + "\n");
						}
						
					} catch (FileNotFoundException e1) {
						
						JOptionPane.showMessageDialog(null, e1+"\nPlease Create a Folder and File in the E: Drive. "+" Name : Book Shop Java App"+"\nFile: customerDatabase.txt"+"\nThanks!");
					}
					
					//write file try catch block
					try {
						fileWriter = new FileWriter("E:/Book Shop Java App/customerDatabase.txt");
						fileWriter.write(fileContent);
						fileWriter.append("\nCustomer Info: " + customerInfo.getText() + "\t\t" + 
						                  "Books Info: " + allBooksInfo.getText() + "\n");
						fileWriter.close();
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex+"\nPlease Create a Folder in the E: Drive. "+" Name : Book Shop Java App"+"\nThanks!");
					}
					
					successMessage.setText("Customer Info Added Successfully In Database!");
					
				}
			}
		});
		completeOrder.setForeground(Color.BLACK);
		completeOrder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		completeOrder.setBackground(new Color(127, 255, 0));
		completeOrder.setBounds(100, 28, 227, 47);
		panel_2.add(completeOrder);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.GRAY, 8));
		panel_4.setBounds(10, 315, 613, 207);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel bookName = new JLabel("Book Name :");
		bookName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bookName.setBounds(20, 25, 177, 30);
		panel_4.add(bookName);
		
		JLabel writerName = new JLabel("Writer Name :");
		writerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		writerName.setBounds(20, 66, 177, 30);
		panel_4.add(writerName);
		
		txtBookName = new JTextField();
		txtBookName.setColumns(10);
		txtBookName.setBounds(259, 25, 325, 30);
		panel_4.add(txtBookName);
		
		txtWriterName = new JTextField();
		txtWriterName.setColumns(10);
		txtWriterName.setBounds(259, 66, 325, 30);
		panel_4.add(txtWriterName);
		
		//=========================== Book Add Button =======================================
		
		bookAdd = new JButton("Add");
		bookAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtBookName.getText().isEmpty()) {
					successMessage.setText("Do not blank any input field!");
					t3 = "";
				}else {
					t3 = txtBookName.getText();
				}
				
				String bookName = t3;
				
				if(txtWriterName.getText().isEmpty()) {
					successMessage.setText("Do not blank any input field!");
					t4 = "";
				}else {
					t4 = txtWriterName.getText();
				}
				String writerName = t4;
				
				if(bookName.isEmpty() || writerName.isEmpty()) {
					
					booksInfo.setText("");
					
					bookAdd.setEnabled(true);
					bookReset.setEnabled(true);
					
				}else {
					
					booksInfo.setText("Book Name: " + bookName + 
				              "\nWriter Name: " + writerName);
					
					FileWriter fileWriter; // for write into file
					File file = new File("E:/Book Shop Java App/book.txt"); //for read from the file line by line
					String fileContent = "";
					//Read file try catch block
					try {
						
						Scanner scan = new Scanner(file);
						
						while(scan.hasNextLine()) {
							fileContent = fileContent.concat(scan.nextLine() + "\n");
						}
						
					} catch (FileNotFoundException e1) {
						
						JOptionPane.showMessageDialog(null, e1+"\nPlease Create a Folder and File in the E: Drive. "+" Name : Book Shop Java App"+"\nFile: book.txt"+"\nThanks!");
					}
					
					//write file try catch block
					try {
						fileWriter = new FileWriter("E:/Book Shop Java App/book.txt");
						fileWriter.write(fileContent);
						fileWriter.append("\n" + booksInfo.getText());
						fileWriter.close();
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex+"\nPlease Create a Folder in the E: Drive. "+" Name : Book Shop Java App"+"\nThanks!");
					}
					
					bookAdd.setEnabled(true);
					bookReset.setEnabled(true);
					
					allBooksInfo.setText(fileContent + "\n" + booksInfo.getText());
					successMessage.setText("Books Info Added Successfully!");
					
				}
				
			}
		});
		bookAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		bookAdd.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		bookAdd.setBackground(new Color(144, 238, 144));
		bookAdd.setBounds(65, 148, 122, 30);
		panel_4.add(bookAdd);
		
		//================================= Book Reset Button ========================
		
		bookReset = new JButton("Reset");
		bookReset.setEnabled(false);
		bookReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtBookName.setText(null);
				txtWriterName.setText(null);
				
				booksInfo.setText(null);
				allBooksInfo.setText(null);
				
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter("E:/Book Shop Java App/book.txt");
					fileWriter.write("");
					fileWriter.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex+"\nPlease Create a Folder in the E: Drive. "+" Name : Book Shop Java App"+"\nThanks!");
				}
				
				successMessage.setText("Books Info Clear Successfully!");
				
			}
		});
		bookReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		bookReset.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		bookReset.setBackground(new Color(255, 0, 0));
		bookReset.setBounds(433, 148, 122, 30);
		panel_4.add(bookReset);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBorder(new LineBorder(Color.GRAY, 8));
		panel_5.setBounds(10, 533, 613, 103);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		successMessage = new JTextPane();
		successMessage.setFont(new Font("Tahoma", Font.ITALIC, 16));
		successMessage.setBackground(Color.BLACK);
		successMessage.setForeground(Color.WHITE);
		successMessage.setBounds(10, 11, 593, 81);
		panel_5.add(successMessage);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(Color.DARK_GRAY, 8));
		panel_6.setBounds(633, 107, 541, 529);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 521, 507);
		panel_6.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Current Customer Info", null, panel_3, null);
		panel_3.setLayout(null);
		
		customerInfo = new JTextPane();
		customerInfo.setBounds(10, 11, 496, 457);
		panel_3.add(customerInfo);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Currently Added Book Info", null, panel_7, null);
		panel_7.setLayout(null);
		
		booksInfo = new JTextPane();
		booksInfo.setBounds(10, 11, 496, 457);
		panel_7.add(booksInfo);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("All Added Books Info", null, panel_8, null);
		panel_8.setLayout(null);
		
		allBooksInfo = new JTextPane();
		allBooksInfo.setBounds(10, 11, 496, 457);
		panel_8.add(allBooksInfo);
	}
}
