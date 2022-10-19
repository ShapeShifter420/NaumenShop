package org.TeamDream.NaumenShop;

import org.TeamDream.NaumenShop.DB.DataBase;
import org.TeamDream.NaumenShop.DB.models.Card;
import org.TeamDream.NaumenShop.mailsender.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class HelloController {
    public MailSender m = new MailSender();
    @GetMapping("/")
    public String sayHello() {
        return "index.html";
    }
    @RequestMapping(value = "/api/{cardId}", method = GET)
    @ResponseBody
    public String getFoosBySimplePathWithPathVariable(
            @PathVariable("cardId") int cardId) {
        Card card = DataBase.getCard(cardId);
        return card.toString();
    }
    @GetMapping("/anotations")
    public String getanotations() {
        return "anotations.html";
    }
}
