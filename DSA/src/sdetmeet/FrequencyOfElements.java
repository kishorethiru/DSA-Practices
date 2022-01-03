package sdetmeet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class FrequencyOfElements {
	/*
		Problem Statement
	
	*/

	/*
	   1. 
	  Input(s) ? 
		  Output ?
		  Constraint(s) ?
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		List<Integer> list= new ArrayList<>(Arrays.asList(2,1,2));
		Assert.assertTrue(freqElements(list).equals(Arrays.asList(2,1,1)));
	}

	@Test
	public void testData02() { // Negative
		List<Integer> list= new ArrayList<>(Arrays.asList(2,2,2));
		Assert.assertTrue(freqElements(list).equals(Arrays.asList(3,2,1)));
	}

	@Test
	public void testData03() { // Edge

	}
	
	private List<Integer> freqElements(List<Integer> nums) {
		Map<Integer,Integer>  freqMap = new HashMap<Integer, Integer>();
		for(int i : nums) freqMap.put(i, freqMap.getOrDefault(i, 0)+1);
		List<Integer> arr = new ArrayList<>();
		for(int i = 0 ; i<nums.size(); i++) {
			int currentVal = nums.get(i);
			arr.add(freqMap.get(currentVal));
			if(freqMap.get(currentVal)>1) 
				freqMap.put(currentVal, freqMap.get(currentVal)-1);
			else freqMap.remove(nums.get(i));
		}
		return arr;
	}
}
