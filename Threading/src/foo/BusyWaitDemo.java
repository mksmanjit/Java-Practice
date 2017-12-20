package foo;

public class BusyWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySignal m =new MySignal();
		BusyWaitRunnable busy = new BusyWaitRunnable(m);
		Thread t1 = new Thread(busy);
		t1.setName("Start");
		Thread t2 = new Thread(busy);
		t2.setName("Second");
		t1.start();
		t2.start();
	}

}

class BusyWaitRunnable implements Runnable{
	MySignal m = null;
	public void run(){
		if(Thread.currentThread().getName().equals("Start")){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.setSharedSignal(true);
		} else{
			/**
			 * This is Busy Waiting as Thread is continously busy in checking the status .
			 */
			while(!m.isSharedSignal()){
				System.out.println("Hello");
			}
		}
		
	}
	public BusyWaitRunnable(MySignal m){
		this.m = m;
	}
}

class MySignal{
	private boolean sharedSignal = false;

	public boolean isSharedSignal() {
		return sharedSignal;
	}

	public void setSharedSignal(boolean sharedSignal) {
		this.sharedSignal = sharedSignal;
	}
}
