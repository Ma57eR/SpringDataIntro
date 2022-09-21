package spring_intro.services;

import org.springframework.beans.factory.annotation.Autowired;
import spring_intro.repositories.AccountRepository;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public void withdrawMoney(BigDecimal amount, Long id) {

    }

    @Override
    public void transferMoney(BigDecimal amount, Long id) {

    }
}
