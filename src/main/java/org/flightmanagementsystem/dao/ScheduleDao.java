package org.flightmanagementsystem.dao;

import org.flightmanagementsystem.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDao extends CrudRepository<Schedule, Long>  {

}
