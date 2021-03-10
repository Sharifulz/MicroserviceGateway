package com.exam.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.CustomerModel;

@Repository
public interface ICustomerDao extends JpaRepository<CustomerModel, UUID> {

}
