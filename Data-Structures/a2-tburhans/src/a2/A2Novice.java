package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Your code here.
		int numItems = scan.nextInt();
		String[] items = new String[numItems];
		int vegCounter = 0;
		float highest = 0;
		float lowest = 0;
		int slotH = 0;
		int slotL = 0;
		for (int i=0; i<numItems; i++) {
			items[i] = scan.next();
			float price = scan.nextFloat();
			if (scan.nextBoolean() == true) {
				vegCounter++;
			}
			int calories = scan.nextInt();
			float priceCal = calories / price;
			if (highest == 0) {
				highest = priceCal;
			}
			if (lowest == 0) {
				lowest = priceCal;
			}
			if (priceCal > highest) {
				highest = priceCal;
				slotH = i;
			} else if (priceCal < lowest) {
				lowest = priceCal;
				slotL = i;
			}
		}
		System.out.println("Number of vegetarian ingredients: " + vegCounter);
		System.out.println("Highest cals/$: " + items[slotH]);
		System.out.println("Lowest cals/$: " + items[slotL]);
	}
	
	// You can define helper methods here if needed.
	
}
