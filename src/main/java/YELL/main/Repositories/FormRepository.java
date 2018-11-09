package YELL.main.Repositories;

import YELL.main.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Account, Long> {
}
