package AVL_Trees;

public class AVLTree {

	private class Node {
		int data;
		Node left;
		Node right;
		int height;

		private Node(int data) {
			this.data = data;
			this.height = 1;
		}

	}

	private Node root;

	// Inserting a normal node in BST
	public void insert(int item) {
		this.root = insert(this.root, item);
	}

	private Node insert(Node node, int item) {

		if (node == null) {
			Node nn = new Node(item);
			return nn;
		}

		if (node.data < item) {
			node.right = insert(node.right, item);
		}

		else if (node.data > item) {
			node.left = insert(node.left, item);
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		int bf = balancingFactor(node);

		// LL case
		if (bf > 1 && item < node.left.data) {
			return rightRotate(node);
		}

		// RR case
		if (bf < -1 && item > node.right.data) {
			return leftRotate(node);
		}

		// LR case
		if (bf > 1 && item > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// RL case
		if (bf < -1 && item < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);

		}

		return node;
	}

	private int height(Node node) {

		if (node == null) {
			return 0;
		}

		return Math.max(height(node.left), height(node.right)) + 1;

	}

	private int balancingFactor(Node node) {

		if (node == null) {
			return 0;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		return (lh - rh);

	}

	private Node rightRotate(Node c) {

		Node b = c.left;
		Node t3 = b.right;

		b.right = c;
		c.left = t3;

		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;

		return b;

	}

	private Node leftRotate(Node c) {
		Node b = c.right;
		Node T2 = b.left;

		b.left = c;
		c.right = T2;

		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;

		return b;

	}

	public void display() {

		display(this.root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		if (node.left == null) {
			System.out.print(". ");
		} else {
			System.out.print(node.left.data + " ");
		}

		System.out.print("=> " + node.data + " <= ");

		if (node.right == null) {
			System.out.println(".");
		} else {
			System.out.println(node.right.data);
		}

		display(node.left);
		display(node.right);

	}

}
