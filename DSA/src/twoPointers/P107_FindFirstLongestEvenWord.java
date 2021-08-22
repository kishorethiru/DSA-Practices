package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P107_FindFirstLongestEvenWord {
	/*
		Problem Statement
	
	*/

	/*
	   1. 
	  	 Input(s) ? String
		  Output ? String
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
		String s = "Time to write great code";
		Assert.assertTrue(findLongestEvenWord(s).equals("Time"));
	}

	@Test
	public void testData02() { // Negative
		String s = "Tim tos write great coe";
		Assert.assertTrue(findLongestEvenWord(s).equals(""));
	}

	@Test
	public void testData03() { // Edge
		String s = "Time to writes greatest code";
		Assert.assertTrue(findLongestEvenWord(s).equals("greatest"));
	}

	/* Create int max and index  as -1
	 * Iterate the input
	 *  find the length of each char
	 *  if its even store the count of max and its index
	 * if index = -1 return ""
	 * else return string[index]
	 * 
	 */
	private String findLongestEvenWord(String s) {
		String[] ch = s.split(" ");
		int max=0 ,index = -1;
		for (int i = 0; i < ch.length; i++) {
			if(ch[i].length()%2 == 0) {
				if(ch[i].length()>max) {
					max = ch[i].length();
					index = i;
				}
			}
		}
		if(index==-1) return "";
		return ch[index];
	}
}
