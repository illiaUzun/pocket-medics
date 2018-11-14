package YELL.main.Services;

import YELL.main.Entities.Account;
import YELL.main.Entities.Medic;
import YELL.main.Repositories.FormRepository;
import YELL.main.Repositories.MedicsTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService {

    @Autowired
    MedicsTableRepository repository;

    public void addUser(Medic medic) {
        repository.saveAndFlush(medic);
    }
}
