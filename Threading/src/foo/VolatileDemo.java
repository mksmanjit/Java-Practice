package foo;

public class VolatileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VolatileReadWrite vol1 = new VolatileReadWrite();
		Thread t = new Thread(vol1);
		Thread t2 = new Thread(vol1);
		t.setName("First");
		t.start();
		t2.setName("Second");
		t2.start();
	}

}

class VolatileReadWrite implements Runnable{
	 int a =0;
	int b = 0;
	volatile boolean c= false;
	public void run(){
		if(Thread.currentThread().getName().equals("First")){
			writeValue();
		}else{
			readValue();
		}
	}
	void writeValue(){
		/*while(a<5){
		a = a+1;
		b = b+1;
		System.out.println("Write>>"+a+">>"+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}*/
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a = 20;
		b=10;
		c = true;
		
		System.out.println(c+">>"+Thread.currentThread().getName());
		
	}
	void readValue(){
		
		/*int local = a;
		System.out.println("Before Read Loop");
		while(a<5){
			//int d = a==10?1:0;
			if (a != local) {
				System.out.println("Read>>" + a + ">>"
						+ Thread.currentThread().getName());
				local = a;
			}
			
		}*/
		System.out.println("Read Started"+">>"+Thread.currentThread().getName());
		
		while(!c){
			/*try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			/**
			 * Synchronized block Start flushing the cache to main memory.
			 */
			/*synchronized (this) {
				System.out.println("SyncBlock");*/
			if(c){
			System.out.println(c+">>a="+a+">>b="+b+">>"+Thread.currentThread().getName());
			}
			///}
		}
	}
}
