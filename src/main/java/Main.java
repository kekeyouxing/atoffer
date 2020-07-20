import java.util.*;

public class Main {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 0, list);
        return list;
    }

    private void depth(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> list) {
        if(pRoot == null) {
            return;
        }
        if(list.size() == depth) {
            list.add(new ArrayList<>());
        }
        list.get(depth).add(pRoot.val);
        depth(pRoot, depth + 1, list);
        depth(pRoot, depth + 1, list);
    }

    public int getLPS(String string){
        int[][] dp = new int[string.length()][string.length()];
        //k代表字符串的跨度
        for (int k = 0; k < string.length(); k++) {
            int i = 0;
            int j = i + k;
            while (i < string.length() && j < string.length()) {
                if (i == j) {
                    dp[i][j] = 1;
                }else if (string.charAt(i) == string.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
                j = (++i) + k;
            }
        }
        return dp[0][string.length()-1];
    }
     public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 3 -> 2 -> 4 -> 5 -> 7
    // reOrderArray
    // L - k + 1
    public ListNode Merge(ListNode list1,ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else {
            list2.next = Merge(list2.next, list1);
            return list2;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        //System.out.println(main.getLPS("javaej"));
        //a1b3c3d1
//        TreeNode root = new TreeNode(1);
//
//        TreeNode rootLeft= new TreeNode(2);
//        TreeNode rootRight = new TreeNode(3);
//
//        TreeNode rootLeftLeft= new TreeNode(4);
//        TreeNode rootLeftRight = new TreeNode(5);
//        root.left = rootLeft;
//        root.right = rootRight;
//
//        rootLeft.left = rootLeftLeft;
//        rootLeft.right = rootLeftRight;

    }


}
