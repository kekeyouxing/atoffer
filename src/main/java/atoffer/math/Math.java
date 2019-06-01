package atoffer.math;

import java.util.ArrayList;

public class Math {


    /**
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer>>();
        int plow = 1,phigh = 2;
        while(phigh > plow){
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
            }else if(cur < sum){
                phigh++;
            }else{
                plow++;
            }
        }
        return result;
    }
    
	public int numberOfOne(int n) {
		int count = 0;
		while( n>0 ) {
			count++;
			n = (n-1)&n;
		}
		return count;
	}
	
    /**
     * <p>
     * There is a list of sorted integers from 1 to n. Starting from left to right, 
     * remove the first number and every other number afterward until you reach the end of the list.
     * Repeat the previous step again, but this time from right to left, 
     * remove the right most number and every other number from the remaining numbers.
     * We keep repeating the steps again, alternating left to right and right to left, 
     * until a single number remains.
     * Find the last number that remains starting with a list of length n.
     * <p>
     * Example:
     * <blockquote>
     * <pre>
     * Input:
     * n = 9,
     * 1 2 3 4 5 6 7 8 9
     * 2 4 6 8
     * 2 6
     * 6
     * Output:
     * 6
     * </pre>
     * </blockquote>
     * @param n
     * @return
     * @see <a href="https://leetcode.com/problems/elimination-game/">elimination-game</a>
     */
    public int lastRemaining(int n) {
    	return 0;
    }
    
    public int add(int num1, int num2) {
        int noCarryNum = num1 ^ num2;
        int carryNum = (num1 & num2) << 1;
        while (carryNum != 0) {
            num1 = noCarryNum;
            num2 = carryNum;
            noCarryNum = num1 ^ num2;
            carryNum = (num1 & num2) << 1;
        }
        return noCarryNum;
    }
}
