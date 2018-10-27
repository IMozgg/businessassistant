package io.khasang.ba.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// default AUTO

    @SuppressWarnings(value = "ALL")
    @Column(name = "employee_id")
    private long id;

    private String name;

    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //private List<Car> carList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public List<Car> getCarList() {
        return carList;
    }*/

    /*public void setCarList(List<Car> carList) {
        this.carList = carList;
    }*/
}
