import java.text.DecimalFormat;

//Class Box
abstract class Box {
	
	//Instance variables
	private double boxWidth;
	private double boxHeight;
	private double boxLength;
	private int boxQuantity;

	public abstract String name();
	
	//Get and Set Methods
	public double getBoxWidth() {
		return boxWidth;
	}

	public void setBoxWidth(double boxWidth) {
		this.boxWidth = boxWidth;
	}

	public double getBoxHeight() {
		return boxHeight;
	}

	public void setBoxHeight(double boxHeight) {
		this.boxHeight = boxHeight;
	}

	public double getBoxLength() {
		return boxLength;
	}

	public void setBoxLength(double boxLength) {
		this.boxLength = boxLength;
	}


	public int getBoxQuantity() {
		return boxQuantity;
	}

	public void setBoxQuantity(int boxQuantity) {
		this.boxQuantity = boxQuantity;
	}

}

//Class CardBoardBox
abstract class CardBoardBox extends Box {

	public String name() {
		return "CardBoardBox";
	}
	
	abstract public double calculatePrice();
	
	//Instance variables
	private int cardGrade;
	private double priceOfGrade;
	private double boxSurfaceArea;
	private boolean boxSealableTops;
	private int boxColour;
	private boolean boxReinforcedBottom;
	private boolean boxReinforcedCorner;

	final double cardGradeOne = 0.45;
	final double cardGradeTwo = 0.59;
	final double cardGradeThree = 0.68;
	final double cardGradeFour = 0.92;
	final double cardGradeFive = 1.30;
	
	abstract public String cbBoxType();
	
	//Constructor method
	public CardBoardBox() {

		setBoxWidth(0);
		setBoxHeight(0);
		setBoxLength(0);
		setCardGrade(0);
		setBoxQuantity(0);
		boxColour = 0;
	}

	public CardBoardBox(double boxWidth, double boxHeight, double boxLength,
			int cardGrade, boolean boxSealableTops, int boxQuantity,
			int boxColour, boolean boxReinforcedBottom,
			boolean boxReinforcedCorner) {

		this.setBoxWidth(boxWidth);
		this.setBoxHeight(boxHeight);
		this.setBoxLength(boxLength);
		this.setCardGrade(cardGrade);
		this.boxSealableTops = boxSealableTops;
		this.setBoxQuantity(boxQuantity);
		this.boxColour = boxColour;
		this.priceOfGrade = priceOfGrade(cardGrade);
		this.boxSurfaceArea = boxSurfaceArea();
		this.boxReinforcedBottom = boxReinforcedBottom;
		this.boxReinforcedCorner = boxReinforcedCorner;
	}
	
	
	//Workout box surface area
	public double boxSurfaceArea() {

		boxSurfaceArea = 2 *(getBoxLength() * getBoxHeight()) +  2 *(getBoxWidth() * getBoxHeight()) + (getBoxLength() * getBoxWidth());
		
		return boxSurfaceArea;

	}
	
	//Switch to grade of card 
	public double priceOfGrade(int cardGrade) {
		switch (cardGrade) {
		case 1:
			priceOfGrade = cardGradeOne;
			break;
		case 2:
			priceOfGrade = cardGradeTwo;
			break;
		case 3:
			priceOfGrade = cardGradeThree;
			break;
		case 4:
			priceOfGrade = cardGradeFour;
			break;
		case 5:
			priceOfGrade = cardGradeFive;
			break;
		}
		return priceOfGrade;
	}
	
	//Workout original price
	public double originalPrice() {

		double originalPrice = priceOfGrade * boxSurfaceArea;
		return originalPrice;
	}

	//Workout total price including the additional costs
	public double wholePrice() {

		double wholePrice = calculatePrice() * getBoxQuantity();

		wholePrice = Double.parseDouble(new DecimalFormat("0.00")
				.format(wholePrice));
		return wholePrice;

	}
	
