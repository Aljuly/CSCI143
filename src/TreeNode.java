
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
}
