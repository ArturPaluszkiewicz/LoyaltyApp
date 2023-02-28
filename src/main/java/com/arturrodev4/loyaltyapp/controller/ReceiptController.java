package com.arturrodev4.loyaltyapp.controller;

import com.arturrodev4.loyaltyapp.model.ReceiptRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public class ReceiptController {
    private final ReceiptRepository receiptRepository;

    public ReceiptController(final ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }
}
