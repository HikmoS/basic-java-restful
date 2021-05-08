package com.kloia.hackathon.service;

import com.kloia.hackathon.exception.AccountNotFoundException;
import com.kloia.hackathon.model.Account;
import com.kloia.hackathon.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public void save(Account account) {
        accountRepository.save(account);
    }

    public Account getStudent(ObjectId id) throws AccountNotFoundException {
        Optional<Account> byId = accountRepository.findById(id);
        Account account = byId.orElseThrow(() -> new AccountNotFoundException("Student not found"));
        return account;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
