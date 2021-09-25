package dp;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class Check {
	@Test
	public void test01() {
		int[] num = {42,33,60};
		System.out.println(findMax(num));
	}
	public int findMax (int[] num) {
	 int[] values = new int[num.length];
	 for(int i = 0; i < num.length;i++) {
		 values[i] = addNums(num[i]);
	 }
	 int max = Integer.MIN_VALUE;
	 for(int i = 0; i<values.length-1; i++) {
		 for(int j = i+1; j < values.length; j++) {
			 if(values[i] == values[j]) {
				 max = Math.max(max, num[i]+num[j]);
			 }
		 }
	 }
	 return max;
	 
	}
	public int addNums(int n) {
		int retVal = 0;
		while(n!=0){
			retVal += n%10;
			n /= 10;
		}
		return retVal;
		
	}
	}
