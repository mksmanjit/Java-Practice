package foo;

public class WaitNotifyAllDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaitNotifyAllRunnable waitNotifyAllRunnable = new WaitNotifyAllRunnable();
		Thread t1 = new Thread(waitNotifyAllRunnable);
		t1.setName("First");
		Thread t2 = new Thread(waitNotifyAllRunnable);
		Thread t3 = new Thread(waitNotifyAllRunnable);
		Thread t4 = new Thread(waitNotifyAllRunnable);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*t2.stop();
		t3.stop();
		t4.stop();*/
		
		
		/*System.out.println("All Thread Started");
		t2.interrupt();
		System.out.println("First Thread interupteed");
		t3.interrupt();
		t4.interrupt();*/
		
		
		
	}

}

class WaitNotifyAllRunnable implements Runnable{
	boolean isNotify = false;
	public void run(){
		if(Thread.currentThread().getName().equals("First")){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doNotifyAll();
		} else{
			doWait();
		}
	}
	
	public synchronized void doNotifyAll(){
		notifyAll();
		isNotify = true;
		//Thread.currentThread().interrupt();
	}
	
	public synchronized void doWait() {
		try {
			System.out.println("Thread is going in Wait State>>"
					+ Thread.currentThread().getName());
			while (!isNotify) {
				wait();
			}
			isNotify = false;
			System.out.println("Thread is out of Wait State>>"
					+ Thread.currentThread().getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Thread Interuptted>>"
					+ Thread.currentThread().getName());
			// e.printStackTrace();
		}
	}
	
	
}
