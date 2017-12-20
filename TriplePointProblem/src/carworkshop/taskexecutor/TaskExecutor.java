package carworkshop.taskexecutor;

import java.util.List;

import carworkshop.model.Employee;
import carworkshop.model.Task;

public class TaskExecutor implements Runnable {
	private Employee employee;
	
	public TaskExecutor(Employee employee) {
		super();
		this.employee = employee;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<Task> taskList = employee.getTaskList();
		for(Task task : taskList){
			System.out.println("Employee Name: "+employee.getEmpName()+" ,Task name: "+task.getTaskName()+" ,Time Taken: "+task.getTimetaken()+" ,Fee: "+task.getTaskFees());
		}
	}

}
