package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P102_RingsAndRods_LC_2103 {
	/*
		Problem Statement
		There are n rings and each ring is either red, green, or blue. The rings are distributed across
		 ten rods labeled from 0 to 9.

		You are given a string rings of length 2n that describes the n rings that are placed onto the rods. 
		Every two characters in rings forms a color-position pair that is used to describe each ring where:

		The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
		The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').
		For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3, 
		a green ring placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.
		
		Return the number of rods that have all three colors of rings on them.
	
	*/

	/*
	   1. 
	  	  Input(s) ? String 
		  Output ? int
		  Constraint(s) ?
	   
	   2. Test data
			Positive : B0B6G0R6R0R6G9
			Negative : G4
			Edge     : B0R0G0R9R0B0G0
	
	   3.  Approaches Known 
			 Approach 1 : Using Hashing Algo
	
	   4.  O - Notation 
			 Approach 1 : Using Hashing Algo Time : O(n), Space O(n)
	
	   5.  Pseudocode		
	
	 */	

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String rings = "B0B6G0R6R0R6G9";
		Assert.assertTrue(countPoints(rings)==1);
	}

	@Test
	public void testData02() { // Negative
		String rings = "G4";
		Assert.assertTrue(countPoints(rings)==0);
	}

	@Test
	public void testData03() { // Edge
		String rings = "B0R0G0R9R0B0G0";
		Assert.assertTrue(countPoints(rings)==1);
	}
	
	@Test
	public void testData04() { // Edge
		String rings = "G7G9R4B0G6R1R9R5B8R4G4B4R6B4B1G2B9G5B6G5";
		Assert.assertTrue(countPoints(rings)==3);
	}
	
	public int countPoints(String rings) {
        Map<Integer,Set<Character>> ringsMap = new HashMap<>();

        int index = 0,count= 0 ;
        while(index < rings.length()){
            char currentVal = rings.charAt(index++);
            int val = Integer.parseInt(rings.charAt(index++)+"");
            if(ringsMap.containsKey(val)){
              if(ringsMap.get(val).size()<3){	
            	  Set<Character> set = ringsMap.get(val);
              	  set.add(currentVal);
              	  ringsMap.put(val, set);
              }
            }
            else {
                Set<Character> set = new HashSet<>();
                set.add(currentVal);
                ringsMap.put(val, set);
            }
        }
        for(Map.Entry<Integer, Set<Character>> entrySet : ringsMap.entrySet()) 
            if(entrySet.getValue().size()==3) count++;
        return count;
    }
}
