package atoffer.dynamic;

/**
 * @author Ke
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 *求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {
	
	public int jumpFloor(int n) {
		if(n==0 || n==1 || n==2) {
			return n;
		}
		int[] dp = new int[n+1];
		dp[0] = 0;dp[1] =1;dp[2] =2;
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
		
	}
}
