package foo;

public class SpringDemo {
	Integer int1 = new Integer(1);
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*SpringDemo sp = new SpringDemo();
		synchronized(sp.int1){
		System.out.println(Thread.holdsLock(sp.int1));
		}
		String s="Sanju";
		display(s);
		System.out.println(s);*/
		ThreadDemo t1 = new ThreadDemo();
		t1.start();
		Thread.sleep(10000);
		t1.stopThread();
		System.out.println(t1.isAlive());
	}
	public static void display(String s){
		s = "Manjit";
		
	}

}

class ThreadDemo extends Thread{
	private volatile Thread stopIndicator;
	public void run(){
		while(Thread.currentThread() == stopIndicator){
		System.out.println("Demon");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public void start(){
		System.out.println("Started");
		stopIndicator = new Thread(this);
		stopIndicator.start();
	}
	public void stopThread(){
		System.out.println("Thread Stopped");
		stopIndicator = null;
	}
	ThreadDemo(){
		//setDaemon(true);
	}
}
