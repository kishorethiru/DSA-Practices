package linkedList;

import org.junit.Test;

public class P110_ReverseLinkedList {
	
	@Test
	public void testData01()
	{
		Node head = new Node(1);
		head.next = head.addNode(2);
		head.next.next = head.addNode(3);
		head.next.next.next = head.addNode(4);
		Node res = reverseNode(head);
		head.printAllNodes(res);
		
	}
	
	private Node reverseNode(Node node) {
		Node curr = node, prev = null, next = null;
		while(curr != null) {
			next = curr.next; 
			curr.next = prev; 
			prev = curr;  
			curr = next;  
		}
		return prev;		
	}

}

