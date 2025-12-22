package com.Transaction.TransactionService;



import com.common.dto.TransactionRequestDTO;
import com.common.dto.TransactionResponseDTO;

import java.util.List;

public interface TransactionService {
    public TransactionResponseDTO addTransaction(TransactionRequestDTO transactionRequestDTO);
    public TransactionResponseDTO updateTransaction(TransactionRequestDTO transactionRequestDTO, long id);
    public List<TransactionResponseDTO> getAllTransaction();
    public TransactionResponseDTO getSingleTransaction(long id);
    public void deleteTransaction(long id);
}
