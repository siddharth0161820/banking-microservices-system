package com.Statement.StatementController;



import com.Statement.StatementService.StatementService;

import com.common.dto.StatementRequestDTO;
import com.common.dto.StatementResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Statement")
public class StatementController {
    //1>Connect StatementController to StatementService via constructor injection
    private final StatementService statementService;

    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }


    //2>Creating endpoints
    //2.1>addStatement
    @PostMapping("/addStatement")
    public ResponseEntity<StatementResponseDTO> addStatement(@Valid @RequestBody StatementRequestDTO statementRequestDTO){
        StatementResponseDTO addStatement=statementService.addStatement(statementRequestDTO);
        return new ResponseEntity<>(addStatement, HttpStatus.CREATED);
    }
    //2.2>updateStatement
    @PutMapping("/updateStatement/{id}")
    public ResponseEntity<StatementResponseDTO>updateStatement(@Valid @RequestBody StatementRequestDTO statementRequestDTO,@PathVariable long id){
        StatementResponseDTO updateStatement=statementService.updateStatement(statementRequestDTO,id);
        return ResponseEntity.ok(updateStatement);


    }
    //2.3>getAllStatement
    @GetMapping("/getAllStatement")
    public ResponseEntity<List<StatementResponseDTO>>getAllStatement(){
        List<StatementResponseDTO> getAllStatement=statementService.getAllStatement();
        return ResponseEntity.ok(getAllStatement);
    }

    //2.4>getSingleStatement
    @GetMapping("/getSingleStatement/{id}")
    public ResponseEntity<StatementResponseDTO>getSingleStatement(@PathVariable long id) {
        StatementResponseDTO getSingleStatement=statementService.getSingleStatement(id);
        return ResponseEntity.ok(getSingleStatement);
    }

    //2.5>deleteStatement
    @DeleteMapping("/deleteStatement/{id}")
    public ResponseEntity<String>deleteStatement(@PathVariable long id){
       statementService.deleteStatement(id);
        return ResponseEntity.ok("Statement deleted successfully");
    }



}