	//Get and Set Methods
	public int getCardGrade() {
		return cardGrade;
	}

	public void setCardGrade(int cardGrade) {
		this.cardGrade = cardGrade;
	}

	public boolean getBoxSealableTops() {
		return this.boxSealableTops;
	}

	public void setBoxSealableTops(boolean boxSealableTops) {
		this.boxSealableTops = boxSealableTops;
	}

	public int getBoxColour() {
		return this.boxColour;
	}

	public void setBoxColour(int boxColour) {
		this.boxColour = boxColour;
	}

	public boolean getBoxReinforcedBottom() {
		return this.boxReinforcedBottom;
	}

	public void setBoxReinforcedBottom(boolean boxReinforcedBottom) {
		this.boxReinforcedBottom = boxReinforcedBottom;
	}

	public boolean getBoxReinforcedCorner() {
		return this.boxReinforcedCorner;
	}

	public void setBoxReinforcedCorner(boolean boxReinforcedCorner) {
		this.boxReinforcedCorner = boxReinforcedCorner;
	}
	
	//Print box dimensions. 
	public String boxDimensions() {
		return "Box Type: " + name() + "\n" +
			   "Dimension: " + "\n" + 
			   "Width: " + 
			   getBoxWidth() + "\n" + 
			   "Height: " + 
			   getBoxHeight() + 
			   "\n" + "Length: " + 
			   getBoxLength();
	}

}


//Type One class

class cbTypeOne extends CardBoardBox {
	
	//Instance variables
	private double extraCost = 0.05;
	private double addExtraCost;
	
	//Constructor method
	public cbTypeOne(double boxWidth, double boxHeight, double boxLength,
			int cardGrade, boolean boxSealableTops, int boxQuantity,
			int boxColour, boolean boxReinforcedBottom,
			boolean boxReinforcedCorner) {

		super(boxWidth, boxHeight, boxLength, cardGrade, boxSealableTops,
				boxQuantity, boxColour, boxReinforcedBottom,
				boxReinforcedCorner);

		if (this.getBoxSealableTops()) {
			setAddExtraCost(findPercentage());
		}

	}
	
	//Return box type 
	public String cbBoxType() {
		return "I";

	}
	//Find additional cost percentages. 
	public double findPercentage() {
		double findPercentage = extraCost * originalPrice();
		return findPercentage;
	}
	
	public void setAddExtraCost(double addExtraCost) {
		this.addExtraCost = addExtraCost;
	}

	public double getAddExtraCost() {

		return addExtraCost;
	}
	
	//Add additional cost to original price
	public double calculatePrice() {
		return originalPrice() + getAddExtraCost();

	}

	
}

//Type two class
class cbTypeTwo extends CardBoardBox {
	
	//Instance variables
	private double extraCost = 0.05;
	private double addExtraCost;
	private double oneColour = 0.12;
	
	//Constructor method
	public cbTypeTwo(double boxWidth, double boxHeight, double boxLength,
			int cardGrade, boolean boxSealableTops, int boxQuantity,
			int boxColour, boolean boxReinforcedBottom,
			boolean boxReinforcedCorner) {

		super(boxWidth, boxHeight, boxLength, cardGrade, boxSealableTops,
				boxQuantity, boxColour, boxReinforcedBottom,
				boxReinforcedCorner);

		if (this.getBoxSealableTops()) {
			setAddExtraCost(findPercentage());
		}
		if (this.getBoxColour() == 1) {
			setAddExtraCost(findPercentage2());
		}
		if (this.getBoxSealableTops() & this.getBoxColour() == 1) {
			setAddExtraCost(findPercentage3());
		}

	}
	
	//Return box type 
	public String cbBoxType() {
		return "II";

	}

	public void setAddExtraCost(double addExtraCost) {
		this.addExtraCost = addExtraCost;
	}

	public double getAddExtraCost() {

		return addExtraCost;
	}
	
