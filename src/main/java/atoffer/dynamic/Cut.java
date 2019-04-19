package atoffer.dynamic;

/**
 * @author Ke
 *一根长度为n的绳子，把绳子剪成m段，每段绳子的长度为k[0],k[1],k[2]...k[m]
 *请问k[0]*k[1]*k[2]*。。。*k[m]最大乘积是多少?
 */
public class Cut {
	
	public int cut(int n) {
		
		if(n<2) {
			return 0;
		}
		
		if(n == 3) {
			return 2;
		}
		
		if(n == 4) {
			return 4;
		}
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for(int i=4; i<=n; i++) {
			
			int max = 0;
			for(int j=1; j<=n/2; j++) {
				if(dp[j]*dp[n-j] > max) {
					max = dp[j]*dp[n-j];
				}
			}
			dp[i] = max;
			
		}
		return dp[n];
		
	}
	
}
