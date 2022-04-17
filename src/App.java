
public class App {

	static Node rootNode = null;

	static int size = 0;
	static int item = 0;

	public App() {

		rootNode = null;

	}

	// Creating Node and its values

	public static class Node {

		int data;
		Node left, right;

		Node(int data) {

			this.data = data;
		}

		public void display() {

			System.out.println(data + " ");
		}

	}

	////////////////////// deleting Node //////////////////////////////////

	public void deleteKey(int key) {

		rootNode = deleteNode(rootNode, key);
	}

	public Node deleteNode(Node root, int key) {

		if (root == null)
			return root;

		if (key < root.data)

			root.left = deleteNode(root.left, key);

		else if (key > root.data)

			root.right = deleteNode(root.right, key);

		else {

			if (root.left == null)

				return root.right;

			else if (root.right == null)

				return root.left;

			root.data = minValue(root.right);

			root.right = deleteNode(root.right, root.data);

		}

		return root;

	}

	public int minValue(Node root) {

		int minValue = root.data;

		while (root.left != null) {

			minValue = root.left.data;
			root = root.left;
		}

		return minValue;
	}

	///////// Searching Node InOrder traversal

	public void inOrder(Node node) {

		if (node != null) {

			inOrder(node.left);
			node.display();
			inOrder(node.right);

		}
	}

	// Searching Node InOrder preOrder

	public void preOrder(Node node) {

		if (node != null) {

			node.display();
			preOrder(node.left);
			preOrder(node.right);

		}

	}

	// Inserting Node

	public void insert(Node node, int value) {

		if (value < node.data) {

			if (node.left != null) {

				insert(node.left, value);
			} else {

				node.left = new Node(value);

				item++;

				System.out.println("creating new left Node with value " + node.left.data);

			}

		}

		if (value > node.data) {

			if (node.right != null) {

				insert(node.right, value);
			} else {

				node.right = new Node(value);

				System.out.println("creating new right Node with value " + node.right.data);

				item++;

			}

		}

	}

	// Searching new value node

	public Node search(int value) {

		Node current = rootNode;

		while (current.data != value) {

			if (value < current.data) {

				current = current.left;
				size++;

			}

			else {

				current = current.right;

				size++;

			}

			if (current == null) {

				return null;
			}

		}

		return current;

	}

	// Program to call methods

	public static void main(String args[]) {

		App app = new App();

		rootNode = new Node(34);
		System.out.println("creating new root node " + rootNode.data);

		app.insert(rootNode, 56);
		app.insert(rootNode, 12);
		app.insert(rootNode, 89);
		app.insert(rootNode, 67);
		app.insert(rootNode, 90);

		System.out.println("items = " + item);

		Node result = app.search(56);

		if (result == null) {
			System.out.println("no data is found");
		} else {

			System.out.println("\n Node " + result.data + " is found at position " + size);
		}

		System.out.println("Inorder traversal of binary tree \n");
		app.inOrder(rootNode);

		System.out.println("preOrder traversal of binary tree");
		app.preOrder(rootNode);

	}

}
