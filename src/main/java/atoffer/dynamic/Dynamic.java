package atoffer.dynamic;

/**
 * @author Ke
 */
public class Dynamic {
	
	/**
	 * <p>
	 * Given a positive integer n, 
	 * break it into the sum of at least two positive integers and maximize the product of those integers.
     * <p>
	 * @param n integer n
	 * @return the maximum product you can get
	 * @see <a href="https://leetcode.com/problems/integer-break/">integer-break</a>
	 */
	public int integerBreak(int n) {
		if(n < 2)
			return 0;
		if(n == 2)
			return 1;
		if(n == 3)
			return 2;
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for(int i = 4; i <= n; i++) {
			int max = 0;
			for(int j = 1; j <= i/2; j++) {
				max = Math.max(dp[j] * dp[i-j], max);
			}
			dp[i] = max;
		}
		return dp[n];
	}

	/**
	 * <p>
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	 * <p>
	 * @param n the total steps of stair
	 * @return distinct ways you can climb
	 * @see <a href="https://leetcode.com/problems/climbing-stairs/">climbing-stairs</a>
	 */
	public int climbStairs(int n) {
		if(n == 0 || n == 1 || n == 2) {
			return n;
		}
		int[] dp = new int[n+1];
		dp[0] = 0; dp[1] = 1; dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	/**
	 * <p>A message containing letters from A-Z is being encoded to numbers using the following mapping:<p>
	 * <p>'A' -> 1<p>
	 * <p>'B' -> 2<p>
	 * <p>...<p>
	 * <p>'Z' -> 26<p>
	 * @param s a non-empty string containing only digits
	 * @return the total number of ways to decode {@code s}
	 * @see <a href="https://leetcode.com/problems/decode-ways/">decode-ways</a>
	 */
	public int numDecodings(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int[] val = string2Array(s);
		int[] dp = new int[val.length+1];
		
		dp[0] = 1; dp[1] = (val[0] == 0 ? 0 : 1);
		for(int i = 2; i <= val.length; i++) {
			
			if(val[i-1] != 0) {
				dp[i] = dp[i] + dp[i-1];
			}
			if(val[i-2] != 0 && val[i-2] * 10 + val[i-1] <= 26) {
				dp[i] = dp[i] + dp[i-2];
			}
			
		}
		return dp[val.length];
	}
	
	private int[] string2Array(String s) {
		int[] val = new int[s.length()];
		for(int i=0; i<val.length; i++) {
			val[i] = Integer.parseInt(s.substring(i, i+1));
		}
		return val;
	}
	
	/**
	 * <p>
	 * Given a m x n grid filled with non-negative numbers, 
	 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	 * <p>
	 * @param grid a m x n grid filled with non-negative numbers.
	 * @return a path from top left to bottom right which minimizes the sum of all numbers along its path.
	 * @see <a href="https://leetcode.com/problems/minimum-path-sum/">minimum-path-sum</a>
	 */
	public int minPathSum(int[][] grid){
		if(grid == null||grid.length == 0) {
			return -1;
		}
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] dp = new int[rows][cols];
		dp[0][0] = grid[0][0];
		for(int i=1; i<cols; i++) {
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}
		for(int i=1; i<rows; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				int min = dp[i-1][j] <= dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
				dp[i][j] = min + grid[i][j];
			}
		}
		return dp[rows-1][cols-1];
	}

	/**
	 * <p>
	 * Write a program to find the n-th ugly number.
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
	 * <p>
	 * @param n  the index of the ugly number.
	 * @return n-th ugly number.
	 * @see <a href="https://leetcode.com/problems/ugly-number-ii">nthUglyNumber</a>
	 */
	public int nthUglyNumber(int n) {
		if(n<=0) {
			return -1;
		}
		
		int[] dp = new int[n];
		dp[0] = 1;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		int i = 1;
		while(i<n) {
			
			int min = min(dp[index2]*2, dp[index3]*3, dp[index5]*5);
			dp[i]=min;
			while(dp[index2]*2<=min) {
				index2++;
			}
			while(dp[index3]*3<=min) {
				index3++;
			}
			while(dp[index5]*5<=min) {
				index5++;
			}
			i++;
			
		}
		return dp[n-1];
	}
	
    private int min(int v1,int v2,int v3){
        int m1 = Math.min(v1, v2);
        return Math.min(m1, v3);
    }
    
    /**
     * <p>
     * You are a professional robber planning to rob houses along a street. 
     * Each house has a certain amount of money stashed, 
     * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
     * and it will automatically contact the police if two adjacent houses were broken into on the same night.
     * Given a list of non-negative integers representing the amount of money of each house, 
     * determine the maximum amount of money you can rob tonight without alerting the police.
     * <p>
     * <blockquote>
     * <pre>
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     *              Total amount you can rob = 1 + 3 = 4.
     * </pre>
     * </blockquote>
     * @param nums
     * @see <a href="https://leetcode.com/problems/house-robber">house-robber</a>
     */
    public int rob(int[] nums) {
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	if(nums.length == 1) {
    		return nums[0];
    	}
    	int n = nums.length;
    	int[] dp = new int[n];
    	dp[0] = nums[0];
    	dp[1] = Math.max(nums[0], nums[1]);
    	for(int i=2; i<n;i++) {
    		dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    	}
		return dp[n-1];
    }
    
    /**
     * <p>
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
     * return the length of last word in the string.
     * If the last word does not exist, return 0.
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * <p>
     * @param s
     * @see <a href="https://leetcode.com/problems/length-of-last-word">length-of-last-word</a>
     */
    public int lengthOfLastWord(String s) {
    	if(s==null || s.length() == 0) {
    		return 0;
    	}
    	if(s.length() == 1) {
    		return s.charAt(0) == ' ' ? 0 : 1;
    	}
        char[] ch = s.toCharArray();
        
        int[] dp = new int[s.length()];
        int n = s.length();
        dp[0] = s.charAt(0) == ' ' ? 0 : 1;
        for(int i=1; i<ch.length; i++) {
        	if(ch[i] == ' ') {
        		dp[i] = dp[i-1];
        	}else {
            	if(ch[i-1] == ' ' ) {
            		dp[i] = 1;
            	}else {
            		dp[i] = dp[i-1]+1;
            	}
        	}
        }
        return dp[n-1];
    }
    
    /**
     * <p>
     * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
     * Once you pay the cost, you can either climb one or two steps. 
     * You need to find minimum cost to reach the top of the floor, 
     * and you can either start from the step with index 0, or the step with index 1.
     * <p>
     * <blockquote>
     * <pre>
     * Input: cost = [10, 15, 20]
     * Output: 15
     * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
     * </pre>
     * </blockquote>
     * @param cost
     * @see <a href="https://leetcode.com/problems/min-cost-climbing-stairs">min-cost-climbing-stairs</a>
     */
    public int minCostClimbingStairs(int[] cost) {
    	int n = cost.length;
    	int[] dp = new int[n+1];
    	dp[0] = 0;
    	dp[1] = 0;
    	for(int i=2; i<=cost.length; i++) {
    		dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
    	}
		return dp[n];  
    }

	/**
	 * <p>
	 * Given an integer array nums,
	 * find the contiguous subarray (containing at least one number)
	 * which has the largest sum and return its sum.
	 * <p>
	 * Example:
	 * <blockquote>
	 * <pre>
	 * Input: [-2,1,-3,4,-1,2,1,-5,4],
	 * Output: 6
	 * Explanation: [4,-1,2,1] has the largest sum = 6.</pre>
	 * </blockquote>
	 * @param nums integer array nums
	 * @return
	 * @see <a href="https://leetcode.com/problems/maximum-subarray">maximum-subarray</a>
	 */
	public int maxSubArray(int[] nums) {
		int result = Integer.MIN_VALUE;
		if(nums == null || nums.length == 0) {
			return result;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
		}
		for (int i = 0; i < dp.length; i++) {
			if(result < dp[i]){
				result = dp[i];
			}
		}
		return result;
	}
}
