package io.khasang.ba.service;

import io.khasang.ba.entity.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * method for add employee
     *
     * @param employee - new employee for creation
     * @return return employee
     */
    Employee addEmployee(Employee employee);

    /**
     * method for getting Employee by specific id
     *
     * @param id - employee's id
     * @return employee by id
     */
    Employee getEmployeeById(long id);

    /**
     * method for getting all employees
     *
     * @return employee's list
     */
    List<Employee> getAllEmployees();

    /**
     * method for update employee info
     *
     * @param employee - employee for update
     * @return return employee
     */
    Employee updateEmployee(Employee employee);

    /**
     * method for deleting Employee by specific id
     *
     * @param employee - employee
     */
    void deleteById(Employee employee);
}
