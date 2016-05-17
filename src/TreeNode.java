
public class TreeNode {
	
	public TreeNode left; 
	public String item; 
	public TreeNode right; 
	public int numberDuplicates; 
	
	public TreeNode (String item) { 
		this.item = item; 
		this.left = null; 
		this.right = null; 
		this.numberDuplicates = 0; 
	} 
	
	// Returns the minimum element in the subtree rooted at current node.
	public String minItem() {
		if (left == null) 
			return item;
		else
			return left.minItem();
	}
	
	// delete node from tree
	public boolean delete(TreeNode parent, String item) {
		if (item.compareTo(this.item) < 0) {
			// search for node to delete in left subtree
			if (left != null) {
				return left.delete(this, item);
			} else {
				//if no node in t contains item then return false 
				return false;
			} 
			// search for node to delete in right subtree
		} else if (item.compareTo(this.item) > 0) {
			if (right != null) {
				return right.delete(this, item);
			} else {
				//if no node in t contains item then return false 
				return false;
			}
			// if found
		} else {
			// if we have two children
			if (left != null && right != null) { 
				this.item = right.minItem();
				right.delete(this, item);
			// or only one or none
			} else if (parent.left == this) {
				parent.left = (left != null) ? left : right;
			} else if (parent.right == this) { 
                parent.right = (left != null) ? left : right; 
			}
			return true;
		}
	}
}
