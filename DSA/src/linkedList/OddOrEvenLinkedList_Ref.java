package linkedList;

import org.junit.Test;


public class OddOrEvenLinkedList_Ref {

	public class Node{
		int value;
		Node next;
		Node(){
			next = null;
		}
		Node(int key){
			this.value = key;
			next = null;
		}

	}

	public Node addNode(int key) {
		return new Node(key);
	}

	public void printAllNodes(Node node) {
		while(node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

	public Node oddEvenList(Node node) {

		if (node == null || node.next == null)
			return node;
		Node odd = node, even = node.next, allEven = even;
		
		// Hold the odd numbers separate and point to node
		// Hold the even numbers and point to allEven
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = allEven; // append allEven to odd thus to node 
		return node;
	}
	
	@Test
	public void test1() {
		Node head = addNode(1);
		head.next = addNode(2);
		head.next.next = addNode(3);
		head.next.next.next = addNode(4);
		head.next.next.next.next = addNode(5);

		
		Node oddFirst = oddEvenList(head);
		printAllNodes(oddFirst);
	}

}
