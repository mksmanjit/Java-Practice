package foo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ThreadForkAndJoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForkJoinPool pool = new ForkJoinPool(1);
		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(32);
		pool.invoke(myRecursiveAction);
		System.out.println("Main Method End");
		pool.shutdown();

	}

}
class MyRecursiveAction extends RecursiveAction{
	private long workLoad = 0;
	MyRecursiveAction(long workLoad){
		this.workLoad = workLoad;
	}
	public void compute(){
		if(workLoad > 16){
			System.out.println("Inside Workload>>"+workLoad);
			List<MyRecursiveAction> subTasks = new ArrayList<MyRecursiveAction>();
			subTasks.addAll(createSubTasks());
			for(MyRecursiveAction myRecursiveAction: subTasks){
				System.out.println("Inside Fork");
				myRecursiveAction.fork();
				System.out.println("Inside Fork End");
			}
			/*for(MyRecursiveAction myRecursiveAction: subTasks){ 
				myRecursiveAction.join();
			}*/
		}else{
			System.out.println("One Man Army>>"+Thread.currentThread().getName()+">>"+workLoad);
		}
	}
	
	private List<MyRecursiveAction> createSubTasks(){
		System.out.println("Splitting Task");
		List<MyRecursiveAction> subTasks = new ArrayList<MyRecursiveAction>();
		MyRecursiveAction subTask1 = new MyRecursiveAction(this.workLoad/2);
		MyRecursiveAction subTask2 = new MyRecursiveAction(this.workLoad/2);
		subTasks.add(subTask1);
		subTasks.add(subTask2);
		return subTasks;
	}
}

