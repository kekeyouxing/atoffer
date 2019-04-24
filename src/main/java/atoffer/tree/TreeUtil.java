package atoffer.tree;

public class TreeUtil {

	private Tree tree = null;
	
	public TreeUtil(Tree tree) {
		
		this.tree = tree;
		
	}
	
	public TreeNode mirror(TreeNode root) {
		
		if(root == null) {
			return null;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if(root.left != null) mirror(root.left);
		if(root.right != null) mirror(root.right);
		return root;
		
	}
	
	public boolean hasSubTree(TreeNode root1, TreeNode root2) {
		
		boolean result = false;
		if(root1 == null || root2 == null) {
			return false;
		}
		if(root1.val == root2.val) {
			result = isSubTree(root1, root2);
		}
		if(!result) result = hasSubTree(root1.left, root2);
		if(!result) result = hasSubTree(root1.right, root2);
		return result;
		
	}

	private boolean isSubTree(TreeNode root1, TreeNode root2) {
		
		if(root1 == null) return false;
		
		if(root2 == null) return true;
		
		if(root1.val != root2.val) return false;
		
		return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
		
	}

	public boolean isSymmetrical(TreeNode root) {
		if(root == null) {
			return false;
		}
		return isSymmetricalCore(root.left, root.right);
	}

	private boolean isSymmetricalCore(TreeNode left, TreeNode right) {
		
		if(left == null && right == null) {
			return true;
		}
		if(left == null || right == null) {
			return false;
		}
		
		if(left.val != right.val) {
			return false;
		}
		return isSymmetricalCore(left.left, right.right) && isSymmetricalCore(left.right, right.left);
		
	}
}
