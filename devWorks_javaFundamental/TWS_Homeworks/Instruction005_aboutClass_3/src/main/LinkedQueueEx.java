package main;

public class LinkedQueueEx {
	private class Node {
		Object data;
		Node next;
	}

	private Node pointer;

	public void push(Object obj) {
		Node node = new Node();
		node.data = obj;
		node.next = null;
		if (pointer != null) {
			node.next = pointer;
		}
		pointer = node;
	}

	public Object pop() {
		if (pointer == null) {
			throw new IndexOutOfBoundsException();
		}
		Node node = pointer;
		pointer = node.next;
		return node.data;
	}

	public static void main(String[] args) {
		LinkedQueueEx queue = new LinkedQueueEx();
		queue.push("a");
		queue.push("b");
		queue.push("c");
		queue.push("d");

		for (int i = 0; i < 4; i++) {
			System.out.println(queue.pop());
		}
	}
}