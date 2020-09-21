package Chris;

// TODO: Auto-generated Javadoc
/**
 * The Class TreeTest.
 */
public class TreeTest {
	
	/**
	 * The main method.
	 *
	 *@author Chris
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TASK 1: INSTANTIATE A BINARY binTree
		Main binTree = new Main();

		// TASK 2: ADD NODES TO THE BINARY binTree
		binTree.addNode(7);
		binTree.addNode(9);
		binTree.addNode(5);
		binTree.addNode(8);
		binTree.addNode(6);
		binTree.addNode(10);
		binTree.addNode(3);
		binTree.addNode(-1);

		// TASK 3: DISPLAY THE NODES IN-ORDER
		System.out.println("The node count is: ");
		binTree.displayCountNodes();
		System.out.println("Displaying the nodes in-order:");
		binTree.displayInOrder();
		binTree.deleteNode(3);
		System.out.println("The node count is: ");
		binTree.displayCountNodes();
		
	}
}
