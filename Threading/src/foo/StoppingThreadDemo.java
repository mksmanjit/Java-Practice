package foo;

public class StoppingThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StopThreadRunnable stopThreadRunnable = new StopThreadRunnable();
		Thread t1 = new Thread(stopThreadRunnable);
		t1.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread Stopped");
		stopThreadRunnable.setStopped(true);
	}

}

class StopThreadRunnable implements Runnable{
	private LockObject lock = new LockObject();
	private boolean stopped = false;
	public void run(){
		synchronized (getLock()) {
			System.out.println(Thread.holdsLock(getLock()));
			System.out.println("new Thread Started");
			while(isStopped());
		}
		
	}
	public boolean isStopped() {
		return stopped;
	}
	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}
	public LockObject getLock() {
		return lock;
	}
	public void setLock(LockObject lock) {
		this.lock = lock;
	}
}

class LockObject{
	
}
