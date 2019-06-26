package atoffer.thread;

import java.util.ArrayList;
import java.util.List;

public class Bootstrap {
	
	public static void main(String[] args) {
		List<Integer> taskQueue = new ArrayList<Integer>();
		Producer producer = new Producer(taskQueue, 5);
		Consumer consumer = new Consumer(taskQueue);
		Thread threadProducer = new Thread(producer, "Producer Thread");
		Thread threadConsumer = new Thread(consumer, "Consumer Thread");
		threadProducer.start();
		threadConsumer.start();

	}
	
}
