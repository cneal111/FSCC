package com.ibm.fscc.employeeservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.fscc.employeeservice.data.EmployeeEntity;
import com.ibm.fscc.employeeservice.service.Impl.EmployeeServiceImpl;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeService;

	@Autowired
	private Environment env;

	@GetMapping(path = "/status/check")
	public String status() {
		return "Working on port " + env.getProperty("server.port") + "!";
	}

	@GetMapping(path = "/all-info")
	public Iterable<EmployeeEntity> getAllEmployees(){
		return employeeService.getAllEmployees();
	}

	@GetMapping(path = "/info/{id}")
	public @ResponseBody Optional<EmployeeEntity> getEmployee(@PathVariable int id){
		return employeeService.getEmployee(id);
	}

	@PostMapping(path = "/new")
	public EmployeeEntity newEmployee(@RequestBody EmployeeEntity newEmployee){
		return employeeService.newEmployee(newEmployee);
	}

	@PutMapping(path = "/updated")
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity updatedEmployee){
		return employeeService.updateEmployee(updatedEmployee);
	}

	@DeleteMapping(path = "/removed")
	public String deleteEmployee(@RequestParam int id){
		return employeeService.deleteEmployee(id);
	}
}
