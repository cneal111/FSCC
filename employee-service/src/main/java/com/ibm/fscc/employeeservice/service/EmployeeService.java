package com.ibm.fscc.employeeservice.service;

import java.util.Optional;
import com.ibm.fscc.employeeservice.data.EmployeeEntity;

public interface EmployeeService {

public EmployeeEntity newEmployee(EmployeeEntity newEntity);

public Iterable<EmployeeEntity> getAllEmployees();

public Optional<EmployeeEntity> getEmployee(int id);

public String deleteEmployee(int id);

public EmployeeEntity updateEmployee(EmployeeEntity updatedEntity);

    
}
