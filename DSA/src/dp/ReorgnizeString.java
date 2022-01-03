package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

public class ReorgnizeString {

	@Test
	public void test1() {
		System.out.println(reorganizeString("aabbbbccc"));
	}

	public String reorganizeString(String str) {
		Map<Character, Integer> map = new HashMap<>();

		for (char ch: str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		maxHeap.addAll(map.entrySet());

		Map.Entry<Character, Integer> previousEntry = null;
		StringBuilder sb = new StringBuilder(str.length());

		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

			if (previousEntry != null && previousEntry.getValue() > 0) {
				maxHeap.offer(previousEntry);
			}

			sb.append(currentEntry.getKey());
			currentEntry.setValue(currentEntry.getValue() - 1);
			previousEntry = currentEntry;
		}

		return sb.toString().length() == str.length() ? sb.toString() : "";
	}

}
