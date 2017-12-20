package foo;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadWriteLockRunnable readWriteLockRunnable = new ReadWriteLockRunnable();
		Thread t1 = new Thread(readWriteLockRunnable);
		Thread t2 = new Thread(readWriteLockRunnable);
		Thread t3 = new Thread(readWriteLockRunnable);
		t1.setName("Writer");
		t2.setName("Reader");
		t3.setName("Reader");
		t1.start();
		t2.start();
		t3.start();
	}

}

class ReadWriteLockRunnable implements Runnable {
	ReadWriteLock readWriteLock = new ReadWriteLock();

	public void run() {
		if (Thread.currentThread().getName().equals("Reader")) {
			try {
				readWriteLock.readlock();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Inside Read Lock");
			readWriteLock.readunlock();
		} else {
			try {
				
				readWriteLock.writelock();
				System.out.println("Inside Writer Lock");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Inside Writer Lock");
			
			readWriteLock.writeunlock();
		}
	}
}

class ReadWriteLock{
	int writerRequests = 0;
	int writers = 0;
	int writersCount = 0;
	Thread writerLock = null;
	Map<Thread,Integer> readingThread = new HashMap<Thread,Integer>();
	public synchronized void readlock() throws InterruptedException{
		Thread currentThread = Thread.currentThread();
		if(!canGrantReadAccess(currentThread)){
			wait();
		}
		readingThread.put(currentThread,getReadAccessCount(currentThread) + 1);
		
	}
	
	public synchronized void writelock() throws InterruptedException{
		Thread currentThread = Thread.currentThread();
		writerRequests++;
		if(canGrantWriteAcess(currentThread)){
			wait();
		}
		writerLock = currentThread;
		writers++;
		writerRequests--;
	}

	public synchronized void readunlock() {
		Thread currentThread = Thread.currentThread();
			int readCount = getReadAccessCount(currentThread);
			if(readCount == 1){
					readingThread.remove(currentThread);
				} else{
					readingThread.put(currentThread, --readCount);
				}
					
			notifyAll();
			
	}

	public synchronized void writeunlock() {
		--writers;
		if(writers == 0){
			writerLock = null;
		}
		notifyAll();
	}
	
	private boolean canGrantWriteAcess(Thread callThread) {
		if (!readingThread.isEmpty()) {
			return false;
		}
		if (writerLock != callThread)
			return false;
		return true;
	}
	private boolean canGrantReadAccess(Thread callingThread) {
		if (writers > 0)
			return false;
		if (isReader(callingThread))
			return true;
		if (writerRequests > 0)
			return false;
		return true;
	}
	
	private int getReadAccessCount(Thread callingThread){
		Integer accessCount = readingThread.get(callingThread);
		if(accessCount == null) return 0; 
		return accessCount;
	}
	private boolean isReader(Thread callThread){
		return readingThread.get(callThread) != null? true:false;
	}
}
