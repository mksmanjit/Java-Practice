package collection;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exchanger e = new Exchanger();
		ExchangerRunnableDemo runn1 = new ExchangerRunnableDemo(e,"A");
		ExchangerRunnableDemo runn2 = new ExchangerRunnableDemo(e,"B");
		ExchangerRunnableDemo runn3 = new ExchangerRunnableDemo(e,"C");
		ExchangerRunnableDemo runn4 = new ExchangerRunnableDemo(e,"D");
		new Thread(runn1).start();
		new Thread(runn2).start();
		new Thread(runn3).start();
		new Thread(runn4).start();
	}

}

class ExchangerRunnableDemo implements Runnable{
	Exchanger e;
	Object x;
	ExchangerRunnableDemo(Exchanger e , Object x){
		this.e = e;
		this.x = x;
	}
	public void run(){
		Object previous = this.x;
		try {
			this.x = e.exchange(this.x);
			System.out.println(Thread.currentThread().getName()+" exchanged "+ previous + " for " + this.x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
