package com.namit.springsecuritybasic.repository;

import com.namit.springsecuritybasic.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Long>{

    List<Customer> findByEmail(String email);
}
