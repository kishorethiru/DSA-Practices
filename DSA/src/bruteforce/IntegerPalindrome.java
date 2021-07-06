package bruteforce;

import org.junit.Assert;
import org.junit.Test;

public class IntegerPalindrome {

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
	
	/* create a variable rev and initialize as 0
	 * Create variable data and assign the value of input
	 * Using while loop till data not equal to zero
	 *  find the remainder of number % 10
	 *  in the variable rev * 10 and add rem
	 *  Update the number / 10 
	 * Check if input and rev are equal if equal return true else false
	 */
	private boolean isIntegerPalindrome(int input) {
		int rev = 0;
		if(input >0 && input < 10) return true; 
		int data = input;
		while(data!=0)
		{
			int rem = data % 10;
			rev = rev * 10 + rem;
			data = data / 10;
			
		}
		System.out.println("input" + " :" + input + " Output : "+ rev);
		if (rev == input) return true;
		return false;
	}
	
	/* Convert the input to string
	 * Reverse and store it in a another string
	 * Parse to int and check if equals return true or false
	 */
	private boolean isIntegerPalindromeUsingString(int input) {
		if(input >-10 && input < 10) return true;
		String rev = "";
		String convertInput = "" + input;
		for (int i = convertInput.length()-1; i >=0 ; i--) 
		{
		  rev += convertInput.charAt(i);	
		}
		if(Integer.parseInt(rev)==input) return true;
		System.out.println(Integer.parseInt(rev));
		System.out.println("Input : "+ input + " Output: "+Integer.parseInt(convertInput));
		return false;		 
		
	}

}
