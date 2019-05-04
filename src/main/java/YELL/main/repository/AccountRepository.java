package YELL.main.repository;


import YELL.main.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AccountM entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
