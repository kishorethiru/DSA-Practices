package linkedList;

import org.junit.Test;

public class P104_MergeLinkedList {
	
	/* LinkedList :  1 -> 3 -> 5
	   LinkedList :  2 -> 4 -> 6 
       Sorted LinkedList -> Merge Both LinkedList -> Return the sorted Linked List !!
       1 -> 2 -> 3 -> 4 -> 5 -> 6
	 * 
	 */
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
        Node head2 = addNode(2);
        head1.next = addNode(3);
        head1.next.next = addNode(5);
        head2.next = addNode(4);
        head2.next.next = addNode(6);
        Node node = mergeTwoNodes(head1,head2);
        printAllNodes(node);
	}

	private Node mergeTwoNodes(Node n1, Node n2) {
		Node merged = new Node();
		Node current = merged;
		if (n1 == null)
			return n2;
		if (n2 == null)
			return n1;
		while (n1 != null && n2 != null) {
			if (n1.value < n2.value) {
				current.next = n1; 
				n1 = n1.next;
			} else {
				current.next = n2;
				n2 = n2.next;
			}
			current = current.next;
		}
		current.next = (n1 == null) ? n2 : n1;
		return merged.next;
	}
}
