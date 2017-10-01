import java.util.Scanner; 
public class CashRegister {
	
	final static int _100_DOLLARS = 10000;
	final static int FIFTY_DOLLARS = 5000; 
	final static int TWENTY_DOLLARS = 2000; 
	final static int TEN_DOLLARS = 1000; 
	final static int FIVE_DOLLARS = 500; 
	final static int DOLLARS = 100; 
	final static int QUARTERS = 25; 
	final static int DIMES = 10; 
	final static int NICKELS = 5; 
	final static int PENNIES = 1; 
	
	static int  total_100_Dollars = 0;
	static int total_Fifty_Dollars = 0;
	static int total_TwentyDollars = 0;
	static int total_TenDollars = 0;
	static int total_FiveDollars = 0;
	static int total_Dollars = 0;
	static int total_Quarters = 0;
	static int total_Dimes = 0;
	static int total_Nickels = 0;
	static int total_Pennies = 0; 
	
	static boolean notEnough = false;
	static boolean nextPurchase = true; 
	
	public static void main(String[] args) {
		
		double itemPrice = 0, customerTendered = 0; 
		Scanner input = new Scanner(System.in);
		
		while(nextPurchase) {
				//Console inputs/outputs
				System.out.print("What is the price of the item : " );
				System.out.print("\n >>");
				itemPrice = input.nextDouble();
				System.out.print("\n Enter your amount tendered:  \n >>" );
				customerTendered = input.nextDouble(); 
				
				VerifyTendered(itemPrice, customerTendered); 
				
				if(notEnough) {
					continue; 
				}
				
				ChangeMaker(itemPrice, customerTendered);
				System.out.println();
				NextPurchase();
		}
		input.close();
	}
	
	public static void VerifyTendered(double itemPrice, double amountTendered) {
		if(amountTendered < itemPrice) {
			System.out.println("The amount tendered: " + System.out.printf("%.2f",amountTendered)+ " is not enough for the " + System.out.printf("%.2f", itemPrice));
			notEnough = true; 
		}
		else if(amountTendered == itemPrice) {
			System.out.println("The amount tendered: " + System.out.printf("$.2f", amountTendered) + " is the exact price of " + System.out.printf("%.2f",  itemPrice));
		}
		else {
			System.out.print("....working Returning Change: $" );
			System.out.printf("%.2f", amountTendered - itemPrice );
			System.out.println();
			notEnough = false; 			
		}
	}
	
	public static void ChangeMaker(double itemPrice, double customerTendered) {
		//convert to pennies

		
		double convertedTendered =  customerTendered * 100; 
		double convertedItemPrice =itemPrice * 100; 
		double changeReturnedInPennies = convertedTendered - convertedItemPrice;
		
		
		total_100_Dollars = (int)changeReturnedInPennies / _100_DOLLARS;
		changeReturnedInPennies = changeReturnedInPennies -(total_100_Dollars * _100_DOLLARS);
		
		total_Fifty_Dollars = (int) changeReturnedInPennies / FIFTY_DOLLARS;
		changeReturnedInPennies = changeReturnedInPennies - (total_Fifty_Dollars * FIFTY_DOLLARS);
		
		total_TwentyDollars = (int) changeReturnedInPennies / TWENTY_DOLLARS; 
		changeReturnedInPennies = changeReturnedInPennies - (total_TwentyDollars * TWENTY_DOLLARS);
		
		total_TenDollars = (int) changeReturnedInPennies / TEN_DOLLARS; 
		changeReturnedInPennies = changeReturnedInPennies - (total_TenDollars * TEN_DOLLARS);
		
		total_FiveDollars = (int) changeReturnedInPennies / FIVE_DOLLARS; 
		changeReturnedInPennies = changeReturnedInPennies - (total_FiveDollars * FIVE_DOLLARS);
		
		total_Dollars= (int) changeReturnedInPennies / DOLLARS; 
		changeReturnedInPennies = changeReturnedInPennies - (total_Dollars * DOLLARS);
		
		total_Quarters = (int) changeReturnedInPennies / QUARTERS; 
		changeReturnedInPennies = changeReturnedInPennies - ( total_Quarters* QUARTERS);
		
		total_Dimes = (int) changeReturnedInPennies / DIMES; 
		changeReturnedInPennies = changeReturnedInPennies - (total_Dimes * DIMES);
		
		total_Nickels = (int) changeReturnedInPennies / NICKELS; 
		changeReturnedInPennies = changeReturnedInPennies - (total_Nickels * NICKELS);
		
		total_Pennies = (int) changeReturnedInPennies / PENNIES; 
		changeReturnedInPennies = changeReturnedInPennies - (total_Pennies * PENNIES);
		
		if(total_100_Dollars >0) {
			DisplayChange("100 Dollars: ", total_100_Dollars);
		}
		if(total_Fifty_Dollars > 0) {
			DisplayChange("50 Dollars: ", total_Fifty_Dollars);
		}
		if(total_TwentyDollars > 0) {
			DisplayChange("20 Dollars: ", total_TwentyDollars);
		}
		if(total_TenDollars >0) {
			DisplayChange("10 Dollars: ", total_TenDollars);
		}
		if(total_FiveDollars > 0) {
			DisplayChange("5 Dollars: ", total_FiveDollars);
		}
		if(total_Dollars >0) {
			DisplayChange("Dollars: ", total_Dollars);
		}
		if(total_Quarters > 0) {
			DisplayChange("Quarters: ", total_Quarters);
		}
		if(total_Dimes > 0) {
			DisplayChange("Dimes: ", total_Dimes);
		}
		if(total_Nickels > 0) {
			DisplayChange("Nickels: ", total_Nickels);
		}
		if(total_Pennies >0) {
			DisplayChange("Pennies: ", total_Pennies); 
		}
	}
	public static void DisplayChange(String name, int count) {
		
		System.out.print(name  + " "+ count + "\t");
	}
	
	public static void NextPurchase() {
		String choice; 
		Scanner input  = new Scanner(System.in); 
		System.out.print("Next purchase? Enter Y to continue: \n >>");
		choice = input.next(); 
		choice = choice.toUpperCase(); 
		
		
		if(choice.charAt(0) == 'Y') {
			nextPurchase = true; 
		    total_100_Dollars = 0;
			total_Fifty_Dollars = 0;
			total_TwentyDollars = 0;
			total_TenDollars = 0;
			total_FiveDollars = 0;
			total_Dollars = 0;
			total_Quarters = 0;
			total_Dimes = 0;
			total_Nickels = 0;
			total_Pennies = 0; 
		}
		else {
			input.close();
			System.out.println("Goodbye!");
			nextPurchase = false; 
		}
	}
}