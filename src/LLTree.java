/**
 * @author 
 *
 */

//http://www.sanfoundry.com/java-program-implement-binary-search-tree-using-linked-list/

public class LLTree implements CS143Tree {
	
	private TreeNode root;
	private int size;
	
	public LLTree() {
		root = null;
		size = 0;
	}


	@Override
	public void add(String item) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPreOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPostOrder() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public TreeNode getTreeNodeContaining(String item) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteEntireTree() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getHowManyNodes() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
