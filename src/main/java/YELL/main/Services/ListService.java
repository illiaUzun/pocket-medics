package YELL.main.Services;

import YELL.main.Entities.Medic;
import YELL.main.Repositories.MedicsTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    @Autowired
    MedicsTableRepository repository;

    public void addUser(Medic medic) {
        repository.saveAndFlush(medic);
    }

    public List<Medic> findMedicsByCategory(String category){
        return repository.findAllByCategoryOrderByYearsOfExperience(category);
    }

    public List<Medic> getAllMedics(){
        return repository.findAll();
    }

    public Medic getById (long id){
        return repository.getOne(id);
    }
}
