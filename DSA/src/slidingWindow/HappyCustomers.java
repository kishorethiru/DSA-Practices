package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class HappyCustomers {
	
 /*
  * Today, the bookstore owner has a store open for customers.length minutes.  
  * Every minute, some number of customers (customers[i]) enter the store, and 
  * all those customers leave after the end of that minute.
	On some minutes, the bookstore owner is grumpy.  If the bookstore owner is 
	grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  
	When the bookstore owner is grumpy, the customers of that minute are not satisfied,
 	otherwise they are satisfied.
	The bookstore owner knows a secret technique to keep themselves not grumpy for 
	X minutes straight, but can only use it once.
	Return the maximum number of customers that can be satisfied throughout the day.

	Example 1:
	Input: customers = [1,0,1,2,1,1,7,5],  
		      grumpy = [0,1,0,1,0,1,0,1], X = 3 (length-target - 1)
  * 
  */
	
	/* 1. Problem Analysis 
	 *     1. Input - int[], int[] , int k
	 *     2. Output - int
	 *     3. Constraint - No
	 * 2. Test Data
	 *    
	 *     Positive
	 *     int[] customers = {1,0,1,2,1,1,7,5};
		   int[] grumpy    = {0,1,0,1,0,1,0,1};
		   int k           = 3;
	 *     
	 *     Edge
	 *     int[] customers = {1,1,1,1,1,1,1,1};
		   int[] grumpy    = {1,1,1,1,1,1,1,1};
		   int k           = 1;
	 *     
	 *     Edge
	 *     Input: calories = [-1,1,0,2,-2,0], k = 1, lower = -1, upper = 0
	 *     0+1+0+1-1+0 => 1
	 * 
	 * 3.  Approach to solve
	 *  	
	 *     Approach 1 : Sliding window  
	 * 
	 * 4. Big O Notation
	 *    	Approach 1 : Sliding window Time - O(n), Space O(1)
	 * 
	 */
	
	@Test
	public void testData01() // Positive
	{
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy    = {0,1,0,1,0,1,0,1};
		int k           = 3;
		Assert.assertTrue(findHappyCustomers(customers,grumpy,k) == 16);
	}
	
	@Test
	public void testData02() // Edge
	{
		int[] customers = {1,1,1,1,1,1,1,1};
		int[] grumpy    = {1,1,1,1,1,1,1,1};
		int k           = 1;
		Assert.assertTrue(findHappyCustomers(customers,grumpy,k) == 1);
	}
	
	@Test
	public void testData03() // Edge
	{
		int[] customers = {1,0,0,0,0,0,1};
		int[] grumpy    = {0,1,0,1,0,0,1};
		int k           = 2;
		Assert.assertTrue(findHappyCustomers(customers,grumpy,k) == 2);
	}
	
	@Test
	public void testData04() // Edge
	{
		int[] customers = {2,3,4,1,4,4,3,6};
		int[] grumpy    = {0,0,0,0,1,1,1,1};
		int k           = 3;
		Assert.assertTrue(findHappyCustomers(customers,grumpy,k) == 23);
	}
	
	
	
  /*
   * Initialize a variable maxCustomers and currentMax.
	 Iterate the grumpy array, if the element is zero add the corresponding 
	 value in customers array to maxCustomers
	 Iterate the grumpy array till k and  if current element is 1, add the value to currentMax 
	 Compare and store max
	 Iterate from 1 to length-k -1
   		Remove the previous index value from currentCustomers if previous  is 1.
   		Add i+k-1, if value is 1 add corresponding index value to currentCustomers
   		compare and store max
 	 Return max
 	 Time - O(n)+O(n)+(k) => O(n)
 	 Space - O(1)
   * 
   */
	
	private int findHappyCustomers(int[] customers, int[] grumpy, int k) {
		int maxCustomers = 0, currentCustomers = 0;
		for (int i = 0; i < grumpy.length; i++) {
			if(grumpy[i] == 0) maxCustomers += customers[i];
		}
		currentCustomers = maxCustomers;
		for (int i = 0; i < k; i++) 
		{
			if(grumpy[i] == 1) currentCustomers+=customers[i];
			
		}
		maxCustomers = Math.max(maxCustomers, currentCustomers);
		for (int i = 1; i < grumpy.length-k+1; i++) 
		{
			if(grumpy[i-1] == 1) currentCustomers -= customers[i-1];
			if(grumpy[i+k-1]==1) currentCustomers  +=customers[i+k-1];
			maxCustomers = Math.max(maxCustomers, currentCustomers);		
		}
		return maxCustomers;
		
	}

}
