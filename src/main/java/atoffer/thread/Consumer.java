package atoffer.thread;

import java.util.List;

public class Consumer implements Runnable {
	private List<Integer> taskQueue;
	
	public Consumer(List<Integer> taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	public void run() {
		
		while(true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void consume() throws InterruptedException {
		synchronized (taskQueue) {
			if(taskQueue.isEmpty()) {
				System.out.println("taskQueue is empty, please waiting... ");
				taskQueue.wait();
			}
			Thread.sleep(500);
			int i = taskQueue.remove(0);
			System.out.println("taskQueue is consuming... "+i);
			taskQueue.notifyAll();
		}

		
	}

}
