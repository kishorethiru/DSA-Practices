package singlepassanddp;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P149_SwapCase {
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
		System.out.println(swapCase("Hello-LOL"));
		System.out.println(swapCase("Sup DUDE!!?"));
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
	private String swapCase(String s) {
		char[] charArr = s.toCharArray();
		for(int i = 0; i<charArr.length;i++) {
			if(Character.isLetter(charArr[i])) {
				charArr[i] = Character.isUpperCase(charArr[i]) ? Character.toLowerCase(charArr[i]) : Character.toUpperCase(charArr[i]);
			}
		}
		return new String(charArr);
	}
}
