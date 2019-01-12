package YELL.main.Controllers;

import YELL.main.Services.MedicService;
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
     * 3. id пишем в ссылке, т.к. доступ к id зарегистрированного пользователя нам не доступен (еще)
     */

    @Autowired
    ProfilesService profilesService;

    @Autowired
    MedicService medicService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody Account user) {
        profilesService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Account getUserById(@RequestParam(name = "id", required = true) long id) {
        Optional<Account> user = profilesService.getUserById(id);
        return user.orElse(null);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Account> getAllUsers() {
        return profilesService.getAllUsers();
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public void deleteUserById(@RequestParam(name = "id", required = true) long id) {
        profilesService.deleteUserById(id);
    }


    @RequestMapping(value = "/user/favourites", method = RequestMethod.GET)
    public String getFavourites(@RequestParam(name = "id", required = true) long id) {
        return profilesService.getUserById(id).get().getFavourites().toString();
    }

    @RequestMapping(value = "/user/favourite", method = RequestMethod.POST)
    public void addFavourite(@RequestParam(name = "id_medic", required = true) long idMedic,
                             @RequestParam(name = "id_User", required = true) long idUser) {
        profilesService.addFavourite(profilesService.getUserById(idUser).get(), medicService.getMedicById(idMedic).get());
    }

    @RequestMapping(value = "/user/favourites", method = RequestMethod.POST)
    public void deleteFavourite(@RequestParam(name = "id_medic", required = true) long idMedic,
                                @RequestParam(name = "id_User", required = true) long idUser) {
        profilesService.deleteFavourite(profilesService.getUserById(idUser).get(), medicService.getMedicById(idMedic).get());
    }

}