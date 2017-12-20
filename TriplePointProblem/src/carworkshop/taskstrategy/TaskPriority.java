package carworkshop.taskstrategy;

import java.util.List;

import carworkshop.model.Task;

public interface TaskPriority {
	
	List<Task> getTaskPriorityList(List<Task> taskList);

}
