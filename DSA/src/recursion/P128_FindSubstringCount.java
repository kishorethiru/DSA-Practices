package recursion;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P128_FindSubstringCount {
	/*
		Problem Statement
		 Given two string s and t, find how many t is present in String s
		 1. Base case , when there is not substring replaced.
		 2,3. s= loveleetcodee t = ee , 
		 4. replace the first match, increment count move to next one
	
	*/

	/*
	   1. 
	  	  Input(s) ? String, String 
		  Output ? int
		  Constraint(s) ? Use recursion
	   
	   2. Test data
			Positive : String 
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
		String s = "loveleetcodee";
		String t =  "ee";
		Assert.assertTrue(findSubstringCountOptimized(s,t)==2);
	}

	@Test
	public void testData02() { // Negative
		String s = "loveleetcodee";
		String t =  "aa";
		Assert.assertTrue(findSubstringCountOptimized(s,t)==0);
	}

	@Test
	public void testData03() { // Edge
		String s = "zezezezezeze";
		String t =  "ze";
		Assert.assertTrue(findSubstringCountOptimized(s,t)==6);
	}
	
	/* 
	 * Initialize count
	 * Replace the value of t in s and save to another String check
	 * If both length are same return 0;
	 * Add 1 to count and call the function again with updated string
	 * return count 
	 * 
	 */
	
	private int findSubstringCount(String s, String t) {
		int count= 0;
		String check = s.replaceFirst(t, "");;		
		if(check.length() == s.length())
			return 0;
		count += 1 +findSubstringCount(check,t);
		return count;
	}
	
	private int findSubstringCountOptimized(String s, String t) {
		if(!s.contains(t)) return 0;
		return findSubstringCountOptimized(s.replaceFirst(t, ""),t)+1;
		
	}
}
