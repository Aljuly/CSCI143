import org.testng.Assert; 
import org.testng.annotations.Test; 


public class LLTreeTest {
	
	@Test 
	public void testEmptyConstructor () 
	{ 
		Assert.assertNotNull(new LLTree ()); 
	} 

	@Test
	public void testAdd() {
		LLTree tree = new LLTree (); 
		tree.add("cat"); 
		tree.add("bat"); 
		tree.add("dog"); 
		Assert.assertEquals(tree.getHowManyNodes(), 3); 
		Assert.assertEquals(tree.getNumberLeaf(), 2); 
		Assert.assertEquals(tree.getHeight(), 2); 
	}

	@Test
	public void testDeleteEntireTree() {
		LLTree tree = new LLTree (); 
		tree.add("cat"); 
		tree.add("bat");  
		tree.add("dog"); 
		tree.deleteEntireTree(); 
		Assert.assertEquals(tree.isEmpty(), true); 
	}

	@Test
	public void testGetOrder() {
		LLTree t = new LLTree (); 
		t.add("cat"); t.add("bat"); t.add("elephant"); 
		t.add("ant"); t.add("dog"); t.add("bee"); 
		t.add("fox"); t.add("giraffe"); 
		Assert.assertEquals(t.getInOrder(), "ant bat bee cat dog elephant fox giraffe ");
		Assert.assertEquals(t.getPreOrder(), "cat bat ant bee elephant dog fox giraffe ");
		Assert.assertEquals(t.getPostOrder(), "ant bee bat dog giraffe fox elephant cat ");
	}

	@Test
	public void testGetTreeNodeContaining() {
		LLTree t = new LLTree ();
		t.add("cat"); t.add("bat"); t.add("elephant"); 
		t.add("ant"); t.add("dog"); t.add("bee"); 
		t.add("fox"); t.add("giraffe"); 
		Assert.assertEquals(t.getTreeNodeContaining("$$$") == null, true); 
		Assert.assertEquals(t.getTreeNodeContaining("dog") == null, false);
	}

	@Test
	public void testIsEmpty() {
		LLTree tree = new LLTree (); 
		Assert.assertEquals(tree.isEmpty(), true); 
		tree.add("cat"); 
		Assert.assertEquals(tree.isEmpty(), false); 
		tree.deleteEntireTree(); 
		Assert.assertEquals(tree.isEmpty(), true);  

	}
	
	@Test
	public void testDelete() {
		LLTree t = new LLTree ();
		t.add("cat"); t.add("bat"); t.add("elephant"); 
		t.add("ant"); t.add("dog"); t.add("bee"); 
		t.add("fox"); t.add("giraffe"); 
		Assert.assertEquals(t.deleteNode("cat"), true); 
		Assert.assertEquals(t.deleteNode("dog"), true); 
		Assert.assertEquals(t.deleteNode("elephant"), true); 
		Assert.assertEquals(t.deleteNode("###"), false);
		t.deleteEntireTree();
		Assert.assertEquals(t.deleteNode("cat"), false);
	}
	
	@Test
	public void testCopyTree() {
		LLTree t = new LLTree ();
		t.add("cat"); 
		t.add("bat"); 
		t.add("dog"); 
		LLTree copyoft = new LLTree ();
		t.copyTree(copyoft);
		Assert.assertEquals(copyoft.getHowManyNodes(), 3); 
		Assert.assertEquals(copyoft.getNumberLeaf(), 2); 
		Assert.assertEquals(copyoft.getHeight(), 2);
	}
	
}
