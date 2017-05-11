import java.util.Scanner;
import java.text.DecimalFormat;

public class cbLogic {

	//Instance variables
	private double boxWidth;
	private double boxHeight;
	private double boxLength;
	private int cardGrade;
	private boolean boxSealableTops;
	private int boxQuantity;
	private int boxColour;
	private boolean boxReinforcedBottom;
	private boolean boxReinforcedCorner;

	private boolean success = true;
	private boolean quit = false;
	static Scanner userOrderInput = new Scanner(System.in);
	static Scanner userMenuInput = new Scanner(System.in);
	
	cbBoxOrderList orderList = new cbBoxOrderList();
	CardBoardBox boxType;
	
	//Main Menu method
	public void mainMenu() {

		orderList.addcbBoxOrderDetails(new cbBoxOrderDetails());
		
		int mainMenu;

		System.out.println("\t\tWelcome to FlexBox company\n");
		System.out.println("\t\t-------------------------\n");

		do {

			System.out.println("Main Menu");
				System.out
						.println("--------------------------------------------------------");
				System.out.println("1. Enter 1 to order and create a cardboard box.");
				System.out.println("2. Enter 2 to verify the order details.");
				System.out.println("3. Enter 3 to add order to the cart.");
				System.out.println("4. Enter 4 to create another cardboard box.");
				System.out.println("5. Enter 5 to remove order from cart.");
				System.out.println("6. Enter 6 to checkout and display the order details.");
				System.out.println("7. Enter 7 to Exit the program.");
				System.out
						.println("--------------------------------------------------------");

			mainMenu = userMenuInput.nextInt();

			switch (mainMenu) {
			case 1:
				getUserDetails();
				break;
			case 2:
				checkUserDetails();
				break;
			case 3:
				addOrderToList();
				break;
			case 4:
				getUserDetails();
				break;
			case 5:
				removeOrderFromList();
				break;
			case 6:
				displayOrderDetails();
				break;
			case 7:
				System.out.println("Program is closed.");
				quit = true;
				break;

			default:
				System.out.println("Please choose from the specified options.");
				continue;
				
			}
		} while (!quit);

	}// end of mainMenu method
	
	//Get User Details method
	public void getUserDetails() {
		
		System.out.println("Enter box dimension");

		System.out.println("Enter width:");
		this.boxWidth = userOrderInput.nextDouble();

		System.out.println("Enter height:");
		this.boxHeight = userOrderInput.nextDouble();

		System.out.println("Enter length:");
		this.boxLength = userOrderInput.nextDouble();

		System.out.println("Enter grade:");
		this.cardGrade = userOrderInput.nextInt();

		System.out.println("Would you like Sealable Tops - Enter [yes]or[no]:");
		String st = userOrderInput.next();

		if (st.equals("yes")) {
			this.boxSealableTops = true;
		} else if (st.equals("no")) {
			this.boxSealableTops = false;
		} else {

		}

		System.out.println("Enter quantity:");
		this.boxQuantity = userOrderInput.nextInt();

		System.out.println("Enter amount of colours - Enter [0]or[1]or[2]:");
		this.boxColour = userOrderInput.nextInt();

		if (this.boxColour == 1) {
			this.boxColour = 1;
		} else if (this.boxColour == 2) {
			this.boxColour = 2;
		} else {

		}

		System.out
				.println("Would you like Reinforced Bottom - Enter [yes]or[no]:");
		String rb = userOrderInput.next();
		if (rb.equals("yes")) {

			this.boxReinforcedBottom = true;
		} else if (rb.equals("no")) {

			this.boxReinforcedBottom = false;
		} else {

		}
		System.out
				.println("Woud you like Reinforced Corners - Enter [yes]or[no]:");
		String rc = userOrderInput.next();

		if (rc.equals("yes")) {
			this.boxReinforcedCorner = true;
		} else if (rc.equals("no")) {

			this.boxReinforcedCorner = false;
		} else {

		}
		
}
	//Check User Details method
	public boolean checkUserDetails() {

		// type I
		if (this.boxWidth > 0 &
			this.boxHeight > 0 &
			this.boxLength > 0 &
			(
			this.cardGrade >= 1 & 
			this.cardGrade <= 3) & 
			this.boxColour == 0 &
			this.boxQuantity > 0 &  
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
		else if (
			this.boxWidth > 0 &
			this.boxHeight > 0 &
			this.boxLength > 0 &
			(
			this.cardGrade >= 2 & 
			this.cardGrade <= 4)& 
			this.boxColour == 1 & 
			this.boxQuantity > 0 &  
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
		else if (
			this.boxWidth > 0 &
			this.boxHeight > 0 &
			this.boxLength > 0 &
			(
			this.cardGrade >= 2 & 
			this.cardGrade <= 5)& 
			this.boxColour == 2 &
			this.boxQuantity > 0 &   
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
		else if (
			this.boxWidth > 0 &
			this.boxHeight > 0 &
			this.boxLength > 0 &
			(
			this.cardGrade >= 2 & 
			this.cardGrade <= 5)& 
			this.boxColour == 2 &
			this.boxQuantity > 0 &   
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
		else if (
			this.boxWidth > 0 &
			this.boxHeight > 0 &
			this.boxLength > 0 &
			(
			this.cardGrade >= 3 & 
			this.cardGrade <= 5)& 
			this.boxColour == 2 &
			this.boxQuantity > 0 &   
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

		}else {
			this.success = true;
			System.out.println("Order cannot be supplied by FlexBox");
		}
		if (!this.success) {

			System.out.println("Order can be supplied by FlexBox");
		}
		return this.success;

	}
	//Add Order to List method
	public void addOrderToList() {	

		if (!checkUserDetails()) {
			orderList.listOfOrders.get(orderList.orderListQuantity() - 1).addcbBox(
					boxType);

			System.out.println("Order is added to the cart.");

		} else {
			System.out.println("Order cannot be supplied by FlexBox");
		}

	}
	//Remove Order From List method
	public void removeOrderFromList() {

		int orderListQuantity = orderList.orderListQuantity();
		if (orderList.listOfOrders.get(orderListQuantity - 1).boxListQuantity() >= 1) {

			orderList.listOfOrders.get(orderList.orderListQuantity()-1).clearOrderDetails();
			System.out.println("Order removed from cart.");
		} else {
			System.out.println("There are no orders in the cart.");
		}

	}
	//Display Order Details method
	public void displayOrderDetails() {
		
		System.out.println("Order Details:" + "\n");

		int orderListQuantity = orderList.orderListQuantity();
		int boxListQuantity = orderList.listOfOrders.get(orderListQuantity - 1).boxListQuantity();
		String totalPrice = orderList.listOfOrders.get(orderListQuantity - 1).wholePrice();
		
		if (orderList.listOfOrders.get(orderListQuantity - 1).boxListQuantity() >= 1) {

			orderList.getOrderList();
			
			System.out.println("Summary: " + "\n" + "Quantity of Box Types: " + boxListQuantity +  "\n" + "Total Order Price: " + totalPrice);
		
		} else {
			System.out.println("There are no orders in the cart.");
		}
		
		orderList.listOfOrders.get(orderList.orderListQuantity() - 1)
					.clearOrderDetails();
		orderList.addcbBoxOrderDetails(new cbBoxOrderDetails());

	}

}// end of cbLogic class

