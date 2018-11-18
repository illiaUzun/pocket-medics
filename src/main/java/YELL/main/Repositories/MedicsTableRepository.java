package YELL.main.Repositories;

import YELL.main.Entities.Account;
import YELL.main.Entities.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicsTableRepository extends JpaRepository<Medic, Long> {

    List<Medic> findByCategory(String category);

}
