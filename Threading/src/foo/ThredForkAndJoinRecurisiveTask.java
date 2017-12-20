package foo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ThredForkAndJoinRecurisiveTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForkJoinPool pool = new ForkJoinPool(4);
		MyRecursiveTask myRecursiveTask = new MyRecursiveTask(160);
		Long result = pool.invoke(myRecursiveTask);
		System.out.println("Main Method End"+">>"+result);

	}

}
class MyRecursiveTask extends RecursiveTask<Long>{
	private long workLoad = 0;
	MyRecursiveTask(long workLoad){
		this.workLoad = workLoad;
	}
	public Long compute(){
		if(workLoad > 16){
			//System.out.println("Inside Workload>>"+workLoad);
			List<MyRecursiveTask> subTasks = new ArrayList<MyRecursiveTask>();
			subTasks.addAll(createSubTasks());
			for(MyRecursiveTask myRecursiveAction: subTasks){
				//System.out.println("Inside Fork");
				myRecursiveAction.fork();
				//System.out.println("Inside Fork End");
			}
			long result = 0;
			for(MyRecursiveTask myRecursiveTask: subTasks){ 
				result +=myRecursiveTask.join();
			}
			return result;
		}else{
			System.out.println("One Man Army>>"+Thread.currentThread().getName()+">>"+workLoad);
			return workLoad*2;
		}
	}
	
	private List<MyRecursiveTask> createSubTasks(){
		//System.out.println("Splitting Task");
		List<MyRecursiveTask> subTasks = new ArrayList<MyRecursiveTask>();
		MyRecursiveTask subTask1 = new MyRecursiveTask(this.workLoad/2);
		MyRecursiveTask subTask2 = new MyRecursiveTask(this.workLoad/2);
		subTasks.add(subTask1);
		subTasks.add(subTask2);
		return subTasks;
	}
}

