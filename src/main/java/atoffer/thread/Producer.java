package atoffer.thread;

import java.util.List;

public class Producer implements Runnable{
	
	private List<Integer> taskQueue;
	private int maxSize;
	
	public Producer(List<Integer> taskQueue, int maxSize) {
		
		this.taskQueue = taskQueue;
		this.maxSize = maxSize;
		
	}
	
	public void run() {
		int count = 0;
		while(true) {
			
			try {
				produce(count++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	private void produce(int i) throws InterruptedException {
		
		synchronized (taskQueue) {
			
			if(taskQueue.size() == maxSize) {
				System.out.println("taskQueue is full, please waiting...");
				taskQueue.wait();
			}
			Thread.sleep(500);
			taskQueue.add(i);
			System.out.println("taskQueue is producing... "+i);
			taskQueue.notifyAll();
		}
		
	}
	
	
	



}
