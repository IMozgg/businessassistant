package io.khasang.ba.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// default AUTO

    @SuppressWarnings(value = "ALL")
    @Column(name = "car_id")
    private long id;

    private String markaName;

    private String modelName;

    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @SuppressWarnings(value = "ALL")
    @JoinTable(
            name="car_employee",
            joinColumns=@JoinColumn(name="car_id", referencedColumnName="car_id"),
            inverseJoinColumns=@JoinColumn(name="employee_id", referencedColumnName="employee_id"))
    private List<Employee> employeeList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarkaName() {
        return markaName;
    }

    public void setMarkaName(String name) {
        this.markaName = name;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
