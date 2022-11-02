package org.TeamDream.NaumenShop;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.TeamDream.NaumenShop.DB.DataBase;
import org.TeamDream.NaumenShop.DB.models.Card;
import org.TeamDream.NaumenShop.format.FullCard;
import org.TeamDream.NaumenShop.format.HalfCard;
import org.TeamDream.NaumenShop.mailsender.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class HelloController {
    public MailSender m = new MailSender();
    @GetMapping("/")
    public String sayHello() {
        return "index.html";
    }
    @RequestMapping(value = "/api/card/{cardId}", method = GET)
    @ResponseBody
    public String getFoosBySimplePathWithPathVariable(
            @PathVariable("cardId") int cardId) {
        Card card = (Card) DataBase.getObject(cardId, Card.class);
        FullCard fullCard = new FullCard(card);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(fullCard.getMap());
            return json;
        } catch (JsonProcessingException e) {
            return "error";
        }
    }
    @RequestMapping(value = "/api/search/", method = GET)
    @ResponseBody
    public String getSearchByName(
            @RequestParam String query,@RequestParam int offset) {
        List<Card> cards = DataBase.getCardsByName(query,offset);
        List<Map> halfCards = new ArrayList<Map>();
        for (Card card : cards) {
            halfCards.add(new HalfCard(card).getMap());
        }
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(halfCards);
            return json;
        } catch (JsonProcessingException e) {
            return "error";
        }
    }
    @RequestMapping(value = "/product/{cardId}", method = GET)
    public String getCard(
            @PathVariable("cardId") int cardId, Model model) {
        Card card = (Card) DataBase.getObject(cardId, Card.class);
        FullCard fullCard = new FullCard(card);
        model.addAttribute("cardInfo", fullCard.getMap());
        return "card-fill.html";
    }
    @GetMapping("/anotations")
    public String getanotations() {
        return "anotations.html";
    }
}
