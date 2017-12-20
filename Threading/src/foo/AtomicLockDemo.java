package foo;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicLockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicLockRunnable atomicLockRunnable = new AtomicLockRunnable();
		Thread t1 = new Thread(atomicLockRunnable);
		Thread t2 = new Thread(atomicLockRunnable);
		Thread t3 = new Thread(atomicLockRunnable);
		t1.start();
		t2.start();
		t3.start();
		
	}

}

class AtomicLockRunnable implements Runnable{
	AtomicLock atomicLock = new AtomicLock();
	public void run(){
		while(!atomicLock.lock());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inside Clock");
		while(!atomicLock.unlock());
	}
}

class AtomicLock{
	private AtomicBoolean lock = new AtomicBoolean(false);
	public boolean lock(){
		return lock.compareAndSet(false, true);
	}
	
	public boolean unlock(){
		return lock.compareAndSet(true, false);
	}
	
}
