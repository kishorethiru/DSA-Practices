package trees;

/**
 * @author Kishore
 *
 */
public class Trees {

	static class Node {
		int value;
		Node left, right;

		Node(int value) {
			this.value = value;
			left = right = null;
		}
	}

	public Node addNode(Node node, int value) {
		if (node == null)
			return new Node(value);
		if (value < node.value) {
			node.left = addNode(node.left, value);
		} else if (value > node.value) {
			node.right = addNode(node.right, value);
		}
		return node;
	}

	public void inorderTraversal(Node node) {
		if (node != null) {
			inorderTraversal(node.left);
			System.out.println(node.value);
			inorderTraversal(node.right);
		}
	}
	
	public int findDiffInorderTraversal(Node node) {
		int min = Integer.MAX_VALUE;
		if (node != null) {
			min = Math.min(Math.abs(node.value - node.left.value), Math.abs(node.value-node.right.value));
			findDiffInorderTraversal(node.left);
			findDiffInorderTraversal(node.right);
		}
		return min;
	}

	public void preorderTraversal(Node node) {
		if (node != null) {
			System.out.println(node.value);
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}

	public void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.value);
		}
	}
	
	public Integer findNode(Node node, int value) {
		while(node != null) {
			if(node.value == value) return node.value;
			node = (value < node.value) ? node.left : node.right;	
		}
		return null;
	}
	
	public String findChildNodeType(Node node) {
		if(node.left != null && node.right != null) return "both";
		else if(node.left != null && node.right == null) return "left";
		else if(node.left == null && node.right != null) return "right";
		return null;
	}
	
	public Node removeNode(Node node, int value) {
		
		return node;
	}

	public static void main(String[] args) {
		Trees tree = new Trees();
		Node node = new Node(4);
		/*
		 * tree.addNode(node,13); tree.addNode(node,5); tree.addNode(node,4);
		 * tree.addNode(node,2);
		 */
		tree.addNode(node, 2);
		tree.addNode(node, 6);
		tree.addNode(node, 1);
		tree.addNode(node, 3);
//		System.out.println(tree.findNode(node, 3));
		System.out.println(tree.findDiffInorderTraversal(node));
		int[] arr = new int[] {Integer.MAX_VALUE};
		// tree.inorderTraversal(node);
		// tree.preorderTraversal(node);
		// tree.postOrderTraversal(node);
		// tree.levelOrderTraversal(node);
		// 1,2,2,3,4,4,3

	}
}
