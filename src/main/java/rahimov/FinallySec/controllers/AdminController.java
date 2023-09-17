package rahimov.FinallySec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rahimov.FinallySec.models.User;
import rahimov.FinallySec.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService peopleService;

    @Autowired
    public AdminController(UserService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", peopleService.allUsers());
        return "index";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        peopleService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("user", peopleService.findUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", peopleService.findUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String edit(@PathVariable int id, @ModelAttribute("user") User user){
        peopleService.update(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        peopleService.deleteUser(id);
        return "redirect:/admin";
    }
}
