package com.springlearn.ourspring.repository;

import com.springlearn.ourspring.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorJPA extends JpaRepository<Director, Integer> {
}
