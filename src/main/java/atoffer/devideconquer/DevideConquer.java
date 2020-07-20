package atoffer.devideconquer;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ke
 *分治算法
 */
public class DevideConquer {

	private int inversePairsCount = 0;
	
	public int inversePairs(int[] nums) {
		if(nums == null) {
			throw new NullPointerException("inversePairs's numbers is null");
		}
		int[] temp = new int[nums.length]; 
		inversePairsCore(nums, temp, 0, nums.length-1);
		return inversePairsCount;
	}

	private void inversePairsCore(int[] nums, int[] temp, int start, int end) {
		
		if(start<end) {
			
			int middle = (start+end)/2;
			inversePairsCore(nums, temp, start, middle);
			inversePairsCore(nums, temp, middle+1, end);
			inverseCount(nums, temp, start, end, middle);
		}
	}

	private void inverseCount(int[] nums, int[] temp, int start, int end, int middle) {
		
		int i = start;
		int j = middle+1;
		int k = 0;
		while(i<=middle && j<=end) {
			
			if(nums[i] <= nums[j]) {
				temp[k++] = nums[i++];
			}else {
				temp[k++] = nums[j++];
				inversePairsCount += middle-start+1;
			}
			
		}
		
		while(i<=middle) {
			temp[k++] = nums[i++];
		}
		while(j<=end) {
			temp[k++] = nums[j++];
		}
		System.arraycopy(temp, 0, nums, start, k);
		
	}
	//1 2 3 4 5 6 7
	//9 8 7 6 5 4 3 2 1
	//9 8 7 6 5 4 3

	//7 3 5 9 8 7 9 3 3 7 8 3 4 2 4 9 3
	//1 3 6 1 6 8 9 1 3
	//9 6 6 3 1 9 3 6 6 9 1 6 1 3 1 3 6
	//第i个整数表示将数字i替换为数字a_i。
	//73598793378342493
	//1 3 6 1 6 8 9 1 3

	//-12
	//2 3 7 6 5 4 3 2 1
	//2 3

//	6
//0,30
//0,50
//10,20
//15,30
//20,50
//20,65
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile boolean flag = false;
	public static void main(String[] args) throws InterruptedException {
	    Thread thread1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (flag){
                        condition.await();
                    }
                    System.out.println("A");
                    flag = true;
                    condition.signal();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (!flag){
                        condition.await();
                    }
                    System.out.println("B");
                    flag = false;
                    condition.signal();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        thread1.start();
        thread2.start();
	}
}
