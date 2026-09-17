public class Main {
	public static LinkedList CMult(LinkedList L1) {
		LinkedList L2 = new LinkedList();
		int product = 1;

		Node current = L1.head;
		while (current != null) {
			product *= current.num;
			L2.add(product);
			current = current.next;
		}

		return L2;
	}

	public static void main(String[] args) {
		LinkedList L1 = new LinkedList();
		L1.add(1);
		L1.add(2);
		L1.add(3);
		L1.add(4);
		L1.add(5);

		LinkedList L2 = CMult(L1);

		System.out.println("L1: " + L1);
		System.out.println("L2: " + L2);
	}
}


