package com.programozzteis.cardealer.cardealer.salesmans;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface ISalesmansRepo extends Repository<Salesman, Integer> {

    /** SQL: SELECT * FROM advertisements */
    List<Salesman> findAll();


}
