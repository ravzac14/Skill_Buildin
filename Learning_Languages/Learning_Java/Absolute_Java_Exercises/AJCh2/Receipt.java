/*Zack Raver; ravzac14
 * 4/6/15
 * 
 * Ch.2 #10 from "Absolute Java" by Walter Savitch
 * Write a program that inputs the name, quantity and price of 3 items. The name may contain spaces.
 * Output a bill with a tax rate of %6.25. All prices should be output to two decimal places. The bill should be 
 * formatted in columns with 30 characters for the name, 10 for the quantity and 10 for the price and total. 
 * 
 * (IE. Input name of item 1:...Input quantity of item 1:... Input price of item 1:...
 * Subtotal...6.25% sales tax...Total)
 */
import java.util.Scanner;

public class Receipt {
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		int itemQuantity = 0;
		float itemPrice = 0;
		float subtotal = 0;
		String item1, item2, item3;
		
		//Obtaining there items/quanitities/prices
		System.out.println("Input the name of item 1:");
		item1 = s1.next();
		System.out.println("Input the quanity of " + item1 + "(s):");
		itemQuantity = s1.nextInt();
		System.out.println("Input the price of a " + item1 + ":");
		itemPrice = s1.nextFloat();
		subtotal += (itemPrice * (float)itemQuantity);
		
		System.out.println("Input the name of item 2:");
		item2 = s1.next();
		System.out.println("Input the quanity of " + item2 + "(s):");
		itemQuantity = s1.nextInt();
		System.out.println("Input the price of a " + item2 + ":");
		itemPrice = s1.nextFloat();
		subtotal += (itemPrice * (float)itemQuantity);
		
		System.out.println("Input the name of item 3:");
		item3 = s1.next();
		System.out.println("Input the quanity of " + item3 + "(s):");
		itemQuantity = s1.nextInt();
		System.out.println("Input the price of a " + item3 + ":");
		itemPrice = s1.nextFloat();
		subtotal += (itemPrice * (float)itemQuantity);
		
		System.out.println("Subtotal: " + subtotal);
		System.out.println("After a %6.25 sales tax: ");
		subtotal += (subtotal / 6.25F);
		System.out.println("Total: " + subtotal);
	}

}
