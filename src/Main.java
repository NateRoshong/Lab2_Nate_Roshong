public class Main {

	public static void main(String[] args) {
		LinkedList L1 = new LinkedList(); //Makes list 1
		L1.addtail(1);
		L1.addtail(2);
		L1.addtail(3);
		L1.addtail(4);
		L1.addtail(5);
		L1.addtail(67);

		LinkedList L2 = new LinkedList(); //Makes list 2
		L2.addtail(5);
		L2.addtail(12);
		L2.addtail(4);
		L2.addtail(3);
		L2.addtail(2);
		L2.addtail(1);
		L2.addtail(67);

		System.out.println("List 1: " + L1);
		System.out.println("List 2: " + L2);
		System.out.println("");
		System.out.println("Is List 1 a subset of List 2? " + L1.isSubset(L2));
		System.out.println("Is List 2 a subset of List 1? " + L2.isSubset(L1));
		System.out.println("");
		System.out.println("Multiplied(L1): " + L1.CMult());
		System.out.println("");
		System.out.println("Merged: " + L1.mergeAlternately(L2));
		System.out.println("");
		L2.delete(12);
		System.out.println("List 2 after deleting 12: " + L2);
	}
}


