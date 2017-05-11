import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.text.DecimalFormat;
import java.awt.image.BufferedImage;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumnModel;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;
//import com.mysql.jdbc.Connection;

public class cbGUI extends JFrame {
	
	//Instance variables
	private double boxWidth;
	private double boxHeight;
	private double boxLength;
	private int cardGrade;
	private int boxColour;
	private boolean boxReinforcedBottom;
	private boolean boxReinforcedCorner;
	private boolean boxSealableTops;
	private int boxQuantity;
	
	CardBoardBox boxType;
	cbBoxOrderList orderList;
	
	private boolean success = false;
	
	//User Interface objects
	private JFrame frame = new JFrame("FlexBox - Order Window");
	private JPanel panel = new JPanel();
	
	private JFrame frame2 = new JFrame("FlexBox - Main Window");
	private JPanel panel2 = new JPanel();
	
	private JFrame frame3 = new JFrame("FlexBox - Admin Login Window");
	private JPanel panel3 = new JPanel();
	
	private JFrame frame4 = new JFrame("FlexBox - Database Records Window");
	private JPanel panel4 = new JPanel();

	private JLabel label1, label2, label3, label4, label5, label6, label7,
			label8, label9, label10, label11, label12, label13, label14, label15, label16, label17, label18;

	private JTextField textfield1, textfield2, textfield3, textfield4, textfield5;
	private JTextField textfield6;
	private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14;

	private JComboBox combobox1;
	private JComboBox combobox2;
	private JComboBox combobox3;
	private JComboBox combobox4;
	private JComboBox combobox5;
	private JComboBox combobox6;
	private JComboBox combobox7;

	DefaultTableModel model1, model2, model3;
	JTable table1, table2, table3;
	JScrollPane pane1, pane2, pane3;
	
	BufferedImage myPicture;
	JLabel picLabel;
	
	private JPanel border1, border2, border3, border4;
	
	//GUI 1 method
	public void cbBoxGUI1() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		
		// Table 1
		model1 = new DefaultTableModel();
		table1 = new JTable(model1);
		pane1 = new JScrollPane(table1);
		model1.addColumn("Box No.");
		model1.addColumn("Width");
		model1.addColumn("Height");
		model1.addColumn("Length");
		model1.addColumn("C.Grade");
		model1.addColumn("Colours");
		model1.addColumn("R.Bot");
		model1.addColumn("R.Cor");
		model1.addColumn("S.Tops");
		model1.addColumn("Quantity");
		pane1.setBounds(10, 360, 124, 20);
		panel.add(pane1);

		pane1.setSize(750, 100);
		pane1.setVisible(true);
		setVisible(false);
		setSize(50, 50);

		// Table 2
		model2 = new DefaultTableModel();
		table2 = new JTable(model2);
		pane2 = new JScrollPane(table2);
		model2.addColumn("Order Number");
		model2.addColumn("Customer ID");
		model2.addColumn("List of Orders");
		model2.addColumn("Total Cost");
		pane2.setBounds(10, 540, 124, 20);
		panel.add(pane2);

		pane2.setSize(750, 100);
		pane2.setVisible(true);
		setVisible(false);
		setSize(50, 50);

		// Combo boxes
		String[] cardGradeStrings = { "", "1", "2", "3", "4", "5" };

		combobox1 = new JComboBox(cardGradeStrings);
		combobox1.setBounds(140, 92, 60, 20);
		panel.add(combobox1);

		String[] colourStrings1 = { "0", "1", "2" };

		combobox2 = new JComboBox(colourStrings1);
		combobox2.setBounds(140, 122, 40, 20);
		panel.add(combobox2);

		String[] colourStrings2 = { "", "Brown", "Red", "Green", "Blue" };

		combobox3 = new JComboBox(colourStrings2);
		combobox3.setBounds(215, 122, 60, 20);
		panel.add(combobox3);

		String[] colourStrings3 = { "", "Brown", "Blue", "Red", "Green" };

		combobox4 = new JComboBox(colourStrings3);
		combobox4.setBounds(305, 122, 60, 20);
		panel.add(combobox4);

		String[] rBottomsStrings = { "No", "Yes" };

		combobox5 = new JComboBox(rBottomsStrings);
		combobox5.setBounds(165, 152, 60, 20);
		panel.add(combobox5);

