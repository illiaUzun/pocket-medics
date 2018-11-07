/**
 *  ОБРАЗЕЦ
 *
 */

package YELL.main.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestAPI {


    @RequestMapping(method = RequestMethod.GET, value = "/students/")
    public String getStudent(@RequestParam(name = "lastname") String lastName) {
        return "Lol kek " + lastName;
    }


    /*@RequestMapping(method = RequestMethod.GET, value = "/registration/")
    public String registration(@PathVariable(value = "lastname") String lastName){
        return;
    }*/

    /**
     * Окно регистрации
     *
     * POST: отправка регистрационных данных в БД
     */
    @RequestMapping(method = RequestMethod.POST, value = "/registration/")
    public void addAccount(@RequestBody Object account){
        // SQL ...
    }

    /**
     * Leafs:
     *
     * GET: получение обновленной информации о форумах из сервера
     * GET: получение новостей из сервера
     * POST: add your own form to this leaf and to your leafList
     */

    @RequestMapping(method = RequestMethod.GET, value = "/leafs/{leafname}")
    public String getLeaf(@PathVariable(value = "leafname") String leafname){
        return leafname;
    }

    /**
     * Form:
     *
     * GET: загрузка анкеты и остальных данных из сервера
     * GET: contact data
     * POST: оставление отзыва, оценки
     * POST: запись на прием и т.д
     */

    /**
     * ListOfContacts:
     *
     * POST: addNew
     * PUT: apply changes to existed contacts
     * GET: Forms - after click on contact
     */

    /**
     * AddNewPersonalProfile
     *
     * POST: new data (new profile) to the leaf or without leaf
     */
}

