package atoffer.bit;

/**
 * @author Ke
 *输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOfOne {

	public int numberOfOne(int n) {
		int count = 0;
		while( n>0 ) {
			count++;
			n = (n-1)&n;
		}
		return count;
	}
	
}
