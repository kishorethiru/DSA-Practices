package frogproblem;


import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class MaxFrogJumpsBSA {

	@Test
	public void example1() {
		int[] nums = {6,13,10,8,11,7,3,5,2};
		System.out.println(maxFrogJumps(nums));
	}
	
	@Test
	public void example2() {
		int[] nums = {6,4,5,4,3,2,1};
		System.out.println(maxFrogJumps(nums));
	}
	
	@Test
	public void example3() {
		int[] nums = {5,7,11,9,10,7,6,3,5,2,1};
		System.out.println(maxFrogJumps(nums));
	}
	
	@Test
	public void example4() {
		int[] nums = {5,7,16,9,10,15,14,13,12,7,6,3,5,2,1};
		System.out.println(maxFrogJumps(nums));
	}
	
	public static int maxFrogJumps(int[] nums){
		ArrayList<Integer> sub = new ArrayList<>();
		sub.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num < sub.get(sub.size() - 1)) {
				sub.add(num);
			} else {
				// Find the first element in sub that is greater than or equal to num
				int j = binarySearch(sub, num);
				if(j == sub.size()-1)
					sub.set(j, num);
			}
		}

		return sub.size()-1;
	}

	private static int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }
            
            if (sub.get(mid) > num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
	
}