		String[] rCornersStrings = { "No", "Yes" };

		combobox6 = new JComboBox(rCornersStrings);
		combobox6.setBounds(255, 152, 60, 20);
		panel.add(combobox6);

		String[] sealableStrings = { "No", "Yes" };

		combobox7 = new JComboBox(sealableStrings);
		combobox7.setBounds(140, 182, 60, 20);
		panel.add(combobox7);

		// Labels
		label1 = new JLabel("Size (in metres): *");
		label1.setBounds(10, 62, 124, 14);
		panel.add(label1);

		label2 = new JLabel("W:");
		label2.setBounds(140, 62, 124, 14);
		panel.add(label2);

		label3 = new JLabel("H:");
		label3.setBounds(200, 62, 124, 14);
		panel.add(label3);

		label4 = new JLabel("L:");
		label4.setBounds(260, 62, 124, 14);
		panel.add(label4);

		label5 = new JLabel("Card Grade: *");
		label5.setBounds(10, 92, 124, 14);
		panel.add(label5);

		label6 = new JLabel("C 1:");
		label6.setBounds(190, 122, 124, 14);
		panel.add(label6);

		label7 = new JLabel("C 2:");
		label7.setBounds(280, 122, 124, 14);
		panel.add(label7);

		label8 = new JLabel("Colour Printing:");
		label8.setBounds(10, 122, 124, 14);
		panel.add(label8);

		label9 = new JLabel("Reinforcement:");
		label9.setBounds(10, 152, 124, 14);
		panel.add(label9);

		label10 = new JLabel("Bot:");
		label10.setBounds(140, 152, 124, 14);
		panel.add(label10);

		label11 = new JLabel("Cor:");
		label11.setBounds(230, 152, 124, 14);
		panel.add(label11);

		label12 = new JLabel("Sealable top:");
		label12.setBounds(10, 182, 124, 14);
		panel.add(label12);

		label13 = new JLabel("Quantity: *");
		label13.setBounds(10, 212, 124, 14);
		panel.add(label13);

		// TextFields
		textfield1 = new JTextField(10);
		textfield1.setBounds(160, 62, 30, 20);
		panel.add(textfield1);

		textfield2 = new JTextField(10);
		textfield2.setBounds(220, 62, 30, 20);
		panel.add(textfield2);

		textfield3 = new JTextField(10);
		textfield3.setBounds(280, 62, 30, 20);
		panel.add(textfield3);

		textfield4 = new JTextField(10);
		textfield4.setBounds(140, 212, 30, 20);
		panel.add(textfield4);

		// Buttons
		button1 = new JButton("Verify Order");
		button1.setBounds(10, 300, 110, 20);
		panel.add(button1);

		button2 = new JButton("Add to list");
		button2.setBounds(140, 300, 100, 20);
		panel.add(button2);
		button2.setEnabled(false);
		
		button12 = new JButton("Clear");
		button12.setBounds(260, 300, 100, 20);
		panel.add(button12);
		
		button3 = new JButton("Submit");
		button3.setBounds(10, 490, 100, 20);
		panel.add(button3);

		button4 = new JButton("Add Another Box");
		button4.setBounds(130, 490, 150, 20);
		panel.add(button4);

		button5 = new JButton("New Order");
		button5.setBounds(10, 670, 100, 20);
		panel.add(button5);

		button6 = new JButton("Quit");
		button6.setBounds(130, 670, 100, 20);
		panel.add(button6);
		
		button7 = new JButton("Main Menu");
		button7.setBounds(250, 670, 100, 20);
		panel.add(button7);

		// Borders
		border1 = new JPanel(new BorderLayout());
		border1.setBorder(new TitledBorder("Enter cardboard box details"));
		border1.setBounds(3, 18, 370, 250);
		panel.add(border1);

		border3 = new JPanel(new BorderLayout());
		border3.setBorder(new TitledBorder("Order Cart List"));
		border3.setBounds(3, 340, 770, 140);
		panel.add(border3);

		border4 = new JPanel(new BorderLayout());
		border4.setBorder(new TitledBorder("Order Details"));
		border4.setBounds(3, 520, 770, 140);
		panel.add(border4);
		
		
		//New order
		orderList = new cbBoxOrderList();
		orderList.addcbBoxOrderDetails(new cbBoxOrderDetails());
		
		//Set boolean to false
		success = false;
		
