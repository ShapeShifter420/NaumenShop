package org.TeamDream.NaumenShop;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.TeamDream.NaumenShop.DB.DataBase;
import org.TeamDream.NaumenShop.DB.models.Card.Card;
import org.TeamDream.NaumenShop.format.FullCard;
import org.TeamDream.NaumenShop.format.HalfCard;
import org.TeamDream.NaumenShop.mailsender.MailSender;
import org.TeamDream.NaumenShop.models.CardModel;
import org.TeamDream.NaumenShop.models.Filter;
//import org.TeamDream.NaumenShop.mailsender.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class HelloController {
//    public MailSender m = new MailSender();
    @GetMapping("/")
    public String sayHello() {
        return "index.html";
    }
    @RequestMapping(value = "/api/card/{cardId}", method = GET)
    @ResponseBody
    public String getProductJSON(
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
    @RequestMapping(value = "/api/search/", method = POST)
    @ResponseBody
    public String getSearchByName(@ModelAttribute Filter filter,
            @RequestParam String query,@RequestParam int offset) throws JsonProcessingException {
        List<HalfCard> halfCards = DataBase.getCardsByName(query,offset,filter.getSQLString()).stream().map(HalfCard::new).collect(Collectors.toList());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(halfCards);
    }
    @RequestMapping(value = "/product/{cardId}", method = GET)
    public String getCard(
            @PathVariable("cardId") int cardId, Model model) {
        Card card = (Card) DataBase.getObject(cardId, Card.class);
        FullCard fullCard = new FullCard(card);
        model.addAttribute("cardInfo", fullCard.getMap());
        return "card-fill.html";
    }

    @RequestMapping(value = "/api/cart", method = GET)
    @ResponseBody
    public String addToCart(@CookieValue("cart") String cart) throws JsonProcessingException {
        List<HalfCard> halfCards = DataBase.getCardsByIds(cart.split("~")).stream().map(HalfCard::new).collect(Collectors.toList());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(halfCards);
    }

    @GetMapping("/anotations")
    public String getanotations() {
        return "anotations.html";
    }
}
