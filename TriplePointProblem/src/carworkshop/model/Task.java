package carworkshop.model;

public class Task {
	/**
	 * Holds the task name to be done by employee.
	 */
	private String taskName;
	/**
	 * Holds the fees for given task.
	 */
	private Integer taskFees;
	/**
	 * Holds the time taken for given task.
	 */
	private Integer timetaken;
	
	public Task(String taskName, Integer taskFees, Integer timetaken) {
		super();
		this.taskName = taskName;
		this.taskFees = taskFees;
		this.timetaken = timetaken;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the taskFees
	 */
	public Integer getTaskFees() {
		return taskFees;
	}

	/**
	 * @param taskFees the taskFees to set
	 */
	public void setTaskFees(Integer taskFees) {
		this.taskFees = taskFees;
	}

	/**
	 * @return the timetaken
	 */
	public Integer getTimetaken() {
		return timetaken;
	}

	/**
	 * @param timetaken the timetaken to set
	 */
	public void setTimetaken(Integer timetaken) {
		this.timetaken = timetaken;
	}
	
	

}
