package foo;

public class BoundedSemaphoreDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoundedSemaphore boundedSemaphore = new BoundedSemaphore(3);
		SenderBoundedRunnable senderBoundedRunnable = new SenderBoundedRunnable(boundedSemaphore);
		ReceiverBoundedRunnable receiverBoundedRunnable = new ReceiverBoundedRunnable(boundedSemaphore);
		Thread t1 = new Thread(senderBoundedRunnable);
		Thread t2 = new Thread(senderBoundedRunnable);
		Thread t3 = new Thread(senderBoundedRunnable);
		Thread t4 = new Thread(senderBoundedRunnable);
		Thread t5 = new Thread(senderBoundedRunnable);
		Thread t6 = new Thread(receiverBoundedRunnable);
		Thread t7 = new Thread(receiverBoundedRunnable);
		Thread t8 = new Thread(receiverBoundedRunnable);
		Thread t9 = new Thread(receiverBoundedRunnable);
		Thread t10 = new Thread(receiverBoundedRunnable);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		
		
	}

}
class SenderBoundedRunnable implements Runnable{
	BoundedSemaphore boundedSemaphore = null;
	public void run(){
		try {
			boundedSemaphore.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SenderBoundedRunnable(BoundedSemaphore boundedSemaphore) {
		// TODO Auto-generated constructor stub
		this.boundedSemaphore = boundedSemaphore;
	}
}
class ReceiverBoundedRunnable implements Runnable{
	BoundedSemaphore boundedSemaphore = null;
	public void run(){
		try {
			boundedSemaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ReceiverBoundedRunnable(BoundedSemaphore boundedSemaphore) {
		// TODO Auto-generated constructor stub
		this.boundedSemaphore = boundedSemaphore;
	}
}

class BoundedSemaphore{
	int bound = 0;
	int  signal = 0;
	
	public BoundedSemaphore(int bound) {
		// TODO Auto-generated constructor stub
		this.bound = bound;
	}
	
	public synchronized void take() throws InterruptedException{
		while(signal == bound){
			System.out.println("Signal is full>>"+signal);
			wait();
			
		}
		signal++;
		notify();
		System.out.println("Signal in Notify>>"+signal);
		
	}
	
	public synchronized void release() throws InterruptedException{
		while(signal == 0){
			System.out.println("Signal is Empty");
			wait();
		}
		signal--;
		notify();
		System.out.println("Signal is wait>>"+signal);
	}
	
}
