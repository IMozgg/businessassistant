package io.khasang.ba;

import io.khasang.ba.entity.Car;
import io.khasang.ba.entity.Employee;
import io.khasang.ba.util.HibernateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarControllerIntegrationTest {
    private final String LAN_ADDRESS = "localhost";
    private final String PORT = "8080";
    private final String ROOT = "http://" + LAN_ADDRESS + ":" + PORT + "/car";
    private final String ADD = "/add";
    private final String GET = "/get";
    private final String ID = "/{id}";
    private final String GET_ALL = "/all";
    private final String DELETE_BY_ID = "/delete/{id}";

    @Test
    public void unidirectionalAddCar() {
        Car car = uniCreateCar();
    }


    @Test
    public void addCar() {
        Car car = this.createCar();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Car> responseEntity= restTemplate.exchange(
                ROOT + GET + ID,
                HttpMethod.GET,
                null,
                Car.class,
                car.getId()
        );

        Assert.assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Assert.assertNotNull(responseEntity.getBody());
    }

    private Car createCar() {
        HttpHeaders headers;
        RestTemplate restTemplate;
        Car createdCar;
        Car car = prefillCar();
        HttpEntity<Car> entity;

        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        entity = new HttpEntity<>(car, headers);
        restTemplate = new RestTemplate();

        createdCar = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Car.class
        ).getBody();

        Assert.assertNotNull(createdCar);
        Assert.assertNotNull(createdCar.getMarkaName());
        Assert.assertTrue(createdCar.getId() >= 0);

        return createdCar;
    }

    private Car uniCreateCar() {
        Car car1 = new Car();
        car1.setMarkaName("Opel");
        car1.setModelName("Astra");

        Car car2 = new Car();
        car2.setMarkaName("Subaru");
        car2.setModelName("Impresa");

        Employee vasya = new Employee();
        Employee nordman = new Employee();

        vasya.setName("Vasya");
        nordman.setName("Nordman");

        car1.getEmployeeList().add(vasya);
        car2.getEmployeeList().add(vasya);
        car2.getEmployeeList().add(nordman);

        HttpHeaders headers;
        RestTemplate restTemplate;
        Car createdCar;

        HttpEntity<Car> entity;

        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        entity = new HttpEntity<>(car1, headers);
        restTemplate = new RestTemplate();

        createdCar = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Car.class
        ).getBody();

        entity = new HttpEntity<>(car2, headers);
        restTemplate = new RestTemplate();

        createdCar = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Car.class
        ).getBody();

        return null;
    }

    private Car prefillCar() {
        Car car = new Car();
        car.setMarkaName("Opel");
        car.setModelName("Astra");

        Employee vasya = new Employee();
        Employee nordman = new Employee();

        vasya.setName("Vasya");
        nordman.setName("Nordman");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(vasya);
        employeeList.add(nordman);
        car.setEmployeeList(employeeList);

        return car;
    }

    @Test
    public void getAllCar() {
        List<Car> cars = new ArrayList<>();
        cars.add(createCar());
        cars.add(createCar());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Car>> responseEntity = restTemplate.exchange(
                ROOT + GET + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Car>>() {}
        );

        Assert.assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Assert.assertNotNull(responseEntity.getBody().get(0));
        Assert.assertNotNull(responseEntity.getBody().get(1));
    }

    @Test
    public void deleteById() {
        Car car = createCar();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Car> responseEntity= restTemplate.exchange(
                ROOT + GET + ID,
                HttpMethod.GET,
                null,
                Car.class,
                car.getId()
        );

        Assert.assertNotNull(responseEntity.getBody());

        responseEntity = restTemplate.exchange(
                ROOT + DELETE_BY_ID,
                HttpMethod.DELETE,
                null,
                Car.class,
                car.getId()
        );

        Assert.assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        responseEntity= restTemplate.exchange(
                ROOT + GET + ID,
                HttpMethod.GET,
                null,
                Car.class,
                car.getId()
        );

        Assert.assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Assert.assertNull(responseEntity.getBody());
    }
}
