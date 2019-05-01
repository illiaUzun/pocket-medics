package YELL.main.repository;

import YELL.main.domain.AccountMedic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AccountMedic entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountMedicRepository extends JpaRepository<AccountMedic, Long> {

}
