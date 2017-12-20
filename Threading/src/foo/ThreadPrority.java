package foo;

public class ThreadPrority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPriorityRunnable t = new ThreadPriorityRunnable();
		Thread t1 = new Thread(t);
		t1.setName("First");
		t1.setPriority(10);
		Thread t2 = new Thread(t);
		t2.setName("Second");
		t2.setPriority(9);
		Thread t3 = new Thread(t);
		t3.setName("Third");
		t3.setPriority(8);
		Thread t4 = new Thread(t);
		t4.setName("Fourth");
		t4.setPriority(7);
		Thread t5 = new Thread(t);
		t5.setName("Fifth");
		t5.setPriority(6);
		Thread t6 = new Thread(t);
		t6.setName("Main Thread");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
	}

}

class ThreadPriorityRunnable implements Runnable{
	public void run(){
		if(Thread.currentThread().getName().equalsIgnoreCase("Main Thread")){
			doNotify();
		} else{
			doWait();
		}
	}
	synchronized  void doWait(){
		try {
			System.out.println(Thread.currentThread().getName()+">> is going in Wait State");
			wait();
			System.out.println(Thread.currentThread().getName()+">> is out of Wait State");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	synchronized  void doNotify(){
		System.out.println(Thread.currentThread().getName()+">> is notify");
		notifyAll();
	}
}
