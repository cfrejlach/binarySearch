package Chris;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 * 
 * @author Chris
 * 
 * @version 1.0
 */
public class Main {
	
	/** The root. */
	// TASK 1: SPECIFY THE DATA MEMBER - SIMPLY THE ROOT REFERENCE TO THE TREE
	public Node root;
	
	/** The cycles. */
	public ArrayList<String> cycles = new ArrayList<String>();
	
	/**
	 * Instantiates a new main.
	 */
	// TASK 2: CREATE THE CONSTRUCTOR.
	public Main() {
		// TIP: THE ROOT SHOULD BE INITIALIZED TO NULL, BECAUSE TREES BEGIN EMPTY.
		root = null;
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Delete node.
	 *
	 * @param key the key
	 */
	// DELETE NODE
	public void deleteNode(int key) {
		// TASK 1: DEFINE VARIABLES
		Node toDelete = root;
		Node parentoTD = null;
		boolean found = false;
		
		// TASK 2: LOCATE THE NODE TO DELETE
		while (!found && toDelete != null) {
			if (key == toDelete.key)
				found = true;
			else {
				parentoTD = toDelete;
				if (key > toDelete.key)
					toDelete = toDelete.rightChild;
				else
					toDelete = toDelete.leftChild;
			}
		}
		System.out.println("parentoTD after locating node: " + parentoTD.key);
		// TASK 3: DELETE THE NODE
		// node not found
		if (!found)
			return;
		// if node to delete is a node
		if (toDelete.leftChild == null || toDelete.rightChild == null) {
			Node theChild;
			System.out.println("parentoTD When node is found: " + parentoTD.key);
			if (toDelete.leftChild == null)
				theChild = toDelete.rightChild;
			else
				theChild = toDelete.leftChild;
			
			System.out.println("TheChild: " + theChild.key);
			// DEAL WITH THE SITUATION WHEN THE PARENT IS NULL
			if (parentoTD == null)
				root = theChild;
			else if (parentoTD.leftChild == toDelete) {
				parentoTD.leftChild = theChild;
			}
			else {
				parentoTD.rightChild = theChild;
			}
			
			System.out.println("parentoTD: " + parentoTD.key);
			return;
		}
		// if node to delete only has one child
		// position smallestParent
		Node smallestParent = toDelete;
		Node smallest = toDelete.rightChild;
		while (smallest.leftChild != null) {
			smallestParent = smallest;
			smallest = smallest.leftChild;
		}
		// task b: Smallest contains the smallest child on the rightChild subtree. Swap the
		// contents unlink.
		toDelete.key = smallest.key;
		if (smallest == toDelete) {
			smallestParent.rightChild = smallest.rightChild;
			assert checkPointerSmall(key, root) == true : "Error: left child pointers are incorrect";
			assert CheckLoops() == false : "Error: Your tree has cycles";
		}
		else {
			smallestParent.leftChild = smallest.rightChild;
			assert checkPointerBig(key, root) == true : "Error: right child pointers are incorrect";
			assert CheckLoops() == false : "Error: Your tree has cycles";
		}
	}

	/**
	 * Adds the node.
	 *
	 * @param n the n
	 */
	// ADD NODE
	public void addNode(int n) {
		Node temp = new Node(n);
		assert CheckLoops() == false : "Error: Your tree has cycles";
		//assert CheckRootParent() == false : "Error: The root has a parent";
		// IF EMPTY TREE

		if (isEmpty() == true) {
			root = temp;
		}
		// ELSE THE TREE HAS NODES ALREADY
		else {

			assert isEmpty() == false : "Error: Tree is empty";
			Node loc = root;
			while (true) {
				// TRAVEL TO THE leftChild SIDE
				if (temp.key < loc.key) {
					if (loc.leftChild != null) {
						loc = loc.leftChild;

					} else {
						loc.leftChild = temp;
						String yee = String.valueOf(loc.key) + String.valueOf(temp.key);
						cycles.add(yee);
						assert checkPointerSmall(loc.key, temp) == true : "Error: left child pointers are incorrect";
						break;
					}
				}
				// TRAVEL TO THE rightChild SIDE
				else if (temp.key > loc.key) {
					if (loc.rightChild != null) {
						loc = loc.rightChild;

					} else {
						loc.rightChild = temp;
						String yee = String.valueOf(loc.key) + String.valueOf(temp.key);
						cycles.add(yee);
						assert checkPointerBig(loc.key, temp) == true : "Error: right child pointers are incorrect";
						break;
					}
				} else {
					System.out.println("Error");
					break;
				}
			}
		}

	}

	// IN-ORDER TRAVERSAL: LVR
	/**
	 * Display in order.
	 */
	// display inOrder(): calls inOrder()
	public void displayInOrder() {
		inOrder(root);
	}

	/**
	 * In order.
	 *
	 * @param loc the loc
	 */
	// inOrder() : recursive method
	public void inOrder(Node loc) {
		if (loc != null) {
			if (loc.leftChild != null)
				assert checkPointerSmall(loc.key, loc.leftChild) == true : "Error: leftChild pointers are incorrect";
			inOrder(loc.leftChild);
			System.out.println(loc.key);
			if (loc.rightChild != null)
				assert checkPointerBig(loc.key, loc.rightChild) == true : "Error: rightChild pointers are incorrect";
			inOrder(loc.rightChild);
		}
	}

	// POSTORDER TRAVERSAL: RVL
	/**
	 * Display post order.
	 */
	// display inOrder(): calls inOrder()
	public void displayPostOrder() {
		postOrder(root);
	}

	/**
	 * Post order.
	 *
	 * @param loc the loc
	 */
	// postOrder() : recursive method
	public void postOrder(Node loc) {
		if (loc != null) {
			postOrder(loc.rightChild);
			System.out.println(loc.key);
			postOrder(loc.leftChild);
		}
	}

	// PREORDER TRAVERSAL: VLR
	/**
	 * Display pre order.
	 */
	// display preOrder(): calls inOrder()
	public void displayPreOrder() {
		preOrder(root);
	}

	/**
	 * Pre order.
	 *
	 * @param loc the loc
	 */
	// preOrder() : recursive method
	public void preOrder(Node loc) {
		if (loc != null) {
			System.out.println(loc.key);
			preOrder(loc.leftChild);
			preOrder(loc.rightChild);
		}
	}

	/**
	 * Display count nodes.
	 */
	// COUNT NODES
	public void displayCountNodes() {
		System.out.println(countNodes(root));
	}

	/**
	 * Count nodes.
	 *
	 * @param root the root
	 * @return the int
	 */
	public static int countNodes(Node root) {
		if (null == root)
			return 0;

		int nleftChildSubtree = countNodes(root.leftChild);
		int nrightChildSubtree = countNodes(root.rightChild);
		return nleftChildSubtree + nrightChildSubtree + 1;
	}

	/**
	 * Display single parents.
	 */
	// SINGLE PARENT NODES
	public void displaySingleParents() {
		System.out.println(singleParents(root));
	}

	/**
	 * Single parents.
	 *
	 * @param root the root
	 * @return the int
	 */
	public static int singleParents(Node root) {

		if (null == root)
			return 0;
		int nleftChildSubtree = singleParents(root.leftChild);
		int nrightChildSubtree = singleParents(root.rightChild);
		if (root.leftChild != null && root.rightChild == null || root.leftChild == null && root.rightChild != null)
			return nleftChildSubtree + nrightChildSubtree + 1;
		else
			return 0;

	}

	/**
	 * Check pointer small.
	 *
	 * @param n the n
	 * @param node the node
	 * @return true, if successful
	 */
	public boolean checkPointerSmall(int n, Node node) {
		Node leftChild = node;
		if (n > leftChild.key)
			return true;
		else
			return false;
	}

	/**
	 * Check pointer big.
	 *
	 * @param n the n
	 * @param node the node
	 * @return true, if successful
	 */
	public boolean checkPointerBig(int n, Node node) {
		Node rightChild = node;
		if (n < rightChild.key)
			return true;
		else
			return false;
	}
	
	/**
	 * Check loops.
	 *
	 * @return true, if successful
	 */
	private boolean CheckLoops() {
		if (cycles.isEmpty())
			return false;
		else {
			for (int i = 0; i < cycles.size(); i++) {
				StringBuilder compare = new StringBuilder();
				compare.append(cycles.get(i));
				for (int z = 0; z < cycles.size(); z++) {
					StringBuilder compared = new StringBuilder();
					compared.append(cycles.get(z));
					if (compare.reverse() == compared) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}
}
