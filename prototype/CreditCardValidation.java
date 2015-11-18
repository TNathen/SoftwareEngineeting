import java.util.*;

/*CreditCardValidation is a class that contains methods which checks to
 * see if a credit card meets specific standards and is valid by 
 * using the Luhn algorithm.*/

public class CreditCardValidation {
	static boolean valid=false;
	public CreditCardValidation(String cardNum,String type){

		if(isNumMatch(cardNum,type)){
			if(isValidCard(cardNum)){
				valid=true;
				}else{
				valid=false;			}
		}else{
			valid=false;
			}
		
	}
	
	/*isOnlyNum is a method that takes in a string and checks
	 * to see if the string only contains numbers.
	 * The method shall return a boolean.*/
	public static boolean isOnlyNum(String cardNum) {
		String regex = "[0-9]+";
		return cardNum.matches(regex);
	}
	
	/*isNumMatch is a method that takes in two strings.
	 * One string represents the card number and the other tells
	 * the program what type of card it is. All cards start with
	 * a specific set of numbers, which is checked to see if the 
	 * card starts with a specific set of numbers.*/
	public static boolean isNumMatch(String cardNum,String type){
		if(type.equalsIgnoreCase("visa")){
			return (cardNum.length() == 16 || cardNum.length() == 13)
					&& cardNum.charAt(0) == '4';
		}else if(type.equalsIgnoreCase("mastercard")){
			return cardNum.length() == 16 && (cardNum.substring(0, 2).equalsIgnoreCase("51") || 
					cardNum.substring(0, 2).equalsIgnoreCase("52") || cardNum.substring(0, 2).equalsIgnoreCase("53") ||
					cardNum.substring(0, 2).equalsIgnoreCase("54") || cardNum.substring(0, 2).equalsIgnoreCase("55"));
		}else if(type.equalsIgnoreCase("americanexpress")){
			return cardNum.length() == 15 && (cardNum.substring(0, 2).equalsIgnoreCase("34") || 
					cardNum.substring(0, 2).equalsIgnoreCase("37"));
		}else if(type.equalsIgnoreCase("discovercard")){
			return cardNum.length() == 16 && cardNum.substring(0,4).equalsIgnoreCase("6011");
		}else{
			//System.out.println("Error - isNumMatch error");
			return false;
		}
	}
	/*Luhn algorithm. Takes in a string and converts string
	 * into a long to represent the card number. Reads number from
	 * right to left. 
	 * -Adds all odd position (farthest right equal 1) digits to sum
	 * -All even positions are multiplied by two and added to sum. 
	 * -If even digit is more than 10, it is subtracted by 9 and added to sum.
	 * -The sum of all numbers is mod by 10. 
	 * -If sum%10 = 0, method shall return true boolean, else false*/
	public static boolean isValidCard(String cardNum){
		long card = Long.parseLong(cardNum);
		long sum = 0;
		int i = 1;
		while(card > 0){
			if(isOdd(i)){
				sum = sum + (card%10);
				card /= 10;
				i++;
			}else{
				long j = card % 10;
				if(j*2 >= 10){
					sum = sum + ((j*2)-9);
					card /= 10;
					i++;
				}else{
					sum = sum + (2*j);
					card /= 10;
					i++;
				}
			}
		}
		if(sum % 10 == 0){
			return true;
		}else{
			return false;
		}
	}
	
	/*isOdd method takes in an int and returns a boolean.
	 * Returns true if int is odd, and false if int is even.
	 * Used to check digit position in Luhn algorithm.*/
	public static boolean isOdd(int i){
		if (i%2 == 0){
			return false;
		}else{
			return true;
		}
	}
	public static boolean isValid()
	{
		return valid;
	}
}
