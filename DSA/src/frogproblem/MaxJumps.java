package frogproblem;


import org.junit.Test;

public class MaxJumps {

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

	public static int maxFrogJumps(int[] nums){
		int[] data = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j])
                    data[i] = Math.max(data[i], data[j]+1);
            }
        }
        
        int maxJumps = 0;
        for (int each : data) {
            maxJumps = Math.max(maxJumps, each);
        }
        return maxJumps;
	}
}
