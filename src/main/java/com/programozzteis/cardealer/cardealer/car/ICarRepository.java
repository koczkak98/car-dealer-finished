package com.programozzteis.cardealer.cardealer.car;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ICarRepository extends Repository<Car, Integer> {

    /** SQL: SELECT * FROM advertisements */
    List<Car> findAll();

    Car findById (Integer carId);


    /** SQL: INSERT INTO ... */
    void save(Car car);

    void delete (Car car);

    void deleteById(Integer carId);



}
