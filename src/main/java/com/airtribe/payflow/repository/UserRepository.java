package com.airtribe.payflow.repository;

import com.airtribe.payflow.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUpiId(String upiId);
    
    @Query("SELECT u FROM users  u WHERE u.balance > ?1")
    List<User> findUsersWithBalanceGreaterThan(Double amount);

}