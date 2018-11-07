package YELL.main.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListOfContacts {

    /**
     * ListOfContacts:
     *
     * POST: addNew
     * PUT: apply changes to existed contacts
     * GET: Forms - after click on contact
     */

    @Autowired
    ListOfContacts service;


}
