package bruteforce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class UniqueNumberOccurrences {
	/* Problem Statement
	  * Given array of integers, write a function that returns true only if the number of occurrences
	  * of each value in array is unique
	  * 1. Did I understand the problem? yes or no

	        If no ask the person to provide with more details with examples
	        If yes go to the next step

	        What is the input(s)? int[]
	        What is the expected output? boolean
	        Do I have any constraints to solve the problem? Dont use additional DS, Use only hash
	        Do I have all the information to go to the next steps?  Yes
	        How big is your test data set will be? 
			1,2,3,1,1,3
			1,2,3
			1,-1,-1,2,2,2,-2,-2,-2,-2
			

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
	        Approach 1 : Using Bruteforce using two for loops
	        Approach 2 : Using HashMap 
	        
	6.      Approach 1 : Using Max functionUsing Bruteforce using two for loops - O(n) +O(n^2) + O(m) => O(n^2)
			Approach 2 : Using HashMap - O(n)  + O(n) => O(n)
			
			
	  */
	
	@Test
	public void testData01()
	{
		int[] data = {1,2,3,1,1,3};
		// 1 => 3, 2 => 1 3=> 2 => [3,1,2]=
		Assert.assertTrue(isUniqueOccurrencesPresent(data));
		Assert.assertTrue(isUniqueOccurrencesPresentHashMap(new int[]{1,2,3,1,1,3}));
		
	}
	
	@Test
	public void testData02()
	{
		int[] data = {1,2,3};
		Assert.assertFalse(isUniqueOccurrencesPresent(data));
		Assert.assertFalse(isUniqueOccurrencesPresentHashMap(new int[]{1,2,3}));
		
	}
	
	@Test
	public void testData03()
	{
		int[] data = {1,-1,-1,2,2,2,-2,-2,-2,-2};
		Assert.assertTrue(isUniqueOccurrencesPresent(data));
		Assert.assertTrue(isUniqueOccurrencesPresentHashMap(new int[]{1,-1,-1,2,2,2,-2,-2,-2,-2}));
	}
	
	@Test
	public void testData04()
	{
		int[] data = {1,1,2,2,2,3,3};
		Assert.assertFalse(isUniqueOccurrencesPresent(data));
		Assert.assertFalse(isUniqueOccurrencesPresentHashMap(new int[]{1,1,2,2,2,3,3}));
	}
	
	/* Create a variable marker and store the data[i]
	 * Create a variable counter,index
	 * Create a array of length of same length
	 * Iterate the array once and check if current element is equal to marker
	 *   if equal update the current element to marker value, Update counter
	 *   Push to the array 
	 * Iterate the array from 1 index
	 * if current element is equal to marker break and move to next iteration
	 * Iterate the inner array from i+1 and check if current value is not equal to market
	 *  if not equals update the current value to marker value and increment the count
	 *  push to array
	 *  
	 *  Now iterate the new array if its
	 * 
	 * Time : O(n) + O(n^2) + O(m) => O(n^2)
	 * Space : O(n) + O(m) => O(m+n)
	 */
	private boolean isUniqueOccurrencesPresent(int[] data) {
		if (data.length == 1)
			return true;
		if (data.length == 0)
			return false;
		int marker = data[0];
		int counter = 1, index = 0;
		int[] occurrenceArr = new int[data.length];
		for (int i = 1; i < data.length; i++) {
			// Getting the count of Marker element count
			if (data[i] == marker) {
				data[i] = marker;
				counter++;
			}
		}
		occurrenceArr[index++] = counter;
		// Traversing the array from index 1
		for (int i = 1; i < data.length; i++) {
			counter = 0;
			if (data[i] == marker)
				continue; // if the i is equal to marker value then move to the next element
			else {
				counter++;
				for (int j = i + 1; j < data.length; j++) { // Iterate using inner array
					if (data[i] == data[j]) // If i and j are equals increment counter
					{
						counter++; // and making j value equal to marker value
						data[j] = marker;
					}
				}
				occurrenceArr[index++] = counter;
			}
		}
		int[] resultArr = Arrays.copyOf(occurrenceArr, index); // Making the occurenceArr of items till it filled
		if (resultArr.length == 1)
			return true;
		for (int i = 0; i < resultArr.length - 1; i++) {
			for (int j = i + 1; j < resultArr.length; j++) {
				if (resultArr[i] == resultArr[j])
					return false;
			}
		}
		return true;
	
	}
	
	/*
	 * Create a hash map and insert all items in array in <K,V>
	 * Get the values set and insert to another set
	 * If all items got added return true else false
	 * Time : O(n) + O(n) => O(n)
	 * Space : O(n) + O(n) => O(n)
	 */
	 
	private boolean isUniqueOccurrencesPresentHashMap(int[] data)
	{
		if (data.length == 1)
			return true;
		if (data.length == 0)
			return false;
		Map<Integer, Integer> map =  new HashMap<>();
		for (int i = 0; i < data.length; i++) 
		{
			map.put(data[i], map.getOrDefault(data[i], 0)+1);
		}
		Set<Integer> occurrencesSet = new HashSet<>();
		for (int i : map.values()) {
			if(!occurrencesSet.add(i)) return false;
		}	
		return true;
	}
	
}
