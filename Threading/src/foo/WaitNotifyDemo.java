package foo;

public class WaitNotifyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaitNotifyRunnable waitNotifyRunn = new WaitNotifyRunnable();
		Thread t1 = new Thread(waitNotifyRunn);
		Thread t2 = new Thread(waitNotifyRunn);
		t1.setName("First");
		t1.start();
		t2.setName("Second");
		t2.start();
	}

}

class WaitNotifyRunnable implements Runnable{
	MonitorObjectLock monitorObjectLock = new MonitorObjectLock();
	boolean wasSignalled = false;
	public void run(){
		if(Thread.currentThread().getName().equals("First")){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doWait();
		}else{
			doNotify();
		}
	}
	
	public void doWait(){
		synchronized(monitorObjectLock){
			System.out.println("Thread Inside Wait Method");
			/**
			 * This is Called Spin Lock.
			 */
		while(!wasSignalled){
			try {
				System.out.println("Thread in going to be in Waiting State");
				monitorObjectLock.wait();
				System.out.println("Thread in Waiting State");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		wasSignalled = false;
		}
	}

	public void doNotify() {
		synchronized (monitorObjectLock) {
			System.out.println("Thread Inside Notify Method");
			monitorObjectLock.notify();
			wasSignalled = true;
		}
	}
}

class MonitorObjectLock{
	
}
