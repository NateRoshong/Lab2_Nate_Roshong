public class LinkedList {
	Node head;
	Node tail;
	//adds a new node to the tail of the linked list
	public void addtail(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	//adds a new node to the head of the linked list
	public void addhead(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	// Swaps 2 nodes positions
	public void swap(int i, int j) {
		if (i < 0 || j < 0 || i == j || head == null) {
			return;
		}
		if (i > j) {
			int temp = i;
			i = j;
			j = temp;
		}

		Node previousI = null;
		Node nodeI = head;
		for (int position = 0; position < i && nodeI != null; position++) {
			previousI = nodeI;
			nodeI = nodeI.next;
		}

		Node previousJ = null;
		Node nodeJ = head;
		for (int position = 0; position < j && nodeJ != null; position++) {
			previousJ = nodeJ;
			nodeJ = nodeJ.next;
		}

		if (nodeI == null || nodeJ == null) {
			return;
		}

		if (nodeI.next == nodeJ) {
			if (previousI == null) {
				head = nodeJ;
			} else {
				previousI.next = nodeJ;
			}
			nodeI.next = nodeJ.next;
			nodeJ.next = nodeI;
		} else {
			if (previousI == null) {
				head = nodeJ;
			} else {
				previousI.next = nodeJ;
			}
			previousJ.next = nodeI;
			Node nextI = nodeI.next;
			nodeI.next = nodeJ.next;
			nodeJ.next = nextI;
		}

		if (tail == nodeI) {
			tail = nodeJ;
		} else if (tail == nodeJ) {
			tail = nodeI;
		}
	}

	//delets a specified node from the linked list
	public void delete(int value) {
		if (head == null) {
			return;
		}
		if (head.num == value) {
			head = head.next;
			if (head == null) {
				tail = null;
			}
			return;
		}
		Node current = head;
		while (current.next != null) {
			if (current.next.num == value) {
				current.next = current.next.next;
				if (current.next == null) {
					tail = current;
				}
				return;
			}
			current = current.next;
		}
	}

	// Merges this list with another list by alternating nodes from each list.
	public LinkedList mergeAlternately(LinkedList other) {
		LinkedList merged = new LinkedList();
		Node current1 = head;
		Node current2 = other.head;

		// Add one node from each list when available, preserving each list's order.
		while (current1 != null || current2 != null) {
			if (current1 != null) {
				merged.addtail(current1.num);
				current1 = current1.next;
			}
			if (current2 != null) {
				merged.addtail(current2.num);
				current2 = current2.next;
			}
		}

		return merged;
	}

	// Multiplies each node's value by the product of all preceding nodes.
	public LinkedList CMult() {
		LinkedList multiplied = new LinkedList();
		int product = 1;
		Node current = head;

		while (current != null) {
			product *= current.num;
			multiplied.addtail(product);
			current = current.next;
		}

		return multiplied;
	}

	// Returns true when every value in this list is also in the other list.
	public boolean isSubset(LinkedList other) {
		Node current = head;
		while (current != null) {
			Node otherCurrent = other.head;
			boolean found = false;
			while (otherCurrent != null) {
				if (otherCurrent.num == current.num) {
					found = true;
					break;
				}
				otherCurrent = otherCurrent.next;
			}
			if (!found) {
				return false;
			}
			current = current.next;
		}
		return true;
	}

	// turns the linked list into a string representation with commas and brackets
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
