package atoffer.tree;

public class TreeNode {

	public int val;
	public TreeNode left = null;
	public TreeNode right = null;
	public TreeNode(int val) {
		this.val = val;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj){
			return true;
		}
		if(obj instanceof TreeNode) {
			TreeNode anotherNode = (TreeNode)obj;
			return val==anotherNode.val;
		}
		return false;
		
	}
}
