package com.Transaction.TransactionService;


import com.Transaction.EntityModel.Transaction;
import com.Transaction.GlobalExceptionHandling.NOTFOUNDEXCEPTION;
import com.Transaction.TransactionRepository.TransactionRepository;
import com.common.dto.TransactionRequestDTO;
import com.common.dto.TransactionResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImplementation implements TransactionService {

    //1>Connect transaction service to the transaction repository via constructor injection
    private final TransactionRepository transactionRepository;

    public TransactionServiceImplementation(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    //2>Implementing Methods()
    //2>Implementing Endpoints
    @Override
    public TransactionResponseDTO addTransaction(TransactionRequestDTO transactionRequestDTO) {
        Transaction addTransaction = new Transaction();
        //1>convert dto mapping to entities
        addTransaction.setAccountId(transactionRequestDTO.getAccountId());
        addTransaction.setTransactionType(transactionRequestDTO.getTransactionType());
        addTransaction.setAmount(transactionRequestDTO.getAmount());
        //2>save to database
        Transaction saveTransaction = transactionRepository.save(addTransaction);
        //3>Return details to clients
        return new TransactionResponseDTO(
                saveTransaction.getTransactionId(),
                saveTransaction.getAccountId(),
                saveTransaction.getAmount(),
                saveTransaction.getTransactionType(),
                saveTransaction.getTimestamp()
        );
    }

    @Override
    public TransactionResponseDTO updateTransaction(TransactionRequestDTO transactionRequestDTO, long id) {
        //1>Check if the transaction in the dto to be updated exists in the repository or not to avoid error
       Transaction existingTransaction =transactionRepository.findById(id)
                .orElseThrow(() -> new NOTFOUNDEXCEPTION("transaction details not found by userId to be updated" + id));
        //2>If Transaction details found in the repository update the DTO
        existingTransaction.setAmount(transactionRequestDTO.getAmount());
        existingTransaction.setTransactionType(transactionRequestDTO.getTransactionType());
        existingTransaction.setAccountId(transactionRequestDTO.getAccountId());


        //3>Save to repository
       Transaction savedTransaction = transactionRepository.save(existingTransaction);
        //4>Return Transaction details to the client
        return new TransactionResponseDTO(
               existingTransaction.getTransactionId(),
                existingTransaction.getAccountId(),
                existingTransaction.getAmount(),
                existingTransaction.getTransactionType(),
                existingTransaction.getTimestamp()
        );
    }

    @Override
    public List<TransactionResponseDTO> getAllTransaction() {
        return transactionRepository.findAll().stream().map(
                findAll -> new TransactionResponseDTO(
                       findAll.getTransactionId(),
                        findAll.getAccountId(),
                        findAll.getAmount(),
                        findAll.getTransactionType(),
                        findAll.getTimestamp()
                )
        ).toList();
    }

    @Override
    public TransactionResponseDTO getSingleTransaction(long id) {
        return transactionRepository.findById(id)
                .map(getSingleTransaction -> new TransactionResponseDTO(
                        getSingleTransaction.getTransactionId(),
                        getSingleTransaction.getAccountId(),
                        getSingleTransaction.getAmount(),
                        getSingleTransaction.getTransactionType(),
                        getSingleTransaction.getTimestamp()
                )).orElseThrow(() -> new NOTFOUNDEXCEPTION("Transaction details not found by id" + id));
    }


    @Override
    public void deleteTransaction(long id) {
//1>check if the Transaction to be deleted is there or not to avoid error
        Transaction exisitngTransaction =transactionRepository.findById(id)
                .orElseThrow(()->new NOTFOUNDEXCEPTION("Transaction details  not found  by id"+id));
        //2>Transaction details found to be deleted, just delete it...
       transactionRepository.deleteById(id);
    }
}
