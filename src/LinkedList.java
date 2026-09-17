public class LinkedList {
	Node head;
	Node tail;

	public void add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		Node current = head;
		while (current != null) {
			result.append(current.num);
			if (current.next != null) {
				result.append(", ");
			}
			current = current.next;
		}
		return result.append("]").toString();
	}
}
