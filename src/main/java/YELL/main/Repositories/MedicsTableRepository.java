package YELL.main.Repositories;

import YELL.main.Entities.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicsTableRepository extends JpaRepository<Medic, Long> {

    List<Medic> findAllByCategory(String category);

    List<Medic> findAllByOrderByYearsOfExperience();

    List<Medic> findAllByCategoryOrderByYearsOfExperience(String category);

}
