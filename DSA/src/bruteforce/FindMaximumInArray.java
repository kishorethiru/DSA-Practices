package bruteforce;

import org.junit.Assert;
import org.junit.Test;

public class FindMaximumInArray {

 /* Problem Statement
  * Find the maximum element present in the array
  * 1. Did I understand the problem? yes or no

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? int[]
        What is the expected output? int
        Do I have any constraints to solve the problem? Dont use additional DS, Should not sort
        Do I have all the information to go to the next steps?  Yes
        How big is your test data set will be? 
		1,2,3,4,7,1,0 - Positive
		-1,1,-100,0 - Edge
		1,1,1,1,1 - 
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
        Approach 1 : Using Max function
        Approach 2 : Using arithmetic operators
        Approach 3 : Brute force using 2 for loops
        
6.      Approach 1 : Using Max function - O(n)
		Approach 2 : Using arithmetic operators - O(n)
		Approach 3 : Brute force using 2 for loops - O(n^2)
		
  */

	@Test
	public void testData01()
	{
		int[] data = {1,2,3,4,7,1,0};
		Assert.assertTrue(findMaxInData(data) == 7);
		Assert.assertTrue(findMaxInDataWithoutInbuildFn(data) == 7);
		
	}
	
	@Test
	public void testData02()
	{
		int[] data = {-1,1,-100,0};
		Assert.assertTrue(findMaxInData(data) == 1);
		Assert.assertTrue(findMaxInDataWithoutInbuildFn(data) == 1);
	}
	@Test
	public void testData03()
	{
		int[] data = {1,1,1,1,1};
		Assert.assertTrue(findMaxInData(data) == 1);
		Assert.assertTrue(findMaxInDataWithoutInbuildFn(data) == 1);
	}
	@Test
	public void testData04()
	{
		int[] data = {1};
		Assert.assertTrue(findMaxInData(data) == 1);
		Assert.assertTrue(findMaxInDataWithoutInbuildFn(data) == 1);
		
	}
	
	/* Pseudocode
	 * If array length is 1 return the first element of it
	 * Create a variable max and assign first item in array to it
	 * Iterate through the array
	 *  Using Math.max function compare and save to the variable max
	 * Return max
	 * 
	 * Time : O[N]
	 * Space : O[1]
	 */

	private int findMaxInData(int[] data) {
		if(data.length ==1 ) return data[0];
		int max = data[0];
		for (int i = 1; i < data.length; i++) 
		{
			max = Math.max(max, data[i]);
		}
		return max;
	}
	
	/* Pseudocode
	 * If array length is 1 return the first element of it
	 * Create a variable max and assign first item in array to it
	 * Iterate through the array
	 *  Using compare and save to the variable max using ternary operator
	 * Return max
	 * 
	 * Time : O[N]
	 * Space : O[1]
	 */

	private int findMaxInDataWithoutInbuildFn(int[] data) {
		if(data.length ==1 ) return data[0];
		int max = data[0];
		for (int i = 1; i < data.length; i++) 
		{	
			max = max > data[i] ? max : data[i];
		}
		return max;
	}
	

}
