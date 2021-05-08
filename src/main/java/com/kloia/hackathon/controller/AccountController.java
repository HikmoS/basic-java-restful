package com.kloia.hackathon.controller;

import com.kloia.hackathon.exception.AccountNotFoundException;
import com.kloia.hackathon.model.Account;
import com.kloia.hackathon.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping(value = "/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody Account account) {
        accountService.save(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> getStudent(@PathVariable("id") ObjectId id) throws AccountNotFoundException {
        Account account = accountService.getStudent(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping(value = "/find-all")
    public ResponseEntity<List<Account>> getAllStudent() {
        List<Account> accounts = accountService.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

}
