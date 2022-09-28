package _1_spring_intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import _1_spring_intro.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}