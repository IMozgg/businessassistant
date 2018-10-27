package io.khasang.ba.service.impl;

import io.khasang.ba.dao.EmployeeDao;
import io.khasang.ba.entity.Employee;
import io.khasang.ba.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.create(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeDao.getById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getList();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public void deleteById(Employee employee) {
        employeeDao.deleteById(employee);
    }
}
