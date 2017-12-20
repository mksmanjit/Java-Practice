package foo;

public class BinarySemaphoreDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySemaphore binarySemaphore = new BinarySemaphore(1);
		BinarySemaphoreRunnable  binarySemaphoreRunnable =  new BinarySemaphoreRunnable(binarySemaphore);
		Thread t1 = new Thread(binarySemaphoreRunnable);
		t1.start();
		
	}

}

class BinarySemaphoreRunnable implements Runnable{
	BinarySemaphore binarySemaphore = null;
	public void run(){
		try {
			binarySemaphore.take();
			System.out.println("Inside Lock");
			binarySemaphore.release();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public BinarySemaphoreRunnable(BinarySemaphore binarySemaphore){
		this.binarySemaphore = binarySemaphore;
	}
}

class BinarySemaphore{
	private int signal = 0;
	private int bound = 0;
	
	public BinarySemaphore(int bound){
		this.bound = bound;
	}
	public synchronized void take() throws InterruptedException{
		while(bound == signal){
			wait();
		}
		signal++;
		notify();
	}
	public synchronized void release() throws InterruptedException{
		while(signal == 0){
			wait();
		}
		signal--;
		notify();
	}
}
