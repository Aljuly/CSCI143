
public class LLTree implements CS143Tree {
	
	protected TreeNode root;
	protected int size;
	
	public LLTree() {
		root = null;
		size = 0;
	}

	@Override
	public void add(String item) {
		root = addTreeNode(root, item);
		// count nodes added  
		size++;
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
		return node;
	}
	
	
	// Method for deleting data from tree
	public boolean deleteNode (String item) { 
		// if t is null return false 
		if (root == null) 
			return false;
		else {
			// if found node in t containing item then delete the node and return true
			// if deleting root node, we created temporary root...
			if (root.item.equals(item)) {
				TreeNode tempRoot = new TreeNode("");
				tempRoot.left = root;
				boolean result = root.delete(tempRoot, item);
				root = tempRoot.left;
				return result;
			} else {
				return root.delete(null, item);
			}
		}
	} 
	
	//Method for copying binary tree
	public void copyTree (LLTree destination) { 
		// clear destination
		destination.deleteEntireTree();
		// and copy
		destination.root = copy(this.root);
		destination.size = this.size;
	} 
	
	//private method for recursive copying binary tree
	private TreeNode copy (TreeNode source) { 
		if (source == null) return source;
		TreeNode temp = new TreeNode(source.item);
		temp.left = copy(source.left);
		temp.right = copy(source.right);
		return temp;
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
			data = inOrder(node.left);
			data += node.item + " ";
			data += inOrder(node.right);
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
			data = postOrder(node.left);
			data += postOrder(node.right);
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
			if (item.compareTo(node.item) < 0) {
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
