package com;

public class ThreadDemo extends Thread {
	public ThreadDemo(){
		start();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new ThreadDemo().getDisplay();
	}
	
	public void getDisplay() throws InterruptedException{
		join();
		System.out.println("Hello");
		Integer a = 127;
		Integer b = 127;
		System.out.println(a==b);
		a=128;
		b=128;
		System.out.println(a==b);
	}
	public void run(){
		System.out.println("Inside Run");
	}

}
