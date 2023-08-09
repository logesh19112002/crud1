package com.example.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.first.model.First;

public interface FirstRepository extends JpaRepository<First, Long> {

}
