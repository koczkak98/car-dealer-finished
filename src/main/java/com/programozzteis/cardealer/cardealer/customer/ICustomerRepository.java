package com.programozzteis.cardealer.cardealer.customer;


import org.springframework.data.repository.Repository;

import java.util.List;

public interface ICustomerRepository extends Repository<Customer, Integer> {

    List<Customer> findAll();

}
