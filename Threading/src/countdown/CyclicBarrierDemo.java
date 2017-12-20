package countdown;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable barrier1Action = new Runnable(){
			public void run(){
				System.out.println("BarrierAction 1 executed ");
			}
		};
		Runnable barrier2Action = new Runnable(){
			public void run(){
				System.out.println("BarrierAction 2 executed ");
			}
		};
		
		CyclicBarrier barrier1 = new CyclicBarrier(2,barrier1Action);
		CyclicBarrier barrier2 = new CyclicBarrier(2,barrier2Action);
		
		CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);
		CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2);
		
		new Thread(barrierRunnable1).start();
		new Thread(barrierRunnable2).start();
		
	}

}

class CyclicBarrierRunnable implements Runnable{
	CyclicBarrier cyclicBarrier1 = null;
	CyclicBarrier cyclicBarrier2 = null;
	public void run(){
		try {
			cyclicBarrier1.await();
			cyclicBarrier2.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	CyclicBarrierRunnable(CyclicBarrier cyclicBarrier1, CyclicBarrier cyclicBarrier2){
		this.cyclicBarrier1 = cyclicBarrier1;
		this.cyclicBarrier2 = cyclicBarrier2;
	}
}
