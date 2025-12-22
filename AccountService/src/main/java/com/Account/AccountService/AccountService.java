package com.Account.AccountService;
import com.common.dto.AccountRequestDTO;
import com.common.dto.AccountResponseDTO;



import java.util.List;

public interface AccountService {
    public AccountResponseDTO addAccount(AccountRequestDTO accountRequestDTO);
    public AccountResponseDTO updateAccount(AccountRequestDTO accountRequestDTO,long id);
    public List<AccountResponseDTO>getAllAccount();
    public AccountResponseDTO getSingleAccount(long id);
    public void deleteAccount(long id);


}
