package foo;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLocalRunnable tlr = new ThreadLocalRunnable();
		Thread t = new Thread(tlr);
		Thread t2 = new Thread(tlr);
		t.setName("First");
		t.start();
		t2.setName("Second");
		t2.start();
	}

}

class ThreadLocalRunnable implements Runnable{
	/*ThreadLocal<Integer> th1 = new InheritableThreadLocal<Integer>(){
		protected Integer initialValue(){
			return 1;
		}
	};*/
	ThreadLocal<Integer> th1 = new ThreadLocal<Integer>(){
		protected Integer initialValue(){
			return 1;
		}
	};
	{
		th1.set(50);
		System.out.println("Init Block"+">>"+Thread.currentThread().getName());
	}
	//Integer th1 = new Integer(1);
	public void run(){
		if(Thread.currentThread().getName().equals("First")){
			th1.set(20);
			System.out.println(th1.get()+">>"+Thread.currentThread().getName());
			//th1 = 20;
			//System.out.println(th1);
		} else{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(th1.get()+">>"+Thread.currentThread().getName());
			th1.set(10);
			System.out.println(th1.get()+">>"+Thread.currentThread().getName());
			Runnable rC = new Runnable() {
				public void run() {
					Thread thd;
					thd = Thread.currentThread();
					String name = thd.getName();
					System.out.println(name + ">>" + th1.get());
				}
			};
			Thread t = new Thread(rC);
			t.start();
		}
	}
}
