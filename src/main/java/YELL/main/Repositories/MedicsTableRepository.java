package YELL.main.Repositories;

import YELL.main.Entities.Account;
import YELL.main.Entities.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicsTableRepository extends JpaRepository<Medic, Long> {
}
