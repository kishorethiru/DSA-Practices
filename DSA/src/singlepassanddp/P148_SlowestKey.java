package singlepassanddp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P148_SlowestKey {
	/*
	 * Problem Statement A newly designed keypad was tested, where a tester pressed
	 * a sequence of n keys, one at a time.
	 * 
	 * You are given a string keysPressed of length n, where keysPressed[i] was the
	 * ith key pressed in the testing sequence, and a sorted list releaseTimes,
	 * where releaseTimes[i] was the time the ith key was released. Both arrays are
	 * 0-indexed. The 0th key was pressed at the time 0, and every subsequent key
	 * was pressed at the exact time the previous key was released.
	 * 
	 * The tester wants to know the key of the keypress that had the longest
	 * duration. The ith keypress had a duration of releaseTimes[i] - releaseTimes[i
	 * - 1], and the 0th keypress had a duration of releaseTimes[0].
	 * 
	 * Note that the same key could have been pressed multiple times during the
	 * test, and these multiple presses of the same key may not have had the same
	 * duration.
	 * 
	 * Return the key of the keypress that had the longest duration. If there are
	 * multiple such keypresses, return the lexicographically largest key of the
	 * keypresses.
	 * 
	 */

	/*
	   1. 
	  	  Input(s) ? int[], String 
		  Output ? Char
		  Constraint(s) ? O(n)
	   
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
		Assert.assertTrue(slowestKey(new int[] {9,29,49,50}, "cbcd")=='c');
	}

	@Test
	public void testData02() { // Negative
		Assert.assertTrue(slowestKey(new int[] {12,23,36,46,62}, null)==' ');
	}

	@Test
	public void testData03() { // Edge
		Assert.assertTrue(slowestKey(new int[] {12,23,36,46,62}, "spuda")=='a');

	}
	
	/* 1. Initialize a char as retChar assign first index value of string to it
	 * 2. Intialize int and assign the first index from array
	 * 3. Iterate the array from index 1
	 *    a) get the difference of time between current and previous index
	 *    b) if its greater than max
	 *        Store to the return char and update max time
	 *    c) if its equal
	 *        compare and store the char
	 * 4. return char
	 * 
	 * Time  : O(n)
	 * Space : O(1)
	 * 
	 * 
	 */
	
	private char slowestKey(int[] releaseTimes, String keysPressed) {
		if(keysPressed == null) return ' ';
		if(releaseTimes.length == 0 || keysPressed.isEmpty()) return ' '; 
		char retChar = keysPressed.charAt(0);
		int maxTime = releaseTimes[0];
		for (int i = 1; i < releaseTimes.length; i++){
			int currentTimeDif = releaseTimes[i] - releaseTimes[i - 1];
			if (maxTime < currentTimeDif){
				maxTime = currentTimeDif;
				retChar = keysPressed.charAt(i);
			} else if (maxTime == currentTimeDif)
				retChar = retChar > keysPressed.charAt(i) ? retChar : keysPressed.charAt(i);
		}
		return retChar;
	}
	
    	
	
}

