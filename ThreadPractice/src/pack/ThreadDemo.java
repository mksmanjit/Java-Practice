package pack;

public class ThreadDemo {
	
	public static void main(String args[]){
		MyRunnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable);
		Thread t2 = new Thread(myRunnable);
		t1.start();
		t2.start();
		
	}

}

class MyRunnable implements Runnable{
	public void run(){
		System.out.println(">>"+Thread.currentThread().getName());
		display();
		Thread t = Thread.currentThread();
		if (true) {
			return;
		}
		displayNew();
	}
	public synchronized void display(){
		System.out.println("Display>>"+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Display End>>"+Thread.currentThread().getName());
	}
	
	public synchronized void displayNew(){
		System.out.println("DisplayNew>>"+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DisplayNew End>>"+Thread.currentThread().getName());
	}
}
