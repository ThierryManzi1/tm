package com.tmchecking.tm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmchecking.tm.domain.StudentSchedule;

@Repository
public interface StudentScheduleRepo extends CrudRepository<StudentSchedule, Long> {

}
