package YELL.main.Controllers;

import YELL.main.Entities.Account;
import YELL.main.Entities.Comment;
import YELL.main.Entities.Medic;
import YELL.main.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Получение айдишников оставляющего аккаунтов и медика, которому оставляют?
 */

@RestController
public class CommentController {

    @Autowired
    CommentService service;

    @RequestMapping(value = "/users/comments", method = RequestMethod.POST)
    public void addComment(@RequestBody Account user, Medic medic, String string) {
        Comment comment = new Comment(medic.getId(), user.getId(), string);
        service.addComment(comment);
    }

}
