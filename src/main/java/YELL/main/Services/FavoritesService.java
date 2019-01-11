
/*package YELL.main.Services;

import YELL.main.Controllers.FavoritesController;
import YELL.main.Entities.Favorites;
import YELL.main.Entities.Medic;
import YELL.main.Repositories.AccountRepository;
import YELL.main.Repositories.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesService {

    @Autowired
    FavoritesRepository repository;

    public void addFavorite(Favorites medic){
        repository.saveAndFlush(medic);
    }

    public void deleteFavorite(Favorites medic){
        repository.deleteById(medic.getId_favorites());
    }

    public List<Favorites> getAllFavorites(long id_account) {
        return repository.getAllByAccountAccount_id(id_account);
    }


}
*/