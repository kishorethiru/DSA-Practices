package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class RearrangeString {
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
		String s = "aabbccc";
		rearrangeString(s);
//		Assert.assertTrue(rearrangeString(s).equals("aba"));
	}

	/**
	 * @param s
	 * @return
	 */
	private void rearrangeString(String s) {
		Map<Character,Integer> map = new HashMap<>();
		int maxOccur = 0;
		for(Character c : s.toCharArray()){
			map.put(c, map.getOrDefault(c, 0)+1);
			maxOccur = Math.max(maxOccur, map.get(c));
		}
//		if(maxOccur>(s.length()+1)/2) return "";
		ArrayList<Entry<Character, Integer>> list = new ArrayList<>(map.entrySet()); 
		Collections.sort(list, (a, b) -> (b.getValue().compareTo(a.getValue()))); // nlogn
		StringBuilder sb = new StringBuilder();
		int  i = 0;
		while(i < list.size()){
			Entry<Character,Integer> entry = list.get(i);
			Character firstChar = entry.getKey();
			int firstValue = entry.getValue();
			if(firstValue > 0){
				sb.append(firstChar);
				entry.setValue(firstValue- 1);
				if(i < list.size()-1) {
					Entry<Character, Integer> secondEntry = list.get(i + 1);
					char secondKey = secondEntry.getKey();
					int secondVal = secondEntry.getValue();
					if (secondVal > 0) {
						sb.append(secondKey);
						secondEntry.setValue(secondVal - 1);
					}
				}
			}
			else i++;
		}
		System.out.println(sb.toString());
//		return s.length() == sb.length() ? sb.toString() : "";
	}
	
	private String rearrangeStringFillArrays(String s) {
		Map<Character,Integer> map = new HashMap<>();
		int maxOccur = 0;
		for(Character c : s.toCharArray()){
			map.put(c, map.getOrDefault(c, 0)+1);
			maxOccur = Math.max(maxOccur, map.get(c));
		}
		if(maxOccur>(s.length()+1)/2) return "";
		ArrayList<Entry<Character, Integer>> list = new ArrayList<>(map.entrySet()); 
		Collections.sort(list, (a, b) -> (b.getValue().compareTo(a.getValue()))); // nlogn
		StringBuilder sb = new StringBuilder();
		int  i = 0;
		while(i < list.size()){
			Entry<Character,Integer> entry = list.get(i);
			Character firstChar = entry.getKey();
			int firstValue = entry.getValue();
			if(firstValue > 0){
				sb.append(firstChar);
				entry.setValue(firstValue- 1);
				if(i < list.size()-1) {
					Entry<Character, Integer> secondEntry = list.get(i + 1);
					char secondKey = secondEntry.getKey();
					int secondVal = secondEntry.getValue();
					if (secondVal > 0) {
						sb.append(secondKey);
						secondEntry.setValue(secondVal - 1);
					}
				}
			}
			else i++;
		}
		System.out.println(sb.toString());
		return s.length() == sb.length() ? sb.toString() : "";
	}

}
