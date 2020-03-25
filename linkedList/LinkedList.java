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
	
	

}
