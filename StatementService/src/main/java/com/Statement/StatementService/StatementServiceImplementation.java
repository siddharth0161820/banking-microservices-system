package com.Statement.StatementService;


import com.Statement.GlobalExceptionHandling.NOTFOUNDEXCEPTION;
import com.Statement.ModelEntity.Statement;

import com.Statement.StatementRepository.StatementRepository;
import com.common.dto.StatementRequestDTO;
import com.common.dto.StatementResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementServiceImplementation implements StatementService {
    //1>Connect StatementService to StatementRepository via constructor injection
    private final StatementRepository statementRepository;

    public StatementServiceImplementation(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }


    //2>Implementing Endpoints
    @Override
    public StatementResponseDTO addStatement(StatementRequestDTO statementRequestDTO) {
       Statement addStatement = new Statement();
        //1>convert dto mapping to entities
        addStatement.setAccountId(statementRequestDTO.getAccountId());
        addStatement.setStartDate(statementRequestDTO.getStartDate());
        addStatement.setEndDate(statementRequestDTO.getEndDate());
        addStatement.setBalance(statementRequestDTO.getBalance());
        //2>save to database
        Statement saveStatement= statementRepository.save(addStatement);
        //3>Return details to clients
        return new StatementResponseDTO(
                saveStatement.getStatementId(),
                saveStatement.getAccountId(),
                saveStatement.getStartDate(),
                saveStatement.getEndDate(),
                saveStatement.getBalance()
        );
    }

    @Override
    public StatementResponseDTO updateStatement(StatementRequestDTO statementRequestDTO, long id) {
        //1>Check if the Account in the dto to be updated exists in the repository or not to avoid error
        Statement existingStatement = statementRepository.findById(id)
                .orElseThrow(() -> new NOTFOUNDEXCEPTION("Statement details not found by userId to be updated" + id));
        //2>If Statement details found in the repository update the DTO
        existingStatement.setAccountId(statementRequestDTO.getAccountId());
        existingStatement.setStartDate(statementRequestDTO.getStartDate());
        existingStatement.setEndDate(statementRequestDTO.getEndDate());
        existingStatement.setBalance(statementRequestDTO.getBalance());

        //3>Save to repository
       Statement savedStatement = statementRepository.save(existingStatement);
        //4>Return Statement details to the client
        return new StatementResponseDTO(
                savedStatement.getStatementId(),
                savedStatement.getAccountId(),
                savedStatement.getStartDate(),
                savedStatement.getEndDate(),
                savedStatement.getBalance()
        );
    }

    @Override
    public List<StatementResponseDTO> getAllStatement() {
        return statementRepository.findAll().stream().map(
                findAll -> new StatementResponseDTO(
                       findAll.getStatementId(),
                        findAll.getAccountId(),
                        findAll.getStartDate(),
                        findAll.getEndDate(),
                        findAll.getBalance()
                )
        ).toList();
    }

    @Override
    public StatementResponseDTO getSingleStatement(long id) {
        return statementRepository.findById(id)
                .map(getSingleAccount -> new StatementResponseDTO(
                        getSingleAccount.getStatementId(),
                        getSingleAccount.getAccountId(),
                        getSingleAccount.getStartDate(),
                        getSingleAccount.getEndDate(),
                        getSingleAccount.getBalance()
                )).orElseThrow(() -> new NOTFOUNDEXCEPTION("Statement details not found by id" + id));
    }


    @Override
    public void deleteStatement(long id) {
//1>check if the Statement to be deleted is there or not to avoid error
        Statement exisitngStatement =statementRepository.findById(id)
                .orElseThrow(()->new NOTFOUNDEXCEPTION("Statement details  not found  by id"+id));
                //2>Statement details found to be deleted, just delete it...
           statementRepository.deleteById(id);
    }



}
