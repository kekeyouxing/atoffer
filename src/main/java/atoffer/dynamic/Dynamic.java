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
				if(dp[j] * dp[i-j] > max) {
					max = dp[j] * dp[i-j];
				}
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
				if(dp[i-1][j] <= dp[i][j-1]) {
					dp[i][j] = dp[i-1][j] + grid[i][j];
				}else {
					dp[i][j] = dp[i][j-1] + grid[i][j];
				}
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
	 * @see <a href="https://leetcode.com/problems/ugly-number-ii/">nthUglyNumber</a>
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
        int m1 = v1 < v2 ? v1 : v2;
        return m1 < v3 ? m1 : v3;
    }
}
