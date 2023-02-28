package com.arturrodev4.loyaltyapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    @RestResource(path = "Bind")
    List<Receipt> findByBindToClientIsTrue();
}
