package atoffer.tree.binarysearchtree;

public class Bootstrap {
	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,6,4,7,8,5};
		BST tree = new BST(arr);
		BSTUtil treeUtil = new BSTUtil(tree);
		
	}
}
