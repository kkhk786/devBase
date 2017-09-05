package main;

public class LinkedListEx {
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
		LinkedListEx stack = new LinkedListEx();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");

		for (int i = 0; i < 4; i++) {
			System.out.println(stack.pop());
		}
	}
}