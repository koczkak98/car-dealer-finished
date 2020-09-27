package com.programozzteis.cardealer.cardealer.salesmans;

import javax.persistence.*;

@Entity //Adattábla egy-egy sora megyegyezik a Car osztály példányával
@Table (name = "salesmans")
public class Salesmans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer car_salesman_id;

    @Column (name = "salesmans_name")
    private String name;


    public void setID(Integer ID) {
        this.car_salesman_id = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {
        return car_salesman_id;
    }

    public String getName() {
        return name;
    }
}
