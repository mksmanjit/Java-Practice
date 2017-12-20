package foo;

public class ReentrantLockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantLockRunnable reentlock = new ReentrantLockRunnable();
		Thread t1 = new Thread(reentlock);
		t1.start();
	}

}

class ReentrantLockRunnable implements Runnable{
	ReentrantLock lock = new ReentrantLock();
	public void run(){
		try {
			inner();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void outer() throws InterruptedException{
		lock.dounlock();
		System.out.println("Outer After Unlock");
		lock.dolock();
		System.out.println("Outer");
		lock.dounlock();
	}
	
	public void inner() throws InterruptedException{
		lock.dolock();
		System.out.println("Inner");
		outer();
	}
}
class ReentrantLock{
	boolean isLocked = false;
	Thread lockingThread = null;
	int lockingCount = 0;
	
	public synchronized void dolock() throws InterruptedException{
		Thread callingThread =  Thread.currentThread();
		while(isLocked && callingThread != lockingThread){
			wait();
		}
		isLocked = true;
		lockingThread = callingThread;
		lockingCount++;
	}
	
	public synchronized void dounlock(){
		lockingCount--;
		if(lockingCount == 0){
			isLocked = false;
			notify();
		}
	}
	
}
