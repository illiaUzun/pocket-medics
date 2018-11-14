package YELL.main.Controllers;

import YELL.main.Entities.Medic;
import YELL.main.Services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {

    @Autowired
    ListService service;

    @RequestMapping(value = "/profiles/medics", method = RequestMethod.POST)
    public void addUser(@RequestBody Medic medic) {
        service.addUser(medic);
    }
}
