package carworkshop.taskstrategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import carworkshop.model.Task;

public class TimeTaskPriority implements TaskPriority {

	@Override
	public List<Task> getTaskPriorityList(List<Task> taskList) {
		Comparator<Task> comprator = new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				// TODO Auto-generated method stub
				return o2.getTimetaken().compareTo(o1.getTimetaken());
			}
		};
		Collections.sort(taskList, comprator);
		return taskList;
	}

}
