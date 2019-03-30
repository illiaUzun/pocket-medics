package YELL.main.Controllers;

import YELL.main.Entities.Comment;
import YELL.main.Entities.Medic;
import YELL.main.Services.MedicService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
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
    public String getMedicById(@RequestParam(name = "id", required = true) long id) {
        Optional<Medic> user = service.getMedicById(id);
        Gson gson = new Gson();
        return gson.toJson(user);
        //return user.orElse(null);
    }

    @RequestMapping(value = "/medic", method = RequestMethod.DELETE)
    public void deleteMedicById(@RequestParam(name = "id", required = true) long id) {
        service.deleteMedicById(id);
    }

    @RequestMapping(value = "/medic/comments", method = RequestMethod.GET)
    public String getFavourites(@RequestParam(name = "id", required = true) long id) {
        return service.getMedicById(id).get().getComments().toString();
    }

    @RequestMapping(value = "/medic/add_comment", method = RequestMethod.POST)
    public void addFavourite(@RequestParam(name = "id_medic", required = true) long idMedic,
                             @RequestParam(name = "id_User", required = true) long idUser,
                             @RequestParam(name = "comment", required = true) String comment) {
        service.addComment(service.getMedicById(idMedic).get(), new Comment(idUser, comment));
    }

    @RequestMapping(value = "/medic/delete_comments", method = RequestMethod.POST)
    public void deleteFavourite(@RequestParam(name = "id_medic", required = true) long idMedic,
                                @RequestParam(name = "id_User", required = true) long idUser,
                                @RequestParam(name = "id_comment", required = true) int idComment) {
        if (idUser == service.getMedicById(idMedic).get().getComments().get(idComment).accountId) {
            service.deleteComment(service.getMedicById(idMedic).get(), idComment);
        } else {
            System.out.println("Соси член лох, ты не создатель этого комментария");
        }
    }
}
