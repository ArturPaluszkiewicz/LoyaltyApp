package com.arturrodev4.loyaltyapp.controller;

import com.arturrodev4.loyaltyapp.model.Receipt;
import com.arturrodev4.loyaltyapp.model.ReceiptRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.List;

@RestController
public class ReceiptController {
    private final ReceiptRepository receiptRepository;

    public ReceiptController(final ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @GetMapping(value = "/receipts", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Receipt>> readAllReceipt(){
        return ResponseEntity.ok(receiptRepository.findAll());
    }
//    @GetMapping(value = "/receipts")
//    ResponseEntity<List<Receipt>> readAllReceipt(Pageable page){
//        return ResponseEntity.ok(receiptRepository.findAll(page).getContent());
//    }
    @GetMapping(value = "/receipts/{id}")
    ResponseEntity<Receipt> readReceiptById(@PathVariable int id){
        if(!receiptRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(receiptRepository.findById(id).orElse(null));
    }
    @PostMapping(value = "/receipts")
    ResponseEntity<Receipt> addReceipt(@RequestBody Receipt receiptToAdd){
        Receipt result = receiptRepository.save(receiptToAdd);
        return  ResponseEntity.created(URI.create("receipts/"+result.getId())).build();
    }
    @PutMapping(value = "/receipts/{id}")
    ResponseEntity<?> updateReceipt(@PathVariable int id, @RequestBody Receipt receiptToUpdate){
        if(!receiptRepository.existsById(id)){
         return ResponseEntity.notFound().build();
        }
        receiptToUpdate.setId(id);
        receiptRepository.save(receiptToUpdate);
        return ResponseEntity.noContent().build();
    }

}
