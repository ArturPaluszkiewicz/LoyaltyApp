package com.arturrodev4.loyaltyapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface SqlReceiptRepository extends ReceiptRepository, JpaRepository<Receipt, Integer> {

}
