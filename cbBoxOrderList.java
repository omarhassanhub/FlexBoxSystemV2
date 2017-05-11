import java.util.ArrayList;
import java.util.Random;

public class cbBoxOrderList {
	//Generate random number
	Random generateID = new Random();
	//Arraylist of Orders
	public ArrayList<cbBoxOrderDetails> listOfOrders = new ArrayList<cbBoxOrderDetails>();
	//Add order to arraylist
	public void addcbBoxOrderDetails(cbBoxOrderDetails l) {
		listOfOrders.add(l);
	}
	//Get order number and customer id
	public void getOrderList() {
		int orderCounter = 1;
		int i;
		int IDCounter = 1;
		int c;

		for (i = 0; i < listOfOrders.size(); i++) {

			System.out
					.println("Customer ID: " + "FB" + generateID.nextInt(500) + "\tOrder Number: " + "CB92" + orderCounter);

			listOfOrders.get(i).getOrderDetails();
			IDCounter++;
			orderCounter++;

		}
	}

	//Get Order List Quantity
	public int orderListQuantity() {
		for (int i = 0; i < listOfOrders.size(); i++) {

		}
		return this.listOfOrders.size();
	}
	//Get Customer ID
	public int getCustomerList() {

		int i;
		for (i = 0; i < listOfOrders.size(); i++) {

		}
		return this.generateID.nextInt(500);

	}

}