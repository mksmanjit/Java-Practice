package foo;

public class DeadLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeadLockRunnable d = new DeadLockRunnable();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.setName("First");
		t1.start();
		t2.start();
	}

}
class DeadLockRunnable implements Runnable{
	A a = new A();
	B b = new B();
	public void run(){
		if(Thread.currentThread().getName().equals("First")){
			display1();
		} else{
			display2();
		}
	}
	
	void display1(){
		synchronized(a){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (b) {
				System.out.println("Inside display1");
			}
		}
	}
	void display2(){
		synchronized(b){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (a) {
				System.out.println("Inside display2");
			}
		}
	}
	
	
}

class A{
	
}
class B{
	
}
