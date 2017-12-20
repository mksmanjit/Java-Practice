package foo;

public class LockInsteadOfSynch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LockSynchRunnable lockSynchRunnable = new LockSynchRunnable();
		
		Thread t1 = new Thread(lockSynchRunnable);
		//Thread t2 = new Thread(lockSynchRunnable);
		//Thread t3 = new Thread(lockSynchRunnable);
		t1.start();
		//t2.start();
		//t3.start();
		
	}

}

class LockSynchRunnable implements Runnable{
	LockSync lockSync = new LockSync();
	LockSync lockSync1 = new LockSync();
	public void run(){
		System.out.println(Thread.currentThread());
		try {
			lockSync.lock();
			System.out.println("Inside Sync 1"+Thread.currentThread());
			lockSync1.lock();
			System.out.println("Inside Sync 2"+Thread.currentThread());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lockSync.unlock();
		System.out.println(">>Unlock 1"+Thread.currentThread());
		lockSync1.unlock();
		System.out.println(">>Unlock 2"+Thread.currentThread());
	}
}
class LockSync{
	private boolean isLocked = false;
	private Thread lockingThread = null;
	
	public synchronized void lock() throws InterruptedException{
		while(isLocked){
			wait();
		}
		isLocked = true;
		lockingThread = Thread.currentThread();
	}
	
	public synchronized void unlock(){
		if(lockingThread != Thread.currentThread()){
			throw new IllegalMonitorStateException("Calling thread has not locked this lock");
		}
		isLocked = false;
		lockingThread = null;
		notify();
	}
	
}
