package YELL.main.Services;

//import YELL.main.Entities.Favorites;
import YELL.main.Entities.Medic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import YELL.main.Entities.Account;
import YELL.main.Repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilesService {

    @Autowired
    AccountRepository repository;

    public List<Account> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUserById(long id) {
        repository.deleteById(id);
    }

    public void addUser(Account account) {
        repository.saveAndFlush(account);
    }

    public Optional<Account> getUserById(long id) {
        return repository.findById(id);
    }

    public void addFavourite(Account account, Medic medic){
        account.getFavourites().add(medic);
        repository.save(account);
    }

    public void deleteFavourite(Account account, Medic medic) {
        account.getFavourites().remove(medic);
        repository.save(account);
    }
}
