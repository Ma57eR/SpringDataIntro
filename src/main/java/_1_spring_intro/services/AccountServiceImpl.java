package _1_spring_intro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import _1_spring_intro.models.Account;
import _1_spring_intro.repositories.AccountRepository;
import _1_spring_intro.repositories.UserRepository;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final UserRepository userRepository;


    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository, UserRepository userRepository1) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository1;
    }

    @Override
    public void registerAccount(Account account) {
        this.accountRepository.save(account);

    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) {
        Account currentAccount = this.accountRepository.findById(id).orElseGet(() -> new Account(amount, userRepository.findById(id).get()));
        BigDecimal currentAmount = new BigDecimal(currentAccount.getBalance().longValue() - amount.longValue());
        currentAccount.setBalance(currentAmount);
        this.accountRepository.save(currentAccount);
    }


    @Override
    public void transferMoney(BigDecimal amount, Long id) {
        Account currentAccount = this.accountRepository.findById(id).orElseGet(() -> new Account(amount, userRepository.findById(id).get()));
        BigDecimal currentAmount = new BigDecimal(currentAccount.getBalance().longValue() - amount.longValue());
        currentAccount.setBalance(currentAmount);
        this.accountRepository.save(currentAccount);

    }
}
