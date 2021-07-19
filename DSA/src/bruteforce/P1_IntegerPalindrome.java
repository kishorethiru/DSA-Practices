package bruteforce;

import org.junit.Assert;
import org.junit.Test;

public class P1_IntegerPalindrome {

	/* Problem Statement
	  * Write a method to verify given integer is a palindrome
	  * 
	  * 1. Did I understand the problem? yes or no

	        If no ask the person to provide with more details with examples
	        If yes go to the next step

	        What is the input(s)? int
	        What is the expected output? boolean
	        Do I have any constraints to solve the problem? No
	        Do I have all the information to go to the next steps?  Yes
	        How big is your test data set will be? 
			1221
			1234321
			1000
			1
			

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
	        Approach 1 : Using mod and div operator
	        Approach 2 : Convert to string and reverse the string and parse 
	        
	6.      Approach 1 : Using mod and div operator - O(N)
			Approach 2 : Convert to string and reverse the string and parse - O(N)
			
			
	  */
	
	@Test
	public void testData01()
	{
		int data = 1221;
		Assert.assertTrue(isIntegerPalindrome(data));
		Assert.assertTrue(isIntegerPalindromeUsingString(data));
		
	}
	
	@Test
	public void testData02()
	{
		int data = 1234321;
		Assert.assertTrue(isIntegerPalindrome(data));
		Assert.assertTrue(isIntegerPalindromeUsingString(data));
		
	}
	
	@Test
	public void testData03()
	{
		int data = 1000;
		Assert.assertFalse(isIntegerPalindrome(data));
		Assert.assertFalse(isIntegerPalindromeUsingString(data));
	
	}
	
	@Test
	public void testData04()
	{
		int data = 1;
		Assert.assertTrue(isIntegerPalindrome(data));
		Assert.assertTrue(isIntegerPalindromeUsingString(data));
	}
	@Test
	public void testData05()
	{
		int data = -74;
		Assert.assertFalse(isIntegerPalindrome(data));
		Assert.assertFalse(isIntegerPalindromeUsingString(data));
	}
	
	
	/* create a variable reverseInput and initialize as 0
	 * Create variable data and assign the value of input
	 * Create a variable isInputNegative and make it as true if the input is negative
	 * Using while loop till data not equal to zero
	 *  find the remainder by data % 10 and assign to variable remainder
	 *  Multiply reverseInput by 10 and add remainder to reverseInput
	 *  Divide inputData by 10 and update the variable inputData
	 * Multiply reverse number -1 if the isInputNegative is true
	 * Check if input and reverseInput are equal if equal return true else false
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 */
	private boolean isIntegerPalindrome(int input) {
		int reverseInput = 0;
		if(input >0 && input < 10) return true; 
		int inputData = input;
		boolean isInputNegative = false;
		if (inputData < -9)
		{
		 inputData *= -1;
		 isInputNegative = true;
		}
		while(inputData!=0)
		{
			int remainder = inputData % 10;
			reverseInput = reverseInput * 10 + remainder;
			inputData = inputData / 10;
			
		}
		reverseInput = isInputNegative ? (reverseInput * -1) : reverseInput;
		if (reverseInput == input) return true;
		return false;
	}
	
	/* Check if the input is single digit, if yes -  return true
	 * Create a boolean isInputNegative as assign as false 
	 * if the value is negative, update isInputNegative as true and multiple input by -1
	 * Create variable reverseInput as ""
	 * Convert the input to string and assign to a new variable convertInput
	 * Reverse and store it in reverseInput
	 * Check if isInputNegative is true, if yes  Multiple by -1 and parse the value
	 *   if no, parse the value and compare with input
	 *   if true then multiple by -1 and compare with input
	 *   Time : O(n)
	 *   Space : O(n)
	 */
	private boolean isIntegerPalindromeUsingString(int input) {
		if(input >-10 && input < 10) return true;
		boolean isInputNegative = false;
		int inputData = input;
		if (input < -9)
		{
		 inputData *= -1;
		 isInputNegative = true;
		}
		String reverseInput = "";
		String convertInput = "" + inputData;
		for (int i = convertInput.length()-1; i >=0 ; i--) 
		{
		  reverseInput += convertInput.charAt(i);	
		}
		int checkVal = isInputNegative? (Integer.parseInt(reverseInput) * -1) : (Integer.parseInt(reverseInput));
		if(checkVal == input) return true;
		return false;		 
		
	}

}
