package foo;

public class StaticSynchronzedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticSynchDemo s  = new StaticSynchDemo();
		Thread t = new Thread(s);
		Thread t2 = new Thread(s);
		t.start();
		t2.start();
	}

	
}

class StaticSynchDemo implements Runnable{
	public static synchronized void display() throws InterruptedException{
		System.out.println("Display Static"+">>"+Thread.currentThread().getName());
		Thread.sleep(2000);
	}
	public synchronized void display1(){
		System.out.println("Instance Display1"+">>"+Thread.currentThread().getName());
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			display();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		display1();
	}
}