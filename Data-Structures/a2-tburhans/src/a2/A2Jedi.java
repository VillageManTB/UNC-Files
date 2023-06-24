package a2;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Your code here.
		int numItems = scan.nextInt();
		String[][] grocArray = new String[numItems][];
		String[] grocNames = new String[numItems];
		for (int i=0; i<numItems; i++) {
			grocArray[i] = new String[3];
			grocNames[i] = scan.next();
			for (int j=0; j<3; j++) {
				grocArray[i][j] = scan.next();
			}
		}
		int numFood = scan.nextInt();
		Float[][] foodArray = new Float[numFood][];
		String[] foodNames = new String[numFood];
		int numIngredients = 0;
		int slot = 0;
		float amount = 0;
		float value = 0;
		for (int k=0; k<numFood; k++) {
			foodNames[k] = scan.next();
			numIngredients = scan.nextInt();
			foodArray[k] = new Float[numItems];
			for (int w = 0; w < numIngredients; w++) {
				String ingredient = scan.next();
				amount = scan.nextFloat();
				for (int t = 0; t < numItems; t++) {
					if (grocNames[t].equals(ingredient)) {
						slot = t;
					}
					if (foodArray[k][t] == null) {
						foodArray[k][t] = value;
					}
				}
				foodArray[k][slot] = amount;
			}
		}
		Float[] multiplier = new Float[numFood];
		for (int u=0;u<numFood;u++) {
			if (multiplier[u] == null) {
				multiplier[u] = value;
			}
		}
		while(true) {
			String nextFoodName = scan.next();
			for (int p=0;p<numFood;p++) {
				if (nextFoodName.equals(foodNames[p])) {
					multiplier[p]++;
				}
			}
			if (nextFoodName.equals("EndOrder")) {
				break;
			}
		}
		Float[] finalArray = new Float[numItems];
		for (int o=0;o<numItems;o++) {
			if (finalArray[o] == null) {
				finalArray[o] = value;
			}
		}
		for (int v=0;v<numItems;v++) {
			for(int l=0;l<numFood;l++) {
				finalArray[v] += foodArray[l][v]*multiplier[l];
			}
		}
		System.out.println("The order will require:");
		for (int a=0;a<numItems;a++) {
			System.out.println(String.format("%.2f", finalArray[a]) + " ounces of " + grocNames[a]);
		}
	}
	
	// You can define helper methods here if needed.
	
}
