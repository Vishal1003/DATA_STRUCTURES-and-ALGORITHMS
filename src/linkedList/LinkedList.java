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

	public int removeAt(int idx) throws Exception {

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of bound");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size) {
			return removeLast();
		} else {
			node nm1 = getNodeAt(idx - 1);
			node n = nm1.next;
			node np1 = n.next;

			nm1.next = np1;
			this.size--;
			return n.data;
		}

	}

//	reverse data iteratively
	public void reverseDataIter() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left < right) {

			node ln = getNodeAt(left);
			node rn = getNodeAt(right);
			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right++;

		}

	}

//	reverse pointer iteratively
	public void reversePtrIter() throws Exception {

		node prev = this.head;
		node curr = this.head.next;

		while (curr != null) {
			node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}

		node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

//	reverse pointer recursively
	public void reversePtrRec() {
		reversePtrRec(this.head, this.head.next);

		node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	private void reversePtrRec(node prev, node curr) {

		if (curr == null) {
			return;
		}

		reversePtrRec(curr, curr.next);
		curr.next = prev;

	}

//	reverse data recursively
	public void recDataRec() {
		recDataRec(this.head, this.head, 0);
	}

	private node recDataRec(node left, node right, int count) {

		if (right == null) {
			return left;
		}

		left = recDataRec(left, right.next, count + 1);

		if (count >= this.size / 2) {
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
		}

		return left.next;
	}
}
