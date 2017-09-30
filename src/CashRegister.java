import java.util.InputMismatchException;
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
			try {
				//Console inputs/outputs
				System.out.print("What is the price of the item : " );
				System.out.print("\n >>");
				itemPrice = input.nextDouble();
				System.out.print("\n Enter your amount tendered:  \n >>" );
				customerTendered = input.nextDouble(); 
			}
			catch(InputMismatchException e) {
				System.out.print("Values must be in decimal format. Example: 3.24");
				
			}
			finally {
				
				VerifyTendered(itemPrice, customerTendered); 
				
				if(notEnough) {
					continue; 
				}
				
				ChangeMaker(itemPrice, customerTendered);
				DisplayChange();	
				NextPurchase();
			}
		}
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
			System.out.print("....working Returning Change: \n $" );
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
		
		while(changeReturnedInPennies !=0) {
			if( changeReturnedInPennies % _100_DOLLARS == 0 ) {
				changeReturnedInPennies = changeReturnedInPennies - _100_DOLLARS; 
				total_100_Dollars++; 
				continue;
			}
			else if(changeReturnedInPennies  %  FIFTY_DOLLARS ==0) {
				changeReturnedInPennies = changeReturnedInPennies - FIFTY_DOLLARS; 
				total_Fifty_Dollars++;
				continue;
			}
			else if(changeReturnedInPennies % TWENTY_DOLLARS ==0) {
				changeReturnedInPennies = changeReturnedInPennies - TWENTY_DOLLARS; 
				total_TwentyDollars++; 
				continue;
			}
			else if(changeReturnedInPennies % TEN_DOLLARS ==0) {
				changeReturnedInPennies = changeReturnedInPennies - TEN_DOLLARS; 
				total_TenDollars++; 
				continue;
			}
			else if(changeReturnedInPennies % FIVE_DOLLARS ==0) {
				changeReturnedInPennies = changeReturnedInPennies - FIVE_DOLLARS; 
				total_FiveDollars++; 
				continue; 
			}
			else if(changeReturnedInPennies % DOLLARS == 0) {
				changeReturnedInPennies = changeReturnedInPennies - DOLLARS; 
				total_Dollars++; 
				continue; 
			}
			else if(changeReturnedInPennies % QUARTERS ==0) {
				changeReturnedInPennies = changeReturnedInPennies - QUARTERS; 
				total_Quarters++;
				continue; 
			}
			else if(changeReturnedInPennies % DIMES ==0) {
				changeReturnedInPennies = changeReturnedInPennies - DIMES; 
				total_Dimes++; 
				continue; 
			}
			else if(changeReturnedInPennies % NICKELS ==0) {
				changeReturnedInPennies = changeReturnedInPennies - NICKELS; 
				total_Nickels++; 
				continue;
			}
			else if(changeReturnedInPennies % PENNIES ==0) {
				changeReturnedInPennies = changeReturnedInPennies - PENNIES; 
				total_Pennies++; 
				continue; 
			}
		}
	}
	
	public static void DisplayChange() {
		System.out.println(" 100 Dollars\t\t50 Dollars\t\t20 Dollars\t\t10 Dollars\t\t5 Dollars\t\t1 Dollars\t\tQuarters\t\tDimes\t\tNickels\t\tPennies");
		System.out.println("\t" + total_100_Dollars + "\t\t\t\t" + total_Fifty_Dollars + "\t\t\t\t" + total_TwentyDollars + "\t\t\t\t" + total_TenDollars + "\t\t\t\t" + total_FiveDollars + "\t\t\t" + total_Dollars +  "\t\t\t" + total_Quarters + "\t\t\t"
		+ total_Dimes + "\t\t\t"+ total_Nickels  + "\t\t\t" + total_Pennies);
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
			System.out.println("Goodbye!");
			nextPurchase = false; 
		}
	}
}