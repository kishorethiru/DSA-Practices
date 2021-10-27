package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P151_IntegerToRoman {
	/*
		Problem Statement
	
	*/

	/*
	   1. 
	  Input(s) ? 
		  Output ?
		  Constraint(s) ?
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		List<Integer> input = Arrays.asList(1,2,3,4,5);
		List<String> output = Arrays.asList("I","II","III","IV","V");
		Assert.assertTrue(intToRoman(input).equals(output));
	}

	@Test
	public void testData02() { // Negative
		List<Integer> input = Arrays.asList(75,80,99,100,50);
		List<String> output = Arrays.asList("LXXV","LXXX","XCIX","C","L");
		Assert.assertTrue(intToRoman(input).equals(output));
	}

	@Test
	public void testData03() { // Edge

	}

	public List<String> intToRoman(List<Integer> list) {
		List<String> op = new ArrayList<>();
		String[] romanValues = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		for (Integer n : list) {
			StringBuilder sb = new StringBuilder();
			int currentIndex = 0;
			while (n > 0) {
				while (n >= value[currentIndex]) {
					n -= value[currentIndex];
					sb.append(romanValues[currentIndex]);
				}
				currentIndex++;
			}
			op.add(sb.toString());
		}
		return op;
	}
}
