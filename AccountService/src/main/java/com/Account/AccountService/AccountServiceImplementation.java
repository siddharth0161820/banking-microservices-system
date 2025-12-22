package com.Account.AccountService;


import com.Account.AccountRepository.AccountRepository;
import com.Account.GlobalExceptionHandling.NOTFOUNDEXCEPTION;
import com.Account.ModelEntity.Account;
import com.common.dto.AccountRequestDTO;
import com.common.dto.AccountResponseDTO;
import com.common.dto.StatementResponseDTO;
import com.common.dto.TransactionResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AccountServiceImplementation implements  AccountService {
    //1>Connect AccountService to AccountRepository via constructor injection
    private final AccountRepository accountRepository;

    public AccountServiceImplementation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //2>Implementing Endpoints
    @Override
    public AccountResponseDTO addAccount(AccountRequestDTO accountRequestDTO) {
        Account addAccount = new Account();
        //1>convert dto mapping to entities
        addAccount.setUserId(accountRequestDTO.getUserId());
        addAccount.setAccountType(accountRequestDTO.getAccountType());
        addAccount.setBalance(accountRequestDTO.getBalance());
        //2>save to database
        Account saveAccount = accountRepository.save(addAccount);
        //3>Return details to clients
        return new AccountResponseDTO(
                saveAccount.getAccountId(),
                saveAccount.getUserId(),
                saveAccount.getAccountType(),
                saveAccount.getBalance()
        );
    }

    @Override
    public AccountResponseDTO updateAccount(AccountRequestDTO accountRequestDTO, long id) {
        //1>Check if the Account in the dto to be updated exists in the repository or not to avoid error
        Account exisitngAccount = accountRepository.findById(id)
                .orElseThrow(() -> new NOTFOUNDEXCEPTION("Account details not found by userId to be updated" + id));
        //2>If Account details found in the repository update the DTO
        exisitngAccount.setBalance(accountRequestDTO.getBalance());
        exisitngAccount.setAccountType(accountRequestDTO.getAccountType());
        exisitngAccount.setUserId(accountRequestDTO.getUserId());

        //3>Save to repository
        Account savedAccount = accountRepository.save(exisitngAccount);
        //4>Return Account details to the client
        return new AccountResponseDTO(
                savedAccount.getAccountId(),
                savedAccount.getUserId(),
                savedAccount.getAccountType(),
                savedAccount.getBalance()
        );
    }

    @Override
    public List<AccountResponseDTO> getAllAccount() {
        return accountRepository.findAll().stream().map(
                findAll -> new AccountResponseDTO(
                        findAll.getAccountId(),
                        findAll.getUserId(),
                        findAll.getAccountType(),
                        findAll.getBalance()
                )
        ).toList();
    }

    @Override
    public AccountResponseDTO getSingleAccount(long id) {
        return accountRepository.findById(id)
                .map(getSingleAccount -> new AccountResponseDTO(
                        getSingleAccount.getAccountId(),
                        getSingleAccount.getUserId(),
                        getSingleAccount.getAccountType(),
                        getSingleAccount.getBalance()
                )).orElseThrow(() -> new NOTFOUNDEXCEPTION("Account details not found by id" + id));
    }


    @Override
    public void deleteAccount(long id) {
//1>check if the Account to be deleted is there or not to avoid error
        Account exisitngAccount = accountRepository.findById(id)
                .orElseThrow(() -> new NOTFOUNDEXCEPTION("Account details  not found  by id" + id));
        //2>User details found to be deleted, just delete it...
        accountRepository.deleteById(id);
    }

}
