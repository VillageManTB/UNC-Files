package a1;

import java.util.Objects;
import java.util.Scanner;

public class A1Adept {

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
		float most = 0;
		float least = 0;
		String name1 = null;
		String name2 = null;
		String name3 = null;
		String name4 = null;
		float sum3 = 0;
		for (int k=0; k<numCust; k++) {
			first = scan.next();
			last = scan.next();
			int numGroc = scan.nextInt();
			float sum = 0;
			for (int t=0; t<numGroc; t++) {
				int num = scan.nextInt();
				int place = 0;
				String prod = scan.next();
				for (int s=0; s<items; s++) {
					if (Objects.equals(prod, itemNames[s])) {
						place = s;
					}
				}
				float price = itemPrices[place];
				sum += num * price;
			}
			sum3 += sum;
			if ((most == 0) && (least == 0)) {
				most = sum;
				name1 = first;
				name2 = last;
				least = sum;
				name3 = first;
				name4 = last;
			}
			if (sum > most) {
				most = sum;
				name1 = first;
				name2 = last;
			}
			if ((sum < most) && (sum < least)) {
				least = sum;
				name3 = first;
				name4 = last;
			}
		}
		float avg = (sum3 / numCust);
		String most2 = String.format("%.02f", most);
		String least2 = String.format("%.02f", least);
		String avg2 = String.format("%.02f", avg);
		System.out.println("Biggest: " + name1 + " " + name2 + " (" + most2 + ")");
		System.out.println("Smallest: " + name3 + " " + name4 + " (" + least2 + ")");
		System.out.println("Average: " + avg2);
	}
}
