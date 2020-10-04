package com.programozzteis.cardealer.cardealer.customer;


import com.programozzteis.cardealer.cardealer.model.NamedEntity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer extends NamedEntity {

    @Column(name = "current_money")
    private int currentMoney;


    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }
}
