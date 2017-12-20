package foo;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue blockingQueue = new BlockingQueue(10);
		BlockingQueueRunnable queue = new BlockingQueueRunnable(blockingQueue);
		Thread t1 = new Thread(queue);
		Thread t2 = new Thread(queue);
		t1.setName("First");
		t2.setName("Second");
		t1.start();
		t2.start();
		
	}

}

class BlockingQueueRunnable implements Runnable{
	BlockingQueue queue = null;
	BlockingQueueRunnable(BlockingQueue queue){
		this.queue = queue;
	}
	public void run(){
		if(Thread.currentThread().getName().equals("First")){
			try {
				Thread.sleep(2000);
				queue.enqueue(1);
				queue.enqueue(2);
				
				queue.enqueue(3);
				queue.enqueue(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else{
			try {
				Thread.sleep(1000);
				System.out.println(queue.dequeue());
				System.out.println(queue.dequeue());
				System.out.println(queue.dequeue());
				System.out.println(queue.dequeue());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class BlockingQueue{
	
	private List queue = new LinkedList();
	private int limit;
	
	public BlockingQueue(int limit) {
		// TODO Auto-generated constructor stub
		this.limit = limit;
	}
	public synchronized void enqueue(Object item) throws InterruptedException{
		while(queue.size() == limit){
			wait();
		}
		if(queue.size() == 0){
			notifyAll();
		}
		queue.add(item);
	}
	
	public synchronized Object dequeue() throws InterruptedException{
		while(queue.size() == 0){
			wait();
		}
		if(queue.size() == limit){
			notifyAll();
		}
		return queue.remove(0);
		
	}
}
