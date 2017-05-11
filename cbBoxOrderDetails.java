import java.util.ArrayList;
import java.text.DecimalFormat;

public class cbBoxOrderDetails {
	
	//Arraylist of Boxes
	public ArrayList<CardBoardBox> ListOfBoxes = new ArrayList<CardBoardBox>();
	
	//Add box to arraylist
	public void addcbBox(CardBoardBox l) {
		ListOfBoxes.add(l);

	}
	//Print order details
	public void getOrderDetails() {
		int boxCounter = 1;
		int i;
		for (i = 0; i < ListOfBoxes.size(); i++) {
			System.out.println("\nBox: " + boxCounter);

			getBoxDimension(i);
			getBoxSurfaceArea(i);
			getCardGrade(i);
			getBoxColour(i);
			getBoxReinforcedBottom(i);
			getBoxReinforcedCorner(i);
			getBoxSealableTops(i);
			getBoxQuantity(i);
			getCbBoxType(i);
			getCalculatePrice(i);
			getWholePrice(i);

			boxCounter++;
		}
	}
	
	//Get box quantity
	public int getBoxQuantity(int i) {
		int boxQuantity = 0;

		boxQuantity = ListOfBoxes.get(i).getBoxQuantity();
		System.out.println("Quanity: " + boxQuantity);

		return boxQuantity;
	}
	//Get Box Surface Area
	public double getBoxSurfaceArea(int i) {
		double boxSurfaceArea = 0.0;
		String boxSurfaceAreaString;
		boxSurfaceArea = ListOfBoxes.get(i).boxSurfaceArea();
		
		boxSurfaceAreaString = new DecimalFormat("0.00"+"m2")
		.format(boxSurfaceArea);
		
		System.out.println("Box Surface Area (Square metre): " + boxSurfaceAreaString);

		return boxSurfaceArea;
	}
	//Get Price per box
	public double getCalculatePrice(int i) {
		double calculatePrice = 0.0;
		String calculatePriceString;
		
		calculatePrice = ListOfBoxes.get(i).calculatePrice();
		
		calculatePriceString = new DecimalFormat("'£'0.00")
				.format(calculatePrice);
		System.out.println("Price per box: " + calculatePriceString);
		return calculatePrice;
	}
	//Get Total Price
	public double getWholePrice(int i) {
		double wholePrice = 0.0;
		String wholePriceString;
		
		wholePrice = ListOfBoxes.get(i).wholePrice();
		
		wholePriceString = new DecimalFormat("'£'0.00").format(wholePrice);
		System.out.println("Total Price: " + wholePriceString + "\n");

		return wholePrice;
	}
	//Get Box Dimensions
	public String getBoxDimension(int i) {
		String boxDimension = "";

		boxDimension = ListOfBoxes.get(i).boxDimensions();
		System.out.println(boxDimension);

		return boxDimension;
	}
	
	
	//Get Box Type
	public String getCbBoxType(int i) {
		String cbBoxType = "";

		cbBoxType = ListOfBoxes.get(i).cbBoxType();
		System.out.println("Type: " + cbBoxType);

		return cbBoxType;
	}

	public int getCardGrade(int i) {
		int cardGrade = 0;

		cardGrade = ListOfBoxes.get(i).getCardGrade();
		System.out.println("Grade: " + cardGrade);

		return cardGrade;
	}
	//Get Sealable Top
	public boolean getBoxSealableTops(int i) {
		boolean boxSealableTops;

		boxSealableTops = ListOfBoxes.get(i).getBoxSealableTops();
		if(boxSealableTops == true)
		{
			System.out.println("Sealable Top: " + "Yes");
		}else{
			System.out.println("Sealable Top: " + "No");
		}
		return boxSealableTops;
	}
	//Get Box Colour
	public int getBoxColour(int i) {
		int boxColour;

		boxColour = ListOfBoxes.get(i).getBoxColour();
		System.out.println("Box Colour: " + boxColour);

		return boxColour;
	}
	//Get Box Reinforced Bottom
	public boolean getBoxReinforcedBottom(int i) {
		boolean boxReinforcedBottom;

		boxReinforcedBottom = ListOfBoxes.get(i).getBoxReinforcedBottom();
		if(boxReinforcedBottom == true)
		{
			System.out.println("Box Reinforced Bottom: " + "Yes");
		}else{
			System.out.println("Box Reinforced Bottom: " + "No");
		}
		return boxReinforcedBottom;
	}
	//Get Box Reinforced Corner
	public boolean getBoxReinforcedCorner(int i) {
		boolean boxReinforcedCorner;

		boxReinforcedCorner = ListOfBoxes.get(i).getBoxReinforcedCorner();
		if(boxReinforcedCorner == true)
		{
			System.out.println("Box Reinforced Corner: " + "Yes");
		}else{
			System.out.println("Box Reinforced Corner: " + "No");
		}
		return boxReinforcedCorner;
	}

	//Get Whole Price
	public String wholePrice(){
        double totalPrice = 0;
        for (int i = 0; i < ListOfBoxes.size(); i++) {
        	totalPrice = totalPrice + 
        	ListOfBoxes.get(i).wholePrice();
        }
        String totalPriceS;
        totalPriceS=new DecimalFormat("'£'0.00").format(totalPrice);
        return totalPriceS;
    }
	
	//Get Current List of Boxes
	public int boxListQuantity() {

		for (int i = 0; i < ListOfBoxes.size(); i++) {

		}
		return this.ListOfBoxes.size();
	}
	//Clear Order Details
	public void clearOrderDetails() {

		for (int i = 0; i < ListOfBoxes.size(); i++) {

			this.ListOfBoxes.clear();

		}
		

	}

	
	//Get Box Type and Quantity
	public String getExistingBoxes() {
		String cbBoxType = "";
		int boxQuantity = 0;
		String orderListDetails = "";
		int boxCounter = 1;

		for (int i = 0; i < ListOfBoxes.size(); i++) {

			boxQuantity = ListOfBoxes.get(i).getBoxQuantity();
			cbBoxType = ListOfBoxes.get(i).cbBoxType();
			
			orderListDetails = orderListDetails + 
			"[Box: " + 
			boxCounter + "]"
			+ "\n" + 
			"[Type: " + 
			cbBoxType + 
			"]" + 
			"\n" + 
			"[Qty:"
			+ boxQuantity + "]";

			boxCounter++;
		}
		System.out.println(orderListDetails);
		return orderListDetails;

	}

}