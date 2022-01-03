package singlepassanddp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P153_SmallestNegativeBalance {
	/*
		Problem Statement
		
		Find the negative balance 
	
	*/

	/*
	   1. 
	  	  Input(s) ? String[] 
		  Output ? List<String>
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
		String[] input = {"Alex Blake 2","Blake Alex 2","Cassey Alex 5", "Blake Cassey 7",
							"Alex Blake 4", "Alex Cassey 4"};
		List<String> op = Arrays.asList("Cassey");
		Assert.assertTrue(findNegativeBalance(input).equals(op));
	}

	@Test
	public void testData02() { // Negative
		String[] input = {"Alex Blake 2","Blake Alex 2","Cassey Alex 5", "Alex Cassey 5"};
		List<String> op = Arrays.asList("Nobody has a negative balance");
		Assert.assertTrue(findNegativeBalance(input).equals(op));
	}

	@Test
	public void testData03() { // Edge
		String[] input = {"Alex Blake 2","A	lex Cassey 2"};
		List<String> op = Arrays.asList("Blake","Cassey");
		Assert.assertTrue(findNegativeBalance(input).equals(op));
	}
	
	/*  
	 * Create a treemap
	 * Iterate the input
	 * 	 Split the each item by " "
	 *   Add the borrower (0th index) with the value which is 2nd index or update if already exists
	 * 	 Subtract the lender (1st index) with the value which is 2nd index or update if already exists
	 * int minValue ;
	 * Create a list of strings
	 * Iterate the treeMap with entry set
	 *   if the min value 1st is not negative return "Nobody has a negative balance" 
	 *   iterate and add the key to list until value not matches minValue
	 * return list.
	 * 
	 * Time : O(2n) - O(n)
	 * Space: O(n) 
	 */
	
	private List<String> findNegativeBalance(String[] input) {
		Map<String, Integer> map = new TreeMap<>();
		for (String eachVal : input) {
			String[] val = eachVal.split(" ");
			String borrower = val[0];
			String lender   = val[1];
			int value       = Integer.valueOf(val[2]);
			map.put(borrower, map.getOrDefault(borrower, 0)-value);
			map.put(lender, map.getOrDefault(lender, 0)+value);			
		}
		System.out.println(map);
		int minValue = Collections.min(map.values());
		if(minValue>=0) return new ArrayList<>(Arrays.asList("Nobody has a negative balance"));
		Set<String> retSet = new TreeSet<>();
		for (Map.Entry<String, Integer> eachSet : map.entrySet()){
			if(eachSet.getValue() == minValue) {
				retSet.add(eachSet.getKey());
			}
		}
		return new ArrayList<>(retSet);
	}
	
}
