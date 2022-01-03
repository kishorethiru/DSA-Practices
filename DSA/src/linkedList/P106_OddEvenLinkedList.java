package linkedList;

import org.junit.Test;

public class P106_OddEvenLinkedList {
	
	/*
	 * Given the head of a singly linked list, group all the nodes with odd indices together followed 
	 * by the nodes with even indices, and return the reordered list.
	 */
	
	/*
	 *  1. 
    Input(s)? Node
    Output ?  Node
    Constraints ? No 

	2. Test data set
	
	        Positive : 1,2,3,4,5	
	        Negative : 1,1,1,1
	        Edge     : 2,1,3,5,6,4,7
	
	3. Known Approaches 
			Using Linked List
	4. O-Notations
			Using Linked List - Space : O(n) Time O(n)
	5. Pseudocode
	 * 
	 */
	
	@Test
	public void testData01()
	{
		Node head = new Node(1);
		head.next = head.addNode(2);
		head.next.next = head.addNode(3);
		head.next.next.next = head.addNode(4);
		head.next.next.next.next = head.addNode(5);
		Node res = arrangeOddEvenList(head);
		head.printAllNodes(res);
		
	}
	
	@Test
	public void testData02()
	{
		// 2,1,3,5,6,4,7
		Node head = new Node(2);
		head.next = head.addNode(1);
		head.next.next = head.addNode(3);
		head.next.next.next = head.addNode(5);
		head.next.next.next.next = head.addNode(6);
		head.next.next.next.next.next = head.addNode(4);
		head.next.next.next.next.next.next = head.addNode(7);
		Node res = arrangeOddEvenList(head);
		head.printAllNodes(res);
	}
	
	/* 
	 * Create two Node, create int to switch to odd or even
	 * Iterate till node becomes null 
	 *  	Add the odd nodes value to oddNode, move the odd node to next
	 *  	Add the even nodes value to evenNode,  move the event node to next
	 *      move the input node to next
	 * return add even and odd node by adding it
	 * Time O(n)
	 * Space O(n)
	 */
	private Node arrangeOddEvenList(Node node) {
		Node oddNode = new Node();
		Node oddCal = oddNode;
		Node evenNode = new Node();
		Node evenCal = evenNode;
		int count = 1;
		while (node != null) {
			if (count % 2 != 0) {
				oddCal.next = node; 
				node = node.next;
				oddCal = oddCal.next;
				oddCal.next = null;
				count += 1;
			} else {
				evenCal.next = node; 
				node = node.next;
				evenCal = evenCal.next; 
				evenCal.next = null;
				count += 1;
			}
		}
		oddCal.next = evenNode.next; 
		return oddNode.next;
	}
}
