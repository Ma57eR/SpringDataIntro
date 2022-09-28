package _1_spring_intro.services;

import _1_spring_intro.models.Account;

import java.math.BigDecimal;

public interface AccountService {

    void withdrawMoney(BigDecimal amount, Long id);

    void transferMoney(BigDecimal amount, Long id);

    void registerAccount(Account account);
}
