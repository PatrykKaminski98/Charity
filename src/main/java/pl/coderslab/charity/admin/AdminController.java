package pl.coderslab.charity.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.account.user.User;
import pl.coderslab.charity.account.user.UserRepository;
import pl.coderslab.charity.account.user.UserRole;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
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
}
