package a1;

import java.util.Objects;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int items = scan.nextInt();
		String[] itemNames = new String[items];
		float[] itemPrices = new float[items];
		for (int i=0; i<items; i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextFloat();
		}
		int numCust = scan.nextInt();
		String first = null;
		String last = null;
		int[] list1 = new int[items];
		int[] list2 = new int[items];
		int[] list4 = new int[items];
		int counter = 0;
		for (int k=0; k<numCust; k++) {
			first = scan.next();
			last = scan.next();
			int numGroc = scan.nextInt();
			int[] list3 = new int[items];
			for (int t=0; t<numGroc; t++) {
				int num = scan.nextInt();
				int place = 0;
				String prod = scan.next();
				for (int s=0; s<items; s++) {
					if (Objects.equals(prod, itemNames[s])) {
						place = s;
						list3[s] ++;
					}
					if (list3[s] > 1) {
						list3[s] = 1;
					}
				}
				if(list1[place] == 0) {
					counter++;
					list2[place] ++;
				}
				list1[place] += num;
			}
			for (int y=0; y<items; y++) {
				list4[y] += list3[y];
			}
		}
		for (int p=0; p<counter+1; p++) {
			if (list2[p] == 0) {
				System.out.println("No customers bought " + itemNames[p]);
			}
			else {
				System.out.println(list4[p] + " customers bought " + list1[p] + " " + itemNames[p]);
			}
		}
	}
}
