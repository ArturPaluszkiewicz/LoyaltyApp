package com.arturrodev4.loyaltyapp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface ReceiptRepository {
    List<Receipt> findAll();
  //  Page<Receipt> findAll(Pageable page);
    List<Receipt> findByBindToClient(@Param("state") boolean bind);
    Optional<Receipt> findById(Integer id);

    boolean existsById(Integer id);

    Receipt save(Receipt entity);
}
