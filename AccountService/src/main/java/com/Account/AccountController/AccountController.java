package com.Account.AccountController;


import com.Account.AccountService.AccountService;
import com.common.dto.AccountRequestDTO;
import com.common.dto.AccountResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Account")
public class AccountController {
    //1>Connect AccountController to AccountService via constructor injection
    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //2>Creating endpoints
    //2.1>addAccount
    @PostMapping("/addAccount")
    public ResponseEntity<AccountResponseDTO> addAccount(@Valid @RequestBody AccountRequestDTO accountRequestDTO){
        AccountResponseDTO addAccount=accountService.addAccount(accountRequestDTO);
        return new ResponseEntity<>(addAccount, HttpStatus.CREATED);
    }
    //2.2>updateAccount
    @PutMapping("/updateAccount/{id}")
    public ResponseEntity<AccountResponseDTO>updateAccount(@Valid @RequestBody AccountRequestDTO accountRequestDTO,@PathVariable long id){
        AccountResponseDTO updateAccount=accountService.updateAccount(accountRequestDTO,id);
        return ResponseEntity.ok(updateAccount);


    }
    //2.3>getAllAccount
    @GetMapping("/getAllAccount")
    public ResponseEntity<List<AccountResponseDTO>>getAllAccount(){
        List<AccountResponseDTO> getAllAccount=accountService.getAllAccount();
        return ResponseEntity.ok(getAllAccount);
    }

    //2.4>getSingleAccount
    @GetMapping("/getSingleAccount/{id}")
    public ResponseEntity<AccountResponseDTO>getSingleAccount(@PathVariable long id) {
        AccountResponseDTO getSingleAccount=accountService.getSingleAccount(id);
        return ResponseEntity.ok(getSingleAccount);
    }

    //2.5>deleteUser
    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<String>deleteAccount(@PathVariable long id){
       accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
