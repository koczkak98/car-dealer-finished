package com.programozzteis.cardealer.cardealer.salesmans;

import com.programozzteis.cardealer.cardealer.car.Car;

import javax.persistence.*;
import java.util.List;

@Entity //Adattábla egy-egy sora megyegyezik a Car osztály példányával
@Table (name = "salesmans")
public class Salesman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "salesman")
    private List<Car> cars;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }
}
