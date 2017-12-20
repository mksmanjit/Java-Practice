package foo;

import foo.MyRunnable;

public class ThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable myThread = new MyRunnable();
		Thread t1 = new Thread(myThread);
		Thread t2 = new Thread(myThread);
		Thread t3 = new Thread(myThread);
		Thread t4 = new Thread(myThread);
		//MyThread mt1 = new MyThread();
		//mt1.start();
		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY);
		//Thread.yield();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
	}

}

class MyRunnable implements Runnable{
	int i =2;
	public /*synchronized*/ void run(){
		System.out.println("Runnable Class");
		Thread t = Thread.currentThread();
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		addI();
		System.out.println(Thread.currentThread().getName());
	}
	public synchronized void addI(){
		if(i > 0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i = i-1;
			System.out.println(i);
		}
	}
}

class MyThread extends Thread{
	public /*synchronized*/ void run(){
		System.out.println("Thread Class");
	}
}

