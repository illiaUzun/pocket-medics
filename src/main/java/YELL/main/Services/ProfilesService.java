package YELL.main.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import YELL.main.Entities.Account;
import YELL.main.Repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    AccountRepository repository;

    public List<Account> getAllUsers() {
        return repository.findAll();
    }

    public void addUser(Account user) {
        repository.saveAndFlush(user);
    }

    public Optional<Account> getStudentById(long id) {
        return repository.findById(id);
    }
}
