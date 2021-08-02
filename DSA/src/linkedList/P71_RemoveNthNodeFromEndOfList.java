package linkedList;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P71_RemoveNthNodeFromEndOfList {
	/*
		Problem Statement
		Given a linked list, remove the n-th node from the end of list and return its head
	
	*/

	/*
	   1. 
	  	  Input(s) ? LL , int
		  Output ? LL
		  Constraint(s) ? No
	   
	   2. Test data
			Positive : 1=>2=>3=>4=>5 , n = 2, OP => 1=>2=>3=>5
			Negative : 1=>2=>3=>4=>5 , n = 0, OP => 1=>2=>3=>4=>5 // 1=>2 , n = 3, OP => 1=>2	
			Edge     : 1=>2 n = 2, op 2=>null
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		Node inputNode = new Node(1);
		inputNode.next = inputNode.addNode(2);
		inputNode.next.next = inputNode.addNode(3);
		inputNode.next.next.next = inputNode.addNode(4);
		inputNode.next.next.next.next = inputNode.addNode(5);
		int k = 2;
		inputNode.printAllNodes(removeNthNode(inputNode,k));
	}

	@Test
	public void testData02() { // Negative
		
		Node inputNode = new Node(1);
		inputNode.next = inputNode.addNode(2);
		int k = 4;
		inputNode.printAllNodes(removeNthNode(inputNode,k));

	}

	@Test
	public void testData03() { // Edge
		Node inputNode = new Node(1);
		inputNode.next = inputNode.addNode(2);
		int k = 2;
		inputNode.printAllNodes(removeNthNode(inputNode,k));
	}

	/* Take the copy of input node in new one
	 * Create a variable count
	 * Iterate the node and increment the count till node becomes null
	 * if node count < k return input
	 * create another variable remove node as count-K+1, and make count as 1
	 * Create another node with input as reference 
	 * Itearate the input node again 
	 *   if count == removeNode
	 *   move the node to null
	 *   else 
	 *     append the node
	 *     move the node
	 * return head.next from op  
	 *  
	 */
	private Node removeNthNode(Node inputNode, int k) {
		Node countNode = inputNode;
		int count = 0;
		while(countNode != null) {
			count++;
			countNode = countNode.next;
		}
		int removeNode = count-k+1;
		count = 1;
		Node returnNode = new Node(0);
		Node traverseNode = returnNode;
		while(inputNode != null) {
			if(count++ != removeNode){
				traverseNode.next = inputNode;
				inputNode = inputNode.next;
				traverseNode = traverseNode.next;
			}
			else inputNode = inputNode.next;
		}
		return returnNode.next;
	}
}
