package bruteforce;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P9_RemoveTargetInArray {
	/* Problem Statement
	  * Remove the target element from the array and return the array
	  * 1. Did I understand the problem? yes or no

	        If no ask the person to provide with more details with examples
	        If yes go to the next step

	        What is the input(s)? int[], int
	        What is the expected output? int[]
	        Do I have any constraints to solve the problem? Dont use additional DS, Should not sort
	        Do I have all the information to go to the next steps?  Yes
	        How big is your test data set will be? 
			1,2,7,5,6,7,8, target - 2
			1,2,3,4, target- 7 - Negative
			2,3,5,6,5 target 5  edge
			1,1,1,1 target 1 edge 
			

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
	        Approach 1 : Using Bruteforce
	        Approach 2 : Replacing array element by next one.Not preserving target in Array
	        Approach 3 : Swapping array element by next one. preserving target in Array
	        
	6.      Approach 1 : Using Max function - O(2n) => O(n)
			Approach 2 : Using arithmetic operators - O(n)
			Approach 3 : Brute force using 2 for loops - O(n)
			
	  */
	
	@Test
	public void testData01()
	{
		int[] data = {1,2,7,5,6,7,8};
		int target = 2;
		Assert.assertTrue(Arrays.equals(removeTargetElementInArray(data,target), new int[] {1,7,5,6,7,8}));
		Assert.assertTrue(Arrays.equals(removeTargetReplacingElement(new int[]{1,2,7,5,6,7,8},target), new int[] {1,7,5,6,7,8}));
		Assert.assertTrue(Arrays.equals(removeTargetSwappingElement(new int[]{1,2,7,5,6,7,8},target), new int[] {1,7,5,6,7,8}));
		
	}
	
	@Test
	public void testData02()
	{
		int[] data = {1,2,3,4};
		int target = 7;
		Assert.assertTrue(Arrays.equals(removeTargetElementInArray(data,target), new int[] {1,2,3,4}));
		Assert.assertTrue(Arrays.equals(removeTargetReplacingElement(new int[]{1,2,3,4},target), new int[] {1,2,3,4}));
		Assert.assertTrue(Arrays.equals(removeTargetSwappingElement(new int[]{1,2,3,4},target), new int[] {1,2,3,4}));
	}
	@Test
	public void testData03()
	{
		int[] data = {2,3,5,6,5};
		int target = 5;
		Assert.assertTrue(Arrays.equals(removeTargetElementInArray(data,target), new int[] {2,3,6}));
		Assert.assertTrue(Arrays.equals(removeTargetReplacingElement(new int[] {2,3,5,6,5},target), new int[] {2,3,6}));
		Assert.assertTrue(Arrays.equals(removeTargetSwappingElement(new int[] {2,3,5,6,5},target), new int[] {2,3,6}));
		
	}
	@Test
	public void testData04()
	{
		int[] data = {1,1,1,1};
		int target = 1;
		Assert.assertTrue(Arrays.equals(removeTargetElementInArray(data,target), new int[] {}));
		Assert.assertTrue(Arrays.equals(removeTargetReplacingElement(new int[]{1,1,1,1},target), new int[] {}));
		Assert.assertTrue(Arrays.equals(removeTargetSwappingElement(new int[]{1,1,1,1},target), new int[] {}));
	
	}
	
	/* Pseudocode Brute force
	 * Create a int counter and assign to 0
	 * Iterate the array, if current element matches target increment counter
	 * Create a array of length input size -counter
	 * Iterate the array, if current element not matches target push in to array
	 * Return the array
	 * 
	 */
	
	 private int[] removeTargetElementInArray(int[] data, int target) {
		if (data.length == 0) return data;
		if (data.length == 1) 
		{
			if (data[0] == target)
				return new int[] {};
			else
				return data;
		}
		int counter = 0;
		for (int i : data) 
		{
		 if(i==target) counter++;	
		}
		int[] returnData = new int[data.length-counter];
		counter = 0;
		for (int i : data) {
			if(i != target ) returnData[counter++] = i;
		}
		return returnData;	
	}
	 
	 /* Create a variable pointer = 0;
	  * Iterate the array
	  *  if current element is not matching the target
	  *     Assign the value of current element to data[pointer]
	  *     increment pointer
	  * Return the array by from the range from initial to pointer count
	  * 
	  */

	 private int[] removeTargetReplacingElement(int[] data, int target) {
		 if (data.length == 0)
			 return data;
		 if (data.length == 1) {
			 if (data[0] == target)
				 return new int[] {};
			 else
				 return data;
		 }
		
		 int pointer = 0;
		 for (int i = 0; i < data.length; i++) {
			 if (data[i] != target) {
				 data[pointer++] = data[i];
			 }
		 }
		 System.out.println(Arrays.toString(data));
		 return Arrays.copyOf(data, pointer);

	 }
	 
	 /* Create a variable pointer = 0;
	  * Iterate the array
	  *  if current element is not matching the target
	  *     Assign the value of current element to data[pointer]
	  *     increment pointer
	  * Return the array by from the range from initial to pointer count
	  * 
	  */

	 private int[] removeTargetSwappingElement(int[] data, int target) {
		 if (data.length == 0)
			 return data;
		 if (data.length == 1) {
			 if (data[0] == target)
				 return new int[] {};
			 else
				 return data;
		 }
		 int pointer = 0;
		 for (int i = 0; i < data.length; i++) {
			 if (data[i] != target) {
				 int temp = data[i];
				 data[i] = data[pointer];
				 data[pointer++] = temp; 
			 }
		 }
		 return Arrays.copyOf(data, pointer);
	 }
}
