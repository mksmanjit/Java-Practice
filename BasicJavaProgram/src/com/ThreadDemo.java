package com;

import java.io.Serializable;

public class ThreadDemo {

	public static void main(String[] args) {
		ThreadRunnable t = new ThreadRunnable();
		//Thread t1 = new Thread(t);
		t.start();

	}

}

class ThreadRunnable extends Thread {
	public void run(){
		System.out.println("Run"+Thread.currentThread().getName());
	}
	public void start(){
		super.start();
		System.out.println("Start>>"+Thread.currentThread().getName());
	}
	
	
}
