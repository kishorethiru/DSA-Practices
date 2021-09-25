package hashing;

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
public class AlphabetBoardGame {
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

		String s = "leet";
		Assert.assertTrue(findPath(s).equals("DDR!UURRR!!DDD!"));
	}

	@Test
	public void testData02() { // Edge
		String s = "code";
		Assert.assertTrue(findPath(s).equals("RR!DDRR!UUL!R!"));
	}

	@Test
	public void testData03() { // Edge
		String s = "az";
		Assert.assertTrue(findPath(s).equals("!DDDDD!"));
	}
	
	private String findPath(String s) {
		Map<Character, List<Integer>> boardMap = new HashMap<>();
		int currentCol   =  0;
		int currentRow   =  0;
		for(int i = 97; i<123;i++) {
			boardMap.put((char) i , Arrays.asList(currentRow, currentCol++));
			if(currentCol>4) {
				currentRow++;
				currentCol = 0;
			}
		}
		StringBuilder sb = new StringBuilder();
		currentCol = 0;
		currentRow = 0;
		for(char c : s.toCharArray()) {
			int targetRow = boardMap.get(c).get(0);
			int targetCol = boardMap.get(c).get(1);
			int rowToTravel = targetRow - currentRow;
			int colToTravel = targetCol - currentCol;
			if (c == 'z') {
				colToTravel = Math.abs(colToTravel);
				rowToTravel = Math.abs(rowToTravel);
				while (Math.abs(colToTravel) > 0) {
					sb.append('L');
					colToTravel--;
				}
				currentCol = 0;
				while (Math.abs(rowToTravel) > 0) {
					sb.append('D');
					rowToTravel--;
				}
				currentRow = 5;
			}
			else {
				if(rowToTravel > 0) {
					while(rowToTravel > 0) {
						sb.append('D');
						rowToTravel--;
					}
				}
				else if(rowToTravel< 0) {
					while(rowToTravel<0) {
						sb.append('U');
						rowToTravel++;
					}
				}
				currentRow = targetRow;
				if(colToTravel>0) {
					while(colToTravel>0) {
						sb.append('R');
						colToTravel--;
					}
				}
				else if(colToTravel<0) {
					while(colToTravel<0) {
						sb.append('L');
						colToTravel++;
					}
				}
				currentCol = targetCol;
			}
			sb.append('!');
		}
		return sb.toString();
	}
}
