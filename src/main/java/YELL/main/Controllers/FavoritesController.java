package YELL.main.Controllers;

import YELL.main.Services.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
