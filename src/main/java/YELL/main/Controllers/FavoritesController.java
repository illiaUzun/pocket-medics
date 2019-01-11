package YELL.main.Controllers;

import YELL.main.Entities.Favorites;
import YELL.main.Services.FavoritesService;
import YELL.main.Services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoritesController {

    /**
     * FavoritesController:
     *
     * POST: addNew
     * PUT: apply changes to existed contacts
     * GET: Forms - after click on contact
     */

    @Autowired
    FavoritesService service;

    @Autowired
    ListService medicService;

    //id пишем в ссылке, т.к. доступ к id зарегистрированного пользователя нам не доступен (еще)
    @RequestMapping(value = "/user/favorites", method = RequestMethod.GET)
    public List<Favorites> getFavourites(@RequestParam(name = "id", required = true) long id) {
        return service.getAllFavorites(id);
    }

    @RequestMapping(value = "/user/favourites", method = RequestMethod.POST)
    public void addFavourite(@RequestParam(name = "id_medic", required = true) long id) {
        medicService.getById(id);
        service.addFavorite();
    }

}