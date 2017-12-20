package foo;

public class ThreadSignaling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadRunnable threadRunnable = new ThreadRunnable();
		Thread t1 = new Thread(threadRunnable);
		Thread t2 = new Thread(threadRunnable);
		t1.start();
		t2.start();
	}

}

class ThreadRunnable implements Runnable{
	MyWaitNotify myWaitNotify = new MyWaitNotify();
	boolean flag = true;
	public void run(){
		callWaitOrNotify();
	}
	public void callWaitOrNotify(){
		if(flag){
			flag = false;
		myWaitNotify.dowait();
		flag = false;
		} else {
		myWaitNotify.doNotify();
		}
	}
}
class MyWaitNotify {
	MonitorObject monitorObject = new MonitorObject();
	boolean wasSignalled = false;
	public void dowait(){
		/**
		 * Wait release lock on which wait is called,So this Object lock is still there.
		 */
		synchronized (this) {
		synchronized (monitorObject) {
			System.out.println("DoWait Synchronized Block Start");
			String s = "Manjit Kumar";
			while(!wasSignalled){
				System.out.println("While loop Start");
				s+="Saini";
				try {
					monitorObject.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("While loop End"+s);
			}
			wasSignalled = false;
			System.out.println("DoWait Synchronized Block End");
		}
		}
		
	}
	public void doNotify(){
		synchronized (this) {
		synchronized (monitorObject) {
			System.out.println("DoNofiy Synchronized Block Start");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wasSignalled = true;
			monitorObject.notify();
			
		}
		}
	}
	
}

class MonitorObject{
	
}