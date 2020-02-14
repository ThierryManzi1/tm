package com.tmchecking.tm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmchecking.tm.domain.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

}
