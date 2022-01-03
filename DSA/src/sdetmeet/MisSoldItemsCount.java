package sdetmeet;

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
public class MisSoldItemsCount {
	/*
		Problem Statement
		You have an old grocery shop that instead of scanning 
		their sold proudcts once sold, they type in the prices,
		 which leaves room for mistyping sold prices.
		  Given 4 lists: soldItems = ['eggs', 'milk', 'apple'],
		  soldPrices = [1.00, 2.50, 2.1],
		  productsAvailable = ['eggs', 'lemons', 'milk', 'apple'],
		  productPrices = [1.01, 0.5, 2.50, 2.1], Find the number of items 
		  with mistyped prices
	
	*/

	/*
	   1. 
	  	  Input(s) ? 4 lists 
		  Output ? int
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : Using Hashmap
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		List<String> soldItems = Arrays.asList("eggs", "milk", "apple");
		List<String> products = Arrays.asList("eggs", "lemons", "milk", "apple");
		List<Float>  soldPrice = Arrays.asList(1.00F, 2.50F, 2.1F);
		List<Float>  productPrice = Arrays.asList(1.01F, 0.5F, 2.50F, 2.1F);
		Assert.assertTrue(countOfMissoldItem(products,productPrice,soldItems,soldPrice)==1);
	}

	@Test
	public void testData02() { // Negative
		List<String> soldItems = Arrays.asList("eggs", "milk", "apple");
		List<String> products = Arrays.asList("eggs", "lemons", "milk", "apple");
		List<Float>  soldPrice = Arrays.asList(1.00F, 2.50F, 2.1F);
		List<Float>  productPrice = Arrays.asList(1.00F, 0.5F, 2.50F, 2.1F);
		Assert.assertTrue(countOfMissoldItem(products,productPrice,soldItems,soldPrice)==0);
	}

	@Test
	public void testData03() { // Edge
		List<String> soldItems = Arrays.asList("eggs", "milk", "apple");
		List<String> products = Arrays.asList("eggs", "lemons", "milk", "apple");
		List<Float>  soldPrice = Arrays.asList(1.00F, 2.52F, 2.2F);
		List<Float>  productPrice = Arrays.asList(1.01F, 0.4F, 2.51F, 2.1F);
		Assert.assertTrue(countOfMissoldItem(products,productPrice,soldItems,soldPrice)==3);

	}
	
	/* Pseudocode
	 * 1. Create a hash map and push the value of product as key and their prices as value
	 * 2. Create a variable count as 0
	 * 3. Iterate the solditems list
	 *    	Get the sold itemprices from soldPrice list and compare with the 
	 *      product price from map if not matches increment count
	 * 4. return count
	 * 
	 */
	
	private int countOfMissoldItem(List<String> products, List<Float> productPrice, List<String> soldItems,
			List<Float> soldPrice) {
		Map<String, Float> map = new HashMap<>();
		int count = 0;
		for(int i = 0; i < products.size(); i++) {
			map.put(products.get(i), productPrice.get(i));
		}
		for(int i = 0; i < soldItems.size(); i++) {
			if((float)map.get(soldItems.get(i)) != (float)soldPrice.get(i)) count++;
		}
		return count;
	}
}
