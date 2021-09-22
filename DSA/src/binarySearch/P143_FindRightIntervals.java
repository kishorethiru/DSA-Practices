package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P143_FindRightIntervals {
	/*
		Problem Statement
		
		You are given an array of intervals, where intervals[i] = [starti, endi]
		and each starti is unique.

		The right interval for an interval i is an interval j such that startj >= 
		endi and startj is minimized.
		Return an array of right interval indices for each interval i. 
		If no right interval exists for interval i, then put -1 at index i.	
	*/

	/*
	   1. 
	  	  Input(s) ? int[][] 
		  Output ? int[]
		  Constraint(s) ?
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : Bruteforce
			 Approach 2 : Sorting and find 
	
	   4.  O - Notation 
			 Approach 1 : Bruteforce Time :O(n^2), Space : O(n)
			 Approach 2 : Sorting and find Time O(nlogn), Space : O(n)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[][] input = {{3,4},{2,3},{1,2}};
		int[] output = {-1,0,1};
		Assert.assertTrue(Arrays.equals(findRightIntervalsUsingBS(input), output));
	}

	@Test
	public void testData02() { // Negative
		int[][] input = {{1,2}};
		int[] output = {-1};
		Assert.assertTrue(Arrays.equals(findRightIntervalsBruteForce(input), output));
	}

	@Test
	public void testData03() { // Edge
		int[][] input = {{1,4},{2,3},{3,4}};
		int[] output = {-1,2,-1};
		Assert.assertTrue(Arrays.equals(findRightIntervalsUsingBS(input), output));
	}

	/* 1.Create a new array of length input
	 * 2.Iterate the input from 0
	 *   a) Store the i end value
	 *   b) Iterate the input from 0
	 *   c)	Store the start value 
	 *   d)	Compare start and end start>=end update max and its index
	 *   e) store the value of index to i in the array
	 * 3.return retArray 
	 * Time : O(n^2)
	 * Space : O(n)
	 */
	private int[] findRightIntervalsBruteForce(int[][] intervals) {
		int[] op = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			int end = intervals[i][1];
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int j = 0; j < intervals.length; j++) {
				int start = intervals[j][0];
				if (start >= end && start < min) {
					min = start;
					index = j;
				}
			}
			op[i] = index;
		}
		return op;
	}
	
	/* 1. Create a new array of length input for return output
	 * 2. Create a treemap and add the first index values as key and index as value
	 * 3. Iterate the input and get the ceilingEntry of the 1 index of current i
	 *    a) if the ceilingEntry is null push -1 to i index
	 *       (ceilingEntry will give entries of treemap of 1 index value if its greater and min of it)
	 *    b) else push the value of the entry 
	 * 4. Return the retArr
	 * Time : O(nlogn)
	 * Space : O(n)
	 */
	private int[] findRightIntervalsUsingTreeMap(int[][] intervals) {
		int[] op = new int[intervals.length];
		TreeMap<Integer,Integer> treeMap = new TreeMap<>();
		for(int i = 0;i<intervals.length;i++) {
			treeMap.put(intervals[i][0], i);
		}
		for(int i = 0;i<intervals.length;i++) {
			Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i][1]);
			op[i] = entry == null ? -1 : entry.getValue();
		}
		return op;
	}
	
	/* Using BS
	 * 1. Create a map and push the value of 0 index and i to map.
	 * 2. Convert map to arraylist and sort by the key
	 * 3. Create a output array
	 * 4. Iterate the input
	 *    a) Find if any value if present greater or equal than current 1 index value
	 *    b) return the value of that 
	 *    c) Get the value of that is greater and push its index to return array
	 * 5. Return return array
	 * Time : O(nlogn)
	 * Space : O(n)
	 */
	private int[] findRightIntervalsUsingBS(int[][] intervals) {
		Map<Integer,Integer> map = new HashMap<>();
		int index = 0;
		for(int i = 0; i<intervals.length;i++) {
			map.put(intervals[i][0], i);
		}
 		ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, (a,b) -> {
			return a.getKey().compareTo(b.getKey());
		});
		int[] retArr = new int[intervals.length];
		for(int i = 0; i<intervals.length;i++) {
			index = bs(list,intervals[i][1]);
			retArr[i] = index == Integer.MAX_VALUE  ? -1 : map.get(index);
		}
		return retArr;
	}
	
	private int bs(ArrayList<Map.Entry<Integer,Integer>> list, int i) {
		if(list.get(list.size()-1).getKey()<i) return Integer.MAX_VALUE;
		int low = 0, high = list.size()-1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(list.get(mid).getKey()>=i) high = mid-1;
			else low = mid+1;
		}
		return list.get(low).getKey();
	}
}
