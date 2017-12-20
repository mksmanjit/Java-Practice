package triplePoint.model;

import java.math.BigDecimal;

public class TaskTO {
	
	private String taskName;
	private int serviceFees;
	private int timeTake;
	
	
	public TaskTO(String taskName, int serviceFees, int timeTake) {
		super();
		this.taskName = taskName;
		this.serviceFees = serviceFees;
		this.timeTake = timeTake;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getServiceFees() {
		return serviceFees;
	}
	public void setServiceFees(int serviceFees) {
		this.serviceFees = serviceFees;
	}
	public int getTimeTake() {
		return timeTake;
	}
	public void setTimeTake(int timeTake) {
		this.timeTake = timeTake;
	}

}
