package singlepassanddp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class P138_FindTheSecondLeastCharacter {
	
	@Test
	public void testData01(){            // Positive
		String s = "abcaab";
		Assert.assertTrue(findSecondLeastChar(s) == 'b');
	}


	@Test
	public void testData02(){			 // Negative
		String s = "aaaa";
		Assert.assertTrue(findSecondLeastChar(s) == ' ');
	}

	@Test
	public void testData03(){			 // Edge
		String s = "aabc";
		Assert.assertTrue(findSecondLeastChar(s) == 'c');
	}
	
	/* Create a new map and add the all the chars and its occurrence to it
	 * if map size is 1 return empty char
	 * Add the map entry set to new list
	 * Sort the list
	 * return the second least char
	 */

	private char findSecondLeastChar(String s) {
		Map<Character, Integer> inputMap = new HashMap<>();
		for (char c : s.toCharArray())
			inputMap.put(c, inputMap.getOrDefault(c, 0) + 1);
		if (inputMap.size() == 1)
			return ' ';
		ArrayList<Map.Entry<Character, Integer>> entrySet = new ArrayList<>(inputMap.entrySet());
		Collections.sort(entrySet, (a, b) -> {
			if (a.getValue() == b.getValue())
				return a.getKey().compareTo(b.getKey());
			else
				return a.getValue().compareTo(b.getValue());
		});
		return entrySet.get(entrySet.size() - 2).getKey();
		
	}

}
