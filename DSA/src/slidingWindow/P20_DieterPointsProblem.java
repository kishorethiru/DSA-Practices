package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class P20_DieterPointsProblem 
{
	/*
	 *  A dieter consumes calories[i] calories on the i-th day. For every consecutive 
	 *  sequence of k days, they look at T, the total calories consumed during that 
	 *  sequence of k days:

		If T < lower, they performed poorly on their diet and lose 1 point;
		If T > upper, they performed well on their diet and gain 1 point;
		Otherwise, they performed normally and there is no change in points.
		Return the total number of points the dieter has after all calories.length days.
		
		Note that: The total points could be negative.
		
		Example 1:
		Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
		Output: 0
		Explaination: calories[0], calories[1] < lower and calories[3], calories[4] > upper, total points = 0.
		
		Example 2:
		Input: calories = [3,2], k = 2, lower = 0, upper = 1
		Output: 1
		Explaination: calories[0] + calories[1] > upper, total points = 1.
		
		Example 3:
		Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5
		Output: 0
		Explaination: calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, total points = 0.
	 * 
	 */
	
	/* 1. Problem Analysis 
	 *     1. Input - int[], int k, int lower, int upper
	 *     2. Output - int
	 *     3. Constraint - No
	 * 2. Test Data
	 *    
	 *     Positive
	 *     Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
	 *     
	 *     Edge
	 *     Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5
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
		int[] calories = { 1, 2, 3, 4, 5 };
		int k = 1, lower = 3, upper = 3;
		Assert.assertTrue(findTotalPoints(calories, k, lower, upper) == 0);
	}

	@Test
	public void testData02() // Edge
	{
		int[] calories = { 3, 2 };
		int k = 2, lower = 2, upper = 3;
		Assert.assertTrue(findTotalPoints(calories, k, lower, upper) == 1);
	}

	@Test
	public void testData03() // Edge
	{
		int[] calories = { -1, 1, 0, 2, -2, 0 };
		int k = 1, lower = -1, upper = 1;
		Assert.assertTrue(findTotalPoints(calories, k, lower, upper) == 0);
	}

	@Test
	public void testData04() // Edge
	{
		int[] calories = { 2, 3, -4, 5, 6, -6, 9, -9, 1 };
		int k = 3, lower = 1, upper = 5;
		Assert.assertTrue(findTotalPoints(calories, k, lower, upper) == 0);
	}

	@Test
	public void testData05() // Edge
	{
		int[] calories = { 6, 5, 0, 0 };
		int k = 2, lower = 1, upper = 5;
		Assert.assertTrue(findTotalPoints(calories, k, lower, upper) == 0);
	}
	
	/*
	 * 1.Initialize two variables currentCal and totalCal as 0
	   2.Iterate the input, increment by k
			a) add the element from currentIndex to currentIndex + k -1 value to totalCal
			b) if currentVal < lower t--
			c) if currentVal > upper t++
			d) reset currentCal to zero
	   3.return totalCal
	 * Time : O(n)
	 * Space :O(1)
	 */
	
	private int findTotalPoints(int[] calories, int k, int lower, int upper) {
		int totalCal = 0;
		for (int i = 0; i <= calories.length - k; i += k) {
			int currentCal = 0;
			int addIndex = i + k - 1;
			currentCal = calories[i];
			while (addIndex > i)
				currentCal += calories[addIndex--];
			if (currentCal < lower)
				totalCal -= 1;
			if (currentCal > upper)
				totalCal += 1;
			currentCal = 0;
		}
		return totalCal;
	}

}
