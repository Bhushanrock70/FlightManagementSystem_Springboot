package org.flightmanagementsystem.controller;

import java.util.List;


import org.flightmanagementsystem.model.Schedule;
import org.flightmanagementsystem.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/schedule")
public class ScheduleController{
    //DI
    private ScheduleService scheduleService;
    
    //CI
	public ScheduleController(ScheduleService scheduleService) {
		super();
		this.scheduleService = scheduleService;
	}
	//creating schedule rest API
	
	//addSchedule method
	@PostMapping
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule){
        return new ResponseEntity<Schedule>(scheduleService.addSchedule(schedule),HttpStatus.CREATED);
    }


	//view all schedule
	@GetMapping("")
	public List<Schedule> viewSchedule() {
		return scheduleService.viewSchedule();
	}
    
	//view single schedule
	@GetMapping("{airCode}")
    public ResponseEntity<Schedule> viewSceduleByNumber(@PathVariable("airCode") long airCode){
		  
	     return new ResponseEntity<Schedule>(scheduleService.viewSceduleByNumber(airCode), HttpStatus.OK);    
	    }
	
	//update schedule
    @PutMapping("{airCode}")
    public ResponseEntity<Schedule> modifySchedule(@PathVariable("airCode") long airCode,
            @RequestBody  Schedule schedule)
    {
        return new ResponseEntity<Schedule>(scheduleService.modifySchedule(schedule, airCode),HttpStatus.OK);
    }

    //delete schedule
    @DeleteMapping("{airCode}")
    public ResponseEntity<String> deleteSchedule(@PathVariable("airCode")long airCode)
    {
        //delete
    	scheduleService.deleteSchedule(airCode);
        return new ResponseEntity<String>("Schedule deleted Successfully!",HttpStatus.OK);
    }
}
