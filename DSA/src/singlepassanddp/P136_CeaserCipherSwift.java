package singlepassanddp;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P136_CeaserCipherSwift {
	/*
		Problem Statement
		Swift the character in the string matching the list where index 0 and 1 are from / to index and 
		index 2 is direction to swift
	
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

		System.out.println(cesarCipher("abc", Arrays.asList("0 0 L", "2 2 L", "0 2 R")));
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
	public String cesarCipher(String s, List<String> operations) {
		for(String each : operations) {
			String[] eachItems = each.split(" ");
			int start = Integer.parseInt(eachItems[0]);
			int end   = Integer.parseInt(eachItems[1]);
			StringBuilder sb = new StringBuilder(s);
			for(int i = start; i <= end; i++){
				sb.setCharAt(i,swiftChar(sb.charAt(i),eachItems[2]));
			}
			s = sb.toString();
		}
		return s;
	}
	
	public Character swiftChar(char c, String type) {
		int val = c;
		if(type.equals("L") && val == 97) val = 122;
		else if(type.equals("R") && val == 122) val = 97;
 		else if(type.equals("L"))val--;
 		else val++;
		return (char) val;
	}
}
