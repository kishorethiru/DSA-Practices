package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class LargestString {
	
	@Test
	public void test1() {
		System.out.println(largestString("abccc", 2));
	}
	
	@Test
	public void test2() {
		System.out.println(largestString("abcccbba", 2));
	}
	@Test
	public void test3() {
		System.out.println(largestString("aabbccc", 1));
	}
	
	private static String largestString(String s, int k) {
		char[] chs = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (char ch : chs) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		Set<Entry<Character, Integer>> set = map.entrySet();
		ArrayList<Entry<Character, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, (a, b) -> (b.getKey().compareTo(a.getKey()))); // nlogn

		int i = 0;
		while (i < list.size()) {
			Entry<Character, Integer> firstEntry = list.get(i);
			char firstKey = firstEntry.getKey();
			int firstVal = firstEntry.getValue();

			if (firstVal > k) {
				// reduce by k
				int count = 0;
				while (count < k) {
					sb.append(firstKey);
					count++;
				}
				firstEntry.setValue(firstVal - k);

				// Just add 1 next character
				if(i < list.size()-1) {
			
					Entry<Character, Integer> secondEntry = list.get(i + 1);
					char secondKey = secondEntry.getKey();
					int secondVal = secondEntry.getValue();
	
					if (secondVal > 0) {
						sb.append(secondKey);
						secondEntry.setValue(secondVal - 1);
					}
				}
			} else if (firstVal > 0 && firstVal <= k) {
				int count = 0;
				while (count < firstVal) {
					sb.append(firstKey);
					count++;
				}
				firstEntry.setValue(0);
			} else {// firstVal == 0
				i++;
			}
		}

		return sb.toString();
	}

}
