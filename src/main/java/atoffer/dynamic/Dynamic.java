package atoffer.dynamic;

import atoffer.array.Vector;

/**
 * @author Ke
 */
public class Dynamic {
	
	/**
	 * @param n
	 * @return
	 * 
	 */
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
	
	public int numDecodings(String str) {
		
		if(str == null || str.length()==0) {
			return 0;
		}
		int[] val = str2IntArr(str);
		int[] dp = new int[val.length+1];
		
		dp[0] = 1; dp[1] = val[0]==0?0:1;
		for(int i=2; i<=val.length; i++) {
			
			if(val[i-1]!=0) {
				dp[i] = dp[i]+dp[i-1];
			}
			if(val[i-2]!=0 && val[i-2]*10+val[i-1]<=26) {
				dp[i] =dp[i]+dp[i-2];
			}
			
		}
		return dp[val.length];
		
	}
	
	private int[] str2IntArr(String str) {
		
		int[] val = new int[str.length()];
		for(int i=0; i<val.length; i++) {
			val[i] = Integer.parseInt(str.substring(i, i+1));
		}
		return val;
		
	}
	
	public int getMost(int[][] value){
		
		if(value == null||value.length==0) {
			return -1;
		}
		int rows = value.length;
		int cols = value[0].length;
		int[][] dp = new int[rows][cols];
		for(int i=0; i<cols; i++) {
			dp[0][i] = value[0][i];
		}
		for(int i=0; i<rows; i++) {
			dp[i][0] = value[i][0];
		}
		for(int i=1; i<rows; i++) {
			
			for(int j=1; j<cols; j++) {
				if(dp[i-1][j]>=dp[i][j-1]) {
					dp[i][j] =dp[i-1][j]+value[i][j];
				}else {
					dp[i][j] =dp[i][j-1]+value[i][j];
				}
			}
			
		}
		return dp[rows-1][cols-1];
		
	}
	
	public int longestSubStringWithoutDuplication(String str) {
		
		if(str == null||str.length()==0) {
			return 0;
		}
		Vector<Character> temp = new Vector<Character>();
		int curMax = 0;
		for(int i=0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			if(temp.contains(ch)) {
				temp.clear();
			}
			temp.addElement(ch);
			if(temp.size()>curMax) {
				curMax = temp.size();
			}
			
		}
		return curMax;
		
	}
	
	public int getUglyNumber(int index) {
		
		if(index<=0) {
			return -1;
		}
		
		int[] dp = new int[index];
		dp[0] = 1;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		int i = 1;
		while(i<index) {
			
			int min = min(dp[index2]*2, dp[index3]*3, dp[index5]*5);
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
		return dp[index-1];
	}
	
    private int min(int v1,int v2,int v3){
        int m1 = v1 < v2 ? v1 : v2;
        return m1 < v3 ? m1 : v3;
    }
}
