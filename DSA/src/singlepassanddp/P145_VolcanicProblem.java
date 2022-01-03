package singlepassanddp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Kishore
 *
 */
public class P145_VolcanicProblem {
	/*
		Problem Statement
		Given two lists find the intersecting one and sort the resulting
		list 
	
	*/

	/*
	   1. 
	  	  Input(s) ? Two Lists of integer 
		  Output ?  List<Integer>
		  Constraint(s) ?
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : Two pointers, Hashing
	
	   4.  O - Notation 
			 Approach 1 : Two pointers, Hashing
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		List<Integer> volcanic = Arrays.asList(7000,13400,7000,14000);
		List<Integer> nonVolcanic = Arrays.asList(7000,13400,7000,15000);
		List<Integer> output = Arrays.asList(13400,7000,7000);
		Assert.assertTrue(sortIntersectionTwoPtr(volcanic,nonVolcanic).equals(output));
	}

	@Test
	public void testData02() { // Negative
		List<Integer> volcanic = Arrays.asList(7000,13400,7000,14000);
		List<Integer> nonVolcanic = Arrays.asList(8000,7100,17000);
		List<Integer> output = Arrays.asList();
		Assert.assertTrue(sortIntersectionTwoPtr(volcanic,nonVolcanic).equals(output));
	}

	@Test
	public void testData03() { // Edge
		List<Integer> volcanic = Arrays.asList(7000,50000,2000,19000);
		List<Integer> nonVolcanic = Arrays.asList(8000,7000,17000);
		List<Integer> output = Arrays.asList(7000);
		Assert.assertTrue(sortIntersectionTwoPtr(volcanic,nonVolcanic).equals(output));
	}
	
	private List<Integer> sortIntersection(List<Integer> volcanic,List<Integer> nonVolcanic )
	{
		Map<Integer,Integer> volcanicMap = new HashMap<>();
		for(Integer s : volcanic) {
			volcanicMap.put(s, volcanicMap.getOrDefault(s, 0)+1);
		}
		List<Integer> retList = new ArrayList<>();
		for(Integer i : nonVolcanic) {
			if(volcanicMap.containsKey(i)) {
				retList.add(i);
				if(volcanicMap.get(i)>1) volcanicMap.put(i, volcanicMap.get(i)-1);
				else volcanicMap.remove(i);
			}
		}
		Collections.sort(retList,Collections.reverseOrder());
		return retList;
	}
	
	private List<Integer> sortIntersectionTwoPtr(List<Integer> volcanic,List<Integer> nonVolcanic )
	{
		Collections.sort(volcanic);
		Collections.sort(nonVolcanic);
		int p1 = volcanic.size()-1, p2 =nonVolcanic.size()-1;
		List<Integer> retList = new ArrayList<>();
		while(p1>=0 && p2>=0){
			if(volcanic.get(p1).equals(nonVolcanic.get(p2))){
				retList.add(nonVolcanic.get(p2));
				p2--;
				p1--;
			}
			else if(volcanic.get(p1)>nonVolcanic.get(p2)) p1--;
			else p2--;
		}
		return retList;
	}
}
