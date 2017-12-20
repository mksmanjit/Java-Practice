package countdown;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.execute(new Runnable(){
			public void run(){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Asynchronus Task Run>>"+Thread.currentThread());
			}
		});
		Future future = executorService.submit(new Runnable(){
			public void run(){
				System.out.println("Asynchronus Task >>"+Thread.currentThread());
			}
		});
		
			System.out.println(future.get());
		Future<Long> futureSubmit = executorService.submit(new Callable<Long>() {
			public Long call(){
				System.out.println("inside Submit>>"+Thread.currentThread());
				return 1l;
			}
		});
		
		System.out.println(futureSubmit.get());

	
		Set<Callable<String>> set = new HashSet<Callable<String>>();
		set.add(new Callable<String>(){
			public String call(){
				return "First Callable>>"+Thread.currentThread();
			}
		});
		set.add(new Callable<String>(){
			public String call(){
				return "Second Callable>>"+Thread.currentThread();
			}
		});
		
		set.add(new Callable<String>(){
			public String call(){
				return "Third Callable>>"+Thread.currentThread();
			}
		});
		
		String furtureany = executorService.invokeAny(set);
		List<Future<String>> futureList = executorService.invokeAll(set);
		System.out.println(furtureany);
		for(Future<String>  f: futureList){
			System.out.println(f.get());
		}
		executorService.shutdown();
		
		
	}
	
	

}


