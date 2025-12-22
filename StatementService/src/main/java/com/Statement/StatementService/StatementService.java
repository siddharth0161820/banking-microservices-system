package com.Statement.StatementService;

import com.common.dto.StatementRequestDTO;
import com.common.dto.StatementResponseDTO;

import java.util.List;

public interface StatementService {
    public StatementResponseDTO addStatement( StatementRequestDTO statementRequestDTO);
    public StatementResponseDTO updateStatement(StatementRequestDTO statementRequestDTO, long id);
    public List<StatementResponseDTO> getAllStatement();
    public StatementResponseDTO getSingleStatement(long id);
    public void deleteStatement(long id);

}
