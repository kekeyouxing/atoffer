package atoffer.tree.binarysearchtree;

import atoffer.tree.TreeNode;

public class BST {
	
	private TreeNode root;
	
	private int level;
	
	public BST(int[] val) {
		
		initTree(val);
		
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public int getLevel() {
		
		return level;
		
	}

	private void initTree(int[] val) {
		
		if(val==null || val.length==0) {
			throw new NullPointerException("tree is null");
		}
		
		for(int i=0; i<val.length; i++) {
			TreeNode node = new TreeNode(val[i]);
			root = insertCore(root, node);
		}
		
	}

	private TreeNode insertCore(TreeNode root, TreeNode node) {
		
		if(root == null) {
			return node;
		}
		if(node.val < root.val) {
			root.left = insertCore(root.left, node);
		}else {
			root.right = insertCore(root.right, node);
		}
		return root;
	}
	
	public boolean insert(TreeNode node) {
		
		if(!containsOf(root, node)) {
			insertCore(root, node);
			return true;
		}
		return false;
		
	}

	public boolean containsOf(TreeNode root, TreeNode node) {
		
		if(root == null ) {
			return false;
		}
		if(root.equals(node)) {
			return true;
		}
		if(root.val > node.val) {
			return containsOf(root.left, node);
		}else {
			return containsOf(root.right, node);
		}
		
	}
	
	public int size() {
		return sizeCore(root);
	}

	private int sizeCore(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		return sizeCore(root.left)+sizeCore(root.right)+1;
		
	}
	
	@Override
	public String toString() {
		
		return super.toString();
		
	}
}
