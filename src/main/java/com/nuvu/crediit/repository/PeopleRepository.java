package com.nuvu.crediit.repository;

import com.nuvu.crediit.model.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    List<People> findByIdNumberAndIdType(Long idNumber, Long idType);

}