		//Load Picture
		try {
			
			myPicture = ImageIO.read(new File("cardboardbox.png"));
		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(null, "Picture file cannot be found. Check file location.");
			
		}catch (NullPointerException e) {
			
			JOptionPane.showMessageDialog(null, "Unknown Source.");
		}
		picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(450,50,300,220);
		panel.add(picLabel);

		// frame 1
		frame.add(panel);
		frame.setSize(780, 370);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				getUserDetails();
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				displayOrderToTable();

			}
		});
		
		button12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				clearAllInputs();
			}
		});

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				displayOrderDetails();

			}
		});

		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addAnotherBox();
			}
		});

		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				createNewOrder();
			}
		});

		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				quit();
			}
		});
		
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			
			
				frame.dispose();
				cbBoxGUI2();
				
			}
		});

		

	}
	
	//GUI 2 method
	public void cbBoxGUI2(){
		
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel2.setLayout(null);
		
		label14 = new JLabel("Welcome to FlexBox");
		label14.setBounds(30, 20, 124, 14);
		panel2.add(label14);
		
		button8 = new JButton("Get a quote!");
		button8.setBounds(30, 70, 110, 20);
		panel2.add(button8);
		
		button9 = new JButton("Database");
		button9.setBounds(30, 100, 110, 20);
		panel2.add(button9);
		
		button12 = new JButton("Quit");
		button12.setBounds(30, 130, 110, 20);
		panel2.add(button12);
		

		// frame 2
		
		frame2.add(panel2);
		frame2.setSize(180, 190);
		frame2.setVisible(true);
		frame2.setResizable(false);
		frame2.setLocationRelativeTo(null);
		
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame2.dispose();
				cbGUI runGUI1 = new cbGUI();
				runGUI1.cbBoxGUI1();
			}
		});
		
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame2.dispose();
				cbGUI runGUI3 = new cbGUI();
				runGUI3.cbBoxGUI3();
				
				
			}
		});
		
		button12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			 	quit();
			}
		});
		
		
	}
	//GUI 3 method
	public void cbBoxGUI3(){
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel3.setLayout(null);
		
		label15 = new JLabel("Login Authentication");
		label15.setBounds(30, 15, 124, 14);
		panel3.add(label15);
		
		label16 = new JLabel("Name (flex):");
		label16.setBounds(10, 40, 124, 14);
		panel3.add(label16);
		
		label17 = new JLabel("Password (123):");
		label17.setBounds(10, 70, 124, 14);
		panel3.add(label17);
		
		textfield5 = new JTextField(10);
		textfield5.setBounds(120, 40, 30, 20);
		panel3.add(textfield5);

		textfield6 = new JPasswordField(10);
		textfield6.setBounds(120, 70, 30, 20);
		panel3.add(textfield6);
		
		button10 = new JButton("Login");
		button10.setBounds(30, 100, 110, 20);
		panel3.add(button10);
		
		button14 = new JButton("Main");
		button14.setBounds(30, 125, 110, 20);
		panel3.add(button14);
		
		
			
		// frame 3
		
		frame3.add(panel3);
		frame3.setSize(180, 180);
		frame3.setVisible(true);
		frame3.setResizable(false);
		frame3.setLocationRelativeTo(null);
		
		button10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			
				getNameAndPass();

			}
		});
		
		button14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				frame3.dispose();
				cbGUI runGUI2 = new cbGUI();
				runGUI2.cbBoxGUI2();
				
				
			}
		});
	
	}
	
	
	//GUI 4 method
	public void cbBoxGUI4(){
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel4.setLayout(null);
		
		label18 = new JLabel("Database Records");
		label18.setBounds(30, 20, 124, 14);
		panel4.add(label18);
		
		button11 = new JButton("Main");
		button11.setBounds(10, 148, 110, 20);
		panel4.add(button11);
		
		// Table 3
		model3 = new DefaultTableModel();
		table3 = new JTable(model3);
		pane3 = new JScrollPane(table3);
		model3.addColumn("Order Number");
		model3.addColumn("Customer ID");
		model3.addColumn("List of Orders");
		model3.addColumn("Total Cost");
		pane3.setBounds(10, 40, 124, 20);
		panel4.add(pane3);

		pane3.setSize(750, 100);
		pane3.setVisible(true);
		setVisible(false);
		setSize(50, 50);
		
		
			
		// frame 4
		
		frame4.add(panel4);
		frame4.setSize(780, 200);
		frame4.setVisible(true);
		frame4.setResizable(false);
		frame4.setLocationRelativeTo(null);
		
		button11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				frame4.dispose();
				cbGUI runGUI2 = new cbGUI();
				runGUI2.cbBoxGUI2();
				
			}
		});
	
	}
	//Get User Details method
	public boolean getUserDetails() {

		if (textfield1.getText().trim().equals("")
				|| textfield2.getText().trim().equals("")
				|| textfield3.getText().trim().equals("")
				|| textfield4.getText().trim().equals("")
				|| combobox1.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Empty/Invalid characters entered." + "\n" + "Fields marked with asterisk (*) are required.");
		}

		else {

			try {
				this.boxWidth = Double.parseDouble(textfield1.getText());
				this.boxHeight = Double.parseDouble(textfield2.getText());
				this.boxLength = Double.parseDouble(textfield3.getText());
				this.boxQuantity = Integer.parseInt(textfield4.getText());

				this.cardGrade = Integer.parseInt(combobox1.getSelectedItem()
						.toString());

				this.boxColour = Integer.parseInt(combobox2.getSelectedItem()
						.toString());

				if (this.boxColour == 1) {
					this.boxColour = 1;

				} else if (this.boxColour == 2) {
					this.boxColour = 2;

				} else {
					// do nothing.
				}

				String rB = (String) combobox5.getSelectedItem();

				if (rB == "Yes") {
					this.boxReinforcedBottom = true;
				} else if (rB == "No") {
					this.boxReinforcedBottom = false;
				} else {
					// do nothing.
				}

				String rC = (String) combobox6.getSelectedItem();

				if (rC == "Yes") {
					this.boxReinforcedCorner = true;
				} else if (rC == "No") {
					this.boxReinforcedCorner = false;
				} else {
					// do nothing.
				}

				String sT = (String) combobox7.getSelectedItem();

				if (sT == "Yes") {
					this.boxSealableTops = true;
				} else if (sT == "No") {
					this.boxSealableTops = false;
				} else {
					// do nothing.
				}
				
				
				
				
				// type I
				if (this.boxWidth > 0 &
					this.boxHeight > 0 &
					this.boxLength > 0 &
					(
					this.cardGrade >= 1 & 
					this.cardGrade <= 3)& 
					this.boxColour == 0 &
					this.boxQuantity > 0 & 
					combobox3.getSelectedItem() == "" & 
					combobox4.getSelectedItem() == "" & 
					this.boxReinforcedBottom == false & 
					this.boxReinforcedCorner == false) {

					boxType = new cbTypeOne(
					this.boxWidth, 
					this.boxHeight,
					this.boxLength, 
					this.cardGrade,
					this.boxSealableTops, 
					this.boxQuantity,
					this.boxColour, 
					this.boxReinforcedBottom,
					this.boxReinforcedCorner);
					success = false;
				}

				// type II
				else if (this.boxWidth > 0 &
						this.boxHeight > 0 &
						this.boxLength > 0 &
						(
						this.cardGrade >= 2 & 
						this.cardGrade <= 4) & 
						this.boxColour == 1 &
						this.boxQuantity > 0 & 
						combobox3.getSelectedItem() != "" & 
						combobox4.getSelectedItem() == "" & 
						this.boxReinforcedBottom == false & 
						this.boxReinforcedCorner == false) {

						boxType = new cbTypeTwo(
						this.boxWidth, 
						this.boxHeight,
						this.boxLength,
						this.cardGrade,
						this.boxSealableTops, 
						this.boxQuantity,
						this.boxColour, 
						this.boxReinforcedBottom,
						this.boxReinforcedCorner);
						success = false;

				}
				// type III
				else if (this.boxWidth > 0 &
						this.boxHeight > 0 &
						this.boxLength > 0 &
						(
						this.cardGrade >= 2 & 
						this.cardGrade <= 5) & 
						this.boxColour == 2 &
						this.boxQuantity > 0 & 
						combobox3.getSelectedItem() != "" & 
						combobox4.getSelectedItem() != "" & 
						this.boxReinforcedBottom == false & 
						this.boxReinforcedCorner == false) {

						boxType = new cbTypeThree(
						this.boxWidth, 
						this.boxHeight,
						this.boxLength, 
						this.cardGrade,
						this.boxSealableTops, 
						this.boxQuantity,
						this.boxColour, 
						this.boxReinforcedBottom,
						this.boxReinforcedCorner);
						success = false;

				}
				// type IV
				else if (this.boxWidth > 0 &
						this.boxHeight > 0 &
						this.boxLength > 0 &
						(
						this.cardGrade >= 2 & 
						this.cardGrade <= 5) & 
						this.boxColour == 2 &
						this.boxQuantity > 0 & 
						combobox3.getSelectedItem() != "" & 
						combobox4.getSelectedItem() != "" & 
						this.boxReinforcedBottom == true & 
						this.boxReinforcedCorner == false) {

						boxType = new cbTypeFour(
						this.boxWidth, 
						this.boxHeight,
						this.boxLength, 
						this.cardGrade,
						this.boxSealableTops, 
						this.boxQuantity,
						this.boxColour, 
						this.boxReinforcedBottom,
						this.boxReinforcedCorner);
						success = false;

				}
				// type V
				else if (this.boxWidth > 0 &
						this.boxHeight > 0 &
						this.boxLength > 0 &
						(
						this.cardGrade >= 3 & 
						this.cardGrade <= 5) & 
						this.boxColour == 2 &
						this.boxQuantity > 0 & 
						combobox3.getSelectedItem() != "" & 
						combobox4.getSelectedItem() != "" & 
						this.boxReinforcedBottom == true & 
						this.boxReinforcedCorner == true) {

						boxType = new cbTypeFive(
						this.boxWidth, 
						this.boxHeight,
						this.boxLength, 
						this.cardGrade,
						this.boxSealableTops, 
						this.boxQuantity,
						this.boxColour, 
						this.boxReinforcedBottom,
						this.boxReinforcedCorner);
						success = false;

				}

				else {
					
					this.success = true;
					JOptionPane.showMessageDialog(null,
							"Order cannot be supplied by FlexBox." + "\n"
									+ "Please try again!");
				}
				if (!this.success) {

					JOptionPane.showMessageDialog(null,
							"Order can be supplied by FlexBox.");
					button1.setEnabled(false);
					button2.setEnabled(true);
				}

			} catch (NumberFormatException ee) {
				JOptionPane.showMessageDialog(null,
						"Invalid characters entered.");

			}

		}
		return this.success;
	}
	//Display Order To Table 1 method
	public void displayOrderToTable() {
		
		String rB = "No";
		String rC = "No"; 	
		String sT = "No";
		String colourNameOne = (String) combobox3.getSelectedItem();
		String colourNameTwo = (String) combobox4.getSelectedItem();
		String selectedColour;
		int orderListQuantity;
		int boxNumber;
		
		if (!getUserDetails()) {

			orderList.listOfOrders.get(orderList.orderListQuantity() - 1).addcbBox(
					boxType);
			orderListQuantity = orderList.orderListQuantity();
			boxNumber = orderList.listOfOrders.get(orderListQuantity - 1).boxListQuantity();
			selectedColour = this.boxColour + " " + "[" + colourNameOne + "]" + "" + "[" + colourNameTwo + "]";
			
			if (this.boxReinforcedBottom) {
				rB = "Yes";
			}
		
			if (this.boxReinforcedCorner) {
				rC = "Yes";
			}
	
			if (this.boxSealableTops) {
				sT = "Yes";
			}
			
			
			Object[] orderDetails = { 
			boxNumber,
			this.boxWidth, 
			this.boxHeight,
			this.boxLength, 
			this.cardGrade, 
			selectedColour, 
			rB,
			rC, 
			sT, 
			this.boxQuantity };

			model1.addRow(orderDetails);
			frame.setSize(780, 550);
			frame.setLocationRelativeTo(null);
			
			JOptionPane
					.showMessageDialog(null, "Order added to Cart List.");
					
			TextComboTrueOrFalse(1);
			clearAllInputs();
			buttonTrueOrFalse(1);
		}

	}
	//Display Order Details to Table 2 method
	public void displayOrderDetails() {

		frame.setSize(780, 750);
		frame.setLocationRelativeTo(null);
		buttonTrueOrFalse(3);
		
		try {
	
			int i = 0;
			String orderNo;
			String customerID;
			String boxType;
			String totalPrice;
			int orderListQuantity = orderList.orderListQuantity();
			int getCustomerList = orderList.getCustomerList();

			if (orderList.listOfOrders.get(orderListQuantity - 1).boxListQuantity() >= 1) {
				
				orderNo = "CB92" + orderListQuantity;
				customerID = "FB" + getCustomerList;
				
				boxType = orderList.listOfOrders.get(orderListQuantity - 1)
						.getExistingBoxes();
				totalPrice = orderList.listOfOrders.get(orderListQuantity - 1)
						.wholePrice();
						
				Object[] orderQuote = { orderNo, customerID, boxType, totalPrice };
				
				model2.addRow(orderQuote);
				orderList.addcbBoxOrderDetails(new cbBoxOrderDetails());
				JOptionPane.showMessageDialog(null,
						"Order is successfully submitted.");
				
				ConnectionToMySql(orderNo, customerID, boxType, totalPrice);
			} else {

				JOptionPane.showMessageDialog(null,
						"There are no order to submit.");

			}

		} catch (ArrayIndexOutOfBoundsException e) {
			//
		}

	}
	
	//Add Another Box method
	public void addAnotherBox() {

		frame.setSize(780, 370);
		frame.setLocationRelativeTo(null);

		TextComboTrueOrFalse(2);
		buttonTrueOrFalse(2);
		button2.setEnabled(false);

	}
	
	//Create a New Order method
	public void createNewOrder() {
		for (int i = model2.getRowCount() - 1; i >= 0; i--) {
			model2.removeRow(i);
			
			orderList.listOfOrders.get(orderList.orderListQuantity() - 1)
					.clearOrderDetails();
		
		}
		
		for (int i = model1.getRowCount() - 1; i >= 0; i--) {
			model1.removeRow(i);
		}
		
		
		frame.setSize(780, 370);
		frame.setLocationRelativeTo(null);
		TextComboTrueOrFalse(2);

		//clearTable(2);
		buttonTrueOrFalse(4);
	}
	
	//Quit Program method
	public void quit() {
		JOptionPane.showMessageDialog(null, "Program will now close. Bye.");
		System.exit(0);

	}
	
	//Set buttons to True or False method
	public int buttonTrueOrFalse(int buttonTrueOrFalse) {
		switch (buttonTrueOrFalse) {
		case 1:
			button1.setEnabled(false);
			button2.setEnabled(false);
			button12.setEnabled(false);
			break;
		case 2:
			button1.setEnabled(true);
			button2.setEnabled(true);
			button12.setEnabled(true);
			break;
		case 3:
			button3.setEnabled(false);
			button4.setEnabled(false);
			break;
		case 4:
			button1.setEnabled(true);
			button3.setEnabled(true);
			button4.setEnabled(true);
			break;
		case 5:
			button1.setEnabled(true);
			break;
		}
		return buttonTrueOrFalse;
	}
	
	//Set Combo Boxes to True or False method
	public int TextComboTrueOrFalse(int TextComboTrueOrFalse) {
		switch (TextComboTrueOrFalse) {
		case 1:
			textfield1.setEditable(false);
			textfield2.setEditable(false);
			textfield3.setEditable(false);
			textfield4.setEditable(false);

			combobox1.setEnabled(false);
			combobox2.setEnabled(false);
			combobox3.setEnabled(false);
			combobox4.setEnabled(false);
			combobox5.setEnabled(false);
			combobox6.setEnabled(false);
			combobox7.setEnabled(false);
			break;
		case 2:
			textfield1.setEditable(true);
			textfield2.setEditable(true);
			textfield3.setEditable(true);
			textfield4.setEditable(true);

			combobox1.setEnabled(true);
			combobox2.setEnabled(true);
			combobox3.setEnabled(true);
			combobox4.setEnabled(true);
			combobox5.setEnabled(true);
			combobox6.setEnabled(true);
			combobox7.setEnabled(true);

			break;
		}
		return TextComboTrueOrFalse;
	}
	
	//Clear Tables method
	public int clearTable(int clear) {
		switch (clear) {
		case 1:

			int rowCount = model1.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				model1.removeRow(i);
			}
			orderList.listOfOrders.get(orderList.orderListQuantity() - 1)
					.clearOrderDetails();
			break;
		case 2:

			rowCount = model2.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				model2.removeRow(i);
			}
			orderList.listOfOrders.get(orderList.orderListQuantity() - 1)
					.clearOrderDetails();
			break;
		}
		return clear;
	}

	
	//Clear All User Inputs method
	public void clearAllInputs() {

		textfield1.setText("");

		textfield2.setText("");

		textfield3.setText("");

		combobox1.setSelectedIndex(0);

		combobox2.setSelectedIndex(0);

		combobox3.setSelectedIndex(0);

		combobox4.setSelectedIndex(0);

		combobox5.setSelectedIndex(0);

		combobox6.setSelectedIndex(0);

		combobox7.setSelectedIndex(0);

		textfield4.setText("");
		
		buttonTrueOrFalse(5);

	}
	
	
	//Connect to Local Database method
	public void connection() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Conntect to MySql method
	public void ConnectionToMySql(String orderNo, String customerID, String boxType,
			String totalPrice) {

		connection();
		String host = "jdbc:mysql://localhost/cardboardbox";
		String username = "root";
		String password = "";
		
		try {
			Connection connect = (Connection) DriverManager.getConnection(host,
					username, password);
			PreparedStatement statement = (PreparedStatement) connect
					.prepareStatement("INSERT INTO orderdetails(orderNo,customerID, boxType,totalPrice)VALUES(?,?,?,?)");

			statement.setString(1, orderNo);
			statement.setString(2, customerID);
			statement.setString(3, boxType);
			statement.setString(4, totalPrice);
			statement.executeUpdate();
			statement.close();
			
			connect.close();
			
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Order will not be added to database." + "\n" + "There are either two possibilities:" + "\n" + "Order Number already exists." 
		    		+ "\n" + "Or" + "\n" + "Local server is down.");
			
		}
	}
	
	//Get Admin Name and Password method
	public void getNameAndPass(){
		
		String adminName = textfield5.getText();
		String adminPass = textfield6.getText(); 
		
		displayUsers(adminName, adminPass);
		
		}
		
		//Display Users method
		public void displayUsers(String f, String s) {
		    
			connection();
			String host = "jdbc:mysql://localhost/cardboardbox";
			String username = "root";
			String password = "";
			

			boolean correct = false;
		    try {

		        Connection connect = (Connection) DriverManager.getConnection(host,
						username, password);
		        PreparedStatement st = connect.prepareStatement("SELECT adminName, adminPass FROM `admin`");
			    ResultSet rs=st.executeQuery();

		        while (rs.next()) {
		        String adminName = rs.getString("adminName");
		        String adminPass =  rs.getString("adminPass");

		        if ((f.equals(adminName)) && (s.equals(adminPass))) {
		              correct = true;
		              JOptionPane.showMessageDialog(null, "Username and Password exists.");
		               frame3.dispose();
				
		        cbBoxGUI4();
		        retrieveExistingOrders();
		        } 
		        
		       
		        
		        if(!correct){
		        	JOptionPane.showMessageDialog(null,"Wrong Password or Username.");
		        	textfield5.setText("");
					textfield6.setText("");
		        }
		        
		    } 
		        rs.close();
		    }catch (SQLException e) {
		    	JOptionPane.showMessageDialog(null, "There are either two possibilities:" + "\n" + "There are no orders in the database." 
		    		+ "\n" + "Or" + "\n" + "Local server is down.");

		    }
		    
		 }
		    
	//Retrieve Existing Orders method
	public void retrieveExistingOrders(){
		
		connection();
		String host = "jdbc:mysql://localhost/cardboardbox";
		String username = "root";
		String password = "";
		
		try {
			Connection connect = (Connection) DriverManager.getConnection(host,
					username, password);
			
			
			PreparedStatement st = connect.prepareStatement("SELECT * FROM `orderdetails`");
		    ResultSet rs=st.executeQuery();
			String orderNo = "";
			String customerID = "";
			String boxType = "";
			String totalPrice = "";
		    while(rs.next()) {
		
		    	 orderNo = rs.getString(1);
		    	 customerID = rs.getString(2);
		    	 boxType = rs.getString(3);
		    	 totalPrice = rs.getString(4);
		    	 Object[] row = {orderNo, customerID, boxType, totalPrice};
    			 model3.addRow(row);
		    }
		  	
			connect.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database is empty.");
		}
		
		
		}


}// End of cbGUI class