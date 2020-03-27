package linkedList;

public class LinkedList {

	private class node {

		int data;
		node next;

		public node(int data) {
			this.data = data;
		}

		public node() {

		}

	}

	private node head;
	private node tail;
	private int size;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int getFirst() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is empty");
		}

		return this.tail.data;
	}

	public int getAt(int idx) throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("indexOutOfBound");
		}

		node temp = head;

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	private node getNodeAt(int idx) throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("indexOutOfBound");
		}

		node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp;

	}

	public void display() {
		node temp = this.head;

		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}

	}

	public void addLast(int item) {

		node nn = new node();
		nn.data = item;
		nn.next = null;

		if (!isEmpty()) {
			this.tail.next = nn;
		}

		if (isEmpty()) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}

	}

	public void addFirst(int item) {

		node nn = new node();
		nn.data = item;
		nn.next = null;

		nn.next = head;

		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {

			this.head = nn;
			this.size++;
		}

	}

	public void addAt(int idx, int item) throws Exception {

		if (idx < 0 || idx >= 0) {
			throw new Exception("indexOutOfBound");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		}

		else {

			node nn = new node();
			nn.data = item;
			nn.next = null;

			node nm1 = this.getNodeAt(idx - 1);
			nn.next = nm1.next;
			nm1.next = nn;
			this.size++;

		}

	}

	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		int rv = this.tail.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {

			node sm2 = getNodeAt(size - 2);
			this.tail = sm2;
			sm2.next = null;
			this.size--;
		}

		return rv;

	}

	public int removeFirst() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("LL is empty");
		}

		int rv = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return rv;

	}
}
