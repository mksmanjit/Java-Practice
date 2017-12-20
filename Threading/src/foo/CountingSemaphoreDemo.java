package foo;

public class CountingSemaphoreDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountingSemaphore countingSemaphore = new CountingSemaphore();
		SenderRunnable senderRunnable = new SenderRunnable(countingSemaphore);
		ReceiverRunnable receiverRunnable = new ReceiverRunnable(countingSemaphore);
		Thread t1 = new Thread(senderRunnable);
		Thread t2 = new Thread(receiverRunnable);
		Thread t3 = new Thread(senderRunnable);
		Thread t4 = new Thread(receiverRunnable);
		Thread t5 = new Thread(senderRunnable);
		Thread t6 = new Thread(receiverRunnable);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		
	}

}


class SenderRunnable implements Runnable{
	CountingSemaphore countingSemaphore = null;
	public void run(){
		countingSemaphore.take();
	}
	public SenderRunnable(CountingSemaphore countingSemaphore) {
		// TODO Auto-generated constructor stub
		this.countingSemaphore = countingSemaphore;
	}
}

class ReceiverRunnable implements Runnable{
	CountingSemaphore countingSemaphore = null;
	public void run(){
		try {
			countingSemaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ReceiverRunnable(CountingSemaphore countingSemaphore) {
		// TODO Auto-generated constructor stub
		this.countingSemaphore = countingSemaphore;
	}
}

class CountingSemaphore {
	int signal = 0;

	public synchronized void take() {
		signal++;
		notify();
		System.out.println("Notified Signal>>"+signal);
	}

	public synchronized void release() throws InterruptedException {
		System.out.println("Wait Signal Before While>>"+signal);
		while (signal == 0) {
			wait();
		}
		signal--;
		System.out.println("Wait Signal>>"+signal);
	}
}