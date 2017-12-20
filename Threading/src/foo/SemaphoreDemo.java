package foo;

public class SemaphoreDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore semaphore = new Semaphore();
		Consumer consumer = new Consumer(semaphore);
		Producer producer = new Producer(semaphore);
		Thread t1 = new Thread(consumer);
		Thread t2 = new Thread(producer);
		t1.start();
		t2.start();
	}

}

class Consumer implements Runnable{
	Semaphore semaphore = null;
	public void run(){
		try {
			semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Consumer(Semaphore semaphore) {
		this.semaphore = semaphore;
		// TODO Auto-generated constructor stub
	}
}

class Producer implements Runnable{
	Semaphore semaphore = null;
	public void run(){
			semaphore.take();
	}
	
	public Producer(Semaphore semaphore) {
		this.semaphore = semaphore;
		// TODO Auto-generated constructor stub
	}
}

class Semaphore{
	private boolean signal = false;
	
	public synchronized void take(){
		signal = true;
		notify();
		System.out.println("After notify");
	}
	
	public synchronized void release() throws InterruptedException{
		System.out.println("Inside Release");
		while(!signal){
			wait();
		}
		System.out.println("Inside Release After while");
		signal = false;
	}
}
