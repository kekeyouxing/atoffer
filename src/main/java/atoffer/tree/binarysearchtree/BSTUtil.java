package atoffer.tree.binarysearchtree;

import atoffer.tree.TreeNode;

public class BSTUtil {
	
	private BST tree;
	
	private int count;
	
	TreeNode kthNode = null;
	
	public BSTUtil(BST tree) {
		
		this.tree = tree;
		
	}
	
	public boolean isValidBST() {
		
		TreeNode root = tree.getRoot();
		return isValidBSTCore(root);
	}
	
	public boolean isValidBSTCore(TreeNode root) {
    	
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left != null && root.left.val>root.val){
            return false;
        }
        if(root.right!=null&& root.right.val<root.val){
            return false;
        }
        return isValidBSTCore(root.left)&&isValidBSTCore(root.right);
        
    }
	
	public boolean isPostOfBST(int[] arr) {
		
		return isPostOfBSTCore(arr, 0, arr.length-1);
		
	}
	
	private boolean isPostOfBSTCore(int[] arr, int left, int right) {
		
		if(left>=right) {
			return true;
		}
		
		int i = right;
		while(i>left && arr[i-1]>arr[right]) {
			i--;
		}
		for(int j = left; j<i-1; j++) {
			if(arr[j]>arr[right]) {
				return false;
			}
		}
		return isPostOfBSTCore(arr, left, i-1) && isPostOfBSTCore(arr, i, right-1);
		
	}
	
	public TreeNode  kthNode(int k) {
		TreeNode root=tree.getRoot();
		kthNodeCore(root, k);
		return kthNode;
	}

	private void kthNodeCore(TreeNode root, int k) {
		
		if(root == null) {
			return;
		}
		if(root.left != null) kthNodeCore(root.left, k);
		count++;
		if(k==count) {
			kthNode = root;
		}
		if(root.right != null) kthNodeCore(root.right, k);
		
	}
}
