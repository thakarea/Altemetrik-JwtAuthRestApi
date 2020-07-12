package com.altimetrik.controller;

import org.springframework.web.bind.annotation.*;

import com.altimetrik.model.EmployeeDto;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping({ "/employees" })
public class EmployeeController {

	private List<EmployeeDto> employeeList = createListOfEmployees();

	@GetMapping(produces = "application/json")
	public List<EmployeeDto> getEmployees() {
		return employeeList;
	}

	@DeleteMapping(path = { "/{empId}" })
	public EmployeeDto deleteEmp(@PathVariable("empId") int empId) {
		EmployeeDto delEmp = null;
		for (EmployeeDto emp : employeeList) {
			if (emp.getEmpId().equals(empId)) {
				employeeList.remove(emp);
				delEmp = emp;
				break;
			}
		}
		return delEmp;
	}

	@PostMapping
	public EmployeeDto createEmp(@RequestBody EmployeeDto user) {
		employeeList.add(user);
		return user;
	}

	private static List<EmployeeDto> createListOfEmployees() {
		List<EmployeeDto> employees = new ArrayList<>();
		EmployeeDto emp1 = new EmployeeDto();
		emp1.setName("Suraj");
		emp1.setCompany("Altimetrik");
		emp1.setEmpId("1");
		emp1.setSalary(90000);

		EmployeeDto emp2 = new EmployeeDto();
		emp2.setName("Akash");
		emp2.setCompany("Charter Global");
		emp2.setEmpId("2");
		emp2.setSalary(75000);
		employees.add(emp1);
		employees.add(emp2);
		return employees;
	}

}