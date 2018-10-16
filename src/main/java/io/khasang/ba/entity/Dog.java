package io.khasang.ba.entity;

import javax.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dog_id")
    private long id;

    @Column(name = "dog_name")
    private String name;

    @Column(name = "dog_desc")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}