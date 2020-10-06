package com.programozzteis.cardealer.cardealer.salesmans;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISalesmansRepo extends Repository<Salesman, Integer> {

    /** SQL: SELECT * FROM Salesman */
    List<Salesman> findAll();

    /** SQL: SELECT salesman FROM Salesman salesman WHERE salesman.id = :smanId */
    Salesman findById(Integer smanId);


    @Query("SELECT salesman FROM Salesman salesman WHERE salesman.name LIKE ('%' || :name || '%')")
    List<Salesman> findByName(@Param("name") String name);

    void delete(Salesman sman);
}
