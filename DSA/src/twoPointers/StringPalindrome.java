package twoPointers;

import org.junit.Assert;
import org.junit.Test;

public class StringPalindrome 
{
/*
 * Given a string s, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
 
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 * 
 */
	
	/*
	 * 1. Did I understand the problem?Y es

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? String
        What is the expected output? boolean
        Do I have any constraints to solve the problem? Need to use 2 ptrs 
        Do I have all the information to go to the next steps  Yes
        How big is your test data set will be? 
        Test 1 : "A man, a plan, a canal: Panama"
        Test 2 : "race a car" 
        
        
		

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ? Yes, Bruteforce
        No - can I break the problem into sub problems?

4. Ask for hint (if you dont know how to solve this 
5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know
        
        Approach 1 : Bruteforce
        Approach 2 : Two Ptr

6. If you know the alternate solution find out the O-notations (performance)
	 * 
	 * Approach 1 : Bruteforce - O(n), O(n)
       Approach 2 : Two Ptr  - O(n/2), 
	 */
	
	@Test
	public void testData01()
	{
		String input = "A man, a plan, a canal: Panama";
		Assert.assertTrue(isPalindromeWithTwoPtr(input) == true);
		
	}
	
	@Test
	public void testData02()
	{
		String input = "race a car";
		Assert.assertTrue(isPalindromeWithTwoPtr(input) == false);
		
	}

	@Test
	public void testData03()
	{
		String input = ",,,,,,,,a";
		Assert.assertTrue(isPalindromeWithTwoPtr(input) == true);
	}
	
	/*
	 * Convert input to lowercase and then to char array
	 * Initialize the left as  0  and right as arraylength -1
	 * Iterate till left < right
	 *  if left char and right char is character then check if both are same increment left and decrement right
	 *     else return false
	 *  if left value is not a alphabet or space, increment left
	 *  if right	 value is not a alphabet or space, decrement right
	 * return true
	 *  
	 * Time : O(n)
	 * Space : O(n)
	 */
	
	private boolean isPalindromeWithTwoPtr(String input) {
		if (input.length() < 2)
			return true;
		char[] charArr = input.toLowerCase().toCharArray();
		int left = 0, right = charArr.length - 1;
		while (left < right) {
			if (!Character.isLetterOrDigit(charArr[left]))
				left++;
			if (!Character.isLetterOrDigit(charArr[right]))
				right--;
			if (Character.isLetterOrDigit(charArr[left]) && Character.isLetterOrDigit(charArr[right])) {
				if (charArr[left] != charArr[right])
					return false;
				else {
					left++;
					right--;
				}
			}
		}
		return true;
	}
}
