package YELL.main.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import YELL.main.Entities.UnRegUser;
import YELL.main.Repositories.UnRegUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    UnRegUserRepository repository;

    public List<UnRegUser> getAllUsers() {
        return repository.findAll();
    }

    public void addUser(UnRegUser user) {
        repository.saveAndFlush(user);
    }

    public Optional<UnRegUser> getStudentById(long id) {
        return repository.findById(id);
    }
}
