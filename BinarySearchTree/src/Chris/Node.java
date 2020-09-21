package Chris;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 * 
 * @author Chris
 */
public class Node {
		
	/** The key. */
	// DATA MEMBERS: BINARY TREES HAVE A LEFT AND A RIGHT
		public int key;
		
		/** The left child. */
		public Node leftChild;
		
		/** The right child. */
		public Node rightChild;

		/**
		 * Instantiates a new node.
		 *
		 * @param n the n
		 */
		// EXPLICIT CONSTRUCTOR
		public Node(int n) {
			this.key = n;
			leftChild = null;
			rightChild = null;

		}

		/**
		 * Gets the key.
		 *
		 * @return the key
		 */
		public int getKey() {
			return key;
		}


		/**
		 * Gets the left child.
		 *
		 * @return the left child
		 */
		public Node getLeftChild() {
			return leftChild;
		}


		/**
		 * Gets the right child.
		 *
		 * @return the right child
		 */
		public Node getRightChild() {
			return rightChild;
		}

		
}
