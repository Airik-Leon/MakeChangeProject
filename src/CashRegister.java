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
	final static int PENNYS = 1; 
	
	static int  total_100_Dollars = 0;
	static int total_Fifty_Dollars = 0;
	static int total_TwentyDollars = 0;
	static int total_TenDollars = 0;
	int total_FiveDollars = 0;
	static int total_Dollars = 0;
	static int total_Quarters = 0;
	static int total_Dimes = 0;
	static int total_Nickels = 0;
	static int total_Pennys = 0; 

	public static void main(String[] args) {
		double itemPrice, customerTendered; 
		Scanner input = new Scanner(System.in);
		
		//Console inputs/outputs
		System.out.print("What is the price of the item : " );
		System.out.print("\n >>");
		itemPrice = input.nextDouble();
		System.out.print("\n Enter your amount tendered:  \n >>" );
		customerTendered = input.nextDouble(); 
	
		VerifyTendered(itemPrice, customerTendered); 
		
	}
	public static void VerifyTendered(double itemPrice, double amountTendered) {
		if(amountTendered < itemPrice) {
			System.out.println("The amount tendered: " + amountTendered + " is not enough for the " + itemPrice);
			return; 
		}
		else if(amountTendered == itemPrice) {
			System.out.println("The amount tendered: " + amountTendered + " is the exact price of " + itemPrice);
		}
		else {}
	}
	public static void changeMaker(double itemPrice, double amountTendered) {
		//convert to pennies

		
		int convertedTendered = (int) amountTendered * 100; 
		int convertedItemPrice =(int) itemPrice * 100; 
		int changeReturnedInPennies = convertedTendered - convertedItemPrice; 
		
		while(changeReturnedInPennies >0) {
			if( changeReturnedInPennies % _100_DOLLARS == 0 ) {
				total_100_Dollars++; 
				continue;
			}
			else if(changeReturnedInPennies  %  FIFTY_DOLLARS ==0) {
				total_Fifty_Dollars++;
				continue;
			}
			else if(changeReturnedInPennies % TWENTY_DOLLARS ==0) {
				total_TwentyDollars++; 
				continue;
			}
			else if(changeReturnedInPennies % TEN_DOLLARS ==0) {
				total_TenDollars++; 
				continue;
			}
			else if(changeReturnedInPennies % FIVE_DOLLARS ==0) {
				total_Fifty_Dollars++; 
				continue; 
			}
			else if(changeReturnedInPennies % DOLLARS == 0) {
				total_Dollars++; 
				continue; 
			}
			else if(changeReturnedInPennies % QUARTERS ==0) {
				total_Quarters++; 
				continue; 
			}
			else if(changeReturnedInPennies % DIMES ==0) {
				total_Dimes++; 
				continue; 
			}
			else if(changeReturnedInPennies % NICKELS ==0) {
				total_Nickels++; 
				continue;
			}
			else if(changeReturnedInPennies % PENNYS ==0) {
				total_Pennys++; 
				continue; 
			}
		}
	}
}









