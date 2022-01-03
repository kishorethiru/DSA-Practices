package linkedList;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import linkedList.Node;

public class P107_UniqueElementLinkedList {
	
	/*
	 *  Given a linked list remove the repeated value nodes
	 * 
	 */
	
	/*
	 *  1. 
    Input(s)? Linked List
    Output ?  Linked List
    Constraints ?  No

	2. Test data set
	
	        Positive : [1,2,3,4,2,6]
	        Negative : [1,2,3,4]
	        Edge     : [1,2,3,2,1,3]
	
	3. Known Approaches
	        Approach 1 :Using Single Linked List 
	
	4. O-Notations
	
	5. Pseudocode
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		Node input = new Node(1);
		input.next = input.addNode(2);
		input.next.next = input.addNode(3);
		input.next.next.next = input.addNode(4);
		input.next.next.next.next = input.addNode(2);
		input.next.next.next.next.next = input.addNode(6);
		input.printAllNodes(removeDuplicateNode(input));
	}


	@Test
	public void testData02(){			 // Negative
		Node input = new Node(1);
		input.next = input.addNode(2);
		input.next.next = input.addNode(3);
		input.next.next.next = input.addNode(4);
		input.printAllNodes(removeDuplicateNode(input));
	}

	@Test
	public void testData03(){			 // Edge
		Node input = new Node(1);
		input.next = input.addNode(2);
		input.next.next = input.addNode(3);
		input.next.next.next = input.addNode(2);
		input.next.next.next.next = input.addNode(1);
		input.next.next.next.next.next = input.addNode(3);
		input.printAllNodes(removeDuplicateNode(input));
	}
	
	/*
	 * Create a Hash set. 
	 * Create two new nodes, ouputNode and endNode 
	 * iterate the  node untill it becomes null 
		 * Check if current value is present in the set. 
		 * 	If not, 
		 * 		add to set and add the node. move node to next and endNode point to next
		 * 		else Move the node 
	 * return outputNode.next
	 * 
	 */
	public Node removeDuplicateNode(Node head) {
		Set<Integer> valueSet = new HashSet<Integer>();
		Node outputNode = new Node(0);
		Node endNode = outputNode;
		while (head != null) {
			if (!valueSet.contains(head.value)) {
				valueSet.add(head.value);
				endNode.next = head;
				head = head.next;
				endNode = endNode.next;
				endNode.next = null;
			} else {
				head = head.next;
			}
		}
		return outputNode.next;

	}

}
