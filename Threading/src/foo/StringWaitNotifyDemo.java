package foo;

public class StringWaitNotifyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWaitNotifyFirst myWaitNotifyFirst = new MyWaitNotifyFirst();
		MyWaitNotifySecond myWaitNotifySecond = new MyWaitNotifySecond();
		Thread t1 = new Thread(myWaitNotifyFirst);
		Thread t2 = new Thread(myWaitNotifySecond);
		t1.start();
		t2.start();
	}

}

class MyWaitNotifyFirst implements Runnable{
	String s="Manjit";
	public void run(){
		synchronized (s) {
			try {
				System.out.println("First Object>>"+Thread.currentThread().getName());
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
class MyWaitNotifySecond implements Runnable{
	String s="Manjit";
	public void run(){
		synchronized (s) {
			System.out.println("Second Object>>"+Thread.currentThread().getName());
				notify();
		}
	}
}
