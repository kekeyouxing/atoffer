package atoffer.tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;

import atoffer.tree.TreeNode;

public class BinaryTreeUtil {

	private BinaryTree tree = null;
	
	public BinaryTreeUtil(BinaryTree tree) {
		
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
	
	public ArrayList<Integer> printZTree() {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		TreeNode root = tree.getRoot();
		if(root == null) {
			return result;
		}
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int level = 1;
		queue.offer(root);
		result.add(root.val);
		while(!queue.isEmpty()) {
			
			int length = queue.size();
			
			while(length>0) {
				TreeNode node = queue.poll();
				if(node.left!=null) {
					queue.offer(node.left);
				}
				if(node.right!=null) {
					queue.offer(node.right);
				}
				length--;
			}
			level++;
			
			if(level%2==0){
				for(int i=queue.size()-1; i>=0; i--) {
					result.add(((TreeNode)queue.get(i)).val);
				}
			}
			
			if(level%2==1) {
				for(int i=0; i<queue.size(); i++) {
					result.add(((TreeNode)queue.get(i)).val);
				}
			}
			
		}
		return result;
	}
	
	
	public ArrayList<ArrayList<Integer>> pathSum(int sum) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		TreeNode root = tree.getRoot();
		pathSumCore(root, sum, temp, result);
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	public void pathSumCore(TreeNode root, int sum, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
		
		if(root == null) {
			return;
		}
		temp.add(root.val);
		if(root.left==null && root.right == null) {
			int tempSum = 0;
			for(int i=0; i<temp.size(); i++) {
				tempSum+=temp.get(i);
			}
			if(tempSum == sum) {
				result.add((ArrayList<Integer>)temp.clone());
			}
			temp.remove(temp.size()-1);
			return;
		}
		if(root.left!=null) {
			pathSumCore(root.left, sum, temp, result);
		}
		if(root.right!=null) {
			pathSumCore(root.right, sum, temp, result);
		}
		temp.remove(temp.size()-1);
		
	}
	
	public TreeNode convertToDoubleList() {
		
		TreeNode root = tree.getRoot();
		TreeNode head = null;
		TreeNode pre = null;
		convertToDoubleListCore(root, head, pre);
		return head;
		
	}
	
	private void convertToDoubleListCore(TreeNode root, TreeNode head, TreeNode pre) {
		
		if(root == null) {
			return;
		}
		convertToDoubleListCore(root.left, head, pre);
		
		root.left = pre;
		if(pre!=null) {
			pre.right = root;
		}
		pre = root;
		if(head == null) {
			head = root;
		}
		convertToDoubleListCore(root.right, head, pre);
		
	}
	
	public String serializeTree() {
		
		TreeNode root = tree.getRoot();
		StringBuffer sb = new StringBuffer();
		serializeTreeCore(root, sb);
		return sb.toString();
		
	}
	
	public void serializeTreeCore(TreeNode root, StringBuffer sb) {
		
		if(root == null) {
			sb.append("#");
			return;
		}
		sb.append(root.val);
		serializeTreeCore(root.left, sb);
		serializeTreeCore(root.right, sb);
	}
	
	public void deserializeTree(String str) {
		
		deserializeTreeCore(str, 0);
		
	}
	
	public TreeNode deserializeTreeCore(String str, int k) {
		
		if(k == str.length()) {
			return null;
		}
		char val = str.charAt(k);
		TreeNode node = null;
		if(val!='#') {
			node = new TreeNode(val);
			node.left = deserializeTreeCore(str, k+1);
			node.right = deserializeTreeCore(str, k+1);
		}
		return node;
		
	}
	
}
