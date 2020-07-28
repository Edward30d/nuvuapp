package com.nuvu.crediit.repository;

import com.nuvu.crediit.model.entity.CategoryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryCardRespository extends JpaRepository<CategoryCard , Long> {

    List<CategoryCard> findByTypeAndFranchise(String type, String franchise);
}
