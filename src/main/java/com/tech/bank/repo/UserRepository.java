package com.tech.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.bank.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
