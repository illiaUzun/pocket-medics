package YELL.main.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import YELL.main.Services.FormService;

@RestController
public class FormController {

    /**
     * Form:
     * <p>
     * GET: загрузка анкеты и остальных данных из сервера
     * GET: contact data
     * POST: оставление отзыва, оценки
     * POST: запись на прием и т.д
     */

    @Autowired
    FormService service;


}


