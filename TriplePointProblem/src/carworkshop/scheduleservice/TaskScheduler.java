package carworkshop.scheduleservice;

import java.util.List;

import carworkshop.model.Employee;
import carworkshop.taskstrategy.TaskPriority;

public interface TaskScheduler {
	/**
	 * This method schedule the task given to the employee.
	 * @param employeeList {@link Employee} holds the List of employee which are going to execute their task.
	 * @param taskPriority {@link TaskPriority} signify on which order task should be prioritized.
	 */
	void scheduleTask(List<Employee> employeeList, TaskPriority taskPriority);

}
