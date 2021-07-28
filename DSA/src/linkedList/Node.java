package linkedList;

public class Node {
	public int value;
	public Node next;
	
	Node() {
		next = null;
	}
	
	public Node(int key) {
		this.value = key;
		next = null;
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
}
