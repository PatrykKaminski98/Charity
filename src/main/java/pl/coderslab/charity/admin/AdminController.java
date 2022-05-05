package pl.coderslab.charity.admin;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.account.user.User;
import pl.coderslab.charity.account.user.UserRepository;
import pl.coderslab.charity.account.user.UserRole;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
@Secured("ROLE_ADMIN")
public class AdminController {

    private final UserRepository userRepository;

    @RequestMapping("/list")
    public String adminsList(Model model){
        List<User> admins = userRepository.findAll().stream()
                .filter(user -> user.getUserRole().equals(UserRole.ROLE_ADMIN))
                .toList();
        model.addAttribute("admins", admins);
        return "admin/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        userRepository.delete(userRepository.getById(id));
        return "redirect:/admin/list";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable long id){
        model.addAttribute("user", userRepository.getById(id));
        return "/admin/edit";
    }

    @PostMapping("/edit")
    public String editUserPost(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/admin/edit";
        }
        System.out.println(user.toString());
        userRepository.save(user);
        return "redirect:/admin/list";
    }

    @ModelAttribute("roles")
    public List<String> getRoles(){
        return Arrays.asList("ROLE_USER", "ROLE_ADMIN");
    }
}
