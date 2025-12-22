package com.Transaction.TransactionController;


import com.Transaction.TransactionService.TransactionService;

import com.common.dto.TransactionRequestDTO;
import com.common.dto.TransactionResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
    //1>Connect transaction controller to the transaction service via constructor injection
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //2>Creating endpoints
    //2.1>addTransaction
    @PostMapping("/addTransaction")
    public ResponseEntity<TransactionResponseDTO> addTransaction(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO){
        TransactionResponseDTO addTransaction=transactionService.addTransaction(transactionRequestDTO);
        return new ResponseEntity<>(addTransaction, HttpStatus.CREATED);
    }
    //2.2>updateTransaction
    @PutMapping("/updateTransaction/{id}")
    public ResponseEntity<TransactionResponseDTO>updateTransaction(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO,@PathVariable long id){
       TransactionResponseDTO updateTransaction=transactionService.updateTransaction(transactionRequestDTO,id);
        return ResponseEntity.ok(updateTransaction);


    }
    //2.3>getAllTransaction
    @GetMapping("/getAllTransaction")
    public ResponseEntity<List<TransactionResponseDTO>>getAllTransaction(){
        List<TransactionResponseDTO> getAllTransaction=transactionService.getAllTransaction();
        return ResponseEntity.ok(getAllTransaction);
    }

    //2.4>getSingleTransaction
    @GetMapping("/getSingleTransaction/{id}")
    public ResponseEntity<TransactionResponseDTO>getSingleTransaction(@PathVariable long id) {
        TransactionResponseDTO getSingleTransaction=transactionService.getSingleTransaction(id);
        return ResponseEntity.ok(getSingleTransaction);
    }

    //2.5>deleteTransaction
    @DeleteMapping("/deleteTransaction/{id}")
    public ResponseEntity<String>deleteTransaction(@PathVariable long id){
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok("Transaction deleted successfully");
    }
}
