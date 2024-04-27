package org.flightmanagementsystem.service;

import java.util.List;
import org.flightmanagementsystem.model.Schedule;

public interface ScheduleService{
	
	//Add Schedule method
	 public Schedule addSchedule(Schedule schedule);
	 //Find all schedule
	 public List<Schedule> viewSchedule();
	 //Find a single schedule
	 public Schedule viewSceduleByNumber(long airCode);
	 //updating schedule
	 public Schedule modifySchedule(Schedule schedule, long airCode);
	 //delete schedule
	 public void deleteSchedule(long airCode);

}
