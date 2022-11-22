package com.bw;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	public void updateEmployee(Employee employee, Integer id) {
		Employee employee1 = employeeRepository.getReferenceById(id);
		employee1.setName(employee.getName());
		employeeRepository.save(employee1);
	}
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}
	public Employee getEmployee(Integer id) {
		return employeeRepository.getReferenceById(id);
	}
	public List<Employee> getEmployeeByName(String empname) {
		return employeeRepository.getByName(empname);
	}
}