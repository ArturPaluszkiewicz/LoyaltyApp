package com.arturrodev4.loyaltyapp.controller;

import com.arturrodev4.loyaltyapp.model.ReceiptRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RepositoryRestController
public class ReceiptController {
    private final ReceiptRepository receiptRepository;

    public ReceiptController(final ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @GetMapping("/receipts")
    ResponseEntity<?> readAllReceipt(){
        return ResponseEntity.ok(receiptRepository.findAll());
    }
}
