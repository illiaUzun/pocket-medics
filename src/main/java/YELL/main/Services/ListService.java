package YELL.main.Services;

import YELL.main.Entities.Medic;
import YELL.main.Repositories.MedicsTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListService {

    @Autowired
    MedicsTableRepository repository;

    public void addMedic(Medic medic) {
        repository.saveAndFlush(medic);
    }

    public List<Medic> findMedicsByCategory(String category){
        return repository.findAllByCategoryOrderByYearsOfExperience(category);
    }

    public List<Medic> getAllMedics(){
        return repository.findAll();
    }

    public Optional<Medic> getMedicById (long id){
        return repository.findById(id);
    }
    public void deleteMedicById(long id) {
        repository.deleteById(id);
    }
}
