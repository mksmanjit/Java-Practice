package foo;

import java.util.ArrayList;
import java.util.List;

public class FairLockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FairLockNew fair = new FairLockNew();
		FairLockNewRunnable flnr = new FairLockNewRunnable();
		flnr.setFairLockNew(fair);
		Thread t1 = new Thread(flnr);
		Thread t2 = new Thread(flnr);
		Thread t3 = new Thread(flnr);
		Thread t4 = new Thread(flnr);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}

class FairLockNewRunnable implements Runnable{
	private FairLockNew fairLockNew = null;
	public void run(){
		fairLockNew.lock();
		System.out.println(Thread.currentThread());
		System.out.println(Thread.currentThread());
		System.out.println(Thread.currentThread());
		System.out.println(Thread.currentThread());
		fairLockNew.unlock();
		
	}
	public FairLockNew getFairLockNew() {
		return fairLockNew;
	}
	public void setFairLockNew(FairLockNew fairLockNew) {
		this.fairLockNew = fairLockNew;
	}
}
class FairLockNew{
	private boolean isLocked=false;
	private Thread lockingThread = null;
	private List<QueueObjectNew> waitingThreads  = new ArrayList<QueueObjectNew>();
	public void lock(){
		QueueObjectNew queueObj = new QueueObjectNew();
		boolean isLockedForThisThread = true;
		synchronized (this) {
			waitingThreads.add(queueObj);
		}
		while (isLockedForThisThread) {
			synchronized (this) {
				isLockedForThisThread = isLocked
						|| waitingThreads.get(0) != queueObj;
				if (!isLockedForThisThread) {
					isLocked = true;
					lockingThread = Thread.currentThread();
					waitingThreads.remove(queueObj);
					return;
				}
			}
			try {
				queueObj.doWait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				waitingThreads.remove(queueObj);
				e.printStackTrace();
			}
		}
		
		
		
	}
	public void unlock(){
		if(lockingThread != Thread.currentThread()){
			throw new IllegalMonitorStateException("Calling thread has not locked this lock");
		}
		isLocked = false;
		QueueObjectNew queueObj = null;
		if(waitingThreads.size() > 0){
		queueObj = waitingThreads.get(0);
		queueObj.donotify();
		}
		
	}
}

class QueueObjectNew{
	private boolean isNotified = false;
	public synchronized void doWait() throws InterruptedException{
		while(!isNotified){
				wait();
		}
		isNotified = false;
	}
	
	public synchronized void donotify(){
		notify();
		isNotified = true;
	}
	
}