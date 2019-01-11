//package YELL.main.Controllers;
//
//import YELL.main.Entities.Favorites;
//import YELL.main.Services.FavoritesService;
//import YELL.main.Services.ListService;
//import YELL.main.Services.ProfilesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class FavoritesController {
//
//    /**
//     * FavoritesController:
//     * <p>
//     * POST: addNew
//     * PUT: apply changes to existed contacts
//     * GET: Forms - after click on contact
//     */
//
//    @Autowired
//    FavoritesService service;
//
//    @Autowired
//    ListService medicService;
//
//    @Autowired
//    ProfilesService profilesService;
//
//    //id пишем в ссылке, т.к. доступ к id зарегистрированного пользователя нам не доступен (еще)
//    @RequestMapping(value = "/user/favorites", method = RequestMethod.GET)
//    public List<Favorites> getFavourites(@RequestParam(name = "id", required = true) long id) {
//        return service.getAllFavorites(id);
//    }
//
//    @RequestMapping(value = "/user/favorites", method = RequestMethod.POST)
//    public void addFavourite(@RequestParam(name = "id_medic", required = true) long idMedic,
//                             @RequestParam(name = "id_User", required = true) long idUser) {
//        service.addFavorite(new Favorites(profilesService.getUserById(idUser), medicService.getById(idMedic), ""));
//    }
//
//    @RequestMapping(value = "/user/favorites", method = RequestMethod.DELETE)
//    public void deleteFavourite(@RequestParam(name = "id_medic", required = true) long idMedic,
//                                @RequestParam(name = "id_User", required = true) long idUser) {
//
//        service.deleteFavorite();
//    }
//
//
//}