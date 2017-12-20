package foo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CyclicBarrierDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		RunnableBarrierLastDemo runnableBarrierLastDemo = new RunnableBarrierLastDemo();
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3,runnableBarrierLastDemo);
		RunnableBarrierDemo runnableBarrierDemo = new RunnableBarrierDemo(cyclicBarrier);
		new Thread(runnableBarrierDemo).start();
		new Thread(runnableBarrierDemo).start();
		new Thread(runnableBarrierDemo).start();
		
		CallableBarrierDemo callableBarrierDemo = new CallableBarrierDemo();
		ExecutorService executorService1 = Executors.newFixedThreadPool(3);
		Future futureObj = executorService1.submit(callableBarrierDemo);
		Future futureObj1 = executorService1.submit(callableBarrierDemo);
		Future futureObj2 = executorService1.submit(callableBarrierDemo);
		Future futureObj3 = executorService1.submit(callableBarrierDemo);
		System.out.println(futureObj.get()+">>"+futureObj1.get()+">>"+futureObj2.get()+">>"+futureObj3.get());
		System.out.println(Thread.currentThread().getName()+">>"+"Completed");
		executorService1.shutdown();
		
		CountDownLatch countDownLatch = new CountDownLatch(3);
		CountDownRunnableDemo countDownRunnableDemo = new CountDownRunnableDemo(countDownLatch);
		List squareList = countDownRunnableDemo.squareArrayList;
		CountDownRunnableWaiterDemo countDownRunnableWaiterDemo = new CountDownRunnableWaiterDemo(countDownLatch,squareList);
		new Thread(countDownRunnableWaiterDemo).start();
		new Thread(countDownRunnableDemo).start();
		new Thread(countDownRunnableDemo).start();
		new Thread(countDownRunnableDemo).start();
	}

}
class RunnableBarrierDemo implements Runnable{
	CyclicBarrier cyclicBarrier;
	RunnableBarrierDemo(CyclicBarrier cyclicBarrier){
		this.cyclicBarrier = cyclicBarrier;
	}
	public void run(){
		System.out.println(Thread.currentThread().getName()+">>"+"Started");
		try {
			System.out.println(cyclicBarrier.await());
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+">>"+"End");
	}
}
class RunnableBarrierLastDemo implements Runnable{
	public void run(){
		System.out.println(Thread.currentThread().getName()+">>"+"Last Started");
		System.out.println(Thread.currentThread().getName()+">>"+"Last End");
	}
}

class CallableBarrierDemo implements Callable<Long>{
	public Long call(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double i = Math.random()*10;
		return (long) (i*i);
	}
}


class CountDownRunnableDemo implements Runnable{
	CountDownLatch countDownLatch;
	List squareArrayList = new ArrayList();
	public CountDownRunnableDemo(CountDownLatch countDownLatch){
		this.countDownLatch = countDownLatch;
	}
	public void run(){
		System.out.println("Count Down Class Start");
		countDownLatch.countDown();
		squareArrayList.add(Math.random());
		System.out.println("Count Down Class Complete");
	}
}

class CountDownRunnableWaiterDemo implements Runnable{
	CountDownLatch countDownLatch;
	List<Double> squareList;
	public CountDownRunnableWaiterDemo(CountDownLatch countDownLatch,List<Double> squareList){
		this.countDownLatch = countDownLatch;
		this.squareList = squareList;
	}
	public void run(){
		System.out.println("Wait Class Start");
		try {
			countDownLatch.await();
			double sum = 0;
			for(Double d:squareList){
				sum = sum +d;
				System.out.println(d);
			}
			System.out.println(sum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Wait Class Complete");
	}
}