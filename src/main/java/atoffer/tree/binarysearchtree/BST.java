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
		
		root = constructCore(val);
		
	}

	private TreeNode constructCore(int[] val) {
		
		for(int i=0; i<val.length; i++) {
			insert(val[i]);
		}
		return null;
		
	}
	
	public boolean insert(int val) {
		
		if(!containsOf(root, val)) {
			insertCore(root, val);
			return true;
		}
		return false;
		
	}
	
	public boolean containsOf(TreeNode root, int val) {
		
		if(root == null) {
			return false;
		}
		if(root.val == val) {
			return true;
		}
		
		if(root.val < val) {
			return containsOf(root.right, val);
		}
		if(root.val > val) {
			return containsOf(root.left, val);
		}
		return false;
		
	}
	
	private void insertCore(TreeNode root, int val) {
		
		if(root == null) {
			root = new TreeNode(val);
		}
		
		if(root.val < val) {
			insertCore(root.right, val);
		}
		if(root.val > val) {
			insertCore(root.left, val);
		}
		
	}

}
