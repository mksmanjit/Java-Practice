package countdown;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemoNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
		WaiterBarrier waiter = new WaiterBarrier(cyclicBarrier);
		DecrementerBarrier decrementer = new DecrementerBarrier(cyclicBarrier);
		Thread t1 = new Thread(waiter);
		Thread t2 = new Thread(decrementer);
		t1.start();
		t2.start();
		
	}

}

class WaiterBarrier implements Runnable{
	CyclicBarrier cyclicBarrier = null;
	public void run(){
		
			System.out.println("Waiting in Process");
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Waiting");
		
	}
	
	WaiterBarrier(CyclicBarrier cyclicBarrier){
		this.cyclicBarrier = cyclicBarrier; 
	}
}

class DecrementerBarrier implements Runnable{
	CyclicBarrier cyclicBarrier = null;
	public void run(){
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count Down");
	
	}
	DecrementerBarrier(CyclicBarrier cyclicBarrier){
		this.cyclicBarrier = cyclicBarrier; 
	}
}
