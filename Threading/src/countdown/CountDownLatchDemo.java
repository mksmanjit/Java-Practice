package countdown;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch countDownLatch = new CountDownLatch(3);
		Waiter waiter = new Waiter(countDownLatch);
		Decrementer decrementer = new Decrementer(countDownLatch);
		Thread t1 = new Thread(waiter);
		Thread t2 = new Thread(decrementer);
		t1.start();
		t2.start();
		
	}

}

class Waiter implements Runnable{
	CountDownLatch countDownLatch = null;
	public void run(){
		try {
			System.out.println("Waiting in Process");
			countDownLatch.await();
			System.out.println("Waiting");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Waiter(CountDownLatch countDownLatch){
		this.countDownLatch = countDownLatch; 
	}
}

class Decrementer implements Runnable{
	CountDownLatch countDownLatch = null;
	public void run(){
		System.out.println("Count Down");
		countDownLatch.countDown();
		countDownLatch.countDown();
		countDownLatch.countDown();
	}
	Decrementer(CountDownLatch countDownLatch){
		this.countDownLatch = countDownLatch; 
	}
}
