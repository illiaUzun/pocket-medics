package YELL.main.Controllers;

import YELL.main.Entities.Medic;
import YELL.main.Services.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * !!Индекс медиков един с индексом аккаунтов!!
 * <p>
 * 1. Было бы круто выстроить запрос таким образом : localhost:8080/profiles/medics?category//это меняемый рофл//=ЛОР
 * в данном случае category выступает одновременно и PathVariable и RequestParam, как реализовать?
 */

@RestController
public class MedicsController {

    @Autowired
    MedicService service;

    @RequestMapping(value = "/profiles/medics", method = RequestMethod.POST)
    public void addMedic(@RequestBody Medic medic) {
        service.addMedic(medic);
    }

    @RequestMapping(value = "/profiles/medic", method = RequestMethod.GET)
    public List<Medic> getMedicsByCategory(@RequestParam(name = "category", required = true) String category) {
        return service.findMedicsByCategory(category);
    }

    @RequestMapping(value = "/profiles/medics", method = RequestMethod.GET)
    public List<Medic> getAllMedics() {
        return service.getAllMedics();
    }

    @RequestMapping(value = "/medic", method = RequestMethod.GET)
    public Medic getMedicById(@RequestParam(name = "id", required = true) long id) {
        Optional<Medic> user = service.getMedicById(id);
        return user.orElse(null);
    }

    @RequestMapping(value = "/medic", method = RequestMethod.DELETE)
    public void deleteMedicById(@RequestParam(name = "id", required = true) long id) {
        service.deleteMedicById(id);
    }
}
