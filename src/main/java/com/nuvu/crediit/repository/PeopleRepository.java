package com.nuvu.crediit.repository;

import com.nuvu.crediit.model.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