	//Find additional cost percentages. 
	public double findPercentage() {
		double findPercentage = (extraCost) * originalPrice();
		return findPercentage;
	}

	public double findPercentage2() {
		double findPercentage2 = (oneColour) * originalPrice();
		return findPercentage2;

	}

	public double findPercentage3() {
		double findPercentage3 = (extraCost + oneColour) * originalPrice();
		return findPercentage3;
	}
	
	//Add additional cost to original price
	public double calculatePrice() {

		return originalPrice() + getAddExtraCost();

	}

	

}

//Type Three class
class cbTypeThree extends CardBoardBox {
	
	//Instance variables
	private double extraCost = 0.05;
	private double addExtraCost;
	private double twoColour = 0.15;
	
	//Constructor method
	public cbTypeThree(double boxWidth, double boxHeight, double boxLength,
			int cardGrade, boolean boxSealableTops, int boxQuantity,
			int boxColour, boolean boxReinforcedBottom,
			boolean boxReinforcedCorner) {

		super(boxWidth, boxHeight, boxLength, cardGrade, boxSealableTops,
				boxQuantity, boxColour, boxReinforcedBottom,
				boxReinforcedCorner);

		if (this.getBoxSealableTops()) {
			setAddExtraCost(findPercentage1());
		}

		if (this.getBoxColour() == 2) {
			setAddExtraCost(findPercentage2());
		}

		if (this.getBoxSealableTops() & this.getBoxColour() == 2) {
			setAddExtraCost(findPercentage3());
		}

	}
	
	//Return box type
	public String cbBoxType() {
		return "III";

	}

	public void setAddExtraCost(double addExtraCost) {
		this.addExtraCost = addExtraCost;
	}

	public double getAddExtraCost() {

		return addExtraCost;
	}
	
	//Find additional cost percentages. 
	public double findPercentage1() {
		double findPercentage1 = (extraCost) * originalPrice();
		return findPercentage1;
	}

	public double findPercentage2() {
		double findPercentage2 = (twoColour) * originalPrice();
		return findPercentage2;
	}

	public double findPercentage3() {
		double findPercentage3 = (extraCost + twoColour) * originalPrice();
		return findPercentage3;
	}
	
	//Add additional cost to original price

	public double calculatePrice() {

		return originalPrice() + getAddExtraCost();

	}

	

}

//Type four class
class cbTypeFour extends CardBoardBox {
	
	//Instance variables
	private double extraCost = 0.05;
	private double addExtraCost;
	private double twoColour = 0.15;
	private double rBottom = 0.10;
	
	
	//Constructor method
	public cbTypeFour(double boxWidth, double boxHeight, double boxLength,
			int cardGrade, boolean boxSealableTops, int boxQuantity,
			int boxColour, boolean boxReinforcedBottom,
			boolean boxReinforcedCorner) {

		super(boxWidth, boxHeight, boxLength, cardGrade, boxSealableTops,
				boxQuantity, boxColour, boxReinforcedBottom,
				boxReinforcedCorner);

		if (this.getBoxSealableTops()) {
			setAddExtraCost(findPercentage1());
		}

		if (this.getBoxColour() == 2) {
			setAddExtraCost(findPercentage2());
		}

		if (this.getBoxSealableTops() & this.getBoxColour() == 2) {
			setAddExtraCost(findPercentage3());
		}

		if (this.getBoxReinforcedBottom() & this.getBoxColour() == 2) {
			setAddExtraCost(findPercentage4());
		}

		if (this.getBoxSealableTops() & this.getBoxColour() == 2
				& this.getBoxReinforcedBottom()) {
			setAddExtraCost(findPercentage5());
		}

	}
	//Return box type
	public String cbBoxType() {
		return "IV";

	}


	public void setAddExtraCost(double addExtraCost) {
		this.addExtraCost = addExtraCost;
	}

	public double getAddExtraCost() {

		return addExtraCost;
	}
	//Find additional cost percentages. 
	public double findPercentage1() {
		double findPercentage1 = (extraCost) * originalPrice();
		return findPercentage1;
	}

