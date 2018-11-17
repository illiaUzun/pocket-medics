package YELL.main.Controllers;

import YELL.main.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import YELL.main.Entities.Account;

import java.util.Optional;

@RestController
public class ProfileController {

    /**
     * Окно регистрации
     * POST: отправка регистрационных данных в БД
     */

    @Autowired
    ProfileService service;

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
