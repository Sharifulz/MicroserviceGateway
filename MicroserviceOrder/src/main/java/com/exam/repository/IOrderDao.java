package com.exam.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.OrderModel;

@Repository
public interface IOrderDao extends JpaRepository<OrderModel, UUID> {

}
