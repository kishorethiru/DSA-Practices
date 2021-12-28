package twoPointers;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class P23_HappyNumber 
{
	/*
	 * Write an algorithm to determine if a number n is happy. A happy number is a number defined by 
	 * the following process:

		Starting with any positive integer, replace the number by the sum of the squares of its digits.
		Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
		Those numbers for which this process ends in 1 are happy.
		Return true if n is a happy number, and false if not.
		
		Example 1:
		
		Input: n = 19
		Output: true
		Explanation:
		12 + 92 = 82
		82 + 22 = 68
		62 + 82 = 100
		12 + 02 + 02 = 1
		
		Example 2:
		Input: n = 2
		Output: false
	 * 
	 */
	
	/*
	   1. 
	  	  Input(s) ? int
		  Output ? Boolean
		  Constraint(s) ? Time and Space optimized
	   
	   2. Test data
			Positive :19
			Negative :2	
			Edge     :100 
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 

	 */
	@Test
	public void testData01()
	{
		Assert.assertEquals(isHappyNumberOptmized(19), true);
		
	}
	
	@Test
	public void testData02()
	{
		Assert.assertEquals(isHappyNumberOptmized(2), false);

	}
	
	@Test
	public void testData03()
	{
		Assert.assertEquals(isHappyNumberOptmized(100), true);
	}
	
	/* Pseudocode
	 * 1. Initialize an int sumOfSquare assign value of input to it
	 * 2. Create a hash set
	 * 3. Find the each digit of inputNumber (using modulo) operator
	 *     a) Create variable n and store the sumOfSquare
	 *     b) square the number of each digit and add to sumOfSquare
	 * 4. if  sumOfSquare = 1, return true
	 * 5. Add sumOfSquare the set
	 * 6. Repeat  3,4,5 till, set gets added with duplicate element  
	 * 
	 * Time : O(m*n)
	 * Space : O(m)
	 */
	private boolean isHappyNumber(int number) {
		int sumOfSquares = number;
		Set<Integer> numberSet = new HashSet<>();
		do {
			int n = sumOfSquares;
			sumOfSquares = 0;
			while (n != 0) {
				sumOfSquares += (n % 10) * (n % 10);
				n /= 10;
			}
			if (sumOfSquares == 1)
				return true;
		} while (numberSet.add(sumOfSquares));
		return false;
	}
	

	/*  1. Iterate till the sum of each square is not equal to 4 and 1
	 *   	a)if sum of square number = 1, return true
	 *  2. return false 
	 * 
	 */
	private boolean isHappyNumberOptmized(int number) {
		while(number != 1 && number !=4 ){
			number = sumAndSquareNumber(number);
			if(number==1) return true;
		}
		return false;
	}
	
	/* 1. Initialize Sum as 0
	 * 2. Iterate till the n becomes zero
	 *  	find the last number of the n and square it
	 *  	find the number other than last digit and update the input
	 * 3. return sum
	 * 
	 */
	private int sumAndSquareNumber(int n)
	{
		int sum  = 0;
		while (n != 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}


}
