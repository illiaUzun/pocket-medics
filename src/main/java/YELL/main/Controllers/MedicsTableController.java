package YELL.main.Controllers;

import YELL.main.Entities.Account;
import YELL.main.Entities.Medic;
import YELL.main.Services.MedicsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ProfileController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Индекс медиков един с индексом аккаунтов!
 *
 */

@RestController
public class MedicsTableController {

    @Autowired
    MedicsTableService service;

    @RequestMapping(value = "/profiles/medics", method = RequestMethod.POST)
    public void addUser(@RequestBody Medic medic) {
        service.addUser(medic);
    }
}
