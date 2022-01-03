package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P94_GroupUsers {
	/*
		Problem Statement
			Given a list of integer , each item represents the 
			size of group. Grouping the users group size and return them 
	
	*/

	/*
	   1. 
	  	  Input(s) ? List<Integer>
		  Output ?List<List<Integer>>
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

		int[] groupSizes = { 3, 3, 3, 3, 3, 1, 3 };
		System.out.println(groupThePeople(groupSizes));
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}

	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> retList = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < groupSizes.length; i++) {
			List<Integer> list =  new ArrayList<>(i);
			if (map.containsKey(groupSizes[i])) {
				list = map.get(groupSizes[i]);
				list.add(i);
				
			} else
				list.add(i);
			map.put(groupSizes[i], list);
		}
		ArrayList<Entry<Integer, List<Integer>>> entry = new ArrayList<>(map.entrySet());
		for (Entry<Integer, List<Integer>> eachEntry : entry) {
			List<Integer> values = eachEntry.getValue();
			while (values.size() != 0) {
				int count = eachEntry.getKey();
				List<Integer> list = new ArrayList<>();
				while (count != 0) {
					list.add(values.remove(0));
					count--;
				}
				retList.add(list);
			}
		}
		return retList;
	}
}
