package YELL.main.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import YELL.main.Entities.Account;
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
    public void addUser(@RequestBody Account user) {
        service.addUser(user);
    }

    @RequestMapping("/getusers")
    public Account getUserByQueryStringId(@RequestParam(name = "id", required = true) long id) {
        Optional<Account> student = service.getStudentById(id);
        return student.orElse(null);
    }

}
