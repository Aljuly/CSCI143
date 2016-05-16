
public interface CS143Tree {
	public abstract void add (String item); 
	//add item to tree 
	public abstract String getPreOrder (); 
	//preorder traversal 
	public abstract String getInOrder (); 
	//inorder traversal 
	public abstract String getPostOrder (); 
	//postorder traversal 
	public abstract int getHeight (); 
	//height of the tree 
	public abstract int getNumberLeaf (); 
	//count leaf nodes 
	//search the tree for node containing item and return it 
	public abstract TreeNode getTreeNodeContaining (String item); 
	public abstract void deleteEntireTree (); 
	//set to null after done 
	public abstract int getHowManyNodes (); 
	//count all nodes in tree 
	public abstract boolean isEmpty (); 
	//if total nodes is zero 
}
