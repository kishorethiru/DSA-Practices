package slidingWindow;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P61_FindMinimumBalancedString {

	@Test
	public void example1() {
		String S = "azABaabza";
		System.out.println(findBalanced(S));
	}
	
	@Test
	public void example2() {
		String S = "TacoCat";
		System.out.println(findBalanced(S));
	}
	
	@Test
	public void example3() {
		String S = "AcZCbaBz";
		System.out.println(findBalanced(S));
	}
	@Test
	public void example4() {
		String S = "HkhBubUYy";
		System.out.println(findBalanced(S));
	}

	public int solution(String S) {
		for(int i=1;i<=S.length();i++){
			for(int j=0;j<S.length()-i+1;j++){
				Set<Character> lower = new HashSet<>();
				Set<Character> upper = new HashSet<>();
				String minBalanced = S.substring(j,j+i);
				char[] minChar = minBalanced.toCharArray();
				for(char ch : minChar){
					if(Character.isLowerCase(ch)) lower.add(ch);
					else upper.add(ch);
				}
				if(convertToLower(upper).containsAll(lower) && lower.containsAll(convertToLower(upper)))
					return minBalanced.length();
			}            
		}
		return -1;   
	}
	
	private Set<Character> convertToLower(Set<Character> set){
		Set<Character> lower = new HashSet<>();
		for (Character ch : set)
			lower.add(Character.toLowerCase(ch));
		return lower;
	}
	
	
	/* Sliding Window
	 * 1. Create four HashSet,
	 *    	One for all lower, all upper and one for inputLower and Upper.
	 * 2. Add all the upper and lower to corresponding sets
	 * 3. Iterate the input,
	 *      If the current item is present in both lower and upper,
	 *         If lower add to lowerTemp, else convert to upper and add in lowerTemp
	 *      Else
	 *         Remove left character till right
	 *      if lowerTemp and upperTemp is not empty and equals return right-left+1
	 *      increment right
	 * 4. return -1
	 *    
	 * Time  : O(2n) ->  O(n)
	 * Space : O(4n) -> O(n)
	 */
	private int findBalanced(String s) {
		Set<Character> lower = new HashSet<>();
		Set<Character> upper = new HashSet<>();
		Set<Character> lowerTemp = new HashSet<>();
		Set<Character> upperTemp = new HashSet<>();
		for(char c : s.toCharArray()) {
			if(Character.isUpperCase(c)) upper.add(c);
			else lower.add(c);
		}
		if(lower.isEmpty() || upper.isEmpty()) return -1;
		int left = 0, right = 0;
		while(right<s.length()) {
			char current = s.charAt(right);
			if(lower.contains(Character.toLowerCase(current)) && upper.contains(Character.toUpperCase(current))) {
				if(Character.isLowerCase(current)) lowerTemp.add(current);
				else upperTemp.add(Character.toLowerCase(current));
			}
			else{
				while(left <= right) {
					char remove = s.charAt(left);
					if(Character.isLowerCase(remove)) lowerTemp.remove(remove);
					else upperTemp.remove(Character.toLowerCase(remove));
					left++;
				}
			}
			if(!lowerTemp.isEmpty() && !upperTemp.isEmpty() && lowerTemp.equals(upperTemp))
					 return right-left+1;
			right++;
		}
		return -1;
	}


}
