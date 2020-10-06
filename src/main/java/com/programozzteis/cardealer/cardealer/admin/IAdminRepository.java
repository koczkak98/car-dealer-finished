package com.programozzteis.cardealer.cardealer.admin;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface IAdminRepository extends Repository<Admin, Integer> {

    List<Admin> findAll();

    Admin findById (Integer adminId);
}
