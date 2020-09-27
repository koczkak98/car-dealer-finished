package com.programozzteis.cardealer.cardealer.car;

import com.programozzteis.cardealer.cardealer.salesmans.Salesmans;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity //Adattábla egy-egy sora megyegyezik a Car osztály példányával
@Table (name = "advertisements")
public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Enumerated (EnumType.STRING)
    @Column (name = "car_type")
    private Cartype type;

    @DateTimeFormat (pattern = "yyyy.MM.dd")
    @Column (name = "car_prod_date")
    private LocalDate date;

    @Column (name = "car_power")
    private String power;

    @Column (name = "car_consumption")
    private String consumption;

    @Column (name = "car_price")
    private int price;

    @Column (name = "car_salesman_id")
    private Salesmans salesmansID;



    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setType(Cartype type) {
        this.type = type;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getID() {
        return ID;
    }

    public Cartype getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPower() {
        return power;
    }

    public String getConsumption() {
        return consumption;
    }

    public int getPrice() {
        return price;
    }
}
