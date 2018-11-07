package YELL.main.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import YELL.main.Entities.UnRegUser;
import YELL.main.Services.RegistrationService;

import java.util.Optional;

@RestController
public class RegistrationController {

    /**
     * Окно регистрации
     * POST: отправка регистрационных данных в БД
     */

    @Autowired
    RegistrationService service;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody UnRegUser user) {
        service.addUser(user);
    }

    @RequestMapping("/getusers")
    public UnRegUser getUserByQueryStringId(@RequestParam(name = "id", required = true) long id) {
        Optional<UnRegUser> student = service.getStudentById(id);
        return student.orElse(null);
    }

}
