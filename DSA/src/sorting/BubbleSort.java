package sorting;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class BubbleSort {
	/*
	 * Problem Statement
	 * 
	 */

	/*
	 * 1. Input(s) ? int[] Output ? int[] Constraint(s) ?
	 * 
	 * 2. Test data Positive : Negative : Edge :
	 * 
	 * 3. Approaches Known Approach 1 : Bubble Sort
	 * 
	 * 4. O - Notation Approach 1 : O(n^2)
	 * 
	 * 5. Pseudocode
	 * 
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		System.out.println(Arrays.toString(bubbleSort(new int[] { 4, 5, 2, 3 })));
	}

	/*
	 * Iterate the input with two nested for loop 1. Compare i and j if i value > j
	 * value swap Continue till n-i 4,5,2,3
	 * 
	 */

	private int[] bubbleSort(int[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			for (int j = 1; j < input.length - i; j++) {
				if (input[j - 1] > input[j]) {
					int temp = input[j - 1];
					input[j - 1] = input[j];
					input[j] = temp;
				}
			}
		}
		return input;
	}
	

}
