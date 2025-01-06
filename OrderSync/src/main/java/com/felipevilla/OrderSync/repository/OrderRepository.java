package com.felipevilla.OrderSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipevilla.OrderSync.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
