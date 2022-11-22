package com.bw;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value = "select * from employee where name like %:name%", nativeQuery = true)
	    List<Employee> getByName(String name);
}