package foo;

public class CustomLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableCustom runnableCustom = new RunnableCustom();
		Thread t1 = new Thread(runnableCustom);
		Thread t2 = new Thread(runnableCustom);
		Thread t3 = new Thread(runnableCustom);
		Thread t4 = new Thread(runnableCustom);
		Thread t5 = new Thread(runnableCustom);
		Thread t6 = new Thread(runnableCustom);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		

	}

}

class RunnableCustom implements Runnable{
	Synchronizer synchronizer = new Synchronizer();
	public void run(){
		try {
			synchronizer.doSynchronized();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Synchronizer{
	Lock lock = new Lock();
	int i = 0;
	public void doSynchronized() throws InterruptedException{
		this.lock.lock();
		i++;
		System.out.println("Synchronized Block Started"+Thread.currentThread()+">>"+i);
		Thread.sleep(2000);
		this.lock.unlock();
	}
	
}

class Lock{
	private boolean isLocked =false;
	private Thread lockingThread = null;
	
	public synchronized void lock() throws InterruptedException{
		while(isLocked){
			wait();
			System.out.println("Wait Thread>> "+Thread.currentThread());
		}
		isLocked = true;
		lockingThread = Thread.currentThread();
	}
	
	public synchronized void unlock(){
		if(lockingThread != Thread.currentThread()){
			System.out.println("Calling Thread has not locked this lock");
		}
		isLocked = false;
		lockingThread = null;
		notify();
				
	}
	
}
