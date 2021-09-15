package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P139_CompareVersion {
	/*
		Problem Statement
		Given two version numbers, version1 and version2, compare them.
		Version numbers consist of one or more revisions joined by a dot '.'. 
		Each revision consists of digits and may contain leading zeros. 
		Every revision contains at least one character. 
		Revisions are 0-indexed from left to right, with the leftmost revision 
		being revision 0, the next revision being revision 1, and so on.
		 For example 2.5.33 and 0.1 are valid version numbers.
		To compare version numbers, compare their revisions in 
		left-to-right order. Revisions are compared using their integer value
		ignoring any leading zeros. This means that revisions 1 and 001 
		are considered equal. If a version number does not specify a revision 
		at an index, then treat the revision as 0. For example, version 1.0 
		is less than version 1.1 because their revision 0s are the same,
		but their revision 1s are 0 and 1 respectively, and 0 < 1.

		Return the following:
		
		If version1 < version2, return -1.
		If version1 > version2, return 1.
		Otherwise, return 0.	
	*/

	/*
	   1. 
	  	  Input(s) ? Two String 
		  Output ? int
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
		Assert.assertTrue((compareVersion("0.1","1.1")==-1));
	}

	@Test
	public void testData02() { // Negative
		Assert.assertTrue((compareVersion("0.0","0.0")==0));
	}

	@Test
	public void testData03() { // Edge
		Assert.assertTrue((compareVersion("1.0.1","1")==1));
	}
	
	public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int p1 = 0, p2 = 0;
        while(p1 < v1.length || p2 < v2.length){
            int v1Val = (p1 >= v1.length) ? 0 :Integer.parseInt(v1[p1++]);
            int v2Val = (p2 >= v2.length) ? 0 :Integer.parseInt(v2[p2++]);
            if(v1Val == v2Val) continue;
            else if(v1Val>v2Val) return 1;
            else return -1;   
        }
        return 0;
    }
}
