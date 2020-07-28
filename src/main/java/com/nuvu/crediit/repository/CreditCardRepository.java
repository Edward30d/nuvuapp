package com.nuvu.crediit.repository;


import com.nuvu.crediit.model.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    List<CreditCard> findByIdNumber(Long idNumber);

    List<CreditCard> findByPeople(Long idPeople);

}
