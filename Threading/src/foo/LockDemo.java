package foo;

public class LockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LockObjectDemoRunnable lo = new LockObjectDemoRunnable();
		Thread t1 = new Thread(lo);
		t1.setName("First");
		Thread t2 = new Thread(lo);
		t2.setName("Second");
		Thread t3 = new Thread(lo);
		t3.setName("Third");
		Thread t4 = new Thread(lo);
		t4.setName("Fourth");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

class LockObjectDemoRunnable implements Runnable{
	LockObjectDemo lock = new LockObjectDemo();
	LockObjectDemo lock1 = new LockObjectDemo();
	public void run(){
		if (Thread.currentThread().getName().equals("First")
				|| Thread.currentThread().getName().equals("Second")) {
			if (Thread.currentThread().getName().equals("First")) {
				System.out.println("Lock Going Started>>"+Thread.currentThread().getName());
				lock.doLock();
				System.out.println("Lock Going End>>"+Thread.currentThread().getName());
			} else {
				 System.out.println("Lock Going Started>>"+Thread.currentThread().getName());
				lock1.doLock();
				System.out.println("Lock Going End>>"+Thread.currentThread().getName());
			}
		} else {
			if (Thread.currentThread().getName().equals("Third")) {
				System.out.println("Lock Going Notify>>"+Thread.currentThread().getName());
				lock.doNotify();
				System.out.println("Lock Notify End>>"+Thread.currentThread().getName());
			} else {
				 System.out.println("Lock Going Notify>>"+Thread.currentThread().getName());
				lock1.doNotify();
				System.out.println("Lock Notify End>>"+Thread.currentThread().getName());
			}
		}
		
	}
}

class LockObjectDemo{
	private boolean isLocked = false;
	public synchronized void doLock(){
		if (!isLocked) {
			System.out.println(Thread.currentThread().getName()+">>Inside Lock");
			try {
				isLocked = true;
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void doNotify(){
		if (isLocked) {
			System.out.println(Thread.currentThread().getName()+">>Inside Notify");
			notify();
			isLocked = false;
		}
	}
}
