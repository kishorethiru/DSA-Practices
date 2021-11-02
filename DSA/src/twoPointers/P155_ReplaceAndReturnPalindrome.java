package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public final class P155_ReplaceAndReturnPalindrome {
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
		String s = "?ab??a";
		Assert.assertTrue(findPalindrome(s).equals("aabbaa"));
	}

	@Test
	public void testData02() { // Negative
		String s = "bab??a";
		Assert.assertTrue(findPalindrome(s).equals("NO"));
	}

	@Test
	public void testData03() { // Edge
		String s = "?a?";
		Assert.assertTrue(findPalindrome(s).equals("zaz"));
	}
	@Test
	public void testData04() { // Edge
		String s = "aa?aa";
		Assert.assertTrue(findPalindrome(s).equals("aaaaa"));
	}

	private String findPalindrome(String s) {
		int left = 0, right = s.length()-1;
		char[] ch = s.toCharArray();
		while(left<=right) {
			if(left == right) {
				if(ch[left]=='?') ch[left] = 'a';
				left++;
			}
			else if(ch[left]=='?' && ch[right]=='?') {
				ch[left++] = 'z';
				ch[right--] = 'z';
			}
			else if(ch[left]==ch[right]) {
				left++;
				right--;
			}
			else if(Character.isLetter(ch[left]) && ch[right]=='?')
				ch[right--] = ch[left++];
			else if(Character.isLetter(ch[right]) && ch[left]=='?')
				ch[left++] = ch[right--];
			else return "NO";
		}
		return new String(ch);
	}
}
