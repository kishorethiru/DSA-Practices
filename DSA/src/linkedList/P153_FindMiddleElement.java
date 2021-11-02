package linkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P153_FindMiddleElement {
	/*
		Problem Statement
		Given a linked list, print the node from the mid element
	
	*/

	/*
	   1. 
	  	  Input(s) ? Linked List 
		  Output ? Linked List
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive : 1, 2, 3, 4
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	
	public class LinkedNode{
		int value;
		LinkedNode next;
		public LinkedNode() {
			next = null;
		}
		public LinkedNode(int value) {
			this.value = value;
			next = null;
		}
		
		public LinkedNode addNewNode(int value) {
			return new LinkedNode(value);
		}
		
		public void printNodes(LinkedNode node) {
			while(node!=null) {
				System.out.println(node.value);
				node = node.next;
			}
		}	
	}
	@Test
	public void testData01() { // Positive
		LinkedNode input = new LinkedNode(1);
		input.next = new LinkedNode(2);
		input.next.next = new LinkedNode(3);
		input.next.next.next = new LinkedNode(4);
		LinkedNode output = findMidNode(input);
		output.printNodes(output);
	}	

	private LinkedNode findMidNode(LinkedNode input) {
		LinkedNode p1 = input;
		LinkedNode p2 = input;
		while(p1 != null && p1.next != null) {
			p1 = p1.next.next;
			p2 = p2.next;
		}
		return p2;
	}

	@Test
	public void testData02() { // Negative
		LinkedNode input = new LinkedNode(1);
		input.next = new LinkedNode(2);
		input.next.next = new LinkedNode(3);
		input.next.next.next = new LinkedNode(4);
		input.next.next.next.next = new LinkedNode(5);
		LinkedNode output = findMidNode(input);
		output.printNodes(output);

	}

	@Test
	public void testData03() { // Edge

	}
	
	
}