	public double findPercentage2() {
		double findPercentage2 = (twoColour) * originalPrice();
		return findPercentage2;
	}

	public double findPercentage3() {
		double findPercentage3 = (extraCost + twoColour) * originalPrice();
		return findPercentage3;
	}

	public double findPercentage4() {
		double findPercentage4 = (twoColour + rBottom) * originalPrice();
		return findPercentage4;
	}

	public double findPercentage5() {
		double findPercentage5 = (twoColour + rBottom) * originalPrice();
		return findPercentage5;
	}
	//Add additional cost to original price
	public double calculatePrice() {

		return originalPrice() + getAddExtraCost();

	}

	
}

//Type Five class
class cbTypeFive extends CardBoardBox {
	
	//Instance variables
	private double extraCost = 0.05;
	private double addExtraCost;
	private double twoColour = 0.15;
	private double rBottom = 0.10;
	private double rCorner = 0.07;
	
	//Constructor method
	public cbTypeFive(double boxWidth, double boxHeight, double boxLength,
			int cardGrade, boolean boxSealableTops, int boxQuantity,
			int boxColour, boolean boxReinforcedBottom,
			boolean boxReinforcedCorner) {

		super(boxWidth, boxHeight, boxLength, cardGrade, boxSealableTops,
				boxQuantity, boxColour, boxReinforcedBottom,
				boxReinforcedCorner);

		if (this.getBoxSealableTops()) {
			setAddExtraCost(findPercentage1());
		}

		if (this.getBoxColour() == 2) {
			setAddExtraCost(findPercentage2());
		}

		if (this.getBoxSealableTops() & this.getBoxColour() == 2) {
			setAddExtraCost(findPercentage3());
		}

		if (this.getBoxReinforcedBottom() & this.getBoxColour() == 2) {
			setAddExtraCost(findPercentage5());
		}

		if (this.getBoxSealableTops() & this.getBoxColour() == 2
				& this.getBoxReinforcedBottom()) {
			setAddExtraCost(findPercentage4());
		}

		if (this.getBoxColour() == 2 & this.getBoxReinforcedBottom()
				& this.getBoxReinforcedCorner()) {
			setAddExtraCost(findPercentage6());
		}

		if (this.getBoxSealableTops() & this.getBoxColour() == 2
				& this.getBoxReinforcedBottom() & this.getBoxReinforcedCorner()) {
			setAddExtraCost(findPercentage7());
		}

	}
	//Return box type
	public String cbBoxType() {
		return "V";

	}

	public void setAddExtraCost(double addExtraCost) {
		this.addExtraCost = addExtraCost;
	}

	public double getAddExtraCost() {

		return addExtraCost;
	}
	//Find additional cost percentages. 
	public double findPercentage1() {
		double findPercentage1 = (extraCost) * originalPrice();
		return findPercentage1;
	}

	public double findPercentage2() {
		double findPercentage2 = (twoColour) * originalPrice();
		return findPercentage2;
	}

	public double findPercentage3() {
		double findPercentage3 = (extraCost + twoColour) * originalPrice();
		return findPercentage3;
	}

	public double findPercentage4() {
		double findPercentage4 = (extraCost + twoColour + rBottom)
				* originalPrice();
		return findPercentage4;
	}

	public double findPercentage5() {
		double findPercentage5 = (twoColour + rBottom) * originalPrice();
		return findPercentage5;
	}

	public double findPercentage6() {
		double findPercentage6 = (twoColour + rBottom + rCorner)
				* originalPrice();
		return findPercentage6;
	}

	public double findPercentage7() {
		double findPercentage7 = (extraCost + twoColour + rBottom + rCorner)
				* originalPrice();
		return findPercentage7;
	}
	//Add additional cost to original price
	public double calculatePrice() {

		return originalPrice() + getAddExtraCost();

	}

	

}
