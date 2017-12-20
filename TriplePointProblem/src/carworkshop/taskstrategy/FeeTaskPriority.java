package carworkshop.taskstrategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import carworkshop.model.Task;

public class FeeTaskPriority implements TaskPriority {

	@Override
	public List<Task> getTaskPriorityList(List<Task> taskList) {
		Comparator<Task> comprator = new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				// TODO Auto-generated method stub
				return o2.getTaskFees().compareTo(o1.getTaskFees());
			}
		};
		Collections.sort(taskList, comprator);
		return taskList;
	}

}
