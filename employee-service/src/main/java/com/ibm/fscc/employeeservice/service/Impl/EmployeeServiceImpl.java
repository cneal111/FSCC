package com.ibm.fscc.employeeservice.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.fscc.employeeservice.data.EmployeeEntity;
import com.ibm.fscc.employeeservice.repository.EmployeeRepository;
import com.ibm.fscc.employeeservice.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    
    @Override
    public EmployeeEntity newEmployee(EmployeeEntity newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Iterable<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> getEmployee(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Employee Removed.";

    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity updatedEmployee) {
        return employeeRepository.save(updatedEmployee);
    }
    
}
