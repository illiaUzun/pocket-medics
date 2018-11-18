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
 * !!Индекс медиков един с индексом аккаунтов!!
 *
 *  1. Было бы круто выстроить запрос таким образом : localhost:8080/profiles/medics?category//это меняемый рофл//=ЛОР
 *      в данном случае category выступает одновременно и PathVariable и RequestParam, как реализовать?
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

    @RequestMapping(value = "/profiles/medic", method = RequestMethod.GET)
    public List<Medic> getMedicsByCategory(@RequestParam(name = "category", required = true) String category) {
        return service.findMedicsByCategory(category);
    }

    @RequestMapping(value = "/profiles/medics", method = RequestMethod.GET)
    public List<Medic> getAllMedics() {
        return service.getAllMedics();
    }
}
