package fr.pompey.cda24060.projetwebspringboot.controller;

import org.springframework.ui.Model;
import fr.pompey.cda24060.projetwebspringboot.model.User;
import fr.pompey.cda24060.projetwebspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        Iterable<User> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);

        return "home";
    }

    @GetMapping(value = {"/createuser"})
    public String createuser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "createuser";
    }

    @GetMapping(value = {"/updateuser/{id_user}"})
    public String updateuser(@PathVariable("id_user") final Integer id_user, Model model) {
        User user = userService.getUser(id_user);
        model.addAttribute("user", user);
        return "updateuser";
    }

    @GetMapping(value = {"/deleteuser/{id_user}"})
    public ModelAndView deleteuser(@PathVariable("id_user") final Integer id_user) {
        userService.deleteUser(id_user);
        // redirection vers la page home
        return new ModelAndView("redirect:/");
    }

    @PostMapping(value = {"/saveuser"})
    public ModelAndView saveuser(@ModelAttribute User user) {
        userService.saveUser(user);
        // redirection vers la page home
        return new ModelAndView("redirect:/");
    }

}
