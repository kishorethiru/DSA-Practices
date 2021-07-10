package twoPointers;

import org.junit.Assert;
import org.junit.Test;

public class ReverseString 
{
	/*
	 * Given a string s, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 
		Example 1:
		Input: s = "ab-cd"
		Output: "dc-ba"
		Example 2:
		Input: s = "a-bC-dEf-ghIj"
		Output: "j-Ih-gfE-dCba"
		Example 3:
		Input: s = "Test1ng-Leet=code-Q!"
		Output: "Qedo1ct-eeLg=ntse-T!"
	 * 
	 */
	
	/*
	 * 1. Did I understand the problem? Yes 

        What is the input(s)?  String 
        What is the expected output?  String
        Do I have any constraints to solve the problem? Two Ptr 
        Do I have all the information to go to the next steps  Yes
        How big is your test data set will be? 
        "ab-cd"
        "Test1ng-Leet=code-Q!"
        "!#$%"
		2. Test data set
		        Minimum  3 data set including positive, negative and edge
		        Validate with the interviewer if the data set is fine by his/ her assumptions
		
		3. Do I know to solve it?
		        Yes- great is there an alternate ? Yes
		        No - can I break the problem into sub problems?
		
		4. Ask for hint (if you dont know how to solve this
		5.  Do I know alternate solutions as well
		        Yes- what are those?
		        No- that is still fine, proceed to solve by what you know
		
		6. If you know the alternate solution find out the O-notations (performance)
		Time : O(n)
		Space : O(n) 
	 */
	
	@Test
	public void testData01()
	{
		String input = "ab-cd";
		Assert.assertEquals(reverseString(input), "dc-ba");
	}
	
	@Test
	public void testData02()
	{
		String input = "Test1ng-Leet=code-Q!";
		Assert.assertEquals(reverseString(input), "Qedo1ct-eeLg=ntse-T!");
	}
	
	@Test
	public void testData03()
	{
		String input = "!#$%";
		Assert.assertEquals(reverseString(input), "!#$%");
	}
	
	/* Pseudocode 
	 * Initialize left = 0, right = length-1
	 * Iterate the input till while(left < right)
	 * if leftindex character is not a character, increment left++
	 * if rightindex character is not a character, decrement --;
	 * when both left index value and right index value are character swap and increment left and decrement right
	 * 
	 * O(n^2)
	 * O(n)
	 */
	
	private String reverseString(String input) {
		int left = 0, right = input.length() - 1;
		char[] charArr = input.toCharArray();
		while (left < right) {
			if (!Character.isLetter(charArr[left]))
				left++;
			if (!Character.isLetter(charArr[right]))
				right--;
			if (Character.isLetter(charArr[left]) && Character.isLetter(charArr[right])) {
				char temp = charArr[left];
				charArr[left++] = charArr[right];
				charArr[right--] = temp;
			}
		}
		return new String(charArr);
	}

}
