
public class LLTree implements CS143Tree {
	
	private TreeNode root;
	private int size;
	
	public LLTree() {
		root = null;
		size = 0;
	}

	@Override
	public void add(String item) {
		root = addTreeNode(root, item);
	}
	
	// Method for inserting data into binary tree
	private TreeNode addTreeNode(TreeNode node, String item) {
		if (node == null) {
			// if current nod is Null(for example root nod), then create it and return it
			node = new TreeNode(item);
		} else if (item.compareTo(node.item) <= 0){
			node.left = addTreeNode(node.left, item);
		} else {
			node.right = addTreeNode(node.right, item);
		}
		// count nodes added 
		size++;
		return node;
	}

	@Override
	public String getPreOrder() {
		return preOrder(root);
	}
	
	// Method for tree preorder traversal
	private String preOrder(TreeNode node) {
		String data = "";
		if (node != null) {
			data = node.item + " ";
			data += preOrder(node.left);
			data += preOrder(node.right);
		}
		return data;
	}
	
	@Override
	public String getInOrder() {
		return inOrder(root);
	}
	
	// Method for tree inorder traversal
	private String inOrder(TreeNode node) {
		String data = "";
		if (node != null) {
			data = preOrder(node.left);
			data += node.item + " ";
			data += preOrder(node.right);
		}
		return data;
	}

	@Override
	public String getPostOrder() {
		return postOrder(root);
	}
	
	// Method for tree postorder traversal
	private String postOrder(TreeNode node) {
		String data = "";
		if (node != null) {
			data = preOrder(node.left);
			data += preOrder(node.right);
			data += node.item + " ";
		}
		return data;
	}

	@Override
	public int getHeight() {
		return treeHeight(root);
	}
	
	// Method for recursive definition Height of the tree
	private int treeHeight(TreeNode node){ 
		if (node == null) {
			return 0; 
		} 
		return (1 + Math.max(treeHeight(node.left), treeHeight(node.right))); 
	}


	@Override
	public int getNumberLeaf() {
		return countLeafNodes(root);
	}
	
	// Method for recursive counting of leaf nodes
	private int countLeafNodes(TreeNode node) {
		if (node == null) return 0;
		if ((node.left == null) && (node.right == null)) {
			return 1;
		} else {
			return countLeafNodes(node.left) + countLeafNodes(node.right);
		}
	}

	@Override
	public TreeNode getTreeNodeContaining(String item) {
		return searchNode(root, item);
	}

	// Method for searching for the node, which contains given string
	private TreeNode searchNode(TreeNode node, String item) {
		while (node != null) {
			if (item.compareTo(node.item) <= 0) {
				node = node.left;
			} else if (item.compareTo(node.item) > 0) {
				node = node.right;
			} else {
				return node;
			}
		}
		return null;
	}
	
	@Override
	public void deleteEntireTree() {
		root = null;
		size = 0;
	}

	@Override
	public int getHowManyNodes() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0? true : false;
	}
	
	

}
