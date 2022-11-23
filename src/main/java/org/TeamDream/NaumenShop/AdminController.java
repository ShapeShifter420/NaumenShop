package org.TeamDream.NaumenShop;

import org.TeamDream.NaumenShop.format.FullCard;
import org.TeamDream.NaumenShop.models.CardModel;
import org.TeamDream.NaumenShop.models.ReCardModel;
import org.TeamDream.NaumenShop.models.WebModelsToBD;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class AdminController {
    @RequestMapping(value = "/admin", method = GET)
    @ResponseBody
    public String admin(Model model) {
        model.addAttribute("cardM", new CardModel());
        return "admin";
    }
    @RequestMapping(value = "/admin/addpanel/", method = GET)
    public String getaddpanel(Model model) {
        model.addAttribute("cardM", new CardModel());
        return "addpanel.html";
    }
    @RequestMapping(value="/admin/addpanel/", method= RequestMethod.POST)
    public String submitAdd(@ModelAttribute CardModel card, Model model) throws IOException {
        WebModelsToBD.AddNewCard(card);
        return "redirect:/admin";}
    @RequestMapping(value = "/admin/removepanel/", method = GET)
    @ResponseBody
    public String getremovepanel(Model model) {
        model.addAttribute("recard", new ReCardModel());
        return "removepanel.html";
    }
    @RequestMapping(value="/admin/removepanel/", method= RequestMethod.POST)
    public String submitremove(@ModelAttribute FullCard card, Model model) throws IOException {

        return "redirect:/admin";}
}
