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
public class P113_PriceCheck {
	/*
		Problem Statement
	
	*/

	/*
	   1. 
	      Input(s) ? 4 list 
		  Output ? int 
		  Constraint(s) ? Time Optimized
	   
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
		List<String> products = Arrays.asList("Eggs","Biscuits","Oil");
		List<Float> productPrice = Arrays.asList(1.23f,2.5f,6.5f);
		List<String> productsSold = Arrays.asList("Eggs","Biscuits","Oil","Eggs");
		List<Float> soldPrice = Arrays.asList(1.23f,2.5f,6.5f,2.5f);
		Assert.assertTrue(findSoldProductError(products,productPrice,productsSold,soldPrice) == 1);
	}
	@Test
	public void testData02() { // Negative
		List<String> products = Arrays.asList("Eggs","Biscuits","Oil");
		List<Float> productPrice = Arrays.asList(1.23f,2.5f,6.5f);
		List<String> productsSold = Arrays.asList("Eggs","Biscuits","Oil","Eggs");
		List<Float> soldPrice = Arrays.asList(1.23f,2.5f,6.5f,1.23f);
		Assert.assertTrue(findSoldProductError(products,productPrice,productsSold,soldPrice) == 0);
	}

	@Test
	public void testData03() { // Edge
		List<String> products = Arrays.asList("Eggs","Biscuits","Oil");
		List<Float> productPrice = Arrays.asList(1.23f,2.5f,6.5f);
		List<String> productsSold = Arrays.asList("Eggs","Biscuits","Oil","Eggs");
		List<Float> soldPrice = Arrays.asList(1.25f,2.6f,6.6f,2.5f);
		Assert.assertTrue(findSoldProductError(products,productPrice,productsSold,soldPrice) == 4);

	}
	
	/* Create a map and add the product and its corresponding price
	 * Initialize errorCount as 0
	 * Iterate the productsSold list
	 *   and get the difference between products price and productsSold
	 *    if difference is not zero increment errorCount
	 * 
	 * 
	 */
	private int findSoldProductError(List<String> products, List<Float> productPrice, List<String> productsSold,
			List<Float> soldPrice) {
		Map<String, Float> map = new HashMap<>();
		for (int i = 0; i < products.size(); i++) {
			map.put(products.get(i), productPrice.get(i));
		}
		int errorCount = 0;
		for (int i = 0; i < productsSold.size(); i++) {
			if(map.get(productsSold.get(i)) - soldPrice.get(i)!= 0 ) errorCount++;
		}
		return errorCount;
	}

}
