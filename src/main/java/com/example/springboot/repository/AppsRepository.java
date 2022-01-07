package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.App;

@Repository
public interface AppsRepository extends JpaRepository<App, Long> {

}
