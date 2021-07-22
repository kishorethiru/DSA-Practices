package twoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class P42_ReverseUniqueCharacters {
	
	/* In the given char array, return the unique characters in reverse order
	 * 
	 */
	/* 1. 
    Input(s)? char[] 
    Output ? String
    Constraints ?  Linear time

2. Test data set

        Positive : ['a','b','c','d','b']
        Negative : ['a','b','c','c','a','b']
        Edge     : ['x','z','a','b','z']

3. Known Approaches
        Approach 1 :Using ascii 

4. O-Notations
		Approach 1 :Using ascii - O(2n) - O(n)

5. Pseudocode
	 * 
	 */
	@Test
	public void testData01(){            // Positive
		char[] input = {'a','b','c','d','b'};
		Assert.assertTrue(reverseUniqueChar(input).equals("dca"));
	}

	@Test
	public void testData02(){			 // Negative
		char[] input = {'a','b','c','c','a','b'};
		Assert.assertTrue(reverseUniqueChar(input).equals(""));
	}

	@Test
	public void testData03(){			 // Edge
		char[] input = {'x','z','a','b','z'};
		Assert.assertTrue(reverseUniqueChar(input).equals("bax"));
	}

	/* 
	 * Create a int[] array of length 128
	 * Iterate the input and increment value of char
	 * Iterate the input from end and if counter value in array is one append
	 * return the output 
	 * Time : O(n) + O(n) => O(n)
	 * Space :O(128)
	 */
	private String reverseUniqueChar(char[] input) {
		int[] inputAscii = new int[128];
		int left = 0, right = input.length - 1;
		while (left <= right) {
			if (left == right)
				inputAscii[input[left++]]++;
			else {
				inputAscii[input[left++]]++;
				inputAscii[input[right--]]++;
			}
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = input.length - 1; i >= 0; i--) {
			if (inputAscii[input[i]] == 1)
				sb.append(input[i]);
		}
		return sb.toString();
	}
	
	
}
