package bruteforce;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class FindMajorityElement
{
	/*
	 * Given an array nums of size n, return the majority element. you may assume that 
	 * the majority element always exists in the array.The majority 
	 * element is the element that appears more than (n/2) times. 
	 * 
	 * 1. Did I understand the problem? Yes

        If no ask the person to provide with more details with examples 
        Ex : [1,2,2,2,2] 1=>1 2=>4
        4 is the higher occurrence found which is greater, So n/2 => 3 since the occurence is greater
        than 3, 2 is the majority element
            
        If yes go to the next step

        What is the input(s)? int[]
        What is the expected output? int 
        Do I have any constraints to solve the problem? Do not sort, No extra space 
        Do I have all the information to go to the next steps 
        How big is your test data set will be? 
        1,2,2,2,2
        1,1,2,2
        1,2,2,3,3,3,3,3,3
        
		

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes -Bruteforce using two for loops - great is there an alternate ? Yes, 
        No - can I break the problem into sub problems?

4. Ask for hint (if you dont know how to solve this
5.  Do I know alternate solutions as well
       Approach 1: Brute Force 
       Approach 2:HashMap 
       Approach 3 : Hashmap with single pass
       Approach 4 : Sort the input and using midpoint 

6. If you know the alternate solution find out the O-notations (performance)
 	   Approach 1: Brute Force => O(n^2), O(1)
       Approach 2:HashMap => O(n), O(n)
       Approach 3 : Hashmap with single pass = > O(n), O(n)
       Approach 4 : Sort the input and using midpoint => O(1), O(1)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code
9. Test against different test data
10. If it fails then debug to solve it
	 * 
	 */
	
	@Test
	public void testData01() 
	{
		int[] data = {1,2,2,2,2};
//		Assert.assertTrue(findMajorityElement(data)==2);
//		Assert.assertTrue(findMajorityElementUsingMapSinglepass(new int[]{1,2,2,2,2})==2);
		Assert.assertTrue(findMajorityElementUsingMidpoint(new int[]{1,2,2,2,2})==2);
		
	}
	
	@Test
	public void testData02() 
	{
		int[] data = {1,1,2,3,3,3,3,3,3};
//		Assert.assertTrue(findMajorityElement(data)==3);
//		Assert.assertTrue(findMajorityElementUsingMapSinglepass(new int[]{1,1,2,3,3,3,3,3,3})==3);
		Assert.assertTrue(findMajorityElementUsingMidpoint(new int[]{1,1,2,3,3,3,3,3,3})==3);
		
		
	}
	
	@Test
	public void testData03() 
	{
		int[] data = {2,2,2,3,3,3};
//		Assert.assertTrue(findMajorityElement(data)==0);
//		Assert.assertTrue(findMajorityElementUsingMapSinglepass(new int[]{2,2,2,3,3,3}) == 0);
		Assert.assertTrue(findMajorityElementUsingMidpoint(new int[]{2,2,2,3,3,3}) == 0);
	}
	
	@Test
	public void testData04() 
	{
		int[] data = {2,2,3,3,4,4};
//		Assert.assertTrue(findMajorityElement(data)==0);
//		Assert.assertTrue(findMajorityElementUsingMapSinglepass(new int[]{2,2,3,3,4,4})==0);
		Assert.assertTrue(findMajorityElementUsingMidpoint(new int[]{2,2,3,3,4,4})==0);
	}
	
	/*
	 * Create  variables maxOccurCount, maxOccuValue and marker
	 * Iterate the input
	 *   Initialize currentIndexOcc = 0;
	 *   if current element  == marker
	 *   increment the occurenceCount
	 * Iterate the input from index 1
	 *  If current element is marker continue with next element
	 *  Iterate the input starting from i+1 and check if i == j
	 *   if equals increase the occurrence count and update the current value as marker value
	 *  Check and update the max occurrence value and occurrenceCount
	 *  if maxOccurrenceCount is greater than n/2 return the max occurrence value 
	 *  else throw exception 
	 *  Time : O(n) + O (n^2) => O(n^2)
	 *  Space : O(1)
	 * 
	 */
	
	private int findMajorityElement(int[] data)
	{
		int maxOccurCount = 1,maxOccurValue=data[0],marker = data[0];
		for (int i = 1; i < data.length; i++) 
		{
			if(data[i]==marker) maxOccurCount++;	
		} 
		for (int i = 1; i < data.length-1; i++) 
		{
			int currentElementOcc = 0;
			if(data[i] == marker) continue;
			else
			{
				currentElementOcc++;
				for (int j = i+1; j < data.length; j++) 
				{
					if(data[i] == data[j] && data[j] != marker)
					{
					 data[j] = marker;
					 currentElementOcc++;
					}	
				}
			}
			if(currentElementOcc>maxOccurCount)
			{
				maxOccurCount = currentElementOcc;
				maxOccurValue = data[i];
			}	
		}
		if(maxOccurCount > (data.length >> 1)) return maxOccurValue;
		return 0; 
	}
	
	/*
	 * Iterate the input and add to hashmap using K,V pairs
	 * Iterate the values in map,
	 *  if current value is > size of input/2, return the current element else false
	 *  
	 *  Time : O(n) + O(n) => O(n)
	 *  Space : O(n)
	 */
	
	private int findMajorityElementUsingMap(int[] data)
	{
		Map<Integer, Integer> inputData = new HashMap<>();
		for (int i = 0; i < data.length; i++) 
		{
			inputData.put(data[i], inputData.getOrDefault(data[i], 0)+1);
		}
		for (Map.Entry<Integer, Integer> i : inputData.entrySet()) {
			if(i.getValue() > (data.length >> 1)) return i.getKey(); 
		}
		return 0;	
	}
	
	/* Pseudocode - Hashmap Singlepass
	 * Create variable length and store the length of input
	 * Create a Hash map
	 * Iterate the input and add into the map with <K,V>
	 *  After adding to the m, check if the current element value is
	 *   greater than n/2 if > return the current element
	 * At the end throw new RunTimeException
	 * Time : O(n)
	 * Space : O(n) 
	 */
	
	private int findMajorityElementUsingMapSinglepass(int[] data)
	{
		int inputSize = data.length;
		Map<Integer, Integer> dataMap = new HashMap<>();
		for (int i = 0; i < data.length; i++) 
		{
			dataMap.put(data[i], dataMap.getOrDefault(data[i], 0) + 1);
			if(dataMap.get(data[i]) > inputSize >> 1) return data[i];
		}
		throw new RuntimeException("Invalid Input Data");
	}
	
	/* Pseudocode - Sort and midpoint
	 * Create a variable length and store the size of input
	 * Check if the  n / 2 is even return the mid point value
	 *       if n/2 is odd check if mid point and mid point + 1 are same 
	 *       if same return the mid point value
	 * Time : O(1)
	 * Space : O (1)      
	 */
	
	private int findMajorityElementUsingMidpoint(int[] data)
	{
		int length = data.length;
		if(length == 0) throw new RuntimeException("Invalid Input Data");
		if(length%2 == 0) return data[length/2];
		else
		{
			if(data[length/2] == data[(length/2) + 1]) return data[length/2];
		}
		throw new RuntimeException("Invalid Input Data");	
	}

}
