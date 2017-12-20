package foo;

import java.util.ArrayList;
import java.util.List;

public class FairnessLockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableFairLock runnableFairLock = new RunnableFairLock();
		Thread t1 = new Thread(runnableFairLock);
		Thread t2 = new Thread(runnableFairLock);
		Thread t3 = new Thread(runnableFairLock);
		/*Thread t4 = new Thread(runnableFairLock);
		Thread t5 = new Thread(runnableFairLock);
		Thread t6 = new Thread(runnableFairLock);*/
		
		t1.start();
		t2.start();
		t3.start();
		/*t4.start();
		t5.start();
		t6.start();*/
		
	}

}

class RunnableFairLock implements Runnable{
	FairLock lock = new FairLock();
	public void run(){
		try {
			doSynchronized();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void doSynchronized() throws InterruptedException{
		lock.lock();
		System.out.println("doSynchronized"+Thread.currentThread());
		Thread.sleep(2000);
		System.out.println("Synchronized Block Started"+Thread.currentThread());
		//Thread.sleep(2000);
		lock.unlock();
	}
}

class FairLock{
	private boolean isLocked = false;
	private Thread lockingThread = null;
	private List<QueueObject> waitingThreads = new ArrayList<QueueObject>();
	
	public void lock() throws InterruptedException{
		QueueObject queueObject  = new QueueObject(Thread.currentThread().toString());
		boolean isLockedForThisThread = true;
		System.out.println("Object is going to be Added for Thread"+Thread.currentThread());
		synchronized (this) {
			waitingThreads.add(queueObject);
			System.out.println("Object Added for Thread"+Thread.currentThread()+">>"+waitingThreads);
		}
		while(isLockedForThisThread){
			synchronized (this) {
				isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
				if(!isLockedForThisThread){
					System.out.println("Lock acquired for Thread"+">>"+Thread.currentThread()+">>"+Thread.currentThread());
					isLocked =true;
					waitingThreads.remove(queueObject);
					lockingThread = Thread.currentThread();
					System.out.println("Object returned for Thread"+">>"+Thread.currentThread()+">>"+Thread.currentThread());
					return;
				}
				
			}
			
			try{
				System.out.println("Wait for for Thread"+Thread.currentThread());
				queueObject.doWait();
			}catch(InterruptedException e){
				System.out.println("InInterruptedException>>"+Thread.currentThread());
				synchronized (this) {
					waitingThreads.remove(queueObject);
					System.out.println("InInterruptedException>>"+Thread.currentThread());
				}
				throw e;
			}
		}
	}
	
	public synchronized void unlock(){
		if(this.lockingThread != Thread.currentThread()){
			System.out.println("Calling thread has not locked this lock");
		}
		isLocked = false;
		lockingThread = null;
		if(waitingThreads.size() >0){
			System.out.println("Notify  for Thread"+">>"+Thread.currentThread()+">>"+waitingThreads.get(0)+">>"+waitingThreads);
			waitingThreads.get(0).doNotify();
		}
		
	}
}

class QueueObject{
	private boolean isNotified = false;
	private String name;
	public QueueObject(String name){
		this.name = name;
	}
	public synchronized void doWait() throws InterruptedException{
		while(!isNotified){
			this.wait();
		}
		this.isNotified = true;
	}
	
	public synchronized void doNotify(){
		this.isNotified = true;
		this.notify();
	}
	public boolean equals(Object o){
		return this == o;
	}
	public String toString(){
		return name;
	}
}
