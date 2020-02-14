package com.tmchecking.tm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmchecking.tm.domain.TMTeacher;

@Repository
public interface TMTeacherRepo extends CrudRepository<TMTeacher, Long>{

}
