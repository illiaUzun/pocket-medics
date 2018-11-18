package YELL.main.Controllers;

import YELL.main.Entities.Medic;
import YELL.main.Services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.rest.webmvc.ProfileController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Индекс медиков един с индексом аккаунтов!
 *
 */

@RestController
public class MedicsTableController {

    @Autowired
    ListService service;

    @RequestMapping(value = "/profiles/medics", method = RequestMethod.POST)
    public void addUser(@RequestBody Medic medic) {
        service.addUser(medic);
    }

    @RequestMapping(value = "/profiles/medics", method = RequestMethod.GET)
    public List<Medic> getUserByCategory(@RequestParam(name = "category", required = true) String category) {
        return service.findByCategory(category);
    }
}
