package atoffer.tree.binarytree;

public class Bootstrap {
	
	public static void main(String[] args) {
		int[] pre = new int[] {1,2,4,7,3,5,6,8};
		int[] in = new int[] {4,7,2,1,5,3,8,6};
		
		BinaryTree tree = new BinaryTree(pre, in);
		BinaryTreeUtil treeUtil = new BinaryTreeUtil(tree);
		treeUtil.serializeTree();
	}
	
}
