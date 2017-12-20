package triplePoint.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import triplePoint.model.TaskTO;

public class PriortyScheduler {
	
	public static List<TaskTO> getPriorityList(List<TaskTO> taskTOList){
		Comparator<TaskTO> comparator  = new Comparator<TaskTO>() {
			public int compare(TaskTO t1 , TaskTO t2){
				if(t1.getTimeTake() > t2.getTimeTake()){
					return -1;
				} else if(t1.getTimeTake() < t2.getTimeTake()){
					return 1;
				} else{
					return 0;
				}
			}
		};
		Collections.sort(taskTOList,comparator);
		return taskTOList;
		
	}

}
