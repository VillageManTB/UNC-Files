package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int numCust = scan.nextInt();
		String first = null;
		String last = null;
		for (int i=0; i<numCust; i++) {
			first = scan.next();
			char first1 = first.charAt(0);
			last = scan.next();
			int numGroc = scan.nextInt();
			float sum = 0;
			String sum1 = null;
			for (int k = 0; k < numGroc; k++) {
				int num = scan.nextInt();
				scan.next();
				float price = scan.nextFloat();
				sum += num * price;
				sum1 = String.format("%.02f", sum);
			}
			System.out.println(first1 + ". " + last + ": " + sum1);
		}
	}
}
