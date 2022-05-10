package pl.coderslab.charity.admin;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.account.register.token.ConfirmationTokenRepository;
import pl.coderslab.charity.account.user.User;
import pl.coderslab.charity.account.user.UserRepository;
import pl.coderslab.charity.account.user.UserRole;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
@Secured("ROLE_ADMIN")
public class AdminController {

    private final UserRepository userRepository;
    private final ConfirmationTokenRepository tokenRepository;

    @RequestMapping("/listOfAdmins")
    public String adminsList(Model model){
        List<User> admins = userRepository.findAll().stream()
                .filter(user -> user.getUserRole().equals(UserRole.ROLE_ADMIN))
                .toList();
        model.addAttribute("admins", admins);
        return "admin/list_admin";
    }

    @GetMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable long id){
        tokenRepository.deleteConfirmationTokenByUserId(id);
        userRepository.delete(userRepository.getById(id));
        return "redirect:/admin/listOfAdmins";
    }

    @GetMapping("/editAdmin/{id}")
    public String editAdmin(Model model, @PathVariable long id){
        model.addAttribute("user", userRepository.getById(id));
        return "/admin/edit_admin";
    }

    @PostMapping("/editAdmin")
    public String editAdminPost(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/admin/edit_admin";
        }
        System.out.println(user.toString());
        userRepository.save(user);
        return "redirect:/admin/listOfAdmins";
    }

    @RequestMapping("/listOfUsers")
    public String usersList(Model model){
        List<User> users = userRepository.findAll().stream()
                .filter(user -> user.getUserRole().equals(UserRole.ROLE_USER))
                .toList();
        model.addAttribute("users", users);
        return "admin/list_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable long id){
        tokenRepository.deleteConfirmationTokenByUserId(id);
        userRepository.delete(userRepository.getById(id));
        return "redirect:/admin/listOfUsers";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(Model model, @PathVariable long id){
        model.addAttribute("user", userRepository.getById(id));
        return "/admin/edit_user";
    }

    @PostMapping("/editUser")
    public String editUserPost(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/admin/edit_user";
        }
        userRepository.save(user);
        return "redirect:/admin/listOfUsers";
    }

    @ModelAttribute("roles")
    public List<String> getRoles(){
        return Arrays.asList("ROLE_USER", "ROLE_ADMIN");
    }
}
