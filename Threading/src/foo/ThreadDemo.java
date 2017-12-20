package foo;

public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableDemo  runnableDemo = new RunnableDemo();
		Thread t1 = new Thread(runnableDemo);
		Thread t2 = new Thread(runnableDemo);
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("inside main");

	}

}

class RunnableDemo implements Runnable{
	ThreadLocal local = new ThreadLocal();
	//String local = new String();
	public void run(){
		local.set(Math.random()+""+Thread.currentThread());
		//local += "manjit"+Thread.currentThread()+Math.random();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(local.get());
	}
	
}
