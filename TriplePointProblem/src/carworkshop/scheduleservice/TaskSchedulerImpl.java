package carworkshop.scheduleservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import carworkshop.model.Employee;
import carworkshop.model.Task;
import carworkshop.taskexecutor.TaskExecutor;
import carworkshop.taskstrategy.TaskPriority;

public class TaskSchedulerImpl  implements TaskScheduler {

	@Override
	public void scheduleTask(List<Employee> employeeList,TaskPriority taskPriority) {
		// TODO Auto-generated method stub
		List<TaskExecutor> taskExecutorsList = new ArrayList<TaskExecutor>();
		for(Employee employee : employeeList){
			/*
			 * create and set Task List for given Priority.
			 */
			List<Task> taskList = taskPriority.getTaskPriorityList(employee.getTaskList());
			employee.setTaskList(taskList);
			TaskExecutor taskExecutor = new TaskExecutor(employee);
			taskExecutorsList.add(taskExecutor);
		}
		int poolSize = employeeList.size();
		ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
		for(TaskExecutor taskExecutor :taskExecutorsList){
			// This method return Future Object to check whether Task is completed or not. 
			executorService.submit(taskExecutor);
		}
		while (!executorService.isTerminated()) {
			executorService.shutdown();
		}
		
	}


}
