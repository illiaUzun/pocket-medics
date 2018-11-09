package YELL.main.Controllers;

import YELL.main.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProfilesController {
    @Autowired
    RegistrationService service;


}
