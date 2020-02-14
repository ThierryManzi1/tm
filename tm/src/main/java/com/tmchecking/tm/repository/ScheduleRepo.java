package com.tmchecking.tm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmchecking.tm.domain.Schedule;
@Repository
public interface ScheduleRepo extends CrudRepository<Schedule, Long> {

}
