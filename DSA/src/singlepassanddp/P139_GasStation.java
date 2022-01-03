package singlepassanddp;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P139_GasStation {
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

		int[] gas = {3,3,4};
		int[] cost = {3,4,4};
		System.out.println(canCompleteCircuit(gas,cost));
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        for(int i = 0; i<gas.length;i++)
        {
            if(gas[i]>=cost[i]) {
                startIndex = i;
                break;
            }
        }
        int beginIndex = startIndex;
        int[] orgArr = new int[gas.length+1];
        int[] costArr = new int[gas.length+1];
        for(int i = 0; i<orgArr.length;i++){
            if(startIndex > gas.length-1) {
                orgArr[i] = gas[startIndex-gas.length];
            	costArr[i] = cost[startIndex++-gas.length];
            }
            else {
            	orgArr[i] = gas[startIndex];
            	costArr[i] = cost[startIndex++];
            }
        }
        int gasSum = orgArr[0];
        for(int i = 1; i<orgArr.length;i++) {
        	gasSum += orgArr[i]-costArr[i-1];
        	if( gasSum < 0) return -1;
        }
          if(gasSum<costArr[beginIndex]) return -1;
          return beginIndex;     
        }        
	
 }
