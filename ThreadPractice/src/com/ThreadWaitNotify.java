package com;

import java.util.ArrayList;
import java.util.List;

public class ThreadWaitNotify {

	public static void main(String args[]){
		MyRunnableWait myRunnable = new MyRunnableWait();
		MyThread myThread = new MyThread();
		myRunnable.setMyThread(myThread);
		Thread t1 = new Thread(myRunnable);
		Thread t2 = new Thread(myRunnable);
		t1.start();
		t2.start();
		
		MyRunnableNotify myRunnable1 = new MyRunnableNotify();
		myRunnable1.setMyThread(myThread);
		Thread t3 = new Thread(myRunnable1);
		t3.start();
		System.out.println("Main End");
	}
	
}
class MyRunnableWait implements Runnable{
	private MyThread myThread;
	public void run(){
		waitMethod();
	}
	
	public void waitMethod() {
		synchronized (myThread) {
			System.out.println("Wait Mehtod Start>>"+ Thread.currentThread().getName());
			while (myThread.getMyList().isEmpty()) {
				try {
					System.out.println("Wait>>" + myThread.getMyList().size() +">>"+Thread.currentThread().getName());
					myThread.wait();
					System.out.println("Awake>>"+ myThread.getMyList().size() +">>"+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(myThread.getMyList().size());
		}
	}

	public MyThread getMyThread() {
		return myThread;
	}

	public void setMyThread(MyThread myThread) {
		this.myThread = myThread;
	}
}

class MyThread {
	private List myList = new ArrayList();

	public List getMyList() {
		return myList;
	}

	public void setMyList(List myList) {
		this.myList = myList;
	}

}

class MyRunnableNotify implements Runnable {
	private MyThread myThread;

	public void run() {
		notifyThread();
	}

	public void notifyThread() {
		synchronized (myThread) {
			myThread.getMyList().add("manjit");
			System.out.println("Notify Start>>" + myThread.getMyList().size()+">>"+Thread.currentThread().getName());
			myThread.notifyAll();
			System.out.println("Notify End>>"+ myThread.getMyList().size()+">>"+Thread.currentThread().getName());
		}
	}

	public MyThread getMyThread() {
		return myThread;
	}

	public void setMyThread(MyThread myThread) {
		this.myThread = myThread;
	}
}
