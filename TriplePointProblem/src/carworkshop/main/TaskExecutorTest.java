package carworkshop.main;

import java.util.ArrayList;
import java.util.List;

import carworkshop.model.Employee;
import carworkshop.model.Task;
import carworkshop.scheduleservice.TaskScheduler;
import carworkshop.scheduleservice.TaskSchedulerImpl;
import carworkshop.taskexecutor.TaskExecutor;
import carworkshop.taskstrategy.FeeTaskPriority;
import carworkshop.taskstrategy.TaskPriority;
import carworkshop.taskstrategy.TimeTaskPriority;

public class TaskExecutorTest {

	public static void main(String[] args) {
		  Employee joe = new Employee("Joe", "Trainee");  
          Employee smith = new Employee("Smith", "Expert");  
          Employee walker = new Employee("Walker", "Employee");  
          // Creating Task Object  
          Task task1 = new Task("Car-Repair", 1000, 5);
          Task task2 = new Task("Car-Paint", 1100, 4);
          Task task3 = new Task("Car-Wash", 100, 2);  
            
            
          //Creating list of task for employee Joe.  
          List<Task> joeTaskList = new ArrayList<Task>();  
          joeTaskList.add(task1);  
          joeTaskList.add(task2);  
          joeTaskList.add(task3);  
          
          //Creating list of task for employee Smith. 
          List<Task> smithTaskList = new ArrayList<Task>();  
          smithTaskList.add(task1);  
          
          //Creating list of task for employee Walker.
          List<Task> walkerTaskList = new ArrayList<Task>();  
          walkerTaskList.add(task1);  
          walkerTaskList.add(task2);
          
          TaskPriority timeTaskPriority = new TimeTaskPriority();
          
          joe.setTaskList(joeTaskList);
          
          smith.setTaskList(smithTaskList);
          
          walker.setTaskList(walkerTaskList);
           
          List<Employee> employeeList = new ArrayList<Employee>();
          employeeList.add(joe);
          employeeList.add(smith);
          employeeList.add(walker);
          
          TaskScheduler taskScheduler = new TaskSchedulerImpl();
          System.out.println("----------------------Task Scheduling Start using Time---------------------------------");
          taskScheduler.scheduleTask(employeeList,timeTaskPriority);
          System.out.println("----------------------Task Scheduling Start using Fees---------------------------------");
          TaskPriority feeTaskPriority = new FeeTaskPriority();
          taskScheduler.scheduleTask(employeeList, feeTaskPriority);
          
          
          
	}

}
