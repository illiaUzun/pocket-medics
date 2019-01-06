package YELL.main.Controllers;

import YELL.main.Entities.Favorites;
import YELL.main.Entities.Medic;
import YELL.main.Services.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import YELL.main.Entities.Account;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfilesController {

    /**
     * Окно регистрации
     * POST: отправка регистрационных данных в БД
     * 1. Обновление последовательности, задаваемой БД при удалении?
     * 2. Как получить данные главного аккаунта, какой из аккаунтов главный?
     */

    @Autowired
    ProfilesService service;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody Account user) {
        service.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Account getUserById(@RequestParam(name = "id", required = true) long id) {
        Optional<Account> user = service.getUserById(id);
        return user.orElse(null);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Account> getAllUsers() {
        return service.getAllUsers();
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public void deleteUserById(@RequestParam(name = "id", required = true) long id) {
        service.deleteUserById(id);
    }

    /*
    //см. п.2
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addToFavourites(@RequestParam(name = "id", required = true) long id) {
        service.addToFavourites(id).add(service.getUserById(id));
    }

    //см. п.2
    @RequestMapping(value = "/user/favourites", method = RequestMethod.GET)
    public List<Optional<Account>> getFavourites() {
        return service.favourites(id);
    }

    //подгружать избранные в List аккаунта через БД?
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void setFavourites(@RequestBody Account user) {
        user.setFavourites(service.favourites(user.getId()));//service.addUser(user);
    }*/

    @RequestMapping(value = "/user/favourites", method = RequestMethod.GET)
    public List<Favorites> getFavourites(@RequestParam(name = "id", required = true) long id) {
        return service.favorites(id);
    }
}