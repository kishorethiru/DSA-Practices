package linkedList;

import org.junit.Test;

public class PrintOddNodes {

	public class Node {
		int value;
		Node next;
		
		Node() {
			next = null;
		}
		
		Node(int key) {
			this.value = key;
			next = null;
		}
	}

	public Node addNode(int key) {
		return new Node(key);
	}

	public void printAllNodes(Node node) {
		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}
	
	@Test
    public void test() {
        Node head1 = addNode(1);
        head1.next = addNode(2);
        head1.next.next = addNode(3);
        head1.next.next.next = addNode(4);
        head1.next.next.next.next = addNode(5);
        head1.next.next.next.next.next = addNode(6);
        head1.next.next.next.next.next.next = addNode(7);
        head1.next.next.next.next.next.next.next = addNode(8);
        Node node = printOddNodes(head1);
        printAllNodes(node);
	}
	
	@Test
    public void testEven() {
        Node head1 = addNode(1);
        head1.next = addNode(2);
        head1.next.next = addNode(3);
        head1.next.next.next = addNode(4);
        head1.next.next.next.next = addNode(5);
        head1.next.next.next.next.next = addNode(6);
        head1.next.next.next.next.next.next = addNode(7);
        head1.next.next.next.next.next.next.next = addNode(8);
        Node node = printEvenNodes(head1);
        printAllNodes(node);
	}
	
	
	private Node printOddNodes(Node node) {
		Node oddNodes = new Node();
		Node previous = oddNodes;
		while(node != null) {
			previous.next = node; 
			node = (node.next == null) ? node.next : node.next.next;
			previous = previous.next;
			previous.next = null;
		}
		return oddNodes.next;	
	}
	
	private Node printEvenNodes(Node node) {
		Node evenNodes = new Node();
		Node previous = evenNodes;
		node = node.next;
		while(node != null) {
			previous.next = node; 
			node = (node.next == null) ? node.next : node.next.next;
			previous = previous.next;
			previous.next = null;
		}
		return evenNodes.next;	
	}
}
