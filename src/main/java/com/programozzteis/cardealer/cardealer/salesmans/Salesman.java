package com.programozzteis.cardealer.cardealer.salesmans;

import com.programozzteis.cardealer.cardealer.car.Car;
import com.programozzteis.cardealer.cardealer.model.NamedEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salesmans")
public class Salesman extends NamedEntity {

    @OneToMany(mappedBy = "salesman")
    private List<Car> cars;


    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
        car.setSalesman( this );
    }
}
