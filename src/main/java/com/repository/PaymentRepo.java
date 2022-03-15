package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.entity.Payment;

@Repository

public interface PaymentRepo extends JpaRepository <Payment,Integer> {

}