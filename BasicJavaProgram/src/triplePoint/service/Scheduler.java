package triplePoint.service;

import java.util.List;

import triplePoint.model.EmployeeTO;

public interface Scheduler {
	void startScheduleJob(List<EmployeeTO> employeeTOList);
}
