package a2;

import java.util.Scanner;

public class A2Adept {
	static int sumRange(int low, int high, List , int index, int sum) {

		if (index == list.size()) {
			return sum;
		}

		int x = list.get(index);
		if (x < low || x > high) {
			x = 0;
		}

		return sumRange(low, high, list, index+1, sum+x);
	}
	}
	
	// You can define helper methods here if needed.

}
